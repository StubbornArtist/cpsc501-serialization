import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleObjectView extends ObjectView{
		
	public void requestNum() {
		System.out.println("int num : ");
	}
	
	public void requestLetter() {
		System.out.println("char letter : ");
	}
	
	@Override
	public String getName() {
		return "SimpleObject";
	}

	@Override
	public void run() {
		
		List<String> args = new ArrayList<String>();
		requestNum();
		args.add(getLine());
		requestLetter();
		args.add(getLine());
		
		notifyController(args);
	}

}
