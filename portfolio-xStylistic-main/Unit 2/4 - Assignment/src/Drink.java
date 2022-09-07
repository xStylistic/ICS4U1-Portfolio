/**
 * Names: Bonny Chen 
 * 
 * Date: March 1, 2022 
 * 
 * Description: Create a drink class with the attributes: name, weight, calories and hasStraw
 */

public class Drink {

	/*
	 * Attributes: values and variables related to the objects
	 */
	
	/**
	 * Name of the drink
	 */
	private String name;

	/**
	 * Weight of the drink (grams)
	 */
	private double weight;

	/**
	 * Calories in the drink
	 */
	private int calories;

	/**
	 * If drink has a straw
	 */
	private boolean hasStraw;

	/**
	 * Default drink constructor
	 */
	public Drink() {

		this.name = "";
		this.weight = -1;
		this.calories = -1;
		this.hasStraw = false;

	}

	/**
	 * Drink constructor with no straw 
	 * 
	 * @param name:     name of the drink
	 * @param weight:   weight of the drink
	 * @param calories: calories in the drink
	 */
	public Drink(String name, double weight, int calories) {

		this.name = name;
		this.weight = weight;
		this.calories = calories;
		this.hasStraw = false;

	}

	/**
	 * Creates drink constructor with or without a straw
	 * 
	 * @param name:     name of the drink
	 * @param weight:   weight of the drink
	 * @param calories: calories in the drink
	 * @param hasStraw: drink has straw or no straw
	 */
	public Drink(String name, double weight, int calories, boolean hasStraw) {

		this.name = name;
		this.weight = weight;
		this.calories = calories;
		this.hasStraw = hasStraw;

	}

	/*
	 * Access Methods
	 */

	/**
	 * Gets the name of the drink
	 * 
	 * @return the name of the drink
	 */
	public String getName() {

		return this.name;

	}

	/**
	 * Gets the weight of the drink
	 * 
	 * @return the weight of the drink
	 */
	public double getWeight() {

		return this.weight;

	}

	/**
	 * Gets the calories in the drink
	 * 
	 * @return the calories in the drink
	 */
	public int getCalories() {

		return this.calories;

	}

	/**
	 * If drink has straw
	 * 
	 * @return the drink with straw
	 */
	public boolean getHasStraw() {

		return this.hasStraw;

	}

	/*
	 * Mutator methods: used to change values of objects
	 */

	/**
	 * Adds a straw to the drink
	 */
	public void insertStraw() {

		this.hasStraw = true;

	}

	/**
	 * If the drink is drunk it gives how much calories is drank
	 * 
	 * @param weight: how many grams is the drink
	 * @return if the drink is not drunk or because it has no straw
	 */
	public int drank(double weight) {

		if (weight > this.weight) { // Drink is not drunk

			return -1;
		}

		else if (hasStraw == false) { // Drink is not drunk because it has no straw

			return -2;

		}

		else {
			
			// Calculate the amount of calories that was drank
			int caloriesDrank = (int)(weight / this.weight * calories);
			this.calories -= caloriesDrank;
			this.weight -= weight;

			return caloriesDrank;

		}

	}

	/**
	 * Gives the drink a draw if it doesn't have a straw
	 * 
	 * @param: weight:        how many grams is the drink
	 * @param: hasExtraStraw: if an extra straw is needed
	 * @return if the drink is not drunk or because it has no straw
	 */
	public int drank(double weight, boolean hasExtraStraw) {

		if (weight > this.weight) { // Drink is not drunk

			return -1;

		} else if (this.hasStraw == false) {

			if (hasExtraStraw == false) { // Drink is not drunk because it has no straw

				return -2;

			} else {
				
				// Calculate the amount of calories that was drank
				int caloriesDrank = (int)(weight / this.weight * calories);
				this.calories -= caloriesDrank;
				this.weight -= weight;

				return caloriesDrank;

			}

		} else {
			
			// Calculate the amount of calories that was drank
			int caloriesDrank = (int)(weight / this.weight * calories);
			this.calories -= caloriesDrank;
			this.weight -= weight;

			return caloriesDrank;

		}

	}
	
	/**
	 * Displays all the attributes of the drink in a string
	 * 
	 * @return a string with all the attributes of the drink line by line
	 */
	public String toString() {

		return ("Name: " + this.name + "\nWeight: " + this.weight + " g\nCalories: " + this.calories + " cal\nHas Straw: " + this.hasStraw + "\n");

	}
	
}
