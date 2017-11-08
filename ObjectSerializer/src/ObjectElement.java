import java.lang.reflect.Field;

import org.jdom2.Element;

public class ObjectElement extends Element  {
		
	private RootElement root;
	
	protected ObjectElement(Object obj, RootElement root) {
		super("object");
		this.root = root;
		
		setClassName(obj.getClass().getName());
		setMembers(obj);
	}
	
	public void setClassName(String clazz) {
		setAttribute("class", clazz);
	}
	
	protected void setMembers(Object obj) {
		for(Field f : obj.getClass().getDeclaredFields()) {
			Element field = new FieldElement(f);
			try {
				f.setAccessible(true);
				Object val = f.get(obj);
				field.addContent(ElementBuilder.create(f.getType(),val, root));
				addContent(field);
			}
			catch(Exception e) {}
		}
	}
		
	public RootElement getRoot() {
		return root;
	}

}
