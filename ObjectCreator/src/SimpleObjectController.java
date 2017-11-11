import java.io.IOException;

public class SimpleObjectController implements IController{

	private SimpleObjectView view;
	private SimpleObject model;
	
	public SimpleObjectController(SimpleObjectView view) {
		this.view = view;
		this.view.addListener(this);
		this.model = new SimpleObject();
	}
	
	@Override
	public void onTextInput(String [] input) {
		model.setNum(new Integer(input[0]));
		model.setLetter(input[1].charAt(0));
		
		try {
			ObjectSender.getInstance().send(model);
		}catch(IOException e) {}
		
	}

}
