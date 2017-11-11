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

	
	public void recieveInput() {
		String [] args = new String[2];
		requestNum();
		args[0] = input.nextLine();
		requestLetter();
		args[1] = input.nextLine();
		
		controller.onTextInput(args);
	}
	
	
	@Override
	public String getName() {
		return "SimpleObject";
	}

	@Override
	public void run() {
		recieveInput();
	}

	@Override
	public void addListener(IController controller) {
		this.controller = controller;
	}

}
