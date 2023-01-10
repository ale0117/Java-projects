package labs.lab4;

/**
 * A class to simulate a combination lock.
 */
public class ComboLock {
	private int turns;
	private int num1;
	private int num2;
	private int num3;
	private int currNum;
	private boolean actionsValid;

	/**
	 * Initializes the combination of the lock. Assume all inputs are valid ints
	 * between 0 and 39 inclusive
	 * 
	 * @param num1 first number to turn right to
	 * @param num2 second number to turn left to
	 * @param num3 third number to turn right to
	 */
	public ComboLock(int num1, int num2, int num3) {
		turns = 0;
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		currNum = 0;
		actionsValid = true;
	}

	/**
	 * Resets the state of the lock so that it can be opened again; resets the
	 * dial so that it points to 0
	 */
	public void reset() {
		turns = 0;
		currNum = 0;
		actionsValid = true;
	}

	/**
	 * Turns lock left given number of ticks.
	 * 
	 * @param ticks number of ticks to turn left; assume ticks always between 0 
	 * and 39 inclusive
	 */
	public void turnLeft(int ticks) {
		if (turns != 1) {
			actionsValid = false;
		}
		currNum = currNum + ticks;
		while (currNum > 39) {
			currNum -= 40;
		}
		if (turns == 1 && currNum != num2) {
			actionsValid = false;
		}
		turns++;
	}

	/**
	 * Turns lock right given number of ticks
	 * 
	 * @param ticks number of ticks to turn right; assume ticks always between 0
	 * and 39 inclusive
	 */
	public void turnRight(int ticks) {
		if (turns != 0 && turns != 2) {
			actionsValid = false;
		}
		currNum = currNum - ticks;
		while (currNum < 0) {
			currNum += 40;
		}
		if (turns == 0 && currNum != num1) {
			actionsValid = false;
		}
		else if (turns == 2 && currNum != num3) {
			actionsValid = false;
		}
		turns++;
	}

	/**
	 * Returns true if the lock can be opened now, false otherwise
	 * 
	 * @return true if lock is in open state
	 */
	public boolean open() {
		return actionsValid && turns == 3;
	}
}
