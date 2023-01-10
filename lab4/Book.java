package labs.lab4;

/**
 * A book in a library
 */
public abstract class Book extends LibraryItem {
	private String author;

	
	/**
	 * Constructor
	 * 
	 * @param title		title of the book
	 * @param author	author of the book
	 */
	public Book(String title, String author) {
		super(title);
		this.author = author;
	}

	
	public String getAuthor() {
		return author;
	}

	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	/**
	 * Returns true if the parameter object is a Book that has the same instance 
	 * variable value(s) as this one
	 */
	public boolean equals(Object otherObject) {
		if (!super.equals(otherObject)) {
			return false;
		}
		if (otherObject instanceof Book) {
			Book other = (Book) otherObject;
			return author.equals(other.author);
		}
		return false;
	}
}