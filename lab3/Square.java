package labs.lab3;

/**
 * A magic square is an n x n matrix which, if filled with numbers, the sum of
 * the elements in each row, each column, and the two diagonal is the same
 * value.
 */
public class Square {
	int[][] matrix;

	/**
	 * Construct a Square object.
	 * 
	 * @param nums	the square array (assume it will always be n x n)
	 */
	public Square(int[][] nums) {
		matrix = nums;
	}

	/**
	 * Add the numbers in a row of the square.
	 * 
	 * @param i the row index
	 * @return the sum of the row
	 */
	public int rowSum(int i) {
		int res = 0;
		for (int x = 0; x < matrix[i].length; x++) {
			res += matrix[i][x];
		}
		return res;
	}

	/**
	 * Add the numbers in a column of the square.
	 * 
	 * @param i the column index
	 * @return the sum of the column
	 */
	public int columnSum(int i) {
		int res = 0;
		for (int x = 0; x < matrix.length; x++) {
			res += matrix[x][i];
		}
		return res;
	}

	/**
	 * Find the sum of the diagonal.
	 * 
	 * @param mainDiagonal true if it is the main diagonal (left/top to right/bottom),
	 * false otherwise (right/top to left/bottom)
	 * 
	 * @return sum the sum of the diagonal
	 */
	public int diagonalSum(boolean mainDiagonal) {
		int res = 0;
		if (mainDiagonal) {
			for (int i = 0; i < matrix.length; i++) {
				res += matrix[i][i];
			}
		}
		else {
			for (int i = 0; i < matrix.length; i++) {
				res += matrix[i][matrix.length-1-i];
			}
		}
		return res;
	}

	/**
	 * Determine if the square is a magic square.
	 * 
	 * @return true if square is a magic square, false otherwise
	 */
	public boolean isMagic() {
		int sum = 0;
		if (this.diagonalSum(true) == this.diagonalSum(false)) {
			sum = this.diagonalSum(true);
		}
		else {
			return false;
		}
		for (int i = 0; i < matrix.length; i++) {
			int temp1 = this.rowSum(i);
			int temp2 = this.columnSum(i);
			if (temp1 != sum || temp2 != sum) {
				return false;
			}
		}
		return true;
	}
}
