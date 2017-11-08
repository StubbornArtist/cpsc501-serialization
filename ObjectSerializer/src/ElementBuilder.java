import org.jdom2.Element;

public class ElementBuilder {
	
	public static ObjectElement create (Object obj, RootElement root) {
		Class<?> classObj = obj.getClass();
		
		if(classObj.isArray()) {
			return new ArrayElement(obj, root);
		}
		
		return new ObjectElement(obj, root);
	}
	
	
	public static Element create(Class<?> type, Object member, RootElement root) {		
		if(member == null || type.isPrimitive()) {
			return new ValueElement(member, root);
		}
		return new ReferenceElement(member, root);
	}

}
