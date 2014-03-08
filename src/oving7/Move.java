package oving7;

public class Move {
	
	private char value = 0;
	private boolean block = false;
	private boolean move;
	
	Move(char c) {
		if (c == 'w' || c == 'a' || c == 's' || c == 'd') {
			this.value = c;
			move = true;
		} else if (c == 'x' || c == 'u' || c == 'r') {
			this.value = c;
			move = false;
		}
	}
	
	public char getValue() {
		return value;
	}
	
	public char getOpposite() {
		switch (value) {
		case 'w':
			return 's';
		case 'a':
			return 'd';
		case 's':
			return 'w';
		case 'd':
			return 'a';
		default:
			return 0;
		}
	}

	public boolean isMove() {
		return move;
	}
	
	public boolean movedBlock() {
		return block;
	}

	public void setBlock(boolean block) {
		this.block = block;
	}
	
}
