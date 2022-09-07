import java.util.*;

/**
 * Name: Bonny Chen
 * 
 * Date: 02/08/2022
 * 
 * Description: A program that asks for two grocery items and it's price.
 */

public class Chen_Bonny_GroceryItem {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		// Variables
		String item1, item2;
		double itemPrice1, itemPrice2;

		// Get items input
		System.out.println("Enter grocery item #1:");
		item1 = in.nextLine();

		System.out.println("Enter the price of " + item1 + ":");
		itemPrice1 = in.nextDouble();
		in.nextLine();
		
		// Get prices input
		System.out.println("Enter grocery item #2:");
		item2 = in.nextLine();

		System.out.println("Enter the price of " + item2 + ":");
		itemPrice2 = in.nextDouble();

		// Items and price output
		System.out.println("----------------------------------"); 
		System.out.printf("%-27s %6s %n", item1, "$" + String.format("%.2f", itemPrice1)); // Formats the item on the left, prices on the right 
		System.out.printf("%-27s %6s %n", item2, "$" + String.format("%.2f", itemPrice2)); // Formats the item on the left, prices on the right 
		System.out.println("----------------------------------");

	}

}
