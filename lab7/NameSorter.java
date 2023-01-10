package labs.lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Sorts a file of names alphabetically, ignoring case
 */
public class NameSorter {
	
	private class Name implements Comparable{
		private String name;
		public Name(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return name;
		}
		public int compareTo(Object otherObject) {
			Name other = (Name) otherObject;
			return name.toLowerCase().compareTo(other.name.toLowerCase());
		}
	}
	
	private ArrayList<Name> names;
	private String inputFile;
	
	/**
	 * Constructs a name sorter with the names from the input file
	 * 
	 * @param inputFile	name of the input file
	 */
	public NameSorter(String inputFile) {
		names = new ArrayList<Name>();
		this.inputFile = inputFile;
		try (Scanner inFile = new Scanner(new File(inputFile))) {
			while (inFile.hasNextLine()) {
				names.add(new Name(inFile.nextLine()));
			}
		}
		catch (FileNotFoundException e) {
			System.out.print("File: " + inputFile + " not found");
		}
	}
	
	
	/**
	 * Sorts the names from the input file alphabetically, ignoring case, 
	 * then writes the sorted names back to the file, overwriting the 
	 * previous content
	 */
	public void sortNames() {
		Collections.sort(names);
		try (PrintWriter writeFile = new PrintWriter(inputFile)) {
			for (Name n: names) {
				writeFile.println(n);
			}
		}
		catch (FileNotFoundException e) {
			System.out.print("File: " + inputFile + " not found");
		}
	}
}