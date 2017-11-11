
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SimpleObjectView view1 = new SimpleObjectView();
		SimpleObjectController controller1 = new SimpleObjectController(view1);
		
		ArrayObjectView view2 = new ArrayObjectView();
		ArrayObjectController controller2 = new ArrayObjectController(view2);
		
		ObjectCreatorView view = new ObjectCreatorView();
		view.addObjectView(view1);
		view.addObjectView(view2);
		
		view.run();
	}

}
