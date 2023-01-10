package labs.lab5;

public class Player {
	
	private String name;
	private double health;
	
	
	/**
	 * 
	 * Creates a new Player with the given name and health=0.5
	 */
	public Player(String name) {
		this.name = name;
		health = 0.5;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String s) {
		name = s;
	}
	
	
	/**
	 * 
	 * @return	the health, which is always a number from 0 (least healthy) to 1 (most healthy)
	 */
	public double getHealth() {
		return health;
	}
	
	
	/**
	 * 
	 * Sets the health to the new value, as long as it's within the bounds
	 * (If below 0, sets it to 0; if above 1, sets it to 1)
	 * 
	 * If health == 0, print out a message "[this.name] died!"
	 */
	public void setHealth(double d) {
		if (d <= 0) {
			health = 0;
			System.out.print(this.name + " died!");
		}
		else if (d >= 1) {
			health = 1;
		}
		else {
			health = d;
		}
	}
}