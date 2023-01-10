package labs.lab7;

/**
 * A quantity and price of a block of stocks.
 */
public class Block {
	private int price;
	private int quantity;

	/**
	 * Constructor
	 * 
	 * @param quantity the quantity of shares in this block.
	 * @param price    the price of this block.
	 */
	public Block(int quantity, int price) {
		this.quantity = quantity;
		this.price = price;
	}

	
	public int getQuantity() {
		return quantity;
	}

	
	public int getPrice() {
		return price;
	}

	
	/**
	 * Sells shares in this block
	 * 
	 * @param shares   the number of shares to sell
	 */
	public void sell(int shares) {
		quantity -= shares;
	}
}
