import org.jdom2.Element;

public class XMLValueConverter extends XMLConverter{
	
	private Object primitive;
	
	
	public XMLValueConverter(Element value, Root root) {
		super(root);
		
		String text = value.getText();
		
		if(text.equals("null")) {
			primitive = null;
		}
		else {
			primitive = PrimitiveConverter.getFromString(text);
		}
	}

	@Override
	public Object conversion() {
		return primitive;
	}

}
