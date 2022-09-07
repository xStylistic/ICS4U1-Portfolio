class HumanMain {
	
  public static void main(String[] args) {
	  
    //Initialize the Human Mikasa
    Human mikasa = new Human("Mikasa", 19, 70, 176, 75);
    
    System.out.println(mikasa.toString()); // Output set attributes
    
    // Change Mikasa's attributes
    mikasa.setEnergyLevel(1);
    mikasa.sleep(5);
    mikasa.setWeight(65);
    mikasa.setName("Mikasa Ackerman"); 
    
    System.out.println(mikasa.toString());

    // Initialize the Human Eren
    Human eren = new Human("Eren", 19, 80, 183, 88); 
    
    System.out.println(eren.toString()); // Output set attributes
    
    // Change Eren's attributes
    eren.run(8);
    eren.setHeight(185);
    eren.setAge(18);
    
    System.out.println(eren.toString()); // Output changed attributes
    
  }
  
}