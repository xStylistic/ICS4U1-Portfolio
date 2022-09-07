/*
This is a class, it has blueprints for creating objects
 */

public class Vegetable {
	
	/*
	 * Attributes
	 */

	/** The type of vegetable */
	private String name;

	/** The color of vegetable */
	private String colour;

	/** The smell of vegetable */
	private String smell;

	/** The calories of vegetable */
	private int calories;

	/** The type of vegetable */
	private double weight;

	/** The type of vegetable */
	private boolean hasPeel;
	

	/*
	 * Constructor
	 */

	public Vegetable(String name, String colour, String smell, int calories, double weight, boolean hasPeel) {

		// Gets the attribute and puts it into the parameter
		this.name = name;
		this.colour = colour;
		this.smell = smell;
		this.calories = calories;
		this.weight = weight;
		this.hasPeel = hasPeel;

		if (calories < 0) {

			this.calories = 1;

		} else {

			this.calories = calories;

		}

		this.hasPeel = hasPeel;

		if (!hasPeel) { // If it doesn't have a peel, min weight is 1

			if (weight <= 0) {
				this.weight = 1;

			} else {

				this.weight = weight;

			}

		} else { // If it has a peel of 20 g

			if (weight <= 20) {
				
				this.weight = 21;

			} else {

				this.weight = weight;

			}

		}

	}

}