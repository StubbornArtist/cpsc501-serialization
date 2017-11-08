import java.util.HashMap;

import org.jdom2.Element;

public class RootElement extends Element{
	
	private HashMap<Object,Integer> objects;
	
	public RootElement(Object rootObj) {
		super("serialized");
		objects = new HashMap<Object, Integer>();
		addObject(rootObj);
	}
	
	public Integer getId(Object obj) {
		return objects.get(obj);
	}
	
	public boolean hasObject(Object obj) {
		return objects.containsKey(obj);
	}
	
	public void addObject(Object obj) {
		Integer id = objects.size();
		objects.put(obj, id);
		
		ObjectElement ele = ElementBuilder.create(obj, this);
		ele.setAttribute("id", id.toString());
		
		addContent(ele);
	}
	
}
