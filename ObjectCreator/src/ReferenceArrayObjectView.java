import java.util.ArrayList;
import java.util.List;

public class ReferenceArrayObjectView extends ObjectView {

	public void requestLength() {
		System.out.println("int length : ");
	}
	
	public void requestNum() {
		System.out.println("int num : ");
	}
	
	public void requestLetter() {
		System.out.println("char letter : ");
	}

	
	@Override
	public void run() {
		List<String> args = new ArrayList<String>();
		
		requestLength();
		Integer length = new Integer(getLine());
		args.add(length.toString());
		
		for(int i = 0; i < length; i++) {
			requestNum();
			args.add(getLine());
			requestLetter();
			args.add(getLine());
		}
		
		notifyController(args);
	}

	@Override
	public String getName() {
		return "ReferenceArrayObject";
	}

}
