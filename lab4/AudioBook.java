package labs.lab4;

/**
 * An audio book item in a library
 */
public class AudioBook extends Book {
	private double playingTime;
	private int checkOuts;

	/**
	 * Constructor
	 * 
	 * @param title			audio book title
	 * @param author		audio book author
	 * @param playingTime	audio book playing time
	 */
	public AudioBook(String title, String author, double playingTime) {
		super(title, author);
		this.playingTime = playingTime;
		checkOuts = 0;
	}

	
	public double getPlayingTime() {
		return playingTime;
	}
	
	
	public void setPlayingTime(double playingTime) {
		this.playingTime = playingTime;
	}
	
	
	/**
	 * If the max number of checkouts for this item has not already been reached,
	 * this method checks this item out and returns the loan period; if no more
	 * check outs are available for this item, returns the String "NOT ALLOWED";
	 * overrides LibraryItem.checkOut()
	 */
	@Override
	public String checkOut() {
		if (checkOuts < 2) {
			super.setCheckedOut(true);
			checkOuts++;
			return "28 days";
		}
		else {
			return "NOT ALLOWED";
		}
	}
	
	
	/**
	 * Checks in this item  (frees up one checkout for this item); overrides
	 * LibraryItem.checkIn()
	 */
	@Override
	public void checkIn() {
		if (checkOuts > 0) {
			super.checkIn();
			checkOuts--;
		}
	}
	
	
	/**
	 * Returns true if the parameter object is an AudioBook that has the same
	 * instance variable value(s) as this one
	 */
	public boolean equals(Object otherObject) {
		if (!super.equals(otherObject)) {
			return false;
		}
		if (otherObject instanceof AudioBook) {
			AudioBook other = (AudioBook) otherObject;
			return playingTime == other.playingTime && checkOuts == other.checkOuts;
		}
		return false;
	}
}