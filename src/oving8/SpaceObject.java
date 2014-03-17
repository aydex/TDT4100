package oving8;

import javafx.geometry.Point2D;

public class SpaceObject extends BaseSpaceObject {
	
	protected double mass = 0;
	private Point2D speed = new Point2D(mass, mass);
	
	public Point2D getSpeed() {
		return this.speed;
	}
	
	public void setSpeed(double vx, double vy) {
		this.speed = new Point2D(vx, vy);
	}
	
	public void accelerate(double ax, double ay) {
		speed = new Point2D(speed.getX() + ax, speed.getY() + ay);
	}
	
	public double getMass() {
		return this.mass;
	}
	
	public void applyForce(double fx, double fy) {
		if (this.mass == 0) {
			throw new IllegalStateException("Object has no mass");
		} else {
			speed = new Point2D(speed.getX()+(fx/this.mass), speed.getY()+(fy/this.mass));
		}
	}
	
	public boolean intersects(SpaceObject other) {
		for (int i = 0; i < other.getPointCount(); i++) {
			if (this.contains(other, i)) {
				return true;
			}
		}
		
		if (this.contains(other.getCenter(true))) {
			return true;			
		} else {
			return false;
		}
	}
	

	public void tick() {
		System.out.println("Object is at: " + this.getTranslateX() + "," + this.getTranslateY());
		System.out.println("Moving with speed of " + this.speed.getX() + "," + this.speed.getY());
		this.translate(this.speed.getX(), this.speed.getY());
		System.out.println("Object now is at: " + this.getTranslateX() + "," + this.getTranslateY());
	}

}
