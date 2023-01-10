package labs.lab1;

/**
 * A rechargeable battery.
 */
public class Battery {

	private double capacity;
	private double maxCapacity;

	/**
	 * Create a battery with specified capacity.
	 * 
	 * @param capacity maximum capacity, measured in milliampere hours
	 */
	public Battery(double capacity) {
		this.capacity = capacity;
		maxCapacity = capacity;
	}


	/**
	 * Drain capacity of the battery by given amount.
	 * 
	 * @param amount amount of battery used (assume it will not be > its current capacity
	 */
	public void drain(double amount) {
		capacity -= amount;
	}


	/**
	 * Recharge the battery to maximum capacity.
	 */
	public void charge() {
		capacity = maxCapacity;
	}


	/**
	 * Retrieve the battery's current capacity.
	 * 
	 * @return remaining capacity
	 */
	public double getRemainingCapacity() {
		return capacity;
	}
}
