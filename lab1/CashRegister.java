package labs.lab1;

import java.util.ArrayList;
/**
 * A cash register totals up sales and computes change due.
 */
public class CashRegister {
	private double purchase;
	private double payment;
	private ArrayList<Double> items;
	private double salesTotal;
	private int salesCount;

	/**
	 * Constructs a cash register with no money in it.
	 */
	public CashRegister() {
		purchase = 0;
		payment = 0;
		items = new ArrayList<Double>();
		salesTotal = 0;
		salesCount = 0;
	}

	/**
	 * Records the sale of an item.
	 * 
	 * @param amount the price of the item
	 */
	public void recordPurchase(double amount) {
		purchase = purchase + amount;
		items.add(amount);
	}

	/**
	 * Processes a payment received from the customer.
	 * 
	 * @param amount the amount of the payment
	 */
	public void receivePayment(double amount) {
		payment = payment + amount;
	}

	/**
	 * Computes the change due and resets the machine for the next customer.
	 * 
	 * @return the change due to the customer
	 */
	public double giveChange() {
		double change = payment - purchase;
		salesTotal += purchase;
		salesCount++;
		purchase = 0;
		payment = 0;
		items.clear();
		return change;
	}
	

	/**
	 * Returns count of items purchased.
	 * 
	 * @return count of items purchased
	 */
	public int getItemCountInPurchase() {
		return items.size();
	}

	/**
	 * Get the total amount of all sales for the day.
	 * 
	 * @return the total amount of all sales for the day
	 */
	public double getSalesTotal() {
		return salesTotal;
	}

	/**
	 * Get the total number of sales for the day.
	 * 
	 * @return the number of sales for the day
	 */
	public int getSalesCount() {
		return salesCount;
	}

	/**
	 * Reset counters and totals for the next day's sales.
	 */
	public void reset() {
		purchase = 0;
		payment = 0;
		items.clear();
		salesTotal = 0;
		salesCount = 0;
	}

	public String getReceipt() {
		String res = "";
		for (double i: items) {
			res += i + "\n";
		}
		res += purchase + "\n";
		return res;
	}
}
