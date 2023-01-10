package labs.lab3;

/**
 * A theater seating chart implemented as a 2-d array of ticket prices
 */
public class SeatingChart {
	private int[][] seats = {
			{40, 50, 50, 50, 40},
			{30, 40, 40, 40, 30},
			{20, 30, 30, 30, 20},
			{10, 20, 20, 20, 10},
			{10, 10, 10, 10, 10}};

	/**
	 * Returns a string that represents the price of seats in a grid-like pattern.
	 */
	public String getSeatingChart() {
		String res = "";
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[0].length; j++) {
				if (seats[i][j] != 0) {
					res += seats[i][j];
				}
				else {
					res += " 0";
				}
				if (j < seats[0].length-1) {
					res += " ";
				}
				else {
					res += System.lineSeparator();
				}
			}
		}
		return res;
	}

	
	/**
	 * Goes from left to right and front to back to find a seat with the specified
	 * price, then, if found, sets its price to 0 to mark it as sold. If no seat 
	 * is found with the specified price, the seating chart remains unchanged. 
	 * Assume all inputs are valid ints.
	 * 
	 * @param price the price to mark to zero
	 */
	public void sellSeatByPrice(int price) {
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[0].length; j++) {
				if (seats[i][j] == price) {
					seats[i][j] = 0;
					return;
				}
			}
		}
	}

	
	/**
	 * Marks the specified seat as sold by setting its price to 0. If the seat 
	 * doesn't exist, the seating chart remains unchanged. Valid rows are A through 
	 * E, case sensitive (A is the front row, E is the back row). Valid seats are 1 
	 * through 5 (if facing the front/stage, 1 is the leftmost seat, 5 is the 
	 * rightmost seat). Assume all inputs are valid chars and ints.
	 */
	public void sellSeatByNumber(char row, int seat) {
		int rowNum;
		if (row == 'A') {
			rowNum = 0;
		}
		else if (row == 'B') {
			rowNum = 1;
		}
		else if (row == 'C') {
			rowNum = 2;
		}
		else if (row == 'D') {
			rowNum = 3;
		}
		else if (row == 'E') {
			rowNum = 4;
		}
		else {
			return;
		}
		if (seat >= 1 && seat <= 5) {
			seats[rowNum][seat-1] = 0;
		}
	}
}
