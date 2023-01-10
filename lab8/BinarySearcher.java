package labs.lab8;

/**
 * A class for executing binary searches through an array.
 */
public class BinarySearcher<T extends Comparable>{

	private T[] a;

	/**
	 * Constructs a BinarySearcher.
	 * 
	 * @param anArray a sorted array
	 */
	public BinarySearcher(T[] anArray) {
		a = anArray;
	}


	/**
	 * Finds a value in a sorted array, using the binary search algorithm.
	 * 
	 * @param v the value to search
	 * @return the index at which the value occurs, or -1 if it does not occur in
	 *         the array
	 */
	public int search(T v) {
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			int diff = a[mid].compareTo(v);

			if (diff == 0) // a[mid] == v
				return mid;
			else if (diff < 0) // a[mid] < v
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}
	
	
	   public static void main(String[] args){
	      String[] words = {
	         "Alpha", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot",
	         "Golf", "Hotel", "India", "Juliet", "Kilo", "Lima", "Mike",
	         "November", "Oscar", "Papa", "Quebec", "Romeo", "Sierra",
	         "Tango", "Uniform", "Victor", "Whiskey", "X-Ray", "Yankee",
	         "Zulu"
	      };
	      BinarySearcher<String> searcher = new BinarySearcher<String>(words);
	      System.out.println(searcher.search("November"));
	      System.out.println("Expected: 13");
	      System.out.println(searcher.search("October"));
	      System.out.println("Expected: -1");
	   }

}
