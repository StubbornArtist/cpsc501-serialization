import java.util.ArrayList;
import java.util.Collection;

public class ReferenceObject {
	
	private Collection<SimpleObject> simpleObjects;
	private SimpleObject simpleObject;
	
	public ReferenceObject() {
		simpleObjects = new ArrayList<SimpleObject>();
	}
	
	public void setSimpleObject(SimpleObject obj) {
		simpleObject = obj;
	}
	
	public void addSimpleObject(SimpleObject obj) {
		simpleObjects.add(obj);
	}

}
