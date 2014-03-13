package oving8;

public class SpaceShip extends SpaceObject {
	
	SpaceShip() {
		this.setSpeed(0, 0);
	}
	
	public double getMass() {
		return 1;
	}
	
	public void sidewaysThrust(double thrust) {
		this.setRotate(getRotate()+thrust);
	}
	
	public void forwardThrust(double thrust) {
		this.setSpeed(Math.sin(thrust), Math.cos(thrust));
	}
}
