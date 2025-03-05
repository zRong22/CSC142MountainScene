import java.text.DecimalFormat; // to format the output

import uwcse.io.Input; // use the Input class

/**
 * Homework 3 <br>
 * Simulating a purchase in Canada paid in US dollars
 * 
 * @author ZhuoRong RuanZhao
 */

public class CanadianGiftShop {

	/** Exchange rate 1 US dollar = RATE Canadian dollar */
	public static final double RATE = 1.43;

	/** Price of a jar of maple syrup in Canadian dollars before taxes */
	public static final double JAR_PRICE = 5.95;

	/**
	 * Price of photograph of the city of Victoria in Canadian dollars before taxes
	 */
	public static final double PHOTO_PRICE = 7.65;

	/** Price of a beaver hat in Canadian dollars before taxes */
	public static final double HAT_PRICE = 16.35;

	/** Maximum allowed number of purchased items for each item */
	public static final int MAX_ITEM = 100;

	/** Tax rate */
	public static final double TAX_RATE = 0.117;

	// instance variables
	// number of purchased jars of maple syrup
	private int jarNumber;

	// number of purchased photographs of the city of Victoria
	private int photoNumber;

	// number of purchased beaver hats
	private int hatNumber;

	// 2 digits after the decimal point for doubles
	private DecimalFormat twoDigits = new DecimalFormat("0.00");
	// primitive type to get change back in cents
	private double change;
	// total primitive type double to be able to get
	// total in cents
	private double total;
	// calculating the total in USD
	private double payUS;
	// calculating the total in CA
	private double costCA;
	// Input for the user to input a value
	private Input in = new Input();

	/**
	 * Takes and processes the order from the customer
	 */
	public void takeAndProcessOrder() {
		// Here is a possible series of steps: call some other (private)
		// methods to do each step.
		// Display the items and their prices
		introCanadian();
		// Get the Customer's order
		input();
		// Compute the total with tax
		// Any discount?
		itemList();
		// Get the user's USD payment
		// Give the change back in Canadian dollars
		changeinCAD(payUS, costCA);
	}

	// Some ideas for some private methods
	// You don't have to use exactly these same methods.

	/**
	 * Displays the items for sale and their prices in Canadian dollars
	 */
	private void introCanadian() {
		System.out.println("\tWelcome to Canadian Wonders" + "\n\t***************************\n");
		System.out.println("Here is a price list of our most popular products (in Canadian dollars)\n");
		System.out.println("Jar of Maple Syrup: $5.95\n" + "Photograph of Victoria: $7.65\n" + "Beaver Hat: $16.35\n");
		System.out.println("The above prices don't include taxes. The tax rate is 11.7%.\n"
				+ "Our exchange rate is 1 US dollar = 1.43 Canadian dollars.\n");
	}

	/**
	 * boolean method to see if the total it has non decreasing digits from CA
	 * dollars and CA cents when read from left to right
	 * 
	 * @param d (return true if the digits are increasing (1234) return false if
	 *          nondecreasing digits are (4321)
	 * @return true or false statements
	 * 
	 */
	public boolean nonDecreasing(int d) {
		if (d < 10) {
			return true;
		}
		int lastDigit = d % 10;
		int secondLast = (d / 10) % 10;
		if (secondLast > lastDigit) {
			return false;
		} else {
			return nonDecreasing(d / 10);
		}
	}

	// the method to calculate the total of the list
	// to see if they qualify for the 10% discount or not
	private void itemList() {
		System.out.println("\nYour purchase total is $" + twoDigits.format(total) + " CA (tax included)");
		if (nonDecreasing((int) total)) {
			System.out
					.println("You are a lucky customer. You qualify for our (mathematically mysterious!) discount :)");
			total *= 0.90;
			System.out.println("Your purchase total is now $" + twoDigits.format(total) + " CA (tax included)");
		} else {
			System.out.println("\nYou don't qualify for our (mathematically mysterious!) discount :(");
		}

		payUS = in.readDouble("Please, enter the US dollar amount to pay for the order :");
	}

	/**
	 * Gets the customer's order
	 * 
	 * Precondition: none
	 * 
	 * Postcondition: jarNumber, photoNumber and hatNumber are initialized to a
	 * value between 0 and MAX_ITEM
	 */
	// method to get the input of the user in however many quantity
	// they would like to get from each different fields
	private void input() {
		jarNumber = in.readInt("How many jars of maple syrup would you like?: ");
		jarNumber = checkValue(jarNumber);
		photoNumber = in.readInt("How many photographs of Victoria would you like?: ");
		photoNumber = checkValue(photoNumber);
		hatNumber = in.readInt("How many beaver hats would you like?: ");
		hatNumber = checkValue(hatNumber);
		total = (jarNumber * JAR_PRICE + photoNumber * PHOTO_PRICE + hatNumber * HAT_PRICE) * (1 + TAX_RATE);
	}

	// method to check if the user input, inputs a
	// a value between 0 - 100
	private int checkValue(int items) {
		if (items > MAX_ITEM) {
			System.out.println("Sorry, we don't have that many in stock ");
			return 0;
		} else if (items < 0) {
			System.out.println(items + " is not a valid number of items!");
			return 0;
		} else {
			return items;
		}

	}

	/**
	 * Given a purchase in canadian dollars and a payment in US dollars, displays
	 * the change amount in canadian dollars and cents
	 * 
	 * @param payUS  payment in US dollars
	 * @param costCA purchase amount in Canadian dollars
	 */
	// method calculates the total in US and then CA rounded to the nearest nickel
	// gives back the total in CA rounded to the nearest nickel
	private void changeinCAD(double payUS, double costCA) {
		double payCA = payUS * RATE;
		costCA = total;
		change = payCA - costCA;
		change = (double) Math.round(change * 20) / 20;
		int changeCent = (int) Math.round(change * 100);
		System.out.println(
				"You gave $" + twoDigits.format(payUS) + " US" + ", which is $" + twoDigits.format(payCA) + " CA.");
		if (change < 0) {
			System.out.println("Sorry, this is not enough!");
			System.exit(0);
		} else {
			System.out.println(
					"Here is your change (rounded to the closest nickel): $" + twoDigits.format(change) + " CA.");
		}
		int bill100 = changeCent / 10000;
		changeCent %= 10000;
		if (bill100 > 0) {
			System.out.println(bill100 + " $100" + (bill100 == 1 ? " bill" : " bills"));
		}

		int bill50 = changeCent / 5000;
		changeCent %= 5000;
		if (bill50 > 0) {
			System.out.println(bill50 + " $50" + (bill50 == 1 ? " bill" : " bills"));
		}

		int bill20 = changeCent / 2000;
		changeCent %= 2000;
		if (bill20 > 0) {
			System.out.println(bill20 + " $20" + (bill20 == 1 ? " bill" : " bills"));
		}

		int bill10 = changeCent / 1000;
		changeCent %= 1000;
		if (bill10 > 0) {
			System.out.println(bill10 + " $10" + (bill10 == 1 ? " bill" : " bills"));
		}

		int bill5 = changeCent / 500;
		changeCent %= 500;
		if (bill5 > 0) {
			System.out.println(bill5 + " $5" + (bill5 == 1 ? " bill" : " bills"));
		}

		int toonie = changeCent / 200;
		changeCent %= 200;
		if (toonie > 0) {
			System.out.println(toonie + (toonie == 1 ? " toonie" : " toonies"));
		}

		int loonie = changeCent / 100;
		changeCent %= 100;
		if (loonie > 0) {
			System.out.println(loonie + (loonie == 1 ? " loonie" : " loonies"));
		}

		int coin25 = changeCent / 25;
		changeCent %= 25;
		if (coin25 > 0) {
			System.out.println(coin25 + (coin25 == 1 ? " quarter" : " quarters"));
		}

		int coin10 = changeCent / 10;
		changeCent %= 10;
		if (coin10 > 0) {
			System.out.println(coin10 + (coin10 == 1 ? " dime" : " dimes"));
		}

		int coin5 = changeCent / 5;
		changeCent %= 5;
		if (coin5 > 0) {
			System.out.println(coin5 + (coin5 == 1 ? " nickel" : " nickels"));
		}
		System.out.println("\nThank you for your business.");
		System.exit(0);
	}

	/**
	 * Entry point of the program
	 */
	public static void main(String[] args) {
		new CanadianGiftShop().takeAndProcessOrder();
	}

}
