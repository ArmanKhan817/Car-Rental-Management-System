import java.util.*;
import java.io.*;

public class Search{

public static void search() throws Exception{
	int fieldInt;
	String search, field="", searchAgain;
	// Insert CarReadWrite.carList to initialize the CarReadWrite.carList
	CarReadWrite.readInput();
	do{
		System.out.println("Whcih field would you like to search? Please enter 1 to 10.");
		System.out.println(
			"1. Registration No.\n"+
			"2. Availability\n"+
			"3. Car Brand\n"+
			"4. Car Model\n"+
			"5. Car color\n"+
			"6. Mileage\n"+
			"7. Year of Produce\n"+
			"8. First Name of the User\n"+
			"9. Last Name of the User\n"+
			"10. User Number");
		Scanner scan = new Scanner(System.in);
		fieldInt = scan.nextInt();
		System.out.println("Please type in a search word.");
		System.out.println("(Enter a number for searching mileage or year of produce)");
		search = scan.next();

		System.out.println("This is the car you are searching for: \n");

		for(int i=0; i<CarReadWrite.carList.size();i++){
			Car object = CarReadWrite.carList.get(i);
			// according to different user choice, initialize field
			switch(fieldInt){
				case 1: field = object.getRegis(); break;
				case 2: field = object.getAvailability(); break;
				case 3: field = object.getBrand(); break;
				case 4: field = object.getModel(); break;
				case 5: field = object.getColor(); break;
				case 6: field = Integer.toString(object.getMile()); break;
				case 7: field = Integer.toString(object.getYear()); break;
				case 8: field = object.getFName(); break;
				case 9: field = object.getLName(); break;
				case 10: field = object.getUserNo(); break;
			}
			// check if the assigned field equals to the search word
			if(search.equalsIgnoreCase(field)){
				System.out.println(object);
			}
		} //End of for loop

		//Check for entering next loop
		System.out.println("Would you like to search again?");
		searchAgain = scan.next();
		if (searchAgain.equalsIgnoreCase("no")){
			break;
		}
	} while(searchAgain.equalsIgnoreCase("yes"));

}//End of search method

public static void available() throws Exception{
	// Insert CarReadWrite.carList to initialize the CarReadWrite.carList
	CarReadWrite.readInput();
	
	System.out.println("Those are the avaialbe cars: ");
	// Display all available cars
	for(int i=0; i<CarReadWrite.carList.size();i++){
		Car object = CarReadWrite.carList.get(i);
		if(object.getAvailability().equalsIgnoreCase("yes")){
			System.out.println(object);
		}
	} //End of for loop

}//End of available method


public static void borrowed() throws Exception{
	// Insert CarReadWrite.carList to initialize the CarReadWrite.carList
	CarReadWrite.readInput();
	
	System.out.println("Those are borrowed cars: ");
	// Display all available cars
	for(int i=0; i<CarReadWrite.carList.size();i++){
		Car object = CarReadWrite.carList.get(i);
		if(object.getAvailability().equalsIgnoreCase("no")){
			System.out.println(object);
		}
	} //End of for loop

}//End of borrowed method


}//End of search class