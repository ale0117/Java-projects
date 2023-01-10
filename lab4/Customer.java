package labs.lab4;

/**
 * A class for a customer in Robert's pet store. For every $100 spent, the
 * customer gets a 10% discount that will be automatically applied to
 * a future purchase. Note that some results will have more than two places
 * after the decimal points, and that's ok.
 */
public class Customer {
	private double totalAmountSpent;
	private int numDiscountsToUse;
	
	/**
	 * Creates a new customer
	 */
	public Customer() {
		totalAmountSpent = 0;
		numDiscountsToUse = 0;
	}

	
	/**
	 * adds a purchase for the amount to the customer's account; assume 
	 * the amount will always be a valid monetary amount > 0
	 * 
	 * @param amount	amount of purchase
	 */
	public void makePurchase(double amount) {
		if (numDiscountsToUse > 0) {
			amount -= amount * 0.1;
			numDiscountsToUse--;
		}
		if ((totalAmountSpent % 100) + amount >= 100) {
			numDiscountsToUse += (int)(((totalAmountSpent % 100) + amount) / 100);
		}
		totalAmountSpent += amount;
	}
	
	
	/**
	 * Returns the number of discounts this customer has on their account 
	 * to be used on future purchases
	 * 
	 * @return	number of discounts to use
	 */
	public int getNumDiscountsToUse() {
		return numDiscountsToUse;
	}

	
	/**
	 * Returns the total amount this customer has spent on all their purchases
	 * 
	 * @return	total amount spent
	 */
	public double getTotalAmountSpent() {
		return totalAmountSpent;
	}
}
