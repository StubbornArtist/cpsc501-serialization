import java.util.List;

public class ReferenceArrayObjectController extends Controller{
	
	private ReferenceArrayObject model;
	
	public ReferenceArrayObjectController(View view) {
		super(view);
	}

	@Override
	public void onTextInput(List<String> input) {
		Integer length = new Integer(input.remove(0));
		model = new ReferenceArrayObject(length);
		
		for(int i = 0; i < length; i++) {
			SimpleObject obj = new SimpleObject();
			obj.setNum(new Integer(input.remove(0)));
			obj.setLetter(input.remove(0).charAt(0));
			model.setAt(i, obj);
		}
		
		try {
			ObjectSender.getInstance().send(model);
		}catch(Exception e) {
			throw new RuntimeException();
		}
	}
	
	

}
