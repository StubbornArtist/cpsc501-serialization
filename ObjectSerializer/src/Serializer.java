import org.jdom2.Document;


public class Serializer {
	
	private RootElement root;
		
	public Document serialize(Object obj) {
		root = new RootElement(obj);
		return new Document(root);
	}
	
}
