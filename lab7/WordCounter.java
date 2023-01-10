package labs.lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * A program that reads text from a file and breaks it up into individual words,
 * inserts the words into a tree set, and allows you to get stats about the
 * words.
 */
public class WordCounter {
	private TreeSet<String> uniqueWords;
	private int numWords;

	/**
	 * Constructor
	 * 
	 * @param filename file from which to read words
	 */
	public WordCounter(String filename) {
		uniqueWords = new TreeSet<String>();
		numWords = 0;
		try (Scanner inFile = new Scanner(new File(filename))) {
			while (inFile.hasNext()) {
				uniqueWords.add(inFile.next().toLowerCase().replaceAll("[^a-z0-9]", ""));
				numWords++;
			}
		}
		catch (FileNotFoundException e) {
			System.out.print("File: " + filename + " not found");
		}
		
	}


	/**
	 * Returns the number of unique words in the file
	 * 
	 * @return number of unique words
	 */
	public int getNumUniqueWords() {
		return uniqueWords.size();
	}


	/**
	 * Returns the number of words in the file
	 * 
	 * @return number of words
	 */
	public int getNumWords() {
		return numWords;
	}


	/**
	 * returns a list of the unique words with all non-letter and non-digit
	 * characters removed, all in lower case, as a List in alphabetical order
	 * 
	 * @return list of unique words
	 */
	public List<String> getUniqueWords() {
		List<String> res = new ArrayList<String>();
		for (String w: uniqueWords) {
			res.add(w);
		}
		return res;
	}
}
