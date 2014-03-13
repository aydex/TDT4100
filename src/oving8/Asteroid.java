package oving8;

public class Asteroid extends SpaceObject {
	
	private double density;
	private double radius;
	
	public Asteroid(double density, double radius) {
		this.density = density;
		this.radius = radius;
	}
	
	public double getMass() {
		return density*(4/3*Math.PI*(Math.pow(radius,3)));
	}

}
