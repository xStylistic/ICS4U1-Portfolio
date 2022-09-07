import java.io.*;
import java.util.*;

/**
 * Name: Bonny Chen
 * 
 * Date: 02/10/2022
 * 
 * Description: Read the file at
 * https://github.com/ngryman/lol-champions/blob/master/champions.json. In the
 * file, MaxChampStats.txt, write out in separate lines:
 * 
 * a) the name and hp of the champion with the highest hp 
 * b) the name and armor of the champion with the lowest armor.
 */

public class Chen_Bonny_ChampionFilter {

	public static void main(String[] args) {
		
		// Variables
		String hpChamp = "", armorChamp = "", lineIn, fileIn = "champions.json", fileOut = "MaxChampStats.txt", currentChamp = "";
		String[] line;
		double armor, hp, maxHp = -99999999, minArmor = 99999999;
		
		try {		
			
			// File reader 
			BufferedReader in = new BufferedReader(new FileReader(fileIn));
			lineIn = in.readLine();
			
			// Infinite loop until it's done reading the file
			while (lineIn != null) {

				line = (lineIn.substring(0, lineIn.length() - 1)).split(" "); // Removes the commas
				
				// Loop to get the name of the champion
				for (int i = 0; i < line.length; i++) {

					if (line[i].equals("\"name\":")) {

						currentChamp = line[i + 1]; 

					}
					
					// Checks the armor each line and if the number is > than the last number read
					else if (line[i].equals("\"armor\":")) {

						armor = Double.parseDouble(line[i + 1]);

						if (armor < minArmor) { 

							minArmor = armor; // Sets the minArmor to the lesser armor read
							armorChamp = currentChamp;

						}

					}
					
					// Checks if the hp each line and if the number is < than the last number read 
					else if (line[i].equals("\"hp\":")) {

						hp = Double.parseDouble(line[i + 1]);
						
						if (hp > maxHp) { 

							maxHp = hp; // Sets the maxHp to the greater hp read
							hpChamp = currentChamp;

						}

					}

				}

				lineIn = in.readLine(); // Reader 
				
			}
			
			// Writes in the MaxChampStats.txt 
			FileWriter writer = new FileWriter(fileOut, false);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			
			// Outputs the champion with most hp and least armor 
			bufferedWriter.write(hpChamp + " has " + maxHp + " hp which is the champion with the most health");
			bufferedWriter.newLine(); // Next line 
			bufferedWriter.write(armorChamp + " has " + minArmor + " armor which is the champion with the least armor");

			bufferedWriter.close();

		} catch (IOException e) {

			System.out.println(e + " issue reading " + fileIn); // Error message

		}

	}

}
