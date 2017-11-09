public class NullFieldClass {
	
	protected Object obj;
	
	public NullFieldClass() {}
	@Override
	public boolean equals(Object other) {
		if((other == null)||!(other instanceof NullFieldClass)) return false;
		return obj == ((NullFieldClass)other).obj;
	}

}
