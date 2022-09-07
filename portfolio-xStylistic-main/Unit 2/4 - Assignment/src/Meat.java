/**
 * Names: Bonny Chen
 * 
 * Date: March 1, 2022
 * 
 * Description: Create a meat class with the attributes: name, weight and hasBone
 */

public class Meat {

	/*
	 * Attributes: values and variables related to the objects
	 */

	/**
	 * Type of meat
	 */
	private String name;

	/**
	 * Weight of the meat (grams)
	 */
	private double weight;

	/**
	 * If the meat has a bone/bones
	 */
	private boolean hasBone;

	/**
	 * Default meat constructor
	 */
	public Meat() {

		this.name = "";
		this.weight = -1;
		this.hasBone = false;

	}

	/**
	 * Creates a meat constructor
	 * 
	 * @param name:    name of the meat
	 * @param weight:  weight of the meat
	 * @param hasBone: if the meat has bone in it
	 */
	public Meat(String name, double weight, boolean hasBone) {

		this.name = name;
		this.weight = weight;
		this.hasBone = hasBone;

		if (this.hasBone) {

			this.weight += 50;

		}

	}

	/*
	 * Access methods
	 */

	/**
	 * Gets the meats' name
	 * 
	 * @return the name of the meat
	 */
	public String getName() {

		return this.name;

	}

	/**
	 * Gets the meats' weight
	 * 
	 * @return the weight of the meat
	 */
	public double getWeight() {

		return this.weight;

	}

	/**
	 * Sees if the meat has bone
	 * 
	 * @return if meat has bone
	 */
	public boolean getHasBone() {

		return this.hasBone;

	}

	/*
	 * Mutator methods: used to change values of objects
	 */

	/**
	 * Remove the bone in the meat and removes 50 grams
	 */
	public void deBone() {

		this.hasBone = false;
		this.weight -= 50;

	}

	/**
	 * How much meat was eaten converted into calories
	 * 
	 * @param weight: amount of meat eaten
	 * @return if the meat was not eaten or because there was a bone
	 */
	public int eaten(double weight) {

		if (weight > this.weight) { // Meat was not eaten

			return -1;

		}

		else if (hasBone && weight > (this.weight - 50) && weight <= this.weight) { // Meat was not eaten because there
																					// was a bone

			return -2;
		}

		else {

			weight -= this.weight; // Calculate the weight of the meat eaten

		}

		return (int) (weight * 2.5); // Return the amount of calories eaten

	}

	/**
	 * Displays all the attributes of the human in a string
	 * 
	 * @return a string with all the attributes of the human line by line
	 */
	public String toString() {

		return ("Name: " + this.name + "\nWeight: " + this.weight + "\nHas Bone: " + this.hasBone + "\n");

	}

}
