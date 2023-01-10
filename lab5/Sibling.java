package labs.lab5;

/**
 * A sibling pest in the Pest game
 */
public class Sibling extends Person implements Pest {
	
	/**
	 * Constructor
	 * 
	 * @param name	name of the sibling
	 */
	public Sibling(String name) {
		super(name);
	}
	
	
	/**
	 * @return the string made up of teaseYouAboutYourInsecurities() and laughAtYouWhenYouAreMad(),
	 * separated by a " | "
	 */
	@Override
	public String annoy() {
		return this.teaseYouAboutYourInsecurities() + " | " + this.laughAtYouWhenYouAreMad();
	}
	
	
	/**
	 * @return the string "Tease you about your insecurities"
	 */
	private String teaseYouAboutYourInsecurities() {
		return "Tease you about your insecurities";
	}
	
	
	/**
	 * 
	 * @return the string "Laugh at you when you are mad"
	 */
	private String laughAtYouWhenYouAreMad() {
		return "Laugh at you when you are mad";
	}
}