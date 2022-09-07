import java.util.ArrayList;

/**
 * Names: Bonny Chen and Shuhan Zhang
 * Date: March 10, 2022 
 * Description: Old phone class without inheritance
 */


public class OldPhone {

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

	/** Phone number of the device */
	private long phoneNumber;

	/** Amount of battery level drained for each hour using the phone */
	private int drain;

	/**
	 * Constructor to create a phone
	 * 
	 * @param modelName: model name of the phone
	 * @param weight: how much does the phone weigh (kilograms / kg)
	 * @param colour: colour of the outside of the phone
	 * @param storage: how much storage the phone has (gigabytes / GB)
	 * @param batteryLevel: the battery percentage of the phone
	 */
	public OldPhone(String modelName, double weight, String colour, int storage, int batteryLevel) {

		this.modelName = modelName;
		this.weight = weight;
		this.colour = colour;
		this.storage = storage;
		this.batteryLevel = batteryLevel;
		this.canCarry=false;
		games = new ArrayList<String>();
		this.games.add("Temple Run");
		this.games.add("Clash Royale");
		this.games.add("Subway Surfers");
		this.games.add("Cookie Run Kingdom");
		this.drain = 15; // drain = 20 for laptop

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
	 * Phone loses battery based on how many hours you spend browsing the internet
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
	 * Phone will call the phone number
	 * 
	 * @param phone: the phone being called
	 */
	public void call(Phone phone) {

		System.out.println("Calling " + phone.getPhoneNumber());

	}

	/**
	 * Get the phone's number
	 * 
	 * @return the phone number of the phone
	 */
	public long getPhoneNumber() {

		return this.phoneNumber;

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
	 * Displays all the attributes of the Phone in a string
	 * 
	 * @return a string with all the attributes of the laptop line by line
	 */
	public String toString() {

		return ("\nModel Name: " + this.modelName + "\nWeight: " + this.weight + " kg\nColour: " + this.colour + "\nAvailable Storage: " + this.storage
				+ "GB\nBattery Level: " + this.batteryLevel+ "\nPhone number: " + this.phoneNumber);

	}

}
