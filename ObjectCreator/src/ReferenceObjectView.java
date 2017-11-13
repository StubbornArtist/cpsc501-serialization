import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReferenceObjectView implements ObjectView{

	private IController controller;
	private Scanner input;
	
	
	public ReferenceObjectView() {
		input = new Scanner(System.in);
	}
	
	public void requestLength() {
		System.out.println("int length : ");
	}
	
	public void requestSimpleObj() {
		System.out.println("SimpleObject simpleObject: ");
	}
	
	public void requestSimpleObjNum() {
		System.out.println("int num : ");
	}
	
	public void requestSimpleObjLetter() {
		System.out.println("char letter : ");
	}
	
	
	public void requestMember(int index) {
		System.out.println( index + " : SimpleObject" );
	}
	
	@Override
	public String getName() {
		return "ReferenceObject";
	}

	@Override
	public void run() {
		
		List<String> args = new ArrayList<String>();
		
		requestLength();
		Integer len = new Integer(input.nextLine());
		requestSimpleObj();
		requestSimpleObjNum();
		args.add(input.nextLine());
		requestSimpleObjLetter();
		args.add(input.nextLine());
		
		for(int i = 0; i < len; i++) {
			requestMember(i);
			requestSimpleObjNum();
			args.add(input.nextLine());
			requestSimpleObjLetter();
			args.add(input.nextLine());
		}
		
		controller.onTextInput(args);
	}

	@Override
	public void addListener(IController controller) {
		this.controller = controller;
	}

}
