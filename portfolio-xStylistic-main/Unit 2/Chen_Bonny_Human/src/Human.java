/**
Names: Bonny and Dimitri
Date: Feb 25, 2022
Description: Create a human class with the attributes: name, age, weight, height and energy level
 */

public class Human {

	// Attributes

	/**
	 * name of the human
	 */
	private String name;
	/**
	 * age of the human
	 */
	private int age;
	/**
	 * weight, energyLevel, height of the human
	 */
	private double weight, energyLevel, height;

	/**
	 * @param name: name of human
	 * @param weight: weight of human
	 * @param energyLevel: energy level of human
	 * @param height: height of human
	 * @param age: age of human
	 * @return
	 */
	Human(String name, int age, double weight, double height, double energyLevel) {

		this.name = name;
		this.weight = Math.max(0.001, weight);
		this.energyLevel = Math.max(0, energyLevel);
		this.height = Math.max(0.001, height);
		this.age = Math.max(0, age);

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
	 * Gets the age of the human
	 * 
	 * @return the age of the human
	 */
	public int getAge() {

		return this.age;

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
	 * Gets the height of the human
	 * 
	 * @return the height of the human
	 */
	public double getHeight() {

		return this.height;

	}

	/**
	 * Gets the energy level of the human
	 * 
	 * @return the energy level of the human
	 */
	public double getEnergyLevel() {

		return this.energyLevel;

	}

	/**
	 * Displays all the attributes of the human in a string
	 * 
	 * @return a string with all the attributes of the human line by line
	 */
	public String toString() {

		return String.format("Name: %s \nAge: %d \nWeight: %.2f \nEnergy Level: %.2f%% \nHeight: %.2f \n", this.name,
				this.age, this.weight, this.energyLevel, this.height);

	}

	/*
	 * Mutator Methods
	 */

	/**
	 * Gets the new name of the human
	 * 
	 * @param newName: changes the name of the human
	 */
	public void setName(String newName) {

		this.name = newName;

	}

	/**
	 * Gets the new age of human and has to be greater than 0
	 * 
	 *  @param newAge: changes the age of the human
	 */
	public void setAge(int newAge) {

		if (newAge > 0) {

			this.age = newAge;

		}

	}

	/**
	 * Gets the new weight of the human and has to be greater than 0
	 * 
	 * @param newWeight: changes the weight of the human
	 */
	public void setWeight(double newWeight) {

		if (newWeight > 0) {

			this.weight = newWeight;

		}

	}

	/**
	 * Gets the new height of the human and has to be greater than 0
	 * 
	 * @param newHeight: changes the height of the human
	 */
	public void setHeight(double newHeight) {

		if (newHeight > 0) {

			this.height = newHeight;

		}

	}

	/**
	 * Gets the new energy level of the human
	 * 
	 * @param newEnergyLevel: changes the energy level of the human
	 */
	public void setEnergyLevel(double newEnergyLevel) {

		this.energyLevel = newEnergyLevel;

	}

	/**
	 * Makes the human sleep for x number of hours and increase their energy by 10% x number of hours
	 * 
	 * @param hours: how many hours they slept
	 **/
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
	 * @param km: distance that they ran
	 */
	public void run(double km) {

		if (this.energyLevel >= km) {

			this.energyLevel -= km;

		}

		if (this.weight > 0.001 * km) {

			this.weight -= 0.001 * km;

		}

	}

}
