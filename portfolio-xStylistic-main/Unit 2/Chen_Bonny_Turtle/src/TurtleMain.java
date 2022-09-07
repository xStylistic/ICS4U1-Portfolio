import java.awt.Color;

/**
* Name: Bonny Chen
*
* Date: 02/17/2022
* 
* Description: Make the turtle draw a house and fill it in
*/

public class TurtleMain {

	public static void main(String[] a) {

		Turtle bob = new Turtle();

		// Look at https://docs.oracle.com/javase/7/docs/api/java/awt/Color.html for
		// different colours

		// .forward(double distance);
		// .right/left(double angle);
		// .dot(colour, int size);
		// .fillColor(colour);
		// .stamp();
		// .penColor(colour);
		// lift pen .up();
		// put pen down .down();

		Turtle.bgcolor("lightblue");
		bob.penColor(new Color(0, 0, 0));
		bob.width(8);

		// ------------------- OUTLINE OF HOUSE ------------------- //

		// Base of house
		bob.up();
		bob.forward(100);
		bob.left(180);
		bob.down();
		bob.forward(200);
		bob.left(90);
		bob.forward(125);
		bob.left(90);
		bob.forward(200);
		bob.left(90);
		bob.forward(125);

		// Roof
		bob.right(90);
		bob.forward(20);
		bob.up();
		bob.left(180);
		bob.forward(220);
		bob.down();
		bob.forward(20);
		bob.right(135);
		bob.forward(172);
		bob.right(90);
		bob.forward(172);

		// Chimney
		bob.up();
		bob.left(180);
		bob.forward(172);
		bob.left(90);
		bob.forward(55);
		bob.down();

		bob.right(135);
		bob.forward(35);
		bob.left(90);
		bob.forward(45);
		bob.left(90);
		bob.forward(77);

		bob.up();
		bob.forward(70);
		bob.down();

		// Window
		bob.forward(50);
		bob.left(90);
		bob.forward(50);
		bob.left(90);
		bob.forward(50);
		bob.left(90);
		bob.forward(50);

		bob.up();
		bob.right(180);
		bob.forward(25);
		bob.down();
		bob.right(90);
		bob.forward(50);
		bob.up();
		bob.right(180);
		bob.forward(25);
		bob.down();
		bob.right(90);
		bob.forward(25);
		bob.up();
		bob.right(180);
		bob.forward(25);
		bob.down();
		bob.forward(25);

		// Door
		bob.up();
		bob.left(180);
		bob.forward(100);
		bob.left(90);
		bob.down();

		bob.forward(30);
		bob.right(90);
		bob.forward(55);
		bob.right(90);
		bob.forward(100);

		bob.up();
		bob.right(90);
		bob.forward(55);
		bob.right(90);
		bob.down();
		bob.forward(70);

		// ------------------- PAINT THE HOUSE ------------------- //

		// Colour of the base of the house
		bob.shape("rectangle");
		bob.fillColor(new Color(209, 6, 6));
		bob.shapeSize(200, 125);
		bob.up();
		bob.left(90);
		bob.forward(17);
		bob.left(90);
		bob.forward(9);
		bob.left(90);
		bob.stamp();

		// Colour of the chimney
		bob.fillColor(new Color(204, 102, 0));
		bob.shapeSize(77, 45);
		bob.left(90);
		bob.forward(140);
		bob.left(90);
		bob.forward(61);
		bob.right(90);
		bob.stamp();

		// Colour of the roof
		bob.shape("triangle");
		bob.fillColor(new Color(0, 0, 0));
		bob.shapeSize(117, 243);
		bob.right(90);
		bob.forward(62);
		bob.right(90);
		bob.forward(20);
		bob.left(180);
		bob.stamp();

		// Colour of the window
		bob.shape("square");
		bob.fillColor(new Color(255, 255, 255));
		bob.shapeSize(50, 50);
		bob.right(180);
		bob.forward(110);
		bob.right(90);
		bob.forward(53);
		bob.stamp();

		// Colour of the door
		bob.shape("rectangle");
		bob.fillColor(new Color(96, 96, 96));
		bob.shapeSize(105, 55);
		bob.left(180);
		bob.forward(100);
		bob.right(90);
		bob.forward(20);
		bob.stamp();

		// ------------------- RE-OUTLINE OF HOUSE ------------------- //

		bob.shape("turtle");
		bob.fillColor(new Color(0, 255, 128));
		
		// Window
		bob.forward(5);
		bob.right(90);
		bob.forward(77);
		bob.down();
		bob.forward(50);
		bob.right(90);
		bob.forward(50);
		bob.right(90);
		bob.forward(50);
		bob.right(90);
		bob.forward(50);

		bob.up();
		bob.right(90);
		bob.forward(25);
		bob.right(90);
		bob.down();
		bob.forward(50);

		bob.up();
		bob.right(90);
		bob.forward(25);
		bob.right(90);
		bob.forward(25);
		bob.right(90);
		bob.down();

		bob.forward(50);

		// Door
		bob.up();
		bob.left(180);
		bob.forward(100);
		bob.left(90);
		bob.down();

		bob.forward(30);
		bob.right(90);
		bob.forward(55);
		bob.right(90);
		bob.forward(100);
		bob.right(90);
		bob.forward(55);
		bob.right(90);
		bob.forward(70);

		// House base
		bob.up();
		bob.forward(53);
		bob.right(90);
		bob.down();
		bob.forward(78);
		bob.right(90);
		bob.forward(125);
		bob.right(90);
		bob.forward(200);
		bob.right(90);
		bob.forward(125);
		bob.right(90);
		bob.forward(200);

		// Roof
		bob.forward(20);
		bob.left(135);
		bob.forward(172);
		bob.left(90);
		bob.forward(172);
		
		// Chimney
		bob.right(180);
		bob.forward(55);
		bob.left(45);
		bob.forward(77);
		bob.right(90);
		bob.forward(50);
		bob.right(90);
		bob.forward(35);
		bob.right(45);
		bob.forward(50);
		
		// Turtle exiting
		bob.up();
		bob.forward(500);

		
	
	}

}
