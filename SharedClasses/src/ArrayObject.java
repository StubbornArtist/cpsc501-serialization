
public class ArrayObject {
	
	private char [] primitiveArray;
	private SimpleObject [] referenceArray;
	
	public ArrayObject() {
		this(1);
	}
	public ArrayObject(int len) {
		primitiveArray = new char[len];
		referenceArray = new SimpleObject[len];
	}
	
	
	public void setAt(int index, SimpleObject obj) {
		referenceArray[index] = obj;
	}
	
	public void setAt(int index, char prim) {
		primitiveArray[index] = prim;
	}
	
}
