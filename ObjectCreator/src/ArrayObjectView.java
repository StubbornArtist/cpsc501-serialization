import java.util.Scanner;

public class ArrayObjectView implements ObjectView{

	private IController controller;
	private Scanner input;
	
	public ArrayObjectView() {
		input = new Scanner(System.in);
	}
	
	
	public void requestLength() {
		System.out.println("int length : ");
	}
	
	public void requestCharMember(int index) {
		System.out.println("char " + index + " : " );	
	}
	
	
	@Override
	public String getName() {
		return "ArrayObject";
	}

	@Override
	public void run() {
		requestLength();
		Integer len = new Integer(input.nextLine());
		String [] args = new String[(2 * len) + 1];
		args[0] = len.toString();
		
		for(int i = 0; i < len; i++) {
			requestCharMember(i);
			args[i + 1] = input.nextLine();
		}
		
		controller.onTextInput(args);
	}

	@Override
	public void addListener(IController controller) {
		this.controller = controller;
	}

}
