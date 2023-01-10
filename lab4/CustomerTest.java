package labs.lab4;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {
	private final double EPSILON = 1e-13;
	
	@Test
	public void testPurchaseLessThan100() {
		Customer c = new Customer();
		c.makePurchase(50);
		assertEquals(0, c.getNumDiscountsToUse());
		assertEquals(50.0, c.getTotalAmountSpent(), EPSILON);
	}
	
	@Test
	public void testPurchaseMoreThan100() {
		Customer c = new Customer();
		c.makePurchase(170);
		assertEquals(1, c.getNumDiscountsToUse());
		assertEquals(170.0, c.getTotalAmountSpent(), EPSILON);
	}
	
	@Test
	public void testDiscountApplied() {
		Customer c = new Customer();
		c.makePurchase(120);
		assertEquals(1, c.getNumDiscountsToUse());
		assertEquals(120.0, c.getTotalAmountSpent(), EPSILON);
		c.makePurchase(30);
		assertEquals(0, c.getNumDiscountsToUse());
		assertEquals(147.0, c.getTotalAmountSpent(), EPSILON);
	}
	
	@Test
	public void testPurchaseEarningMultipleDiscounts() {
		Customer c = new Customer();
		c.makePurchase(350);
		assertEquals(3, c.getNumDiscountsToUse());
		assertEquals(350.0, c.getTotalAmountSpent(), EPSILON);
	}
	
	@Test
	public void testOnlyOneDiscountApplied() {
		Customer c = new Customer();
		c.makePurchase(500);
		assertEquals(5, c.getNumDiscountsToUse());
		assertEquals(500.0, c.getTotalAmountSpent(), EPSILON);
		c.makePurchase(20);
		assertEquals(4, c.getNumDiscountsToUse());
		assertEquals(518.0, c.getTotalAmountSpent(), EPSILON);
		c.makePurchase(30);
		assertEquals(3, c.getNumDiscountsToUse());
		assertEquals(545.0, c.getTotalAmountSpent(), EPSILON);
		c.makePurchase(70);
		assertEquals(3, c.getNumDiscountsToUse());
		assertEquals(608.0, c.getTotalAmountSpent(), EPSILON);
	}
}
