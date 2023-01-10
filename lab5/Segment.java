package labs.lab5;

/**
 * Segment implements an indirect reference to string of characters
 */
public class Segment implements CharSequence {

	private String data;
	private int start;
	private int end;

	/**
	 * Create a Segment
	 * 
	 * @param data  the data referenced by the Segment
	 * @param start the starting point of the data (inclusive) (assume will be within expected bounds of data)
	 * @param end   the ending point of the data (exclusive) (assume will be within expected bounds of data)
	 */
	public Segment(String data, int start, int end) {
		this.data = data;
		this.start = start;
		this.end = end;
	}


	/**
	 * 
	 * @return the length of the Segment
	 */
	@Override
	public int length() {
		return end-start;
	}


	/**
	 * @param pos (assume pos will always be within bounds of the segment size)
	 * @return the character at location pos within the Segment
	 */
	@Override
	public char charAt(int pos) {
		return data.charAt(start+pos);
	}


	/**
	 * @param start the starting position (inclusive) of the sub-sequence
	 * @param end   the ending position (exclusive) of the sub-sequence
	 * @return the sub-sequence starting at start and ending just before end
	 */
	@Override
	public CharSequence subSequence(int start, int end) {
		return data.substring(this.start+start, this.start+end);
	}


	/**
	 * @return the string referenced by the bounds of Segment
	 */
	@Override
	public String toString() {
		return data.substring(start, end);
	}
}
