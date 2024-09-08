import java.util.*;
import java.io.*;
/*Purpose: modify specific fields of a chosen car
How it works? 
1.It uses the carList in CarReadWrite class, so it presents as CarReadWrite.carList
2.In method header: throws exception
3.Use CarReadWrite.readInput() to start use the carList in CarReadWrite class
4.Modification by:
  CarReadWrite.carList.get(modiIndex).setRegis(regisNo)
5.We can use setter of Car class is because carList is an array of Car objects;
  any objects in carList can use functions in Car class
6.Write all objects in carList into the output file by CarReadWrite.writeOutput()
*/
public class Modify {
	
	static private String regisNo="", available="", carBrand="", model="", color="", 
		firstName="", lastName="", userNo="";
	static private int mile=0, yearOfProduce=0;
	static private String inputFile="carInput.txt", outputFile="output.txt";

public static void modify() throws Exception{
	Scanner modiScan = new Scanner(System.in);
	String modiChoice, modiAgain;
	int modiChoiceInt, modiIndex;
	do{
		// Print out all registration no. and car no. 
		for(int i=0; i < CarReadWrite.carList.size(); i++){
			System.out.println(
				"Car NO. "+ (i+1) + '\t' + "Registration No. " + 
				CarReadWrite.carList.get(i).getRegis());
		}
		// Ask user to choose which car to modify
		System.out.println();
		System.out.println("Which car you would like to modify?"+ '\n'+
			"Please enter Car No. or enter 99 to see the all car records.");
		System.out.println();
		Scanner scan = new Scanner(System.in);
		modiChoiceInt = scan.nextInt();
		modiIndex = modiChoiceInt-1;
		
		// Insert CarReadWrite.carList in modify class
		CarReadWrite.readInput();

		// Display all or a chosen car record details
		if(modiChoiceInt==99){
			for(Car eachCar: CarReadWrite.carList){
				System.out.println(eachCar);
			}
		} else{
			System.out.println(CarReadWrite.carList.get(modiIndex));
		}
		
		// Ask users to specify a field to modify
		System.out.println("Please enter a field to modify\n"+
			"(regisNo/availability/carBrand/model/color/userName/userNo/mile/yearOfProduce)."+"\n"+
			"Or enter \"exit\" to exit.");
		modiChoice = modiScan.next();

		if (modiChoice.equalsIgnoreCase("resigNo")){
			System.out.println("Please enter registration number (C1 to C10).");
			regisNo = modiScan.next();
			CarReadWrite.carList.get(modiIndex).setRegis(regisNo);
		}
		if (modiChoice.equalsIgnoreCase("availability")){
			System.out.println("Please enter availability (yes or no).");
			available = modiScan.next();
			CarReadWrite.carList.get(modiIndex).setAvailability(available);
		}
		if (modiChoice.equalsIgnoreCase("carBrand")){
			System.out.println("Please enter brand.");
			carBrand = modiScan.next();
			CarReadWrite.carList.get(modiIndex).setBrand(carBrand);
		}
		if (modiChoice.equalsIgnoreCase("model")){
			System.out.println("Please enter model.");
			model = modiScan.next();
			CarReadWrite.carList.get(modiIndex).setModel(model);
		}
		if (modiChoice.equalsIgnoreCase("color")){
			System.out.println("Please enter color.");
			color = modiScan.next();
			CarReadWrite.carList.get(modiIndex).setColor(color);
		}
		if (modiChoice.equalsIgnoreCase("mile")){
			System.out.println("Please enter mileage (number).");
			mile = modiScan.nextInt();
			CarReadWrite.carList.get(modiIndex).setMile(mile);
		}
		if (modiChoice.equalsIgnoreCase("yearOfProduce")){
			System.out.println("Please enter the year of produce.");
			yearOfProduce = modiScan.nextInt();
			CarReadWrite.carList.get(modiIndex).setYear(yearOfProduce);
		}
		if (modiChoice.equalsIgnoreCase("userName")){
			System.out.println("Please enter the first name.");
			firstName = modiScan.next();
			System.out.println("Please enter the last name of the user.");
			lastName = modiScan.next();
			CarReadWrite.carList.get(modiIndex).setUserName(firstName,lastName);
		}
		if (modiChoice.equalsIgnoreCase("userNo")){
			System.out.println("Please enter the phone number of the user.");
			userNo = modiScan.next();
			CarReadWrite.carList.get(modiIndex).setUserNo(userNo);
		}
		if (modiChoice.equalsIgnoreCase("exit")){
			break;
		}

		// Print the modified item in CarReadWrite.carList
		System.out.println("\nThis is the modified result."+"\n\n"+
			CarReadWrite.carList.get(modiIndex));

		// Write all objects in carList into the output file 
		CarReadWrite.writeOutput();

		//Check for entering next loop
		System.out.println("Would you like to modify more?");
		modiAgain = modiScan.next();
		if (modiAgain.equalsIgnoreCase("no")){
			break;
		}
	} while(modiAgain.equalsIgnoreCase("yes"));
 } //End of modify()

public static void delete() throws Exception{
	Scanner deleteScan = new Scanner(System.in);
	String deleteAgain, deleteConfirm;
	int deleteChoiceInt, deleteIndex;
	do{
		// Print out all registration no. and car no. 
		for(int i=0; i < CarReadWrite.carList.size(); i++){
			System.out.println(
				"Car NO. "+ (i+1) + '\t' + "Car Brand: " + 
				CarReadWrite.carList.get(i).getBrand());
		}
		// Ask user to choose which car to delete
		System.out.println();
		System.out.println("Which car you would like to delete? (Please enter car no.");
		System.out.println();
		Scanner scan = new Scanner(System.in);
		deleteChoiceInt = scan.nextInt();
		deleteIndex = deleteChoiceInt-1;
		
		// Insert CarReadWrite.carList in delete class
		CarReadWrite.readInput();

		// Display all or a chosen car record details
		if(deleteChoiceInt==99){
			for(Car eachCar: CarReadWrite.carList){
				System.out.println(eachCar);
			}
		} else{
			System.out.println(CarReadWrite.carList.get(deleteIndex));
		}
		// Confirmation
		System.out.println("Are you sure you wanna delete this car record?");
		deleteConfirm = deleteScan.next();
		if (deleteConfirm.equalsIgnoreCase("yes")){
			CarReadWrite.carList.get(deleteIndex).setRegis(null);			
			CarReadWrite.carList.get(deleteIndex).setAvailability(null);
			CarReadWrite.carList.get(deleteIndex).setBrand(null);			
			CarReadWrite.carList.get(deleteIndex).setModel(null);			
			CarReadWrite.carList.get(deleteIndex).setColor(null);			
			CarReadWrite.carList.get(deleteIndex).setMile(0);			
			CarReadWrite.carList.get(deleteIndex).setYear(0);			
			CarReadWrite.carList.get(deleteIndex).setUserName(null, null);			
			CarReadWrite.carList.get(deleteIndex).setUserNo(null);			
		}

		// Write all objects in carList into the output file 
		CarReadWrite.writeOutput();

		//Check for entering next loop
		System.out.println("Would you like to delete more?");
		deleteAgain = deleteScan.next();
		if (deleteAgain.equalsIgnoreCase("no")){
			break;
		}
	} while(deleteAgain.equalsIgnoreCase("yes"));
  } // End of delete()

}// End of modify class