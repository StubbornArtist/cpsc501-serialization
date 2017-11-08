import org.jdom2.Document;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Serializer s = new Serializer();
		Deserializer d = new Deserializer();
		ClassTest t = new ClassTest();
		
		System.out.println(t);
		
		Document doc = s.serialize(t);
		ClassTest obj = (ClassTest) d.deserialize(doc);
		
		System.out.println(obj);
	
	}

}
