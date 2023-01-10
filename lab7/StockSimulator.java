package labs.lab7;

import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Class for simulating trading a single stock at varying prices.
 */
public class StockSimulator {

	private Queue<Block> blocks;
	private int totalQuantity;
	private int currBlockQuantity;

	/**
	 * Constructor
	 */
	public StockSimulator() {
		blocks = new LinkedList<>();
		totalQuantity = 0;
		currBlockQuantity = 0;
	}


	/**
	 * Handle a user buying a given quantity of stock at a given price.
	 * 
	 * @param quantity how many to buy.
	 * @param price    the price to buy at.
	 * 
	 * @throws IllegalArgumentException if the requested quantity/price cannot be
	 *                                  bought i.e., quantity <= 0 or price < 0
	 */
	public void buy(int quantity, int price) throws IllegalArgumentException {
		if (quantity <= 0 || price < 0) {
			throw new IllegalArgumentException("Unable to complete purchase");
		}
		else {
			if (blocks.size() == 0) {
				currBlockQuantity = quantity;
			}
			blocks.add(new Block(quantity, price));
			totalQuantity += quantity;
		}
	}


	/**
	 * Handle a user selling a given quantity of stock at a given price.
	 * 
	 * @param quantity how many to sell.
	 * @param price    the price to sell.
	 * 
	 * @return the gain (can be positive or negative)
	 * 
	 * @throws IllegalArgumentException if the requested quantity cannot be sold
	 *                                  e.g., quantity exceeds quantity owned,
	 *                                  quantity < 1, price < 0
	 */
	public int sell(int quantity, int price) throws IllegalArgumentException {
		if (quantity > totalQuantity || quantity < 1 || price < 0) {
			throw new IllegalArgumentException("Unable to complete sale");
		}
		else {
			totalQuantity -= quantity;
			int gain = 0;
			while (quantity != 0) {
				if (quantity >= currBlockQuantity) {
					quantity -= currBlockQuantity;
					gain += currBlockQuantity * (price - blocks.peek().getPrice());
					blocks.remove();
				}
				else {
					currBlockQuantity -= quantity;
					gain += quantity * (price - blocks.peek().getPrice());
					quantity = 0;
				}
			}
			return gain;
		}
	}


	/**
	 * This is a method for us to test your class
	 * 
	 * @return a List of Blocks owned
	 */
	public List<Block> getBlocks() {
		return (List<Block>) blocks;
	}

}
