import java.util.Arrays;

public class PrimitiveArrayClass {
	
	protected int [] integers;
	
	public PrimitiveArrayClass() {
		integers = new int[2];
		integers[0] = 1;
		integers[1] = 2;
	}
	
	@Override
	public boolean equals(Object other) {
		if(other == null || !(other instanceof PrimitiveArrayClass)) return false;
		return Arrays.equals(((PrimitiveArrayClass)other).integers, integers);
	}
}
