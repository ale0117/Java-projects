package labs.lab5;

/**
 * A person in the Pest game
 */
public abstract class Person implements Comparable {
	private String name;

	
	/**
	 * Constructor
	 * 
	 * @param name	name of person
	 */
	public Person(String name) {
		this.name = name;
	}

	
	public String getName() {
		return name;
	}

	
	/**
	 * Compares Persons by name, lexicographically
	 */
	public int compareTo(Object otherPerson) {
		Person other = (Person) otherPerson;
		return name.compareTo(other.name);
	}
}