import java.util.ArrayList;
import java.util.List;

public class ReferenceCollectionObjectView extends ObjectView{

	public void requestNum() {
		System.out.println("int num : ");
	}
	
	public void requestLetter() {
		System.out.println("char letter : ");
	}

	public void questionContinue() {
		System.out.println("add another member? y/n");
	}
	
	@Override
	public String getName() {
		return "ReferenceCollectionObject";
	}

	@Override
	public void run() {
		List<String> args = new ArrayList<String>();
		do {
			requestNum();
			args.add(getLine());
			requestLetter();
			args.add(getLine());
			questionContinue();
		} while(getLine().toLowerCase().equals("y"));	
		
		notifyController(args);
	}

}
