package labs.lab4;

/**
 * A magazine item in a library
 */
public class Magazine extends LibraryItem {
	private int issueNumber;
	private String publicationDate;

	
	/**
	 * Constructor
	 * 
	 * @param title				magazine title
	 * @param issueNumber		magazine issue number
	 * @param publicationDate	magazine publication date
	 */
	public Magazine(String title, int issueNumber, String publicationDate) {
		super(title);
		this.issueNumber = issueNumber;
		this.publicationDate = publicationDate;
	}
	
	
	public int getIssueNumber() {
		return issueNumber;
	}
	
	
	public void setIssueNumber(int issueNumber) {
		this.issueNumber = issueNumber;
	}

	
	public String getPublicationDate() {
		return publicationDate;
	}

	
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	
	
	/**
	 * If this item is not already checked out, this method checks this item out and 
	 * returns the loan period; if it is already checked out, returns the String 
	 * "NOT ALLOWED"; overrides LibraryItem.checkOut()
	 */
	@Override
	public String checkOut() {
		if (this.isCheckedOut()) {
			return "NOT ALLOWED";
		}
		else {
			this.setCheckedOut(true);
			return "7 days";
		}
	}
	
	
	/**
	 * Returns true if the parameter object is a Magazine that has the same instance 
	 * variable value(s) as this one
	 */
	public boolean equals(Object otherObject) {
		if (!super.equals(otherObject)) {
			return false;
		}
		if (otherObject instanceof Magazine) {
			Magazine other = (Magazine) otherObject;
			return issueNumber == other.issueNumber && publicationDate.equals(other.publicationDate);
		}
		return false;
	}
}