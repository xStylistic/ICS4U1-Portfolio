import java.util.*;

/**
 * Name: Bonny Chen
 * 
 * Date: 02/11/2022
 * 
 * Description: A program that repeatedly asked for the numerator and divisor.
 * For each set of data, the program prints out the result (quotient), or an
 * informative error message if there is a problem (division by zero or poor
 * input data). The program continues looping, even if there is a problem. Exit
 * the loop when data entered for the numerator start with characters “q” or
 * “Q”. Don’t print out an error message in this case. Don’t ask for the divisor
 * if the user just asked to quit.
 */

public class FoolProof {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		// Infinite loop
		while (true) { 
			
			// Variables
			String input1, input2;
			int numerator, divisor; 
			double answer;
			
			// Get first input from user
			System.out.println("Enter the numerator (type 'q' to exit program): ");
			input1 = in.next();
			
			// Check if input has a q in the first character
			char checkForQ = input1.charAt(0);
			
			if (String.valueOf(checkForQ).equalsIgnoreCase("q")){ // Converts char to string and checks for quit command
				
				break; // Quits program
				
			}
			
			try {
				
				// Tries first input
				numerator = Integer.parseInt(input1);
				
				// Get second input from user
				System.out.println("\nEnter the divisor: ");
				input2 = in.next();
				
				try {
					     
					// Tries second input if it works
					divisor = Integer.parseInt(input2);
					
					// Checks if a 0 was entered
					if (divisor == 0) {
						
						System.out.println("\nCannot divide by 0, please try again.\n"); // Output error message
						
					}
					
					else {
						
						// Calculation
						answer = numerator * 1.0 / divisor * 1.0;
						System.out.println("\n" + answer + "\n"); // Outputs the answer
						
					}
	

				} catch (NumberFormatException e) {
					
					System.out.println("\nInvalid number, please try again.\n"); // Output error message
					
				}
				
			} catch (NumberFormatException e) {
				
				System.out.println("\nInvalid number, please try again.\n"); // Output error message
				
			}

		}

	}

}
