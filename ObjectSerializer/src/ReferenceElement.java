import org.jdom2.Element;

public class ReferenceElement extends Element{
	
	
	protected ReferenceElement(Object obj, RootElement root) {
		super("reference");
	
		if(!root.hasObject(obj)) {
			root.addObject(obj);
		}
		
		setText(root.getId(obj).toString());
	}
	

}
