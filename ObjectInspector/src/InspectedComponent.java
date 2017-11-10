
public abstract class InspectedComponent {
	
	
	public static InspectedComponent create(Class<?> type, Object value) {
		
		if(value == null || type.isPrimitive()) {
			return new InspectedPrimitive(value);
		}
		else if(type.isArray()) {
			return new InspectedArray(value);
		}
		
		return new InspectedObject(value);
	}
	
	
	public abstract String inspect();

}
