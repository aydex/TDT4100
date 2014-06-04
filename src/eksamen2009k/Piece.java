package eksamen2009k;

public enum Piece {
	LIGHT, DARK;
	
	public Piece other() {
		switch(this) {
		case DARK:
			return LIGHT;
		case LIGHT:
			return DARK;
		}
		return null;
	}
}
