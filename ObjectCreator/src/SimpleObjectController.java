import java.io.IOException;
import java.util.List;

public class SimpleObjectController implements IController{

	private SimpleObjectView view;
	private SimpleObject model;
	
	public SimpleObjectController(SimpleObjectView view) {
		this.view = view;
		this.view.addListener(this);
		this.model = new SimpleObject();
	}
	
	@Override
	public void onTextInput(List<String>input) {
		model.setNum(new Integer(input.remove(0)));
		model.setLetter(input.remove(0).charAt(0));
		
		try {
			ObjectSender.getInstance().send(model);
		}catch(IOException e) {
			
			e.getStackTrace();
		}
		
	}

}
