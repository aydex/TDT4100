package oving7;


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
	
	public String getBoard() {
		String retString = "";
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				retString += boardArray[i][j];
			}
			retString += "\n";
		}
		return retString;
	}
	
	public void setSquare(int x, int y, Square s) {
		if (x < width && y < height) {
			
		}
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
	
	public int move(char move, boolean withBlock) {
		int x = getPlayerX();
		int y = getPlayerY();
		int nextX = x;
		int nextY = y;
		int prevX = x;
		int prevY = y;
		int blockX = x;
		int blockY = y;
		char repChar;
		int retVal = 0;
		
		switch (move) {
		case 'w':
			nextY = y-1;
			prevY = y+1;
			blockY = y-2;
			break;
		case 'a': 
			nextX = x-1;
			prevX = x+1;
			blockX = x-2;
			break;
		case 's':
			nextY = y+1;
			prevY = y-1;
			blockY = y+2;
			break;
		case 'd':
			nextX = x+1;
			prevX = x-1;
			blockX = x+2;
			break;
		}
		
		if (boardArray[y][x].getValue() =='+') {
			repChar = '.';
		} else {
			repChar = ' ';
		}
		
		switch (boardArray[nextY][nextX].getValue()) {
		case ' ':
			boardArray[nextY][nextX].setValue('@');
			boardArray[y][x].setValue(repChar);
			setPlayerY(nextY);
			setPlayerX(nextX);
			break;
		case '.':
			boardArray[nextY][nextX].setValue('+');
			boardArray[y][x].setValue(repChar);
			setPlayerY(nextY);
			setPlayerX(nextX);
			break;
		case '#':
			retVal = -1;
			break;
		case '$':
			switch (boardArray[blockY][blockX].getValue()) {
			case ' ':
				boardArray[blockY][blockX].setValue('$');
				boardArray[nextY][nextX].setValue('@');
				boardArray[y][x].setValue(repChar);
				setPlayerY(nextY);
				setPlayerX(nextX);
				retVal = 1;
				break;
			case '.':
				boardArray[blockY][blockX].setValue('*');
				boardArray[nextY][nextX].setValue('@');
				boardArray[y][x].setValue(repChar);
				setPlayerY(nextY);
				setPlayerX(nextX);
				retVal = 1;
				break;
			default:
				break;
			}
			break;
		case '*':
			switch (boardArray[blockY][blockX].getValue()) {
			case ' ':
				boardArray[blockY][blockX].setValue('$');
				boardArray[nextY][nextX].setValue('+');
				boardArray[y][x].setValue(repChar);
				setPlayerY(nextY);
				setPlayerX(nextX);
				retVal = 1;
				break;
			case '.':
				boardArray[blockY][blockX].setValue('*');
				boardArray[nextY][nextX].setValue('+');
				boardArray[y][x].setValue(repChar);
				setPlayerY(nextY);
				setPlayerX(nextX);
				retVal = 1;
				break;
			default:
				break;
			}
			break;
		default:
			break;
		}
		
		if (withBlock) {
			switch (boardArray[prevY][prevX].getValue()) {
			case '$':
				boardArray[prevY][prevX].setValue(' ');
			case '*':
				boardArray[prevY][prevX].setValue('.');
			}
			switch (boardArray[y][x].getValue()) {
			case ' ':
				boardArray[y][x].setValue('$');
				break;
			case '.':
				boardArray[y][x].setValue('*');
			}
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

}
