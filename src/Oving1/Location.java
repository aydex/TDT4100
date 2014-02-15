package Oving1;

public class Location {
	
	public int x;
	public int y;
	
	public Location() {
		this.x = 0;
		this.y = 0;
	}
	
	public void up() {
		this.y--;
	}
	
	public void down() {
		this.y++;
	}
	
	public void left() {
		this.x--;
	}
	
	public void right() {
		this.x++;
	}
	
	public String toString() {
		return "(" + x + "," + y + ")"; 
	}
	
	public static void main(String[] args) {
		Location l = new Location();
		l.down();
		l.right();
		l.right();
		l.down();
		System.out.println(l);
		l.up();
		l.left();
		System.out.println(l);
	}

}
