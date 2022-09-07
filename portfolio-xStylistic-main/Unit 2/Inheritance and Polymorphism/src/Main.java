/**
 * Names: Bonny Chen and Shuhan Zhang 
 * Date: March 10, 2022 
 * Description: Main class
 */

public class Main {

	public static void main(String[] args) {

		// Creates a laptop
		Laptop l = new Laptop("ASUS", 4.8, "Black", 256, 40);


		// Laptop commands
		l.downloadApp("Roblox", 13, true);
		l.downloadApp("Valorant", 75, true);
		l.downloadApp("Apex Legends", 180, true);
		l.playGame(4, 2);
		l.attachMouse();
		
		System.out.println(l); // Output the laptop's attributes


		// Creates phones
		Phone p1 = new Phone("Samsung S20", 1.2, "White", 128, 100, 21390219);
		Phone p2 = new Phone("iPhone 13 Pro", 4, "Gold", 50, 30, 95454983);

		// Phone commands
		p1.addSkin("Green");
		p1.downloadApp("Instagram", 10, false);
		p1.downloadApp("Plant vs Zombies", 20, true);
		p1.playGame(4, 5);
		p2.getPhoneNumber();

		System.out.println(p1); // Output the phone's attributes

		/*
		 * Putting both the laptops and phones into the devices array because they are
		 * specific types of devices so they still classify as devices
		 */
		Device[] devices = new Device[3];
		devices[0] = l;
		devices[1] = p1;
		devices[2] = p2;

		/* 
		 * Going through the array, if the device is an instance of a laptop, use the
		 * Laptop class's unique method-useMouse. If the device is an instance of a
		 * phone, use the Phone class's unique method-call.
		 */ 
		for (int i = 0; i < devices.length; i++) {
			
			devices[i].browseInternet(1);
			
			if (devices[i] instanceof Laptop) {
				
				((Laptop) devices[i]).useMouse();
				
			} else if (devices[i] instanceof Phone) {
				
				((Phone) devices[i]).call(p2);
				
			}
			
		}

	}

}
