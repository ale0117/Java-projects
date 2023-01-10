package labs.lab1;

/**
 * A class to represent an inflatable spherical balloon.
 */
public class Balloon {
	private double radius;

	/**
	 * Construct an unfilled balloon.
	 */
	public Balloon() {
		radius = 0;
	}

	/**
	 * Inflates the balloon.
	 * 
	 * @param amount the amount of increase to the radius of the balloon
	 */
	public void inflate(double amount) {
		radius += amount;
	}

	/**
	 * Computes the current volume of the balloon.
	 * 
	 * @return the volume of balloon (in cubic units)
	 */
	public double getVolume() {
		return (4.0/3.0) * Math.PI * radius * radius * radius;
	}
}