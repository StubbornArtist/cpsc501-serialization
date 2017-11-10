
public class Inspector {
	
	
	public void inspect(Object obj) {
		InspectedObject result = (InspectedObject)InspectedComponent.create(obj.getClass(),obj);
		System.out.println(result.inspect());
	}

}
