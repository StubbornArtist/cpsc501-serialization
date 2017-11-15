import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.jdom2.Element;

public class XMLObjectConverter extends XMLConverter{
	
	private Class<?> type;
	private Element object;
	
	protected XMLObjectConverter(Element object, Root root) {
		super(root);
		this.object = object;
		
		String className = object.getAttributeValue("class");
		try {
			type = Class.forName(className);
		}
		catch(Exception e) {}	
	}
	
	public Class<?> getType(){
		return type;
	}
	
	public Element getElement() {
		return object;
	}
	
	@Override
	public Object conversion() {
		try {
			Object base = type.newInstance();
			setMembers(base);
			return base;
		}
		catch(Exception e) {
			throw new RuntimeException();
		}
	}
	
	private void setMembers(Object obj) {
		for(Element field : object.getChildren()) {
			try {
				String name = field.getAttributeValue("name");
				Element value = field.getChildren().get(0);
				
				Field f = obj.getClass().getDeclaredField(name);
				int mods = f.getModifiers();
				
				if(!Modifier.isFinal(mods)) {
					f.setAccessible(true);
					f.set(obj, XMLConverter.convert(value, getRoot()));
				}
			}catch(Exception e){
				throw new RuntimeException();
			}
		}
	}

}
