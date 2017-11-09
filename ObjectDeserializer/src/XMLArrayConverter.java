import java.lang.reflect.Array;
import org.jdom2.Element;

public class XMLArrayConverter extends XMLObjectConverter{
	
	private Integer length;
	
	protected XMLArrayConverter(Element array, Root root) {
		super(array, root);
		length = new Integer(array.getAttributeValue("length"));
	}
	
	@Override
	public Object conversion() {
		Object base = Array.newInstance(getType().getComponentType(), length);
		setMembers(base);
		return base;
	}
	
	private void setMembers(Object obj) {
		for(int i = 0; i < length; i++) {
			Element member = getElement().getChildren().get(i);
			Array.set(obj, i, XMLConverter.convert(member, getRoot()));
		}
	}

}
