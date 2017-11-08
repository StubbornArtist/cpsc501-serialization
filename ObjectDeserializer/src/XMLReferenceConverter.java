import org.jdom2.Element;

public class XMLReferenceConverter extends XMLConverter {
	
	private Integer id; 
	
	protected XMLReferenceConverter(Element ref, Root root) {
		super(root);
		id = new Integer(ref.getText());
	}
	
	
	@Override
	public Object conversion() {
		Root root = getRoot();
		
		if(!root.hasObject(id)) {
			root.addObject(id);
		}
		return root.getObject(id);
	}

}
