import java.util.ArrayList;
import java.util.Collection;

public class ReferenceCollectionObject {
	
	private Collection<SimpleObject> simpleObjects;
	
	public ReferenceCollectionObject() {
		simpleObjects = new ArrayList<SimpleObject>();
	}
	
	public void addSimpleObject(SimpleObject obj) {
		simpleObjects.add(obj);
	}

}
