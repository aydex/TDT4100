package eksamen2009;

import java.util.Scanner;

public abstract class Board {
	
	public static final int BOARD_WIDTH = 8;
	public static final int BOARD_HEIGHT = 8;
	
	private Piece[][] board;
	
	public Board() {
		board = new Piece[BOARD_HEIGHT][BOARD_WIDTH];
		board[3][3] = Piece.WHITE;
		board[3][4] = Piece.BLACK;
		board[4][3] = Piece.BLACK;
		board[4][4] = Piece.WHITE;
	}
		
	public boolean isLegalPosition(int x, int y) {
		return x >= 0 && x < BOARD_WIDTH && y >= 0 && y < BOARD_HEIGHT;
	}
	
	public Piece getPiece(int x, int y) {
		return isLegalPosition(x, y) ? board[y][x] : null;
	}
	
	public void setPiece(int x, int y, Piece piece) {
		if (isLegalPosition(x, y)) {
			board[y][x] = piece;
		} 
	}
	
	private int count(int x, int y, Piece piece, Direction d, boolean replace) {
		int count = 0;
		x += d.dx;
		y += d.dy;
		while (getPiece(x, y) == piece.other()) {
			count++;
			x += d.dx;
			y += d.dy;
		}
		if (getPiece(x, y) != piece) {
			count = 0;
		}
		if (count > 0 && replace) {
			x -= d.dx;
			y -= d.dy;
			while (getPiece(x, y) == piece.other()) {
				setPiece(x, y, piece);
				x -= d.dx;
				y -= d.dy;
			}
		}
		return count;
	}
	
	public int countTraps (int x, int y, Piece piece, Direction d) {
		return count(x, y, piece, d, false);
	}
	
	public boolean canTrap(int x, int y, Piece piece) {
		int count = 0;
		for (Direction d : Direction.values()) {
			count += count(x, y, piece, d, false);
		}
		return count > 0;
	}
	
	public void place(int x, int y, Piece piece) {
		setPiece(x, y, piece);
		for (Direction d : Direction.values()) {
			count(x, y, piece, d, true);
		}
	}
	
	private boolean mustPass (Piece currentPlayer) {
		for (int i = 0; i < BOARD_HEIGHT; i++) {
			for (int j = 0; j < BOARD_WIDTH; j++) {
				if (canTrap(j, i, currentPlayer.other())) {
					return false; 
				}
			}
		}
		return true;
	}
	
	private void printBoard(Piece currentPlayer) {
		System.out.println(" " + "abcdefgh");
		if (mustPass(currentPlayer.other())) {
			System.out.println(currentPlayer.other() + " har ingen gyldige trekk");
		} else {
			for (int i = 0; i < BOARD_HEIGHT; i++) {
				String line = String.valueOf(i+1);
				for (int j = 0; j < BOARD_WIDTH; j++) {
					if (getPiece(j, i) == null) {
						line += canTrap(j, i, currentPlayer.other()) ? '+' : '.';
					} else {
						line += getPiece(j, i) == Piece.BLACK ? "x" : "o"; 					
					}
				}
				line += i+1;
				System.out.println(line);
			}
			System.out.println(" " + "abcdefgh");
			System.out.println("It is " + currentPlayer.other() + "'s turn");			
		}
	}
	
	private void inputAndPlace() {
		String x = "abcdefgh";
		String input = "";
		Piece currentPlayer = Piece.BLACK;
		printBoard(currentPlayer.other());
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			input = sc.next();
			if (!mustPass(currentPlayer)) {
				int inputX = x.indexOf(input.charAt(0));
				int inputY = Integer.parseInt("" + input.charAt(1))-1;
				if (canTrap(inputX, inputY, currentPlayer)) {
					place(inputX, inputY, currentPlayer);
					printBoard(currentPlayer);
					currentPlayer = currentPlayer.other();				
				} else {
					System.out.println("Illegal move, try again");
				}				
			} else {
				currentPlayer = currentPlayer.other();
				printBoard(currentPlayer);
			}
		}
	}
}
