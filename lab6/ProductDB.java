package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class ProductDB {

	private String productsFileName;
	private ArrayList<Product> products;

	/**
	 * Constructor that reads in the product data from a file
	 * 
	 * @param productsFileName name of file with product data
	 */
	public ProductDB(String productsFileName) {
		this.productsFileName = productsFileName;
		products = new ArrayList<Product>();
		try (Scanner inFile = new Scanner(new File(productsFileName))) {
			while (inFile.hasNextLine()) {
				String temp = inFile.nextLine();
				String[] tempArr = temp.split(";");
				products.add(new Product(tempArr[0], Double.parseDouble(tempArr[1]), Integer.parseInt(tempArr[2])));
			}
		}
		catch (FileNotFoundException e) {
			System.out.print("File: " + productsFileName + " not found");
		}
	}


	/**
	 * Searches for the product with the given name and returns it if found,
	 * otherwise returns null.
	 * 
	 * @param productName name of product to search for
	 * 
	 * @return product with given name, or null if not found
	 */
	public Product findProduct(String productName) {
		for (Product p: products) {
			if (productName.equals(p.getName())) {
				return p;
			}
		}
		return null;
	}


	/**
	 * Adds a new product to the products DB if a product with the given name
	 * doesn't already exist
	 * 
	 * @param name     name of product
	 * @param price    price of product
	 * @param quantity quantity of product
	 */
	public void addProduct(String name, double price, int quantity) {
		for (Product p: products) {
			if (name.equals(p.getName())) {
				return;
			}
		}
		products.add(new Product(name, price, quantity));
		try (PrintWriter writeFile = new PrintWriter(new FileOutputStream(new File(productsFileName),true))) {
			writeFile.println(name+";"+price+";"+quantity);
		}
		catch (FileNotFoundException e) {
			System.out.print("File: " + productsFileName + " not found");
		}
	}
}
