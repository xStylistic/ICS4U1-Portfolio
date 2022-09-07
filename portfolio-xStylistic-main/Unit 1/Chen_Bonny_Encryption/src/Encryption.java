import java.util.*;

/**
 * Name: Bonny Chen
 * 
 * Date: 02/09/2022
 * 
 * Description: A program which encrypts a line of code. The encryption
 * specifications are as follows: First and last character of each string are
 * exchanged. Middle characters of each string are shifted to the character two
 * after it in the ASCII table (works for non-letters as well.) spaces are left
 * alone careful with strings less than 3 characters
 * 
 * EXAMPLE: 
 * Input: Enter a line to be encrypted: Happy Days! 
 * Output: The encryption is: ycrrH !c{uD
 */

public class Chen_Bonny_Encryption {

	/**
	 * @param str - the original string that will be encrypted
	 * @return will return the new string after it's encrypted
	 */

	// Encryption function
	public static String encryptString(String str) {

		String newString = ""; // New string
		newString += str.charAt(str.length() - 1); // Adds last letter
		
		// Loops through the middle letters
		for (int i = 1; i < str.length() - 1; i++) { 
			
			char newChar = (char)(str.charAt(i) + 2); // Creates char value that is shifted by two
			newString += newChar; // Adds char to string

		}

		newString += str.charAt(0); // Adds first letter
		
		return newString;

	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.println("Enter a message to encrypt: \n"); // Get string input

		String line[] = in.nextLine().split(" "); // Splits input by spaces into the array

		for (String str : line) { // Loops through array
			
			System.out.print(encryptString(str) + " "); // Prints out each encrypted string

		}

	}

}
