import java.util.*;

/**
 * Name: Bonny Chen
 * 
 * Date: 02/08/2022
 * 
 * Description: A method that returns the smallest angle in a triangle in
 * degrees given two sides and an angle.
 */

public class SASTriangleSolver {

	/**
	 * This method will get the smallest angle in the triangle
	 * 
	 * @param sideA  - first side of the triangle used to calculate the angle
	 * @param sideB  - second side of the triangle used to calculate the angle
	 * @param angleC - the angle in between the first and second side of the triangle
	 * @return returns the smallest angle in degrees
	 */

	public static double getSmallestAngle(double sideA, double sideB, double angleC) {
		
		// The angles in a triangle added up
		int totalDegrees = 180;
		
		// Calculate the 3rd side using cosine law
		double sideC = Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2) - 2 * sideA * sideB * Math.cos(angleC));
		
		// Calculate angleB using sine line
		double angleB = (Math.asin(sideA * Math.sin(angleC) / sideC));

		// Convert the angles in radian to degrees
		angleB = Math.toDegrees(angleB);
		angleC = Math.toDegrees(angleC);

		double angleA = totalDegrees - angleB - angleC; // Find the last missing angle of the triangle

		// An array to sort the angles from smallest to biggest
		double angles[] = {angleA, angleB, angleC};
		Arrays.sort(angles); // Function to sort the array
		double smallestAngle = angles[0]; // Smallest angle will be the first variable in the array
		
		return (double) smallestAngle;

	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		double sideA, sideB, angleC, smallestAngle; // Variables

		// Get user input of the numbers
		System.out.println("Enter the first side of the triangle:");
		sideA = in.nextDouble();
		in.nextLine();

		System.out.println("Enter the angle of the triangle in radians:");
		angleC = in.nextDouble();
		in.nextLine();

		System.out.println("Enter the second side of the triangle:");
		sideB = in.nextDouble();
		in.nextLine();

		smallestAngle = getSmallestAngle(sideA, sideB, angleC); // Call method

		// Output smallest angle in the triangle
		System.out.println("\nThe smallest angle in the triangle in is " + String.format("%.2f", smallestAngle) + " degrees.");

	}

}
