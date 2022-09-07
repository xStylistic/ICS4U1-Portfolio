/**
 * Names: Bonny Chen and Shuhan Zhang
 * Date: March 10, 2022 
 * Description: Laptop child class with unique attribute: hasMouse and unique method: useMouse()
 */


public class Laptop extends Device {
	
	/*
	 * Attributes: values and variables related to the objects 
	 */
	
	/** If the device has a mouse */
	private boolean hasMouse;
	
	/** Amount of battery level drained for each hour using the laptop */
	private int drain;
	
	/**
	 * Constructor to create a laptop
	 * 
	 * @param modelName: model name of the laptop
	 * @param weight: how much does the laptop weigh (kilograms / kg)
	 * @param colour: colour of the outside of the laptop
	 * @param storage: how much storage the laptop has (gigabytes / GB)
	 * @param batteryLevel: the battery percentage of the laptop
	 */
	public Laptop(String modelName, double weight, String colour, int storage, int batteryLevel) {
		
		super(modelName, weight, colour, storage, batteryLevel);
		setCanCarry(false);
		addGame("Minecraft");
		addGame("League of Legends");
		addGame("Genshin Impact");
		drain = 10; // drain = 15 for phone

	}
	
	/*
	 * Methods
	 */
	
	public boolean getHasMouse() {
		
		return this.hasMouse;
	
	}
	
	/**
	 * Phone loses battery based on how many hours you play a game and prints out the game you're playing
	 * 
	 * @param choice: game selected to play
	 * @param hours: hours spent playing the game
	 */
	public void playGame(int choice, int hours) {
		
		int i = getBatteryLevel() - hours * drain;
		
		if (i < 0) {
			
			i = 0;
			
		}
		
		setBatteryLevel(i);
		System.out.println("Playing " + this.getGame(choice) + "...");
		
	}
	
	/**
	 * Laptop loses battery based on how many hours you spend browsing the internet
	 * 
	 * @param hours: hours spent browsing the internet
	 */
	public void browseInternet(int hours) {
		
		int i = getBatteryLevel() - hours * drain;
		
		if (i < 0) {
			
			i = 0;
			
		}
		
		setBatteryLevel(i);
	
	}
	
	/**
	 * Attaches a mouse to the laptop
	 */
	public void attachMouse() {
		
		this.hasMouse = true;
	
	}
	
	/** 
	 * Checks if you have a mouse to use
	 */
	public void useMouse() {
		
		if (!hasMouse) { 
			
			System.out.println("A mouse is not connected!");
			
		} else {
			
			System.out.println("Using mouse...");
			
		}
		
	}
	
	/**
	 * Displays all the attributes of the laptop in a string
	 * 
	 * @return a string with all the attributes of the laptop line by line
	 */
	public String toString() {

		return ("\nModel Name: " + getModelName() + "\nWeight: " + getWeight() + " kg\nColour: " + getColour() + "\nAvailable Storage: " + getStorage()
				+ "GB\nBattery Level: " + getBatteryLevel()+ "\nHas a mouse: " + getHasMouse());

	}

}
