
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SimpleObjectView view1 = new SimpleObjectView();
		SimpleObjectController controller1 = new SimpleObjectController(view1);
		
		ArrayObjectView view2 = new ArrayObjectView();
		ArrayObjectController controller2 = new ArrayObjectController(view2);
		
		ReferenceObjectView view3 = new ReferenceObjectView();
		ReferenceObjectController controller3 = new ReferenceObjectController(view3);
		
		ReferenceArrayObjectView view4 = new ReferenceArrayObjectView();
		ReferenceArrayObjectController controller4 = new ReferenceArrayObjectController(view4);
		
		ReferenceCollectionObjectView view5 = new ReferenceCollectionObjectView();
		ReferenceCollectionObjectController controller5 = new ReferenceCollectionObjectController(view5);
		
		ObjectCreatorView view = new ObjectCreatorView();
		view.addObjectView(view1);
		view.addObjectView(view2);
		view.addObjectView(view3);
		view.addObjectView(view4);
		view.addObjectView(view5);
		
		view.run();
	}

}
