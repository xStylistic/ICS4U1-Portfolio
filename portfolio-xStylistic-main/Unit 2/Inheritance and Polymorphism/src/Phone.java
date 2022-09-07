/**
 * Names: Bonny Chen and Shuhan Zhang
 * Date: March 10, 2022 
 * Description: Phone child class with unique attribute: phoneNumber and unique method: call()
 */

public class Phone extends Device {
	
	/*
	 * Attributes: values and variables related to the objects 
	 */
	
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
	 * @param phoneNumber: phone number in the phone
	 */
	public Phone(String modelName, double weight, String colour, int storage, int batteryLevel, long phoneNumber) {
		
		super(modelName, weight, colour, storage, batteryLevel);
		setCanCarry(true);
		this.phoneNumber = phoneNumber;
		addGame("Temple Run");
		addGame("Clash Royale");
		addGame("Subway Surfers");
		addGame("Cookie Run Kingdom");
		drain = 15; // drain = 20 for laptop

	}
	
	/*
	 * Methods
	 */
	 
    /**
	 * Get the phone's number
	 * 
	 * @return the phone number of the phone
	 */
	public long getPhoneNumber() {
		
		return this.phoneNumber;
	
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
		System.out.println("playing " + this.getGame(choice) + "...");
		
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
	 * Displays all the attributes of the phone in a string
	 * 
	 * @return a string with all the attributes of the phone line by line
	 */
	public String toString() {

		return ("\nModel Name: " + getModelName() + "\nWeight: " + getWeight() + " kg\nColour: " + getColour() + "\nAvailable Storage: " + getStorage()
				+ "GB\nBattery Level: " + getBatteryLevel() + "\nPhone number: " + getPhoneNumber());

	}

}
