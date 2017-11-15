import java.io.IOException;
import java.util.List;

public class ArrayObjectController implements IController {
	
	private ObjectView view;
	private PrimitiveArrayObject model;
	
	public ArrayObjectController(ObjectView view) {
		this.view = view;
		this.view.addListener(this);
	}

	@Override
	public void onTextInput(List<String> input) {
		
		int length = new Integer(input.remove(0));
		model = new PrimitiveArrayObject(length);
		
		for(int i = 0; i < length; i++) {
			model.setAt(i, input.remove(0).charAt(0));
		}		
		try {
			ObjectSender.getInstance().send(model);
		}
		catch(IOException e) {}
	}

}
