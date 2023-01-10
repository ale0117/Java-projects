package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * A bank contains account numbers and balances of each customer.
 */
public class Bank {
	private ArrayList<BankAccount> accounts;

	/**
	 * Construct a Bank object with accounts read from the given file
	 * 
	 * @param filename the name of the file
	 */
	public Bank(String fileName) {
		accounts = new ArrayList<BankAccount>();
		try (Scanner inFile = new Scanner(new File(fileName))) {
			while (inFile.hasNextLine()) {
				String temp = inFile.nextLine();
				String[] tempArr = temp.split(" ");
				accounts.add(new BankAccount(Integer.parseInt(tempArr[0]), Double.parseDouble(tempArr[1])));
			}
		}
		catch (FileNotFoundException e) {
			System.out.print("File: " + fileName + " not found");
		}
	}


	/**
	 * Gets the account with the lowest balance.
	 * 
	 * @return the account with the lowest balance, or null if there are
	 * no accounts in this bank
	 */
	public BankAccount getLowestBalanceAccount() {
		if (accounts.size() == 0) {
			return null;
		}
		double lowest = accounts.get(0).getBalance();
		for (BankAccount a: accounts) {
			if (a.getBalance() < lowest) {
				lowest = a.getBalance();
			}
		}
		for (BankAccount a: accounts) {
			if (a.getBalance() == lowest) {
				return a;
			}
		}
		return null;
	}
}
