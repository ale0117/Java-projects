package labs.lab4;

import java.awt.Point;

/**
 * A class for simulating a robot wandering on a 10 x 10 plane.
 */
public class Robot {
	
	private Point location;
	private int direction;

	
	/**
	 * Creates a Robot at location (0, 0), which is in the center of the plane,
	 * and facing north
	 */
	public Robot() {
		location = new Point(0, 0);
		direction = 0;
	}
	

	/**
	 * Changes the direction but not the location
	 */
	public void turnLeft() {
		direction--;
		if (direction < 0) {
			direction += 4;
		}
	}
	

	/**
	 * Changes the direction but not the location
	 */
	public void turnRight() {
		direction++;
		if (direction >= 4) {
			direction -= 4;
		}
	}

	
	/**
	 * Moves the robot by one unit in the direction it is facing. Returns true if the
	 * robot is still on the plane, or false if it has fallen off.
	 * 
	 * Note 1: In coordinate terms, |x| must be <= 5 and |y| must be <= 5 for the robot
	 * to stay on the plane (see below example).
	 * 
	 * Note 2: This method can still be called on a robot that has fallen off the plane,
	 * and its location should be updated as if it was still on the plane.
	 * 
	 * @return	true if the robot is still on the plane, false otherwise
	 */
	public boolean move() {
		if (direction == 0) {
			location.translate(0, 1);
		}
		else if (direction == 1) {
			location.translate(1, 0);
		}
		else if (direction == 2) {
			location.translate(0, -1);
		}
		else {
			location.translate(-1, 0);
		}
		if (location.getX() >= -5 && location.getX() <= 5 && location.getY() >= -5 && location.getY() <= 5) {
			return true;
		}
		else {
			return false;
		}
	}

	
	/**
	 * Returns the robot's current location on the plane
	 * 
	 * @return	robot's current location
	 */
	public Point getLocation() {
		return location;
	}

	
	/**
	 * Returns "N", "E", "S", or "W" (for north, east, south, or west, respectively)
	 * 
	 * @return	the robot's direction
	 */
	public String getDirection() {
		if (direction == 0) {
			return "N";
		}
		else if (direction == 1) {
			return "E";
		}
		else if (direction == 2) {
			return "S";
		}
		else {
			return "W";
		}
	}
}
