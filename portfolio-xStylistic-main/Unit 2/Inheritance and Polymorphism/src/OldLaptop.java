import java.util.ArrayList;

/**
 * Names: Bonny Chen and Shuhan Zhang
 * Date: March 10, 2022 
 * Description: The old laptop class without inheritance
 */


public class OldLaptop {

	/*
	 * Attributes: values and variables related to the objects 
	 */
	/** Model name of the device */
	private String modelName;

	/** Weight of the device */
	private double weight;

	/** Color of the device */
	private String colour;

	/** Amount of storage the device has */
	private int storage;

	/** Battery level of the device */
	private int batteryLevel;

	/** If a person can carry the device in their hand */
	private boolean canCarry;

	/** Games on the device */
	private ArrayList<String> games;

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
	public OldLaptop(String modelName, double weight, String colour, int storage, int batteryLevel) {

		this.modelName = modelName;
		this.weight = weight;
		this.colour = colour;
		this.storage = storage;
		this.batteryLevel = batteryLevel;
		this.canCarry=false;
		games = new ArrayList<String>();
		this.games.add("Minecraft");
		this.games.add("League of Legends");
		this.games.add("Genshin Impact");
		this.drain = 10; // drain = 15 for phone

	}

	/*
	 * Methods
	 */
	/**
	 * Change the model name of the device
	 * 
	 * @param newModelName: set a new model name
	 */
	public void setModelName(String newModelName){

		this.modelName = newModelName;

	}

	/**
	 * Change the storage of the device
	 * 
	 * @param newStorage: set a new storage amount 
	 */
	public void setStorage(int newStorage){

		this.storage = newStorage;

	}

	/**
	 * Change the battery level of the device
	 * 
	 * @param newBatteryLevel: set a new battery percentage
	 */
	public void setBatteryLevel(int newBatteryLevel){

		this.batteryLevel = newBatteryLevel;

	}

	/**
	 * Change the weight of the device
	 * 
	 * @param newWeight: set a new weight for the device
	 */
	public void setWeight(double newWeight){

		this.weight = newWeight;

	}

	/**
	 * Change the colour of the device
	 * 
	 * @param newColour: set a new colour for the device
	 */
	public void setColour(String newColour){

		this.colour = newColour;

	}

	/**
	 * Change if the device is carriable 
	 * 
	 * @param ifCanCarry: if the device can be hand held
	 */
	public void setCanCarry(boolean ifCanCarry) {

		this.canCarry = ifCanCarry;

	}

	/**
	 * Get model name of the device
	 * 
	 * @return the model name
	 */
	public String getModelName(){

		return this.modelName;

	}

	/**
	 * Get storage of the device
	 * 
	 * @return the amount of storage
	 */
	public int getStorage(){

		return this.storage;
	}

	/**
	 * Get battery level of the device
	 * 
	 * @return the battery percentage
	 */
	public int getBatteryLevel(){

		return this.batteryLevel;

	}

	/**
	 * Get the weight of the device
	 * 
	 * @return the weight
	 */
	public double getWeight(){

		return this.weight;

	}

	/**
	 * Get the colour of the device
	 * 
	 * @return the colour 
	 */
	public String getColour(){

		return this.colour;

	}

	/**
	 * @param choice the game of choice
	 * @return returns the game of choice from the list of games
	 */
	public String getGame(int choice){

		return games.get(choice);

	}

	/**
	 * Adds a game to the list of playable games in the device
	 * 
	 * @param newGame the new game that should be added
	 */
	public void addGame(String newGame) {

		games.add(newGame);

	}
	/**
	 * Gain battery percentage based on the time charged
	 * 
	 * @param hours: number of hours charged
	 */
	public void charge(int hours) {

		int i = this.batteryLevel + hours * 20;

		if (i > 100) {

			i = 100;

		}

		this.batteryLevel = i;

	}

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
	 * Adds a skin on to the device changing it's outer colour
	 * 
	 * @param colour: colour of the device
	 */
	public void addSkin(String colour) {

		this.weight += 0.01;
		this.colour = colour;

	}

	
	/**
	 * Displays all the attributes of the laptop in a string
	 * 
	 * @return a string with all the attributes of the laptop line by line
	 */
	public String toString() {

		return ("\nModel Name: " + this.modelName + "\nWeight: " + this.weight + " kg\nColour: " + this.colour + "\nAvailable Storage: " + this.storage
		+ "GB\nBattery Level: " + this.batteryLevel+ "\nHas a mouse: " + this.hasMouse);

	}

}
