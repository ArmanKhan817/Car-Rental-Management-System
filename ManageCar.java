import java.io.*;
import java.util.*;

public class ManageCar{
// "throws Exception" is required in the function header below 
// which will propagate all the runtime problems to the surface
public static void main(String[] args) throws Exception{
	int choiceInMain;
	do{
	    // DISPLAY THE MAIN MENU
		System.out.println(
			"1. View car rental details"+'\n'+
			"2. Add new car rental record"+'\n'+
			"3. Borrow a car"+'\n'+
			"4. Modify car rental details"+'\n'+
			"5. Delete car rental details"+'\n'+
			"6. Search car rental details"+'\n'+
			"7. List available cars for rent"+'\n'+
			"8. List all borrowed cars"+'\n'+
			"9. Exit"+'\n'+
			"Please enter the service number you would like to use (from 1 to 9)."
		); 

		Scanner scanMenu = new Scanner(System.in);
		choiceInMain = scanMenu.nextInt();
		switch(choiceInMain){
			case 1: View.viewAll(); break;
			case 2:	
			CarReadWrite.addCar(); CarReadWrite.readInput(); CarReadWrite.writeOutput(); break;
			case 3:	Borrow.borrow(); break;
			case 4: Modify.modify(); break;
			case 5: Modify.delete(); break;
			case 6: Search.search(); break;
			case 7: Search.available(); break;
			case 8: Search.borrowed(); break;
			case 9:	break;
			
			default: System.out.println("Please enter a valid number.");
		} //end of switch of main menu, every break statement in other class goes to here

	} while(choiceInMain!=9);

}//End of main method


}//End of ManageCar class