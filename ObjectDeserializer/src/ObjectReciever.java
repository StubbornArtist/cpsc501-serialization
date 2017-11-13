import java.io.DataInputStream;
import java.io.StringReader;
import java.net.ServerSocket;
import java.net.Socket;

import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;

public class ObjectReciever {

	private static ServerSocket socket;
	private static Deserializer deserializer;
	private static Inspector inspector;
	
	static {
		
		deserializer = new Deserializer();
		inspector = new Inspector();	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			socket = new ServerSocket(8080);
			socket.setSoTimeout(100000);
			
			while(true) {
				Socket server = socket.accept();
				DataInputStream in = new DataInputStream(server.getInputStream());
				
				String input = in.readUTF();
				SAXBuilder builder = new SAXBuilder();
				Document doc = builder.build(new StringReader(input));
				
				Object obj = deserializer.deserialize(doc);
				inspector.inspect(obj);
				
			}	
		}
		catch(Exception e) {}
	}

}
