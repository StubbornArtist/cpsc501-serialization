import java.lang.reflect.Array;

import org.jdom2.Element;

public class ArrayElement extends ObjectElement{
	
	
	protected ArrayElement(Object obj, RootElement root) {
		super(obj, root);
		setLength(Array.getLength(obj));
	}
	
	public void setLength(Integer length) {
		setAttribute("length", length.toString());
	}

	@Override
	protected void setMembers(Object obj) {
		Class<?> compClass = obj.getClass().getComponentType();
		
		for(int i = 0; i < Array.getLength(obj); i++) {	
			Object val = Array.get(obj, i);
			Element child = ElementBuilder.create(compClass, val, getRoot());
			addContent(child);
		}
	}
	
	
}
