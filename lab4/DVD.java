package labs.lab4;

import java.util.List;

/**
 * A DVD item in a library
 */
public class DVD extends LibraryItem {
	// ADD YOUR INSTANCE VARIABLES HERE
	private List<String> actors;
	
	/**
	 * Constructor
	 * 
	 * @param title		title of the DVD
	 * @param actors	actors in the DVD
	 */
	public DVD(String title, List<String> actors) {
		super(title);
		this.actors = actors;
	}

	
	public List<String> getActors() {
		return actors;
	}
	
	
	public void setActors(List<String> actors) {
		this.actors = actors;
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
	 * Returns true if the parameter object is a DVD that has the same instance 
	 * variable value(s) as this one
	 */
	public boolean equals(Object otherObject) {
		if (!super.equals(otherObject)) {
			return false;
		}
		if (otherObject instanceof DVD) {
			DVD other = (DVD) otherObject;
			return actors == other.actors;
		}
		return false;
	}
}