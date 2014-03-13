package oving8;

import javafx.geometry.Point2D;

public class SpaceObject extends BaseSpaceObject {
	
	private double mass = 0;
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
		if (this.contains(other, other.getPointCount())) {
			return true;
		} else {
			return false;			
		}
	}
	

	public void tick() {
		this.translate(this.speed.getX(), this.speed.getY());
	}

	public void translate(double x, double y) {
		// TODO Auto-generated method stub
		
	}

}
