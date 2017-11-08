import java.util.HashMap;
import java.util.List;

import org.jdom2.Element;

public class Root {
	
	private HashMap<Integer, Object> objects;
	private List<Element> elements;
	
	public Root(Element root) {
		objects = new HashMap<Integer, Object>();
		elements = root.getChildren();
	}
	
	public Object conversion() {
		addObject(0);
		return getObject(0);
	}
	
	public Object getObject(Integer id) {
		return objects.get(id);
	}
	
	public boolean hasObject(Integer id) {
		return objects.containsKey(id);
	}
	
	public void addObject(Integer id) {
		Element xml = findById(id);
		Object val = XMLConverter.convert(xml, this);
		objects.put(id, val);
	}
	
	public Element findById(Integer id) {
		
		for(Element ele : elements) {
			Integer curId = new Integer(ele.getAttributeValue("id"));
			
			if(id.equals(curId)) return ele;
		}
		
		throw new RuntimeException();
	}
}
