import java.util.List;

public class ReferenceObjectController extends Controller{

	private ReferenceObject model;
	
	public ReferenceObjectController(View view) {
		super(view);
		this.model = new ReferenceObject();
	}
	
	
	@Override
	public void onTextInput(List<String> input) {
		SimpleObject simpleObject = new SimpleObject();
		simpleObject.setNum(new Integer(input.remove(0)));
		simpleObject.setLetter(input.remove(0).charAt(0));
		
		model.setSimpleObject(simpleObject);
				
		try {
			ObjectSender.getInstance().send(model);
		}catch(Exception e) {}
	}

}
