import java.io.IOException;

public class ArrayObjectController implements IController {
	
	private ObjectView view;
	private ArrayObject model;
	
	public ArrayObjectController(ObjectView view) {
		this.view = view;
		this.view.addListener(this);
	}

	@Override
	public void onTextInput(String[] input) {
		
		int length = new Integer(input[0]);
		model = new ArrayObject(length);
		
		for(int i = 0; i < length; i++) {
			model.setAt(i, input[i + 1].charAt(0));
		}
		
		try {
			ObjectSender.getInstance().send(model);
		}catch(IOException e) {}
	}

}
