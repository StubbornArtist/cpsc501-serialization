import java.util.List;

public abstract class Controller {
	
	private View view;
	
	public Controller(View view) {
		this.view = view;
		this.view.addListener(this);
	}
	
	public abstract void onTextInput(List<String> input);

}
