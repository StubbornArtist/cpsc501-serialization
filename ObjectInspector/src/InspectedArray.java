import java.lang.reflect.Array;

public class InspectedArray extends InspectedObject {
	
	private int length;
	
	protected InspectedArray(Object array) {
		super(array);
		length = Array.getLength(array);
	}
	
	
	@Override
	public void setMembers() {
		Object array = getObject();
		int length = Array.getLength(array);
		
		for(int i = 0; i < length; i++) {
			Object val = Array.get(getObject(), i);
			addMember(InspectedComponent.create(array.getClass().getComponentType(), val));
		}
	}
	
	@Override
	public String inspect() {
		return super.inspect() +
		"\nLength : " + length;
	}
}
