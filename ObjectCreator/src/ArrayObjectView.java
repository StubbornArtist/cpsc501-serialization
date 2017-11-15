import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayObjectView extends ObjectView{
	
	public void requestLength() {
		System.out.println("int length : ");
	}
	
	public void requestCharMember(int index) {
		System.out.println("char " + index + " : " );	
	}
	
	@Override
	public String getName() {
		return "PrimitiveArrayObject";
	}

	@Override
	public void run() {
		requestLength();
		Integer len = new Integer(getLine());
		
		List<String> args = new ArrayList<String>();
		args.add(len.toString());
		
		for(int i = 0; i < len; i++) {
			requestCharMember(i);
			args.add(getLine());
		}	
		notifyController(args);
	}
}
