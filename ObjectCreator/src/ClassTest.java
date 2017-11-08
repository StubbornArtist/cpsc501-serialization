
public class ClassTest {
	
	
	private ClassTest2 test;
	
	
	public ClassTest() {
		test = new ClassTest2(3,4);
	}
	
	@Override
	public String toString() {
		return "ClassTest : \ntest : " + test.toString();
	}
	
}
