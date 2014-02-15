package Oving1;

public class LineEditor {
	
	public String text;
	int insertionIndex;
	
	public LineEditor() {
		this.insertionIndex = 0;
		this.text = "";
	}
	
	public void left() {
		if (this.insertionIndex > 0) {
			this.insertionIndex--;
		}
	}
	
	public void right() {
		if (this.insertionIndex < this.text.length()) {
			this.insertionIndex++;
		}
	}
	
	public void insertString(String s) {
		if (this.text.isEmpty()) {
			this.text = s;
			this.insertionIndex = this.text.length();
		} else {
			this.text = this.text.substring(0, this.insertionIndex) + s + this.text.substring(this.insertionIndex);
			this.insertionIndex += s.length();
		}
		
	}
	
	public void deleteLeft() {
		if (this.text != "") {
			this.text = this.text.substring(0, this.insertionIndex-1) + this.text.substring(this.insertionIndex);
			this.insertionIndex--;
		}
	}
	
	public void deleteRight() {
		if (this.text != "") {
			this.text = this.text.substring(0, this.insertionIndex) + this.text.substring(this.insertionIndex+1, this.text.length());			
		}
	}
	
	public String toString() {
		return this.text.substring(0, this.insertionIndex) + "|" + this.text.substring(this.insertionIndex, this.text.length());
	}

	public static void main(String[] args) {
		LineEditor s = new LineEditor();
		s.insertString("Text");
		System.out.println(s);
		s.deleteLeft();
		s.deleteLeft();
		s.insertString("st");
		System.out.println(s);
		s.left();
		s.left();
		s.deleteLeft();
		s.insertString("a");
		System.out.println(s);
		s.deleteRight();
		s.insertString("k");
		s.right();
		s.right();
		System.out.println(s);
	}
}
