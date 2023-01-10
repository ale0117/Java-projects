package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.HashMap;

/* I drew some ideas from https://www.youtube.com/watch?v=TpyRKom0X_s */ 

/**
 * A class to improve a piece of text by replacing over-used words with better
 * word choices
 */
public class TextImprover {

	private HashMap<String, String> wordMap;

	/**
	 * Constructor
	 * 
	 * @param wordMapFileName	name of the file containing the over-used words and their replacements
	 */
	public TextImprover(String wordMapFileName) {
		try (Scanner inFile = new Scanner(new File(wordMapFileName))) {
			wordMap = new HashMap<>();
			while (inFile.hasNextLine()) {
				String temp = inFile.nextLine();
				String[] tempArr = temp.split("[^a-z]+");
				int i = 0;
				if (tempArr[i].length() == 0) {
					i++;
				}
				wordMap.put(tempArr[i], tempArr[i+1]);
			}
		}
		catch (FileNotFoundException e) {
			System.out.print("File: " + wordMapFileName + " not found");
		}
	}


	/**
	 * Replaces all of the over-used words in the given file with better words, based on the word map
	 * used to create this TextImprover
	 * 
	 * @param fileName	name of the file containing the text to be improved
	 */
	public void improveText(String fileName) {
		boolean success = false;
		File oldFile = new File(fileName);
		File newFile = new File("myTempFile.txt");
		try (Scanner inFile = new Scanner(oldFile)) {
			try (PrintWriter tempFile = new PrintWriter("myTempFile.txt")) {
				while (inFile.hasNextLine()) {
					String[] lineArr = inFile.nextLine().split(" ");
					String newLine = "";
					for (String word: lineArr) {
						int l = 0;
						int r = word.length()-1;
						while (l < word.length() && !Character.isLetter(word.charAt(l))) {
							l++;
						}
						while (r >= 0 && !Character.isLetter(word.charAt(r))) {
							r--;
						}
						String before = word.substring(0,l);
						String after = word.substring(r+1);
						String temp = word.substring(l, r+1);
						String newTemp = "";
						if (wordMap.containsKey(temp.toLowerCase())) {
							if (temp.equals(temp.toLowerCase())) {
								newTemp = wordMap.get(temp.toLowerCase());
							}
							else if (temp.equals(temp.toUpperCase())) {
								newTemp = wordMap.get(temp.toLowerCase()).toUpperCase();
							}
							else {
								newTemp = wordMap.get(temp.toLowerCase()).substring(0,1).toUpperCase()+wordMap.get(temp.toLowerCase()).substring(1);
							}
						}
						else {
							newTemp = temp;
						}
						newLine += before + newTemp + after + " ";
					}
					newLine = newLine.trim();
					tempFile.println(newLine);
				}
				success = true;
			}
		}
		catch (FileNotFoundException e) {
			System.out.print("File: " + fileName + " not found");
		}
		if (success) {
			oldFile.delete();
			newFile.renameTo(new File(fileName));
		}	
	}
}