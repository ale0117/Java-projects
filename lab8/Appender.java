package labs.lab8;

import java.util.ArrayList;
import java.util.List;

/**
 * A utility class for appending lists/arrays
 *
 */
public class Appender {

	/**
	 * Appends two lists together.
	 * 
	 * Leaves the parameter lists unchanged, and returns a new list that contains
	 * the elements of a and b appended
	 * 
	 * @param <T> the type contained in the lists
	 * @param a   list 1
	 * @param b   list 2
	 * 
	 * @return a new list containing the elements of a and b appended
	 */
	public static <T> List<T> append(List<T> a, List<T> b) {
		ArrayList<T> res = new ArrayList<T>();
		for (T e: a) {
			res.add(e);
		}
		for (T e: b) {
			res.add(e);
		}
		return (List<T>) res;
	}


	/**
	 * Appends two arrays together.
	 * 
	 * Leaves the parameter arrays unchanged, and returns a new arrays that contains
	 * the elements of a and b appended
	 * 
	 * @param <T> the type contained in the arrays
	 * @param a   array 1
	 * @param b   array 2
	 * 
	 * @return a new array containing the elements of a and b appended
	 */
	public static <T> T[] append(T[] a, T[] b) {
		ArrayList<T> res = new ArrayList<T>();
		for (T e: a) {
			res.add(e);
		}
		for (T e: b) {
			res.add(e);
		}
		return res.toArray(a);
	}

}