
public class SimpleObject {
	
	private int num;
	private char letter;
	
	
	public SimpleObject() {
		num = 0;
		letter = ' ';
	}
	
	public SimpleObject(int i, char c) {
		num = i;
		letter = c;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public void setLetter(char letter) {
		this.letter = letter;
	}

}
