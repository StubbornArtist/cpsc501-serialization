import java.util.ArrayList;
import java.util.List;

public class ReferenceObjectView extends ObjectView{
	
	
	public void requestSimpleObj() {
		System.out.println("SimpleObject simpleObject: ");
	}
	
	public void requestNum() {
		System.out.println("int num : ");
	}
	
	public void requestLetter() {
		System.out.println("char letter : ");
	}
			
	@Override
	public String getName() {
		return "ReferenceObject";
	}

	@Override
	public void run() {
		
		List<String> args = new ArrayList<String>();
		requestSimpleObj();
		requestNum();
		args.add(getLine());
		requestLetter();
		args.add(getLine());
	
		notifyController(args);
	}

}
