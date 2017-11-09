public class OnePrimitiveClass {
	
	protected int prim;
	
	public OnePrimitiveClass() {
		prim = 1;
	}
	@Override
	public boolean equals(Object other) {
		if((other == null)||!(other instanceof OnePrimitiveClass)) return false;
		return prim == ((OnePrimitiveClass)other).prim;
	}
}
