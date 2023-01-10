package labs.lab3;

import java.util.Scanner;

public class Main {

	/**
	 * Accepts a String as a parameter and looks for a mirror image (backwards)
	 * string at both the beginning and end of the given string. In other words,
	 * zero or more characters at the very beginning of the given string, and at the
	 * very end of the string in reverse order (possibly overlapping). For example,
	 * the string "abXYZba" has the mirror end "ab".
	 * 
	 * @param str the string to check for mirror ends
	 * @return the mirror end, or the empty string if no mirror end exists
	 */
	public static String problem1_mirrorEnds(String str) {
		String res = "";
		int i = 0;
		while (i < str.length() && str.charAt(i) == str.charAt(str.length()-1-i)) {
			res += str.charAt(i);
			i++;
		}
		return res;
	}


	/**
	 * Given a string, returns the length of the largest "block" in the string. A
	 * block is a run of adjacent chars that are the same.
	 * 
	 * @param str the string to check for blocks
	 * 
	 * @return the length of the largest block in the string
	 */
	public static int problem2_maxBlock(String str) {
		if (str.length() == 0) {
			return 0;
		}
		int maxLeng = 1;
		int currLeng = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i-1)) {
				currLeng += 1;
			}
			else {
				maxLeng = Math.max(maxLeng, currLeng);
				currLeng = 1;
			}
		}
		return Math.max(maxLeng, currLeng);
	}


	/**
	 * An uppercase 'E' in a string is "happy" if there is another uppercase 'E'
	 * immediately to its left or right. Returns true if all the E's in the given
	 * string are happy. (A string with no 'E' in it returns true.)
	 * 
	 * @param str
	 * @return whether or not all E's in the string are happy
	 */
	public static boolean problem3_EHappy(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'E') {
				if (!((i-1 >= 0 && str.charAt(i-1) == 'E') || (i+1 < str.length() && str.charAt(i+1) == 'E'))) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	/**
	 * Returns the minimum number of twists to unlock a lock, based on the starting
	 * and target values
	 * 
	 * @param starting	the current numbers of the lock
	 * @param target	the combination required to unlock the lock
	 * 
	 * @return	the minimum number of twists to unlock the lock
	 */
	public static int problem4_getNumTwists(int starting, int target) {
		int res = 0;
		for (int i = 0; i < 4; i++) {
			int currStarting = starting % 10;
			starting = starting / 10;
			int currTarget = target % 10;
			target = target / 10;
			int diff = Math.abs(currTarget - currStarting);
			res += Math.min(diff, 10-diff);
		}
		return res;
	}
	
	
	/**
	 * Manages crowd control in an office
	 * 
	 * @param in       the Scanner to be used for user input
	 * @param capacity of the office
	 * 
	 *                 To run this method using the keyboard for user input, call it
	 *                 like this: problem5_officeCrowdControl(new Scanner(System.in), 100);
	 */
	public static void problem5_officeCrowdControl(Scanner in, int capacity) {
		int officeCount = 0;
		do 
		{
			System.out.print("People entering or leaving: ");
			int entry = in.nextInt();
			if (officeCount + entry >= 0 && officeCount + entry <= capacity) {
				officeCount += entry;
			}
			System.out.print("People in office: " + officeCount + " | ");
		}
		while (officeCount < capacity);
		System.out.print("Office is full");
	}
	
	
	/**
	 * Takes an array of ints and returns an array that contains the exact same numbers 
	 * as the given array, but rearranged so that all the even numbers come before all
	 * the odd numbers
	 * 
	 * @param nums	the input array
	 * 
	 * @return	the rearranged array with all even numbers coming before all odd numbers
	 */
	public static int[] problem6_evenOdd(int[] nums) {
		int[] res = new int[nums.length];
		int i = 0;
		for (int num: nums) {
			if (num % 2 == 0) {
				res[i] = num;
				i++;
			}
		}
		for (int num: nums) {
			if (num % 2 == 1) {
				res[i] = num;
				i++;
			}
		}
		return res;
	}
	
	
	/**
	 * Given a non-empty array of ints, returns a new array containing the elements from
	 * the original array that come after the last occurrence of the number 4 in the original
	 * array
	 * 
	 * @param nums	the input array
	 * 
	 * @return	a new array containing the elements from the original array that come after 
	 * the last occurrence of the number 4 in the original array
	 * 
	 */
	public static int[] problem7_after4(int[] nums) {
		int i = nums.length - 1;
		while (i >= 0 && nums[i] != 4) {
			i -= 1;
		}
		int[] res = new int[nums.length - i - 1];
		i++;
		int x = 0;
		while (i < nums.length) {
			res[x] = nums[i];
			x++;
			i++;
		}
		return res;
	}
}