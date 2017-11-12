import org.junit.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class SerializerTest {
	
	private static Serializer serializer;
		
	private String xmlString(Document doc) {
		XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
		return out.outputString(doc);
		
	}
	
	@BeforeClass
	public static void setUp() {
		serializer = new Serializer();
	}
	
	@Test
	public void testEmptyClass() {
		Document result = serializer.serialize(new EmptyClass());
		String stringResult = xmlString(result);
		String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
				"<serialized>\r\n" + 
				"  <object class=\"EmptyClass\" id=\"0\" />\r\n" + 
				"</serialized>\r\n";
		
		assertEquals(stringResult, expected);
	}
	
	@Test
	public void testPrimitiveArray() {
		Document result = serializer.serialize(new double[] {1.0, 2.0, 3.0});
		String stringResult = xmlString(result);
		String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
				"<serialized>\r\n" + 
				"  <object class=\"[D\" length=\"3\" id=\"0\">\r\n" + 
				"    <value>1.0</value>\r\n" + 
				"    <value>2.0</value>\r\n" + 
				"    <value>3.0</value>\r\n" + 
				"  </object>\r\n" + 
				"</serialized>\r\n";
		
		assertEquals(stringResult, expected);
	}
	
	
	@Test
	public void testTwoDimensionalArray() {
		Document result = serializer.serialize(new char[][] {{'a'}, {'b'}});
		String stringResult = xmlString(result);
		String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
				"<serialized>\r\n" + 
				"  <object class=\"[C\" length=\"1\" id=\"1\">\r\n" + 
				"    <value>a</value>\r\n" + 
				"  </object>\r\n" + 
				"  <object class=\"[C\" length=\"1\" id=\"2\">\r\n" + 
				"    <value>b</value>\r\n" + 
				"  </object>\r\n" + 
				"  <object class=\"[[C\" length=\"2\" id=\"0\">\r\n" + 
				"    <reference>1</reference>\r\n" + 
				"    <reference>2</reference>\r\n" + 
				"  </object>\r\n" + 
				"</serialized>\r\n";
		
		assertEquals(stringResult, expected);
	}
	
	@Test
	public void testEmptyArray() {
		Document result = serializer.serialize(new float[] {});		
		String stringResult = xmlString(result);
		String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
				"<serialized>\r\n" + 
				"  <object class=\"[F\" length=\"0\" id=\"0\" />\r\n" + 
				"</serialized>\r\n";
		
		assertEquals(stringResult, expected);
	}
	
	@Test
	public void testClassWithArray() {
		Document result = serializer.serialize(new PrimitiveArrayClass());		
		String stringResult = xmlString(result);
		String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
				"<serialized>\r\n" + 
				"  <object class=\"[I\" length=\"2\" id=\"1\">\r\n" + 
				"    <value>1</value>\r\n" + 
				"    <value>2</value>\r\n" + 
				"  </object>\r\n" + 
				"  <object class=\"PrimitiveArrayClass\" id=\"0\">\r\n" + 
				"    <field declaringclass=\"PrimitiveArrayClass\" name=\"integers\">\r\n" + 
				"      <reference>1</reference>\r\n" + 
				"    </field>\r\n" + 
				"  </object>\r\n" + 
				"</serialized>\r\n";
		
		assertEquals(stringResult, expected);
	}
	
	@Test
	public void testClassWithNullField() {
		Document result = serializer.serialize(new NullFieldClass());		
		String stringResult = xmlString(result);
		String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
				"<serialized>\r\n" + 
				"  <object class=\"NullFieldClass\" id=\"0\">\r\n" + 
				"    <field declaringclass=\"NullFieldClass\" name=\"obj\">\r\n" + 
				"      <value>null</value>\r\n" + 
				"    </field>\r\n" + 
				"  </object>\r\n" + 
				"</serialized>\r\n";
		
		assertEquals(stringResult, expected);		
	}
	
	
	@Test
	public void testClassWithPrimitive() {
		Document result = serializer.serialize(new OnePrimitiveClass());		
		String stringResult = xmlString(result);
		String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
				"<serialized>\r\n" + 
				"  <object class=\"OnePrimitiveClass\" id=\"0\">\r\n" + 
				"    <field declaringclass=\"OnePrimitiveClass\" name=\"prim\">\r\n" + 
				"      <value>1</value>\r\n" + 
				"    </field>\r\n" + 
				"  </object>\r\n" + 
				"</serialized>\r\n";
		
		assertEquals(stringResult, expected);
	}
	
	@Test
	public void testClassWithClassField() {
		Document result = serializer.serialize(new OneClassFieldClass());		
		String stringResult = xmlString(result);
		String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
				"<serialized>\r\n" + 
				"  <object class=\"EmptyClass\" id=\"1\" />\r\n" + 
				"  <object class=\"OneClassFieldClass\" id=\"0\">\r\n" + 
				"    <field declaringclass=\"OneClassFieldClass\" name=\"obj\">\r\n" + 
				"      <reference>1</reference>\r\n" + 
				"    </field>\r\n" + 
				"  </object>\r\n" + 
				"</serialized>\r\n";
		
		assertEquals(stringResult, expected);	
	}

}
