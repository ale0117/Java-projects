package labs.lab2;

import java.util.Scanner;

public class Main {

	/**
	 * Reads a number between 1,000 and 999,999 from the user and prints it with a 
	 * comma separating the thousands.
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problem2_printWithCommas(new Scanner(System.in));
	 */
	public static void problem2_printWithCommas(Scanner in) {
		System.out.print("Please enter an integer between 1000 and 999999: ");
		int i = in.nextInt();
		System.out.print(i/1000 + ",");
		if (i%1000 < 10) {
			System.out.print("00" + i%1000);
		}
		else if (i%1000 < 100) {
			System.out.print("0" + i%1000);
		}
		else {
			System.out.print(i%1000);
		}
	}
	
	
	/**
	 * Computes the total of a sticker order based on the price per sticker and number
	 * of stickers, which are prompted for from the user
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problem3_calculateTotal(new Scanner(System.in));
	 */
	public static void problem3_calculateTotal(Scanner in) {
		System.out.print("Enter price per sticker: ");
		double price = in.nextDouble();
		System.out.print("Enter the number of stickers: ");
		int number = in.nextInt();
		double total_price = price * number;
		double tax = total_price * 0.10;
		double shipping_charge = number * 0.15;
		System.out.printf("Your total is: $%.2f", total_price + tax + shipping_charge);
	}
	
	
	/**
	 * Computes the total of a sticker order based on the price per sticker and number
	 * of stickers, which are prompted for from the user
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problemr_compoundInterest(new Scanner(System.in));
	 */
	public static void problem4_compoundInterest(Scanner in) {
		System.out.print("Enter principal amount: ");
		double p = in.nextDouble();
		System.out.print("Enter the annual rate of interest: ");
		double r = in.nextDouble();
		System.out.print("Enter the number of years the amount is invested: ");
		int t = in.nextInt();
		System.out.print("Enter the number of times the interest is compounded per year: ");
		int n = in.nextInt();
		double a = p * Math.pow((1+(r/100)/n), n*t);
		if (r != 0) {
			System.out.printf("$%.2f invested at ", p);
			System.out.print(r);
		}
		else {
			System.out.printf("$%.2f invested at %.1f", p, r);
		}
		System.out.print("% ");
		System.out.printf("for %d years compounded %d times annually is $%.2f.", t, n, a);
	}
	
	
	/**
	 * Computes the number of months it will take to pay off a credit card balance, based
	 * on the balance, APR, and monthly payment which are prompted for from the user
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problem5_creditCardPayoff(new Scanner(System.in));
	 */
	public static void problem5_creditCardPayoff(Scanner in) {
		System.out.print("What is your balance? ");
		double b = in.nextDouble();
		System.out.print("What is the APR on the card? ");
		double i = in.nextDouble()/365/100;
		System.out.print("What is the monthly payment you can make? ");
		double p = in.nextDouble();
		double n = (-1.0/30.0) * Math.log(1+(b/p)*(1-Math.pow(1.0+i,30.0)))/Math.log(1.0+i);
		int months = (int) Math.ceil(n);
		System.out.print("It will take you " + months + " months to pay off this card.");
	}
	
	
	/**
	 * Walk the user through troubleshooting issues with a car.
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problem6_troubleshootCarIssues(new Scanner(System.in));
	 */
	public static void problem6_troubleshootCarIssues(Scanner in) {
		String ans = "";
		System.out.print("Is the car silent when you turn the key? ");
		ans = in.nextLine();
		if (ans.substring(0,1).toLowerCase().equals("y")) {
			System.out.print("Are the battery terminals corroded? ");
			ans = in.nextLine();
			if (ans.substring(0,1).toLowerCase().equals("y")) {
				System.out.print("Clean terminals and try starting again.");
			}
			else if (ans.substring(0,1).toLowerCase().equals("n")) {
				System.out.print("Replace cables and try again.");
			}
			else {
				System.out.print("Invalid input. Exiting.");
			}
		}
		else if (ans.substring(0,1).toLowerCase().equals("n")) {
			System.out.print("Does the car make a clicking noise? ");
			ans = in.nextLine();
			if (ans.substring(0,1).toLowerCase().equals("y")) {
				System.out.print("Replace the battery.");
			}
			else if (ans.substring(0,1).toLowerCase().equals("n")) {
				System.out.print("Does the car crank up but fail to start? ");
				ans = in.nextLine();
				if (ans.substring(0,1).toLowerCase().equals("y")) {
					System.out.print("Check spark plug connections.");
				}
				else if (ans.substring(0,1).toLowerCase().equals("n")) {
					System.out.print("Does the engine start and then die? ");
					ans = in.nextLine();
					if (ans.substring(0,1).toLowerCase().equals("y")) {
						System.out.print("Does your car have fuel injection? ");
						ans = in.nextLine();
						if (ans.substring(0,1).toLowerCase().equals("y")) {
							System.out.print("Get it in for service.");
						}
						else if (ans.substring(0,1).toLowerCase().equals("n")) {
							System.out.print("Check to ensure the choke is opening and closing.");
						}
						else {
							System.out.print("Invalid input. Exiting.");
						}
					}
					else if (ans.substring(0,1).toLowerCase().equals("n")) {
						System.out.print("Get it in for service.");
					}
					else {
						System.out.print("Invalid input. Exiting.");
					}
					
				}
				else {
					System.out.print("Invalid input. Exiting.");
				}
			}
			else {
				System.out.print("Invalid input. Exiting.");
			}
		}
		else {
			System.out.print("Invalid input. Exiting.");
		}
	}
	
	
	/**
	 * Assesses the strength of a password based on these rules:
	 * 
	 * * A very weak password contains only digits and is fewer than eight characters
	 * * A weak password contains only letters and is fewer than eight characters
	 * * A strong password contains at least one letter and at least one digit and is at least
	 * eight characters
	 * * A very strong password contains at least one letter, at least one digit, and at least
	 * one special character (non letter or digit) and is at least eight characters
	 * * All other passwords are medium strength
	 * 
	 * @param password	the password to assess
	 * @return	a string describing its strength
	 */
	public static String problem7_assessPasswordStrength(String password) {
		boolean hasDigits = false;
		boolean hasLetters = false;
		boolean hasSpecials = false;
		for (int i = 0; i < password.length(); i++) {
			if (Character.isDigit(password.charAt(i))) {
				hasDigits = true;
			}
			else if (Character.isLetter(password.charAt(i))) {
				hasLetters = true;
			}
			else {
				hasSpecials = true;
			}
		}
		if (hasDigits && !hasLetters && !hasSpecials && password.length() < 8) {
			return "very weak";
		}
		else if (!hasDigits && hasLetters && !hasSpecials && password.length() < 8) {
			return "weak";
		}
		else if (hasDigits && hasLetters && !hasSpecials && password.length() >= 8) {
			return "strong";
		}
		else if (hasDigits && hasLetters && hasSpecials && password.length() >= 8) {
			return "very strong";
		}
		else {
			return "medium";
		}
	}
	
	
	/**
	 * Translates a letter grade into a numeric grade
	 * 
	 * @param letterGrade	the letter grade to translate
	 * @return	the numeric grade
	 */
	public static double problem8_getNumericGrade(String letterGrade) {
		if (letterGrade.length() > 2) {
			return -1;
		}
		double numericGrade = 0;
		if (letterGrade.substring(0,1).toUpperCase().equals("A")) {
			numericGrade+=4;
		}
		else if (letterGrade.substring(0,1).toUpperCase().equals("B")) {
			numericGrade+=3;
		}
		else if (letterGrade.substring(0,1).toUpperCase().equals("C")) {
			numericGrade+=2;	
		}
		else if (letterGrade.substring(0,1).toUpperCase().equals("D")) {
			numericGrade+=1;
		}
		else if (letterGrade.substring(0,1).toUpperCase().equals("F")) {
			numericGrade+=0;
		}
		else {
			return -1;
		}
		if (letterGrade.length() == 2)
		{
			if (letterGrade.substring(1,2).equals("+")) {
				numericGrade += 0.3;
			}
			else if (letterGrade.substring(1,2).equals("-")) {
				numericGrade -= 0.3;
			}
			else {
				return -1;
			}
		}
		if (numericGrade > 4) {
			return 4;
		}
		else {
			return numericGrade;
		}
	}

	
	/**
	 * Translates a numeric grade into a letter grade
	 * 
	 * @param numericGrade	the numeric grade to translate
	 * 
	 * @return	the letter grade
	 */
	public static String problem8_getLetterGrade(double numericGrade) {
		if (numericGrade < 0 || numericGrade > 4) {
			return "Error";
		}
		else if (numericGrade >= 0 && numericGrade < 0.5){
			return "F";
		}
		else if (numericGrade >= 0.5 && numericGrade < 0.85){
			return "D-";
		}
		else if (numericGrade >= 0.85 && numericGrade < 1.15){
			return "D";
		}
		else if (numericGrade >= 1.15 && numericGrade < 1.5){
			return "D+";
		}
		else if (numericGrade >= 1.5 && numericGrade < 1.85){
			return "C-";
		}
		else if (numericGrade >= 1.85 && numericGrade < 2.15){
			return "C";
		}
		else if (numericGrade >= 2.15 && numericGrade < 2.5){
			return "C+";
		}
		else if (numericGrade >= 2.5 && numericGrade < 2.85){
			return "B-";
		}
		else if (numericGrade >= 2.85 && numericGrade < 3.15){
			return "B";
		}
		else if (numericGrade >= 3.15 && numericGrade < 3.5){
			return "B+";
		}
		else if (numericGrade >= 3.5 && numericGrade < 3.85){
			return "A-";
		}
		else if (numericGrade >= 3.85 && numericGrade < 4.0){
			return "A";
		}
		else {
			return "A+";
		}
	}
	
	
	/**
	 * If one or both of the first 2 chars in the given string is the char 'x' 
	 * (lower case only), returns the string without those 'x' chars. Otherwise, 
	 * returns the string unchanged. 
	 * 
	 * @param str	the string to change
	 * 
	 * @return	the changed string
	 */
	public static String problem10_withoutX2(String str) {
		String res = "";
		for (int i = 0; i < str.length(); i++) {
			if (i < 2) {
				if (!str.substring(i,i+1).equals("x")) {
					res += str.substring(i,i+1);
				}
			}
			else {
				res += str.substring(i,i+1);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		
	}
}
