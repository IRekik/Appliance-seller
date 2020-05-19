// -----------------------------------------------------
// Assignment 1
// Part II
// Written by: Ismael Rekik (40132567)
// -----------------------------------------------------


// Scanner class importation
import java.util.Scanner;
public class part2 {

	public static void main(String[] args) {
		// Prompt welcome text
		System.out.println("Welcome dear user.");
		System.out.println("Please select the maximum number of appliances.");
		// Counter that counts the number of failures for the password
		int failureCounter=0;
		Scanner input=new Scanner(System.in);
		// User enters the number max of appliances
		int maxAppliances=input.nextInt();
		// integer that will later store the number of appliances
		int enteredApp=0;
		// Array that will store all the appliances
		Appliance [] inventory= {};
		// for loop without conditions to loop the program as long as the user does not press 5 in the main menu
		for (;;) {	
			// do while loop to execute the 1st choice in the main menu as long as the user does not enter the correct password
			do {
				System.out.print("What do you want to do?\n\t1.   Enter new appliances (password required)\n\t2.   "
						+ "Change information of an appliance (password required)\n\t3.   Display all appliances by a specific brand\n\t4.   "
						+ "Display all appliances under a certain a price\n\t5.   Quit\nPlease enter your choice>");
				// Enter the user's choice
				int userChoice=input.nextInt();
				// While loop to loop the step as long as the user does not provide a number between 1 and 5
				while (userChoice < 1 || userChoice > 5) {
					System.out.print("What do you want to do?\n\t1.   Enter new appliances (password required)\n\t2.   "
							+ "Change information of an appliance (password required)\n\t3.   Display all appliances by a specific brand\n\t4.  "
							+ " Display all appliances under a certain a price\n\t5.   Quit\nPlease enter your choice>");
					userChoice=input.nextInt();;
				}
				// Store the password (c249)
				final String password="c249";
				// Switch statement that will select an option based on the user'S choice. Breaks at the end of each possibility
				switch (userChoice) {
					// Case 1 : Allows user to enter new appliances and store them in the array created previously
					case 1 : { System.out.println("Please enter the valid password");
						String userAttempt1=input.next();
						// while loop in case user does not enter the right password
						while (!(userAttempt1.equals(password))) {
							failureCounter++;
							// Close the program if the user enters a wrong password 12 times (4 times 3)
							if (failureCounter == 12) {
								System.out.println("Program detected suspicious activities and will terminate immediately");
								System.exit(0);
							}
							// If the user enters 3 times a wrong password, this if statement resets to the main menu
							if (((failureCounter) % 3)==0) {					
								break;
							}
							System.out.println("Please enter the valid password");
							userAttempt1=input.next();
						// Resets the number of counters if the good password is entered by user	
						}
						if (userAttempt1.equals(password)) {
							failureCounter=0;
						// Block of code only reachable if the user enter the right password to avoid executing this part if the entered password is incorrect 
						}
						if (failureCounter==0) {
							System.out.println("How many appliances do you want to enter?");
							enteredApp=input.nextInt();
							// while loop to make sure that the user enters a number of appliances equal or smaller than the number max of appliances entered at the beginning of the program
							while (enteredApp > maxAppliances) {
								System.out.println("Please enter a number of appliances smaller than the maximum allowed number of appliances "
										+ "("+maxAppliances+").");
								enteredApp=input.nextInt();
							
							}
							// for loop to create every appliance with the user's parameters
							inventory= new Appliance[enteredApp];
							for (int i=0;i<enteredApp;i++) {
								System.out.println("Please give the type, brand, serial number and price for the obect number " + (i+1));
								String typeIn=input.next();
								String brandIn=input.next();
								long serialNumIn=input.nextLong();
								double priceIn=input.nextDouble();
								inventory [i]=new Appliance(typeIn,brandIn,serialNumIn,priceIn); 
							}
							
						}
						break;
					}
					// Case 2 : allows user to edit parameters of appliances. Requires the password to reach this option
					case 2 : {
					System.out.println("Please enter the right password.");
						String userAttempt2=input.next();
						int caseTwoCounter=0;
						// while loop in case the user enters an invalid password. If statement to break after 3 wrong passwords and prompt to main menu.
						while (!(userAttempt2.equals(password))) {
							caseTwoCounter++;
							System.out.println("The entered password is wrong. Please enter the right password.");
							userAttempt2=input.next();
							if (caseTwoCounter==2) {
								break;
							}
						}
						// integer that will the store the index of the Appliance with a specific entered serial number 
						int valueOfJToSave=0;
						if (userAttempt2.equals(password)) {
							// Resets counter to 0
							caseTwoCounter=0;
							// Boolean that is false is an appliance with an entered serial number does not exist or true if an appliance has been found
							boolean goodNum=false;
							// While loop that will execute until user enters a serial number assigned to an appliance
							while (goodNum==false) {
								System.out.println("Please select the serial number of the appliance you wish to update");
								// Asks the user to enter another serial number
								int serNumUpdate=input.nextInt();
								// for loop that will search again for an appliance with a specific serial number
								for (int j=0;j<enteredApp;j++) {
									// if statement that will execute if an appliance has been found. Change the boolean goodNum to true
									if (inventory[j].getSerialNumber() == serNumUpdate) {
										valueOfJToSave=j;
										goodNum=true;
									}
									
								}
								// if statement in the case where no appliances has been found for a specific number. Asks the user to either enter another serial number or exit to main menu
								if (goodNum==false) {
									System.out.println("There is no existing appliance with this specific serial number. Please either press 1"
											+ " to enter another serial number or 2 to acces the main menu.");
									int w=input.nextInt();
									if (w==1) {
										continue;
									}
									else {
										break;
									}
								}
							}
							// Display the information of the selected appliance
							System.out.println("Here are the information about the selected appliance :");
							System.out.println("Appliance Serial # "+inventory[valueOfJToSave].getSerialNumber());
							System.out.println("Brand: "+inventory[valueOfJToSave].getBrand());
							System.out.println("Type: "+inventory[valueOfJToSave].getType());
							System.out.println("Price: "+inventory[valueOfJToSave].getPrice());
							// Asks the user the parameter ton modify
							System.out.println("What information would you like to change?");
							System.out.println("\t1.  brand");
							System.out.println("\t2.  type");
							System.out.println("\t3.  price");
							System.out.println("\t4.  Quit");
							System.out.println("Enter your choice >");
							int changeIn=input.nextInt();
							// while loop if the user does not enter a number between 1 and 4
							while (!(changeIn==1 || changeIn==2 || changeIn==3 || changeIn==4)) {
								System.out.println("What information would you like to change?");
								System.out.println("\t1.  brand");
								System.out.println("\t2.  type");
								System.out.println("\t3.  price");
								System.out.println("\t4.  Quit");
								System.out.println("Enter your choice >");
								changeIn=input.nextInt();
							}
							// if/else if/else statements for each choice
							if (changeIn==1) {
								System.out.println("Please select the value");
								String newBrand=input.next();
								inventory[valueOfJToSave].setBrand(newBrand);
							}
							else if (changeIn==2) {
								System.out.println("Please select the value");
								String newType=input.next();
								inventory[valueOfJToSave].setType(newType);
							}
							else if (changeIn==3) {
								System.out.println("Please select the value");
								double newPrice=input.nextDouble();
								inventory[valueOfJToSave].setPrice(newPrice);
							}
							else {
								break;
							}
								
						}
						
						break;
					}
					// Case 3 : Looks at all the appliances with a specific brand
					case 3 : {
						System.out.println("Please select a brand");
						String brandInput=input.next();
						int loopCounter=0;
						// for loop verify one by one if each appliance has the entered brand
						for (int l=0;l<enteredApp;l++) {
							if (brandInput.equals(inventory[l].getBrand())) {
								System.out.println(inventory[l]);
								loopCounter++;
							}
						} 
						// if statement if there is no appliances with that entered brand
						if (loopCounter ==0){
							System.out.println("No appliance has been found with the entered brand. The program shall now go "
									+ "back to the main menu.");
						}
						break;
					}
					// Case 4 : Looks at all the appliances with a price smaller than an entered price
					case 4 : {
						System.out.println("Please enter a price");
						double priceInput=input.nextDouble();
						// Checks one by one all the appliances 
						for (int m=0;m<enteredApp;m++) {
							if (priceInput>inventory[m].getPrice()) {
								System.out.println(inventory[m]);
							}
						}
						break;
					}	
					// exits the program
					case 5 : 
						System.out.println("The program will now exit");
						input.close();
						System.exit(0);
					}
			}
			// while condition from the do/while loop stated at the beginning of the program that will loop the 1st case if the user does not enter the right password
			while (failureCounter != 0);
		}
	
	}
	
}
// End of the program
