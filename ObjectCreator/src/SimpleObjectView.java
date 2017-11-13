import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleObjectView implements ObjectView{

	private IController controller;
	private Scanner input; 
	
	public SimpleObjectView() {
		input = new Scanner(System.in);
	}
	
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
		args.add(input.nextLine());
		requestLetter();
		args.add(input.nextLine());
		
		controller.onTextInput(args);
	}

	@Override
	public void addListener(IController controller) {
		this.controller = controller;
	}

}
