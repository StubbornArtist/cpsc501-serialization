import java.util.List;
import java.util.Scanner;

public abstract class View {
	
	private Scanner input;
	private Controller controller;
	
	
	public View() {
		input = new Scanner(System.in);
	}
	
	public String getLine() {
		return input.nextLine();
	}
	
	public abstract void run();
	
	public void notifyController(List<String> args) {
		controller.onTextInput(args);
	}
	
	public void addListener(Controller controller) {
		this.controller = controller;
	}
}
