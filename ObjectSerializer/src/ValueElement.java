import org.jdom2.Element;

public class ValueElement extends Element{

	
	protected ValueElement(Object obj, RootElement root) {
		super("value");	
		
		String text = "null";
		
		if(obj != null) {
			text = obj.toString();
		}
		
		setText(text);
	}

}
