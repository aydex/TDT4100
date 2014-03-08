package oving7;

public class Square {
	
	private char value;
	
	public Square(char c) {
		if(c == '#' || c == '.' || c == '$' || c == '*' || c == '@' || c == '+' || c == ' ') {
			setValue(c);
		} else {
			throw new IllegalArgumentException("Invalid square type");
		}
	}
	
	public char getValue() {
		return this.value;
	}
	
	public void setValue(char c) {
		this.value = c;
	}
	
	public boolean isEmpty() {
		if (this.value == ' ' || this.value == '.') {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isTarget() {
		if (this.value == '.' || this.value == '+') {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isPlayer() {
		if (this.value == '@' || this.value == '+') {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return String.valueOf(this.value);
	}
}
