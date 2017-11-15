import org.junit.*;
import static org.junit.Assert.*;
import java.io.StringReader;
import java.util.Arrays;
import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;

public class DeserializerTest {
	
	private static Deserializer deserializer;
	
	private Object deserialize(String root) throws Exception {
		String fullRoot = "<serialized>\r\n"
						+ root
						+"</serialized>";
		SAXBuilder builder = new SAXBuilder();
		try {
			Document doc = builder.build(new StringReader(fullRoot));
			return deserializer.deserialize(doc);
		}
		catch(Exception e) {
			throw new Exception();
		}
	}
	
	@BeforeClass
	public static void setUp() {
		deserializer = new Deserializer();
	}
	
	@Test
	public void testEmptyClass() {	
		String root = "<object id =\"0\" class=\"EmptyClass\"></object>\r\n";
		try {
			Object result = deserialize(root);
			assertEquals(result, new EmptyClass());
		}
		catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testPrimitiveArray() {
		String root = "<object id =\"0\" class=\"[D\" length =\"3\">\r\n"
				+ "<value>1.0</value>\r\n"
				+ "<value>2.0</value>\r\n"
				+ "<value>3.0</value>\r\n"
				+ "</object>\r\n";
		
		try {
			Object result = deserialize(root);
			assertEquals(result.getClass(), double[].class);
			assertTrue(Arrays.equals((double[])result, new double[] {1.0,2.0,3.0}));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testTwoDimensionalArray() {
		String root ="<object id = \"0\" class=\"[[C\" length=\"2\">\r\n"
				+ "<reference>1</reference>\r\n"
				+ "<reference>2</reference>\r\n"
				+ "</object>\r\n"
				+ "<object id=\"1\" class=\"[C\" length=\"1\">\r\n"
				+ "<value>a</value>\r\n"
				+ "</object>\r\n"
				+ "<object id=\"2\" class=\"[C\" length=\"1\">\r\n"
				+ "<value>b</value>\r\n"
				+ "</object>\r\n";
		
		try {
			Object result = deserialize(root);
			assertEquals(result.getClass(), char[][].class);					
			assertTrue(Arrays.deepEquals((char[][]) result, new char [][] {{'a'}, {'b'}}));
			
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testEmptyArray() {
		String root = "<object id=\"0\" class=\"[F\" length=\"0\">\r\n"
				+ "</object>\r\n";
		
		try {
			Object result = deserialize(root);
			assertEquals(result.getClass(), float[].class);
			assertTrue(Arrays.equals((float[])result, new float[] {}));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
		
	@Test
	public void testClassWithArray() {
		String root = "<object id =\"0\" class=\"PrimitiveArrayClass\">\r\n"
					+ "<field declaringclass=\"PrimitiveArrayClass\" name=\"integers\">\r\n"
					+ "<reference>1</reference>\r\n"
					+ "</field>\r\n"
					+ "</object>\r\n"
					+ "<object id = \"1\" class=\"[I\" length=\"2\">\r\n"
					+ "<value>1</value>\r\n"
					+ "<value>2</value>\r\n"
					+ "</object>\r\n";
		try {
			Object result = deserialize(root);
			assertEquals(result, new PrimitiveArrayClass());
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testClassWithNullField() {
		String root ="<object id=\"0\" class=\"NullFieldClass\">\r\n"
				+ "<field declaringclass=\"NullFieldClass\" name=\"obj\">\r\n"
				+ "<value>null</value>\r\n"
				+ "</field>\r\n"
				+ "</object>\r\n";
		
		try {
			Object result = deserialize(root);
			assertEquals(result, new NullFieldClass());
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	
	@Test
	public void testClassWithPrimitive() {
		String root = "<object id=\"0\" class=\"OnePrimitiveClass\">\r\n"
				+ "<field declaringclass=\"OnePrimitiveClass\" name=\"prim\">\r\n"
				+ "<value>1</value>\r\n"
				+ "</field>\r\n"
				+ "</object>\r\n";
		try {
			Object result = deserialize(root);
			assertEquals(result, new OnePrimitiveClass());
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
		
	@Test
	public void testClassWithClassField() {
		String root = "<object id =\"0\" class=\"OneClassFieldClass\">\r\n"
				+ "<field declaringclass=\"OneClassFieldClass\" name=\"obj\">\r\n"
				+ "<reference>1</reference>"
				+ "</field>\r\n"
				+ "</object>\r\n"
				+ "<object id=\"1\" class=\"EmptyClass\">\r\n"
				+ "</object>\r\n";
		
		try {
			Object result = deserialize(root);
			assertEquals(result, new OneClassFieldClass());
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testCircularReference() {
		String root = "<object id =\"0\" class=\"[LEmptyClass;\" length =\"2\">\r\n"
				+ "<reference>1</reference>\r\n"
				+ "<reference>1</reference>\r\n"
				+ "</object>\r\n"
				+ "<object id=\"1\" class=\"EmptyClass\">\r\n"
				+ "</object>\r\n";
		try {
			Object result = deserialize(root);
			assertEquals(result.getClass(), EmptyClass[].class);
			assertSame(((EmptyClass[])result)[0], ((EmptyClass[])result)[1]);
		}catch(Exception e) {
			fail();
		}
	}
	
}
