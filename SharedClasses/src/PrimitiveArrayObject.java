
public class PrimitiveArrayObject {
	
	private char [] primitiveArray;
	
	public PrimitiveArrayObject() {
		this(1);
	}
	public PrimitiveArrayObject(int len) {
		primitiveArray = new char[len];
	}
		
	public void setAt(int index, char prim) {
		primitiveArray[index] = prim;
	}
	
}
