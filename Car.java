/* Program Name: Car.java
   Purpose: A car record management system. It contains a Car class with methods
   to view car rental records (current, previous, next), add new car rental record,
   borrow a car, modify car rental details, delete car rental details,
   search car rental record, list of available cars for rent.
*/
import java.util.*; 

public class Car implements Vehicle{
	// Declare class variables
	private String regisNo, available, carBrand, model, color, firstName, lastName, userNo;
	private int mile, yearOfProduce;

	// Constractor, which initializes class variables
	public Car (String regis, String avai, String brand, String mName, String colorName, 
		int mileage, int yProduce, String fName, String lName, String uNo){
		regisNo = regis;
		available = avai;
		carBrand = brand;
		model = mName;
		color = colorName;
		mile = mileage;
		yearOfProduce = yProduce;
		firstName = fName;
		lastName = lName;
		userNo = uNo; 
	}
// TRY TO DO WITHOUT CAR OBJECTS AND CARLIST IN THIS FILE
	// Create new car objects
	static Car C1 = new Car("C1","Yes","Benz","Benz01","black",4800,2014,null,null,null);
	static Car C2 = new Car("C2","Yes","Nissan","Nissan01","black",12000,2010,null,null,null);
	static Car C3 = new Car("C3","Yes","Toyota","Toyota01","white",8900,2000,null,null,null);
	static Car C4 = new Car("C4","Yes","Audi","Audi01","yellow",8900,1993,null,null,null);
	static Car C5 = new Car("C5","No","Ferrari","Ferrari01","silver",8222,1998,"Tina","Zhao","0403827463");
	static Car C6 = new Car("C6","Yes","Mazda","Mazda01","blue",30044,2013,null,null,null);
	static Car C7 = new Car("C7","Yes","Ford","Ford01","green",8000,2011,null,null,null);
	static Car C8 = new Car("C8","Yes","Volvo","Volvo01","red",90035,1997,null,null,null);
	static Car C9 = new Car("C9","Yes","Peugeot","Peugeot01","grey",130229,1999,null,null,null);
	static Car C10 = new Car("C10","No","Subaru","Subaru01","white",74873,2001,"Ada","Wu","0403087652");

	// Create array of objects
	static Car[] carList = {C1,C2,C3,C4,C5,C6,C7,C8,C9,C10};

	// Set and Get car registration number
	public void setRegis(String registration){
		regisNo = registration;
	}
	public String getRegis(){ 
		return regisNo;
	}

	// Set and Get availability
	public void setAvailability(String yesOrNo){
		available = yesOrNo;
	}
	public String getAvailability(){
		return available;
	}

	// Set and Get car brand
	public void setBrand(String brand){
		carBrand = brand;
	}
	public String getBrand(){
		return carBrand;
	}

	// Set and Get car model
	public void setModel(String cModel){
		model = cModel;
	}
	public String getModel(){
		return model;
	}

	// Set and Get color
	public void setColor(String cColor){
		color = cColor;
	}
	public String getColor(){
		return color;
	}

	// Set and Get user name
	public void setUserName(String fName, String lName){
		firstName = fName;
		lastName = lName;
	}
	public String getUserName(){
		return (firstName + '\t' + lastName);
	}
	public String getFName(){
		return firstName;
	}
	public String getLName(){
		return lastName;
	}

	// Set and Get user number
	public void setUserNo(String userNumber){
		userNo = userNumber;
	}
	public String getUserNo(){
		return userNo;
	}

	// Set and Get mile
	public void setMile(int mileage){
		mile = mileage;
	}
	public int getMile(){
		return mile;
	}

	// Set and Get year of produce
	public void setYear(int yProduce){
		yearOfProduce = yProduce;
	}
	public int getYear(){
		return yearOfProduce;
	}


	// return all information of a car
	// Single quote can use for only one character, so use double quotes.
	public String toString(){
		return (
			"Car registration number: " + regisNo +'\n'+
			"Availability: " + available + '\n' + 
			"Brand: " + carBrand + '\n' + 
			"Model: " + model + '\n' + 
			"Color: " + color + '\n' + 
			"Mileage: " + mile + '\n' + 
			"Year of Produce: " + yearOfProduce + '\n' + 
			"User Name: " + firstName + ' ' + lastName + '\n' + 
			"User Number: " + userNo + '\n');
	} 

}