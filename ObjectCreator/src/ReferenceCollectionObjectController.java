import java.util.List;

public class ReferenceCollectionObjectController extends Controller{
	
	private ReferenceCollectionObject model;
	
	public ReferenceCollectionObjectController(View view) {
		super(view);
		this.model = new ReferenceCollectionObject();
	}

	@Override
	public void onTextInput(List<String> input) {
		
		for(int i = 0; i <= input.size()/2; i++) {
			
			SimpleObject obj = new SimpleObject();
			obj.setNum(new Integer(input.remove(0)));
			obj.setLetter(input.remove(0).charAt(0));
			
			model.addSimpleObject(obj);
		}
		try {
			ObjectSender.getInstance().send(model);
		}catch(Exception e) {
			
			throw new RuntimeException();
		}
	}

}
