/**
 * Names: Bonny Chen and Shuhan Zhang
 * Date: March 10, 2022 
 * Description: Device super class
 */

import java.util.ArrayList;

public class Device {

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

	/**
	 * Constructor to create a device
	 * 
	 * @param modelName: model name of the device
	 * @param weight: how much does the device weigh (kilograms / kg)
	 * @param colour: colour of the outside of the device
	 * @param storage: how much storage the device has (gigabytes / GB)
	 * @param batteryLevel: the battery percentage of the device
	 */
	public Device(String modelName, double weight, String colour, int storage, int batteryLevel) {

		this.modelName = modelName;
		this.weight = weight;
		this.colour = colour;
		this.storage = storage;
		this.batteryLevel = batteryLevel;
		games = new ArrayList<String>();
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
	 * Device loses battery based on how long you spend browsing the internet
	 * 
	 * @param hours: how long you've browsed the internet for
	 */
	public void browseInternet(int hours) {

		int i = this.batteryLevel - hours * 10;

		if (i < 0) {

			i = 0;

		}

		this.batteryLevel = i;

	}

	/**
	 * Downloads an app onto the device but will only download if there is enough storage
	 * 
	 * @param app: name of the app
	 * @param size: how much storage the app takes up
	 * @param isGame: checks if it's a game
	 */
	public void downloadApp(String app, int size, boolean isGame) {

		if (this.storage > size) {

			if(isGame) {

				addGame(app);

			}

			this.storage -= size;
			System.out.println("Successfully downloaded " + app);

		} else {

			System.out.println("Unsuccessful download...");

		}

	}

	/**
	 * Removes the app from the device and it's storage space
	 * 
	 * @param app: name of the app
	 * @param size: how much storage the app takes up
	 */
	public void deleteApp(String app, int size) {

		games.remove(games.indexOf(app));
		System.out.println("Deleted " + app);

		this.storage += size;

	}

	/**
	 * If you didn't create a phone or laptop, and only a device, you play nothing
	 */
	public void playGame() {

		System.out.println("Playing...nothing");

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

}
