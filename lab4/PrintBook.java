package labs.lab4;

/**
 * Print book item in a library
 */
public class PrintBook extends Book {
	private int numPages;

	/**
	 * Constructor
	 * 
	 * @param title		book title
	 * @param author	book author
	 * @param numPages	number of pages
	 */
	public PrintBook(String title, String author, int numPages) {
		super(title, author);
		this.numPages = numPages;
	}

	
	public int getNumPages() {
		return numPages;
	}

	
	public void setNumPages(int numPages) {
		this.numPages = numPages;
	}

	
	/**
	 * If this item is not already checked out, this method checks this item out
	 * and returns the loan period; if it is already checked out, returns the
	 * String "NOT ALLOWED"; overrides LibraryItem.checkOut()
	 */
	@Override
	public String checkOut() {
		if (this.isCheckedOut()) {
			return "NOT ALLOWED";
		}
		else {
			this.setCheckedOut(true);
			return "21 days";
		}
	}

	
	/**
	 * Returns true if the parameter object is a PrintBook that has the same
	 * instance variable value(s) as this one
	 */
	public boolean equals(Object otherObject) {
		if (!super.equals(otherObject)) {
			return false;
		}
		if (otherObject instanceof PrintBook) {
			PrintBook other = (PrintBook) otherObject;
			return numPages == other.numPages;
		}
		return false;
	}
}