package oving4;


public class Board {
	
	private Square[][] boardArray;
	private int width = 0;
	private int height = 0;
	private int playerX;
	private int playerY;
	
	public Board (String board) {
		String[] readLines = board.split("\n");
		width = readLines[0].length();
		height = readLines.length;
		boardArray = new Square[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < readLines[i].length(); j++) {
				boardArray[i][j] = new Square(readLines[i].charAt(j));
				if (boardArray[i][j].isPlayer()) {
					setPlayerX(j);
					setPlayerY(i);
				}
			}
		}
	}
	
	public Square[][] getBoard() {
		return boardArray;
	}
	
	public Boolean goal() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (boardArray[i][j].getValue() == '$') {
					return false;
				}
			}
		}
		return true;
	}
	
	public Boolean up() {
		int x = getPlayerX();
		int y = getPlayerY();
		char repChar;
		boolean retVal = false;
		if (boardArray[y][x].getValue() =='+') {
			repChar = '.';
		} else {
			repChar = ' ';
		}
		
		switch (boardArray[y-1][x].getValue()) {
		case ' ':
			boardArray[y-1][x].setValue('@');
			boardArray[y][x].setValue(repChar);
			setPlayerY(y-1);
			retVal = true;
			break;
		case '.':
			boardArray[y-1][x].setValue('+');
			boardArray[y][x].setValue(repChar);
			setPlayerY(y-1);
			retVal = true;
			break;
		case '#':
			retVal = false;
			break;
		case '$':
			switch (boardArray[y-2][x].getValue()) {
			case ' ':
				boardArray[y-2][x].setValue('$');
				boardArray[y-1][x].setValue(' ');
				return this.up();
			case '.':
				boardArray[y-2][x].setValue('*');
				boardArray[y-1][x].setValue(' ');
				return this.up();
			default:
				retVal = false;
				break;
			}
			break;
		case '*':
			switch (boardArray[y-2][x].getValue()) {
			case ' ':
				boardArray[y-2][x].setValue('$');
				boardArray[y-1][x].setValue('.');
				return this.up();
			case '.':
				boardArray[y-2][x].setValue('*');
				boardArray[y-1][x].setValue('.');
				return this.up();
			default:
				retVal = false;
				break;
			}
			break;
		default:
			break;
		}
		return retVal;
	}
	
	public Boolean left() {
		int x = getPlayerX();
		int y = getPlayerY();
		char repChar;
		boolean retVal = false;
		if (boardArray[y][x].getValue() =='+') {
			repChar = '.';
		} else {
			repChar = ' ';
		}
		
		switch (boardArray[y][x-1].getValue()) {
		case ' ':
			boardArray[y][x-1].setValue('@');
			boardArray[y][x].setValue(repChar);
			setPlayerX(x-1);
			retVal = true;
			break;
		case '.':
			boardArray[y][x-1].setValue('+');
			boardArray[y][x].setValue(repChar);
			setPlayerX(x-1);
			retVal = true;
			break;
		case '#':
			retVal = false;
			break;
		case '$':
			switch (boardArray[y][x-2].getValue()) {
			case ' ':
				boardArray[y][x-2].setValue('$');
				boardArray[y][x-1].setValue(' ');
				return this.left();
			case '.':
				boardArray[y][x-2].setValue('*');
				boardArray[y][x-1].setValue(' ');
				return this.left();
			default:
				retVal = false;
				break;
			}
			break;
		case '*':
			switch (boardArray[y][x-2].getValue()) {
			case ' ':
				boardArray[y][x-2].setValue('$');
				boardArray[y][x-1].setValue('.');
				return this.left();
			case '.':
				boardArray[y][x-2].setValue('*');
				boardArray[y][x-1].setValue('.');
				return this.left();
			default:
				retVal = false;
				break;
			}
			break;
		default:
			break;
		}
		return retVal;
	}
	
	public Boolean right() {
		int x = getPlayerX();
		int y = getPlayerY();
		char repChar;
		boolean retVal = false;
		if (boardArray[y][x].getValue() =='+') {
			repChar = '.';
		} else {
			repChar = ' ';
		}
		
		switch (boardArray[y][x+1].getValue()) {
		case ' ':
			boardArray[y][x+1].setValue('@');
			boardArray[y][x].setValue(repChar);
			setPlayerX(x+1);
			retVal = true;
			break;
		case '.':
			boardArray[y][x+1].setValue('+');
			boardArray[y][x].setValue(repChar);
			setPlayerX(x+1);
			retVal = true;
			break;
		case '#':
			retVal = false;
			break;
		case '$':
			switch (boardArray[y][x+2].getValue()) {
			case ' ':
				boardArray[y][x+2].setValue('$');
				boardArray[y][x+1].setValue(' ');
				return this.right();
			case '.':
				boardArray[y][x+2].setValue('*');
				boardArray[y][x+1].setValue(' ');
				return this.right();
			default:
				retVal = false;
				break;
			}
			break;
		case '*':
			switch (boardArray[y][x+2].getValue()) {
			case ' ':
				boardArray[y][x+2].setValue('$');
				boardArray[y][x+1].setValue('.');
				return this.right();
			case '.':
				boardArray[y][x+2].setValue('*');
				boardArray[y][x+1].setValue('.');
				return this.right();
			default:
				retVal = false;
				break;
			}
			break;
		default:
			break;
		}
		return retVal;
	}
	
	public Boolean down() {
		int x = getPlayerX();
		int y = getPlayerY();
		char repChar;
		boolean retVal = false;
		if (boardArray[y][x].getValue() =='+') {
			repChar = '.';
		} else {
			repChar = ' ';
		}
		
		switch (boardArray[y+1][x].getValue()) {
		case ' ':
			boardArray[y+1][x].setValue('@');
			boardArray[y][x].setValue(repChar);
			setPlayerY(y+1);
			retVal = true;
			break;
		case '.':
			boardArray[y+1][x].setValue('+');
			boardArray[y][x].setValue(repChar);
			setPlayerY(y+1);
			retVal = true;
			break;
		case '#':
			retVal = false;
			break;
		case '$':
			switch (boardArray[y+2][x].getValue()) {
			case ' ':
				boardArray[y+2][x].setValue('$');
				boardArray[y+1][x].setValue(' ');
				return this.down();
			case '.':
				boardArray[y+2][x].setValue('*');
				boardArray[y+1][x].setValue(' ');
				return this.down();
			default:
				retVal = false;
				break;
			}
			break;
		case '*':
			switch (boardArray[y+2][x].getValue()) {
			case ' ':
				boardArray[y+2][x].setValue('$');
				boardArray[y+1][x].setValue('.');
				return this.down();
			case '.':
				boardArray[y+2][x].setValue('*');
				boardArray[y+1][x].setValue('.');
				return this.down();
			default:
				retVal = false;
				break;
			}
			break;
		default:
			break;
		}
		return retVal;
	}
	
	public void setPlayerX(int x) {
		this.playerX = x;
	}
	
	public void setPlayerY(int y) {
		this.playerY = y;
	}
	
	public int getPlayerX() {
		return this.playerX;
	}
	
	public int getPlayerY() {
		return this.playerY;
	}
	
	public String toString() {
		String returnString = "";
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				returnString += this.boardArray[i][j];
			}
			returnString += "\n";
		}
		return returnString;
	}
	
	public static void main(String[] args) {
		Board board = new Board(SampleLevels.SAMPLE_LEVEL3);
		System.out.println(board);
	}
}
