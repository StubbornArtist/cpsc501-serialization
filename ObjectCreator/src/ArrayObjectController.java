import java.io.IOException;
import java.util.List;

public class ArrayObjectController implements IController {
	
	private ObjectView view;
	private ArrayObject model;
	
	public ArrayObjectController(ObjectView view) {
		this.view = view;
		this.view.addListener(this);
	}

	@Override
	public void onTextInput(List<String> input) {
		
		int length = new Integer(input.remove(0));
		model = new ArrayObject(length);
		
		for(int i = 0; i < length; i++) {
			model.setAt(i, input.remove(0).charAt(0));
		}
		
		for(int i = 0; i < length; i++) {
			SimpleObject simpObj = new SimpleObject();
			simpObj.setNum(new Integer(input.remove(0)));
			simpObj.setLetter(input.remove(0).charAt(0));
			
			model.setAt(i, simpObj);
		}
		
		try {
			ObjectSender.getInstance().send(model);
		}
		catch(IOException e) {}
	}

}
