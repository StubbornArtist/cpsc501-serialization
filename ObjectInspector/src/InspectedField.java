import java.lang.reflect.Field;

public class InspectedField extends InspectedComponent{
	
	private InspectedComponent value;
	private Field field;
	
	public InspectedField(Field field) {
		this.field = field;
	}
	
	public void setValue(Object obj) {
		value = InspectedComponent.create(field.getType(), obj);
	}
	
	@Override
	public String inspect() {
		return "Name : " + field.getName() + 
				"\n" + value.inspect();
	}

}
