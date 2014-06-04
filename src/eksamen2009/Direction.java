package eksamen2009;

public enum Direction {
	
	NORTH(0, -1), NORTHEAST(1, -1), EAST(1, 0), SOUTHEAST(1, 1), SOUTH(0, 1),
	SOUTHWEST(-1, 1), WEST(-1, 0), NORTHWEST(-1, -1); 
	
	public final int dx, dy;
	
	private Direction(int dx, int dy) {
	this.dx = dx;
	this.dy = dy;
	}
}
