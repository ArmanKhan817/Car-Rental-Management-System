import java.util.*;
import java.io.*;
 
public class CarReadWrite {
	
	static private String regisNo="", available="", carBrand="", model="", color="", 
		firstName="", lastName="", userNo="";
	static private int mile=0, yearOfProduce=0;
	static private String inputFile="carInput.txt", outputFile="output.txt";
	static ArrayList<Car> carList = new ArrayList<Car>();

// The existing car rental records
// Must put "throws Exception" in method header
public static void readInput() throws Exception{
	
	Scanner scanFile = new Scanner(new File(inputFile));
	
	// Scan info from inputFile, add them intot the carlist
	while (scanFile.hasNextLine()){
		regisNo = scanFile.next();
		available = scanFile.next();
		carBrand = scanFile.next();
		model = scanFile.next();
		color = scanFile.next();
		while (scanFile.hasNextInt()){
			mile = scanFile.nextInt();
			yearOfProduce = scanFile.nextInt();
		}
		if (scanFile.hasNext()){
			firstName = scanFile.next();
		} 
		if (scanFile.hasNext()){
			lastName = scanFile.next();
			userNo =scanFile.next();
		} 
		// add scanned info into the carlist
		Car carItem = new Car(regisNo,available,carBrand,model,color,mile,
			yearOfProduce,firstName,lastName,userNo);
		carList.add(carItem);
	}
	scanFile.close();
}//End of readInput method

// Display the content in the array carList
public static void displayInput(){
	int idx = 0;
	while(idx < carList.size()){
		System.out.println(carList.get(idx));
		idx++;
	}
}//end of displayInput method

// ASK USERS TO ADD NEW CAR RECORDS
public static void addCar() throws Exception{
	Scanner newScan = new Scanner(System.in);
	String addAgain;
	do{
		String nregisNo="", navailable="", ncarBrand="", nmodel="", ncolor="", nfirstName="", nlastName="", nuserNo="";
		int nmile=0, nyearOfProduce=0;
		System.out.println("Please enter new car registration no.: \n"+
			"Or enter \"exit\" to exit.");
		nregisNo = newScan.next();
		// If statement HAS TO put before next to the first newScan!
		if (nregisNo.equalsIgnoreCase("exit"))
			break;

		System.out.println("Please enter availability (yes or no).");
		navailable = newScan.next();
		System.out.println("Please enter car brand.");
		ncarBrand = newScan.next();
		System.out.println("Please enter car model.");
		nmodel = newScan.next();
		System.out.println("Please enter car color.");
		ncolor = newScan.next();
		System.out.println("Please enter mileage (number).");
		nmile = newScan.nextInt();
		System.out.println("Please enter the year of produce.");
		nyearOfProduce = newScan.nextInt();
		System.out.println("Please enter the first name of the user.");
		nfirstName = newScan.next();
		System.out.println("Please enter the last name of the user.");
		nlastName = newScan.next();
		System.out.println("Please enter the phone number of the user.");
		nuserNo = newScan.next();

		// Add the new car item into carlist
		Car newItem = new Car(nregisNo,navailable,ncarBrand,nmodel,ncolor,nmile,
			nyearOfProduce,nfirstName,nlastName,nuserNo);
		carList.add(newItem);

		//Check for entering next loop
		System.out.println("You have added a new car record: "+"\n\n"+ newItem+"\n");
		System.out.println("Would you like to add more?");
		addAgain = newScan.next();
		if (addAgain.equalsIgnoreCase("no")){
			break;
		}

	} while(addAgain.equalsIgnoreCase("yes"));
	
	newScan.close();
} // End of addCar method

// SET UP THE WRITING OF THE OUTPUT FILE
public static void writeOutput() throws Exception{
	PrintWriter output = new PrintWriter(new FileWriter(outputFile));
	// Write data from carList including newly added and input file, to output file
	int idx = 0;
	while(idx < carList.size()){
		output.println(carList.get(idx));
		idx++;
	}
	// finish writing info the the output file
	output.close();

} // End of writeOutput method


}//end of CarReadWrite class
