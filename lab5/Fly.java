package labs.lab5;

/**
 * A fly pest in the Pest game
 */
public class Fly implements Pest {
	
	/**
	 * @return the string made up of flyAroundYourHead() and landOnThings(),
	 * separated by a " | "
	 */
	@Override
	public String annoy() {
		return this.flyAroundYourHead() + " | " + this.landOnThings();
	}
	
	
	/**
	 * @return the string "Fly around your head"
	 */
	private String flyAroundYourHead() {
		return "Fly around your head";
	}
	
	
	/**
	 * @return the string "Land on things"
	 */
	private String landOnThings() {
		return "Land on things";
	}
}