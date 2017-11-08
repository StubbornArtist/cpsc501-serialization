
public class ClassTest2 {
	private int [] ints;
	
	public ClassTest2() {
		this(0,0);
	}
	
	public ClassTest2(int a, int b) {
		ints = new int[2];
		ints[0] = a;
		ints[1] = b;
	}
	
	@Override
	public String toString() {
		String res = "";
		for(int i = 0; i < ints.length; i++) {
			res +=  i + " : " + ints[i] + "\n";
		}
		return res;
	}
}
