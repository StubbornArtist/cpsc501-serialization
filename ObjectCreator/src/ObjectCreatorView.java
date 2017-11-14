import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ObjectCreatorView extends View{
	 
	private List<ObjectView> objectViews;
	
	public ObjectCreatorView() {
		objectViews = new ArrayList<ObjectView>();
	}
	
	public void requestObject() {
		System.out.println("Select one of the objects below... ");
		for(int i = 0; i < objectViews.size(); i++) {
			ObjectView curView = objectViews.get(i);
			System.out.println( (i + 1) + " : " + curView.getName());
		}
		System.out.println("\nSelection : ");
	}
		
	public void addObjectView(ObjectView objView) {
		objectViews.add(objView);
	}
	
	@Override
	public void run() {
		requestObject();
		Integer view = new Integer(getLine());
		objectViews.get(view - 1).run();
	}
}
