import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;

public class InspectedObject extends InspectedPrimitive{
	
	private Collection<InspectedComponent> members;
		
	protected InspectedObject(Object obj) {
		super(obj);
		members = new ArrayList<InspectedComponent>();
		setMembers();
	}
	
	protected void setMembers() {
		for(Field field : getObject().getClass().getDeclaredFields()) {
			field.setAccessible(true);
			try {
				InspectedField iField = new InspectedField(field);
				Object val = field.get(getObject());
				iField.setValue(val);
				addMember(iField);
			}
			catch(Exception e) {}
		}
	}
	
	public void addMember(InspectedComponent member) {
		members.add(member);
	}
	
	public String inspectMembers() {
		String result = "\n\n";
		for(InspectedComponent mem : members) {
			result +=  mem.inspect() + "\n\n";
		}
		return result;
	}
		
	@Override
	public String inspect() {
		String result = "Class : " + getObject().getClass().getName();
		if(members.size() > 0) result +="\nMembers : " + inspectMembers();
		
		return result; 
	}

}
