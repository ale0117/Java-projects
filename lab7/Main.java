package labs.lab7;

public class Main {

	/**
	 * Given an array of ints, compute recursively the number of times that the
	 * value 11 appears in the array. We'll use the convention of considering only
	 * the part of the array that begins at the given index. In this way, a
	 * recursive call can pass index+1 to move down the array. The initial call will
	 * pass in index as 0.
	 * 
	 * @param nums  the array of ints
	 * @param index starting index at which to consider the part of the array
	 * 
	 * @return the number of times the value 11 appears in the array
	 */
	public static int problem1_countElevens(int[] nums, int index) {
		if (index == nums.length) {
			return 0;
		}
		else {
			if (nums[index] == 11) {
				return 1 + problem1_countElevens(nums, index+1);
			}
			else {
				return problem1_countElevens(nums, index+1);
			}
		}
	}


	/**
	 * We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3,
	 * ..) have the normal 2 ears. The even bunnies (2, 4, ..) we'll say have 3
	 * ears, because they each have a raised foot. Recursively return the number of
	 * "ears" in the bunny line 1, 2, ... n (without loops or multiplication).
	 * 
	 * @param bunnies number of bunnies
	 * 
	 * @return number of ears total in line
	 */
	public static int problem2_countEars(int bunnies) {
		if (bunnies == 0) {
			return 0;
		}
		else {
			if (bunnies % 2 == 0) {
				return 3 + problem2_countEars(bunnies-1);
			}
			else {
				return 2 + problem2_countEars(bunnies-1);
			}
		}
	}
	
	
	/**
	 * Given a valid, non-negative int n, compute recursively (no loops) the count of
	 * the occurrences of 8 as a digit, except that an 8 with another 8 immediately to
	 * its left counts double, so 8818 yields 4.
	 * 
	 * @param n	the int to count 8's in
	 * 
	 * @return the occurrences of 8 as a digit, according ot the stated rules
	 */
	public static int problem3_count8s(int n) {
		if (n == 0) {
			return 0;
		}
		else {
			if (n % 100 == 88) {
				return 2 + problem3_count8s(n/10);
			}
			else if (n % 10 == 8) {
				return 1 + problem3_count8s(n/10);
			}
			else {
				return problem3_count8s(n/10);
			}
		}
	}

}