
public class OneClassFieldClass {
	protected EmptyClass obj;
	
	public OneClassFieldClass() {
		obj = new EmptyClass();
	}
	@Override
	public boolean equals(Object other) {
		if((other == null) || !(other instanceof OneClassFieldClass)) return false;
		return obj.equals(((OneClassFieldClass)other).obj);
		
	}
}
