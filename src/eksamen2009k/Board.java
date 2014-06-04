package eksamen2009k;


public class Board {
	
	private Piece[][] board;
	private static final int ROWS = 6;
	private static final int COLS = 7;
	
	public Board() {
		board = new Piece[ROWS][COLS];
	}
	
	public Piece getPiece(int x, int y) {
		if (isLegal(x, y)) {
			return board[y][x];
		} else {
			return null;
		}
	}
	
	public void setPiece(int x, int y, Piece piece) {
		if (isLegal(x, y)) {
			board[y][x] = piece;
		}
	}
	
	public boolean isLegal(int x, int y) {
		return (x >= 0 && x < COLS && y >= 0 && y < ROWS);
	}
	
	public int getDropRow(int column) {
		if (column < 0 || column >= COLS) {
			return -1;
		}
		for (int y = 0; y < ROWS; y++) {
			if (getPiece(column, y) == null) {
				return y;
			}
		}
		return -1;
	}
	
	public int place(int x, Piece piece) {
		if (isLegalDrop(x)) {
			int y = getDropRow(x);
			setPiece(x, y, piece);
			if (isFourInARow(x, y, piece)) {
				return -1;
			} else {
				return 0;				
			}
		} else {
			return -2;
		}
	}
	
	public boolean isFourInARow(int x, int y, Piece piece) {
		for (Direction d : Direction.values()) {
			if (count(piece, x, y, d) >= 4) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isLegalDrop(int column) {
		return getDropRow(column) >= 0;
	}
	
	public int count(Piece piece, int column, int row, Direction direction) {
		int count = 1;
		while (isLegal(column, row) && getPiece(column, row) == piece) {
			row += direction.dy;
			column += direction.dx;
			count++;
		}
		return count;
	}
	
	public void printBoard(Piece current) {
		System.out.println(" " + "0123456");
		for (int y = ROWS-1; y >= 0; y--) {
			System.out.print(y);
			for (int x = 0; x < COLS; x++) {
				System.out.print((getPiece(x,y) == null) ? '.' : (getPiece(x, y) == Piece.DARK ? 'x' : 'o'));
			}
			System.out.println();
		}
		System.out.println(" " + "0123456");
		System.out.println(current + "'s turn");
	}
	
}
