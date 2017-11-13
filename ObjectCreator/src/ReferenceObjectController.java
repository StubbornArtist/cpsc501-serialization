import java.util.List;

public class ReferenceObjectController implements IController{

	private ObjectView view;
	private ReferenceObject model;
	
	public ReferenceObjectController(ObjectView view) {
		this.view = view;
		this.view.addListener(this);
		this.model = new ReferenceObject();
	}
	
	
	@Override
	public void onTextInput(List<String> input) {
		SimpleObject simpleObject = new SimpleObject();
		simpleObject.setNum(new Integer(input.remove(0)));
		simpleObject.setLetter(input.remove(0).charAt(0));
		
		model.setSimpleObject(simpleObject);
		
		for(int i = 0; i < input.size() - 1; i++) {
			SimpleObject member = new SimpleObject();
			member.setNum(new Integer(input.get(i)));
			member.setLetter(input.get(i + 1).charAt(0));
			model.addSimpleObject(member);
		}
		
		try {
			ObjectSender.getInstance().send(model);
		}catch(Exception e) {}
	}

}
