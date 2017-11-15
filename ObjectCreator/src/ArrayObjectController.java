import java.util.List;

public class ArrayObjectController extends Controller {
	
	private PrimitiveArrayObject model;
	
	public ArrayObjectController(View view) {
		super(view);
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
		catch(Exception e) {
			throw new RuntimeException();
		}
	}

}
