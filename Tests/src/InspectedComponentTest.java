import org.junit.*;
import static org.junit.Assert.*;

public class InspectedComponentTest {
	
	@Test
	public void testNull() {
		InspectedComponent test = InspectedComponent.create(Object.class, null);
		assertEquals(test.inspect(), "Value : null");
	}
	@Test
	public void testPrimitive() {
		InspectedComponent test = InspectedComponent.create(int.class, 1);	
		assertEquals(test.inspect(), "Value : 1");
	}
	
	@Test
	public void testPrimitiveArray() {
		InspectedComponent test = InspectedComponent.create(int[].class, new int[] {0,1});
		assertEquals(test.inspect(), "Class : [I\n" 
									+ "Members : \n" 
									+ "\n\nValue : 1\n\n"
									+ "Value : 0\n\n"
									+"Length : 2");
		
	}
	
	@Test
	public void testEmptyArray() {
		InspectedComponent test = InspectedComponent.create(int[].class, new int[] {});
		assertEquals(test.inspect(), "Class : [I\n"
									+ "Length : 0");				
	}
	
	@Test
	public void testObjectArray() {
		InspectedComponent test = InspectedComponent.create(EmptyClass[].class, new EmptyClass[] {
			new EmptyClass(),
			new EmptyClass()
		});
		
		assertEquals(test.inspect(), "Class : [LEmptyClass\n"
									+ "Members : \n" 
									+ "\n\nClass : EmptyClass"
									+ "\n\nClass : EmptyClass");
		
	}
	
	@Test
	public void testEmptyClass() {
		InspectedComponent test = InspectedComponent.create(EmptyClass.class, new EmptyClass());
		assertEquals(test.inspect(), "Class : EmptyClass\n");
		
	}
	
	@Test
	public void testPrimitiveFieldClass() {
		InspectedComponent test = InspectedComponent.create(OnePrimitiveClass.class, new OnePrimitiveClass());
		assertEquals(test.inspect(), "Class : OnePrimitiveClass\n"
									+ "Members : \n"
									+ "\n\nName : prim"
									+"\nValue : 1");
		
		
	}
	
	@Test
	public void testNullFieldClass() {
		InspectedComponent test = InspectedComponent.create(NullFieldClass.class, new NullFieldClass());
		assertEquals(test.inspect(), "Class : NullFieldClass\n"
									+ "Members : \n"
									+ "\n\nName : obj"
									+ "\nValue : null");
		
	}
	
	@Test
	public void testObjectFieldClass() {
		InspectedComponent test = InspectedComponent.create(OneClassFieldClass.class, new OneClassFieldClass());
		assertEquals(test.inspect(), "Class : OneClassFieldClass\n"
									+ "Members : \n"
									+ "Class : EmptyClass\n");
		
	}

}
