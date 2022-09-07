/**
 * Names: Bonny Chen 
 * 
 * Date: March 1, 2022 
 * 
 * Description: Main class to run the methods
 */

public class Chen_Bonny_OOQuiz1 {

	public static void main(String[] args) {
		
	Human eren = new Human("Eren", 75, 88);
		
        System.out.println(eren);
       
        Meat m1= new Meat("Bulgogi", 150, false);
        Meat m2= new Meat("Sirloin Steak", 170, true);
        
        Drink d1 = new Drink();
        Drink d2 = new Drink("Coffee", 150, 270);
        Drink d3 = new Drink("Bubble Tea", 280, 930, true);
       
        // Human drinks drink
        eren.consume(d1, -1);
        eren.consumeWithStraw(d2, 28);
        eren.consume(d3, 120); 
        
        // Human eats meat
        eren.consume(m1, 88);
        eren.consume(m2, 170);  
        
        // Output
        System.out.println(d3);
        System.out.println(m1);
        System.out.println(eren);
  
	}

}
