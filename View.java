import java.util.Scanner;

// VIEW ALL CAR RENTAL RECORDS
public class View{

	public static void viewAll(){
	
	int viewChoice;
	String viewAgain;
	// loop of the first choice in main menu
	do{
		// Print out all registration no. and car no.
		for(int i=1; i <= Car.carList.length; i++){
			System.out.println(
				"Car NO. "+ i + '\t' + "Brand: " + Car.carList[i-1].getBrand());
		}
		
		// Ask user to choose which car to review
		System.out.println();
		System.out.println("Which car you would like to check?"+ '\n'+
			"Please enter Car No. or enter 99 to see the all car records.");
		System.out.println();
		Scanner scan = new Scanner(System.in);
		viewChoice = scan.nextInt();
		
		// Display all or a specific car record details
		if(viewChoice==99){
			for(Car eachCar: Car.carList){
				System.out.println(eachCar);
			}
		} 
		else{
			System.out.println(Car.carList[viewChoice-1]);
		}
		
		// ask user if they want to check other car records
		System.out.println("Would you like to check other car records? (yes or no)");
		viewAgain = scan.next();
		if(viewAgain.equalsIgnoreCase("no")){
			break;
			// goes back to the end of swtich in main method
		}

	} while(viewAgain.equalsIgnoreCase("yes")); 
}
//End of viewAll()
}
//End of View class
