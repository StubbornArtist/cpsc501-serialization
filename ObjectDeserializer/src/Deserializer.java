import org.jdom2.Document;

public class Deserializer {
	
	private Root root;
	
	public Object deserialize(Document doc) {
		root = new Root(doc.getRootElement());
		return root.conversion();
	}
}
