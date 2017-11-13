import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.jdom2.Document;
import org.jdom2.output.XMLOutputter;

public class ObjectSender {
	
	
	private Serializer serializer;
	private Socket socket;
	private static ObjectSender instance;
	
	
	private ObjectSender() throws IOException {
		serializer = new Serializer();
		socket = new Socket("127.0.0.1", 8080);
	}
	
	public static ObjectSender getInstance() throws IOException{
		if(instance == null) {
			instance = new ObjectSender();
		}
		return instance;
	}
	
	
	public void send(Object obj) throws IOException {
		Document doc = serializer.serialize(obj);
		XMLOutputter xmlOut = new XMLOutputter();
		String xml = xmlOut.outputString(doc);
		
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		out.writeUTF(xml);
		
		socket.close();
	}
	
	

}
