import java.lang.reflect.Field;

import org.jdom2.Element;

public class FieldElement extends Element{
	
	public FieldElement(Field field) {
		super("field");		
		setDeclaringClass(field.getDeclaringClass());
		setFieldName(field.getName());
	}
	
	public void setDeclaringClass(Class<?> type) {
		setAttribute("declaringclass", type.getName());
	}
	
	public void setFieldName(String name) {
		setAttribute("name", name);
	}
}
