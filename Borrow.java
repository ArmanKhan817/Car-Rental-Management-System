import java.util.Scanner;

public class Borrow{
	static String borrowAgain, borrowConfirm;
	public static void borrow() throws Exception{
		int borrowChoice, index;
		do{
			// Insert CarReadWrite.carList in Borrow class
			CarReadWrite.readInput();

			// Print out all registration no. and car no.
			for(int i=0; i < CarReadWrite.carList.size(); i++){
				System.out.println(
					"Car NO. "+ (i+1) + '\t' + "Registration No. " + 
					CarReadWrite.carList.get(i).getRegis());
			}
			// Ask user to choose which car to borrow
			System.out.println();
			System.out.println("Which car you would like to borrow?"+ '\n'+
				"Please enter Car No. or enter 99 to see the all car records.");
			System.out.println();
			Scanner scan = new Scanner(System.in);
			borrowChoice = scan.nextInt();
			index = borrowChoice-1;
			

			// Display all or a specific car record details
			if(borrowChoice==99){
				for(Car eachCar: CarReadWrite.carList){
					System.out.println(eachCar);
				}
			} else{
				System.out.println(CarReadWrite.carList.get(index));
			}

			// confirm user's choice to borrow this car
			System.out.println("Are you sure to borrow this car? (yes or no)");
			borrowConfirm = scan.next();
			
			if(borrowConfirm.equalsIgnoreCase("yes")){
				// reset the availability as no
				CarReadWrite.carList.get(index).setAvailability("no");
  				// reset the first name and last name in borrowed car object
				System.out.println("Please enter your first name.");
				String fName = scan.next();
				System.out.println("Please enter your last name.");
				String lName = scan.next();
				CarReadWrite.carList.get(index).setUserName(fName,lName);
				System.out.println("Please enter your phone number.");
				String userNo = scan.next();
				CarReadWrite.carList.get(index).setUserNo(userNo);

				// print the current borrowed car info
				System.out.println("This is the car you borrowed."+"\n\n"+
					CarReadWrite.carList.get(index));

				// Write all objects in carList into the output file 
				CarReadWrite.writeOutput();
				
				// ask user if they want to borrow other car records
				System.out.println("Would you like to borrow other cars? (yes or no)");
				borrowAgain = scan.next();
				if(borrowAgain.equalsIgnoreCase("no")){
					break;
					// goes back to the end of swtich in main method
				}
			}//End of borrow confirmation

			if(borrowConfirm.equalsIgnoreCase("no")){
				break;
			}

		} while(borrowAgain.equalsIgnoreCase("yes")); 
	}
}