
public class ReferenceArrayObject {
	
	private SimpleObject [] simpleObjects;
	
	public ReferenceArrayObject(int length) {
		simpleObjects = new SimpleObject[length];
	}
	
	public ReferenceArrayObject() {
		this(1);
	}
	
	public void setAt(int index, SimpleObject simpObj) {
		simpleObjects[index] = simpObj;
	}

}
