import java.util.List;

public class SimpleObjectController extends Controller{

	private SimpleObject model;
	
	public SimpleObjectController(View view) {
		super(view);
		this.model = new SimpleObject();
	}
	
	@Override
	public void onTextInput(List<String>input) {
		model.setNum(new Integer(input.remove(0)));
		model.setLetter(input.remove(0).charAt(0));
		
		try {
			ObjectSender.getInstance().send(model);
		}catch(Exception e) {
			throw new RuntimeException();
		}
		
	}

}
