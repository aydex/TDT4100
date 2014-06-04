package eksamen2009;

public enum Piece {
	WHITE, BLACK;
	
	public Piece other() {
		switch(this) {
		case WHITE:
			return BLACK;
		case BLACK:
			return WHITE;
		}
		return null;
	}
}
