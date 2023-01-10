package labs.lab6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A student that has a list of classes in which they are enrolled
 */
public class Student {

	private String name;
	private int id;
	private List<String> classes;

	
	/**
	 * Constructs a student with the given name, ID, and no classes.
	 * 
	 * @param name student name
	 * @param id	student id
	 */
	public Student(String name, int id) throws IllegalArgumentException {
		this.name = name;
		if (id < 0) {
			throw new IllegalArgumentException("ID cannot be negative");
		}
		this.id = id;
		this.classes = new ArrayList<>();
	}
	

	public String getName() {
		return name;
	}
	
	
	public int getID() {
		return id;
	}
	
	
	/**
	 * Returns a list of the names of the classes in which this student is enrolled,
	 * sorted lexicographically by name
	 * 
	 * @return a list of the names of the classes in which this student is enrolled
	 */
	public List<String> getClasses() {
		Collections.sort(classes);
		return List.copyOf(classes);
	}
	
	
	/**
	 * Adds a new class to this student's enrolled classes
	 * 
	 * @param newClass	the new class to add
	 */
	public void addClass(String newClassName) {
		classes.add(newClassName);
	}
	
	
	/**
	 * Drops the class with the given name from the student's enrolled classes
	 * 
	 * @param className	name of class to drop
	 */
	public void dropClass(String className) throws IllegalArgumentException {
		if (!classes.contains(className)) {
			throw new IllegalArgumentException("Cannot drop class " + className + " because student is not enrolled in it");
		}
		classes.remove(className);
	}
}
