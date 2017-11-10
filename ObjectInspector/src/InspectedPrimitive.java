public class InspectedPrimitive extends InspectedComponent{
	
	private Object value;
	
	protected InspectedPrimitive(Object primitive) {
		
		value = primitive;
		
	}
	
	public Object getObject() {
		return value;
	}
	
	
	public String inspect() {
		return "Value : " + value; 
	}

}
