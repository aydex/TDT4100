package eksamen2009k;

public enum Direction {
	NORTH(0,1), NORTHWEST(1,1), EAST(1,0), SOUTHEAST(1,-1), SOUTH(0,-1), SOUTHWEST(-1,-1), WEST(-1,0), NORTHEAST(-1,1);
	
	public final int dx, dy;
	
	Direction(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	public Direction opposite() {
		switch(this) {
		case NORTH:
			return SOUTH;
		case NORTHWEST:
			return SOUTHEAST;
		case WEST:
			return EAST;
		case SOUTHWEST:
			return NORTHEAST;
		case SOUTH:
			return NORTH;
		case SOUTHEAST:
			return NORTHWEST;
		case EAST:
			return WEST;
		case NORTHEAST:
			return SOUTHWEST;
		}
		return null;
	}
	
}
