/**
 * Names: Bonny Chen 
 * 
 * Date: March 1, 2022 
 * 
 * Description: Create a human class with the attributes: name, age, weight, height and energy level
 */

public class Human {

	/*
	 * Attributes: values and variables related to the objects
	 */

	/**
	 * Name of the human
	 */
	private String name;

	/**
	 * Weight of the human (kilograms)
	 */
	private double weight;

	/**
	 * Energy level of the human
	 */
	private int energyLevel;
	
	/**
	 * Default human constructor
	 */
	public Human() {

		this.name = "";
		this.weight = -1;
		this.energyLevel = -1;

	}

	/**
	 * Creates a human constructor
	 * 
	 * @param name:        name of human
	 * @param weight:      weight of human
	 * @param energyLevel: energy level of human
	 */
	public Human(String name, int energyLevel, double weight) {

		this.name = name;
		this.weight = weight;
		this.energyLevel = energyLevel;

	}

	/*
	 * Access Methods
	 */

	/**
	 * Gets the name of the human
	 * 
	 * @return the name of the human
	 */
	public String getName() {

		return this.name;

	}

	/**
	 * Gets the weight of the human
	 * 
	 * @return the weight of the human
	 */
	public double getWeight() {

		return this.weight;

	}

	/**
	 * Gets the energy level of the human
	 * 
	 * @return the energy level of the human
	 */
	public int getEnergyLevel() {

		return this.energyLevel;

	}

	/*
	 * Mutator methods: used to change values of objects
	 */

	/**
	 * Makes the human sleep for x number of hours and increase their energy by 10% x number of hours
	 * 
	 * @param hours: how many hours the will slept
	 */
	public void sleep(int hours) {

		double energy = hours * 10;
		
		if (energy > 100) {

			this.energyLevel = 100;

		} else {

			this.energyLevel += energy; 

		}

	}

	/**
	 * Makes the human run x number of km to lose energy and weight
	 * 
	 * @param km: distance that the will ran
	 */
	public void run(double km) {
		
		if (this.energyLevel >= km) {

			this.energyLevel -= km;

		}

		if (this.weight > 0.001 * km) {

			this.weight -= 0.001 * km;

		}

	}

	/**
	 * Human eats meat and gains the weight eaten
	 * 
	 * @param meat: how much meat they eat
	 */
	public void consume(Meat meat, double weight) {

		int caloriesConsumed = meat.eaten(weight);
		
		if (caloriesConsumed == -1) { // Meat was not eaten

			System.out.println("I don’t have that much food \n");

		} else if (caloriesConsumed == -2) { // Meat was not eaten because of a bone

			System.out.println("There’s a bone in the way \n");

		} else {
			
			// Calculate the amount of calories that was drunk
			this.weight += (weight * 0.001);
			this.energyLevel += (caloriesConsumed / 15);

		}

	}

	/**
	 * Makes the human drink a drink without the straw and gains weight and energy drank
	 * 
	 * @param drink: drink the drink with no straw
	 */
	public void consume(Drink drink, double weight) {

		int caloriesConsumed = drink.drank(weight);

		if (caloriesConsumed == -1) { // Drink is not drunk

			System.out.println("I don’t have that much drink \n");

		} else if (caloriesConsumed == -2) { // Drink is not drunk because it has no straw

			System.out.println("I don’t have a straw \n");

		} else {
			
			// Calculate the amount of calories that was drunk
			this.weight += (weight * 0.001);
			this.energyLevel += (caloriesConsumed / 15);

		}

	}

	/**
	 * Makes the human drink a drink with a straw and gains weight and energy drank
	 * 
	 * @param drink: drink the drink with a straw
	 */
	public void consumeWithStraw(Drink drink, double weight) {
		
		int caloriesConsumed = drink.drank(weight, true);

		if (caloriesConsumed == -1) { // Drink is not drunk

			System.out.println("I don’t have that much drink \n"); // Drink is not drunk

		} else {
			
			// Calculate the amount of calories that was drunk
			this.weight += (weight * 0.001);
			this.energyLevel += (caloriesConsumed / 15);

		}

	}
	
	/**
	 * Displays all the attributes of the human in a string
	 * 
	 * @return a string with all the attributes of the human line by line
	 */
	public String toString() {

		return ("Name: " + this.name + "\nWeight: " + this.weight + "\nEnergy Level: " + this.energyLevel + "\n");

	}
	
}
