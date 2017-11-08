import org.jdom2.Element;

public abstract class XMLConverter {
	
	private Root root;
	
	protected XMLConverter(Root root) {
		this.root = root;
	}
	
	public static Object convert(Element object, Root root) {
		
		XMLConverter converter = null;
		if(isArray(object)) {
			converter = new XMLArrayConverter(object, root);
		}
		else if(isObject(object)) {
			converter = new XMLObjectConverter(object, root);
		}
		else if(isReference(object)) {
			converter = new XMLReferenceConverter(object, root);
		}
		else if(isValue(object)) {
			converter = new XMLValueConverter(object, root);
		}
		
		if(converter == null) {
			throw new RuntimeException("No appropriate converter");
		}
		return converter.conversion();
	}
		
	
	public abstract Object conversion();
	
	public Root getRoot() {
		return root;
	}
	
	public static boolean isArray(Element object) {
		return isObject(object) 
				&& object.getAttribute("length") != null;
	}
	
	public static boolean isObject(Element object) {
		return object.getName().equals("object") &&
				object.getAttribute("id") != null &&
				object.getAttribute("class") != null;
	}
	
	public static boolean isReference(Element object) {
		return object.getName().equals("reference");
	}
	
	public static boolean isValue(Element object) {
		return object.getName().equals("value");
	}


}
