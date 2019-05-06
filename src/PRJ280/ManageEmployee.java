package PRJ280;
import java.lang.*;
import java.util.Scanner;
import java.util.ArrayList; //delete?
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
class ManageEmployee extends Employee { // super.methodName to call method // super(int x, String y); //for constructor
	//1,2,4
	public static void option1() throws IOException { // "Add hours to an employee ID";
		String[] IDs = FileManager.getIDsOnly(); //creates the array to find the existing ID numbers.
		for (int i = 0; i < IDs.length; ++i) {
			//System.out.print(IDs[i] + "\t");
		} // ^ displays available IDs to the user.
		System.out.print("\nChoose the employee ID to add hours to: "); 
        
		String userInputID = Employee.userInputID_withExistingID(IDs);
        //Employee.userInputID_withExistingID();
		
        // search for userInputID and add hours to userInputID
        int userInputHours = Employee.userInputAddHours();
        FileManager.addHours(FileManager.filePath, userInputID, userInputHours); //change "5" to hoursAdded variable (from method in Employee class).
	}
	
	public static void option2() throws IOException { //"Edit hourly pay for an employee";
		String[] IDs = FileManager.getIDsOnly(); //creates the array to find the existing ID numbers.
		System.out.println("Input a 4 digit ID number that you want to edit the hourly pay for. ");
		String userInputID = Employee.userInputID_withExistingID(IDs);
		
		double userInput_NewHourlyPay = Employee.userInputHourlyPay();
		FileManager.editHourlyPay(FileManager.filePath, userInputID, userInput_NewHourlyPay);
	}
	
	public static void option3() { //"Create a new Employee ID";
		System.out.println("Enter a first name for the new employee. ");
		String firstName = Employee.userInputName();
		System.out.println("Enter a last name for the new employee. ");
		String lastName = Employee.userInputName();
		
		System.out.println( "Enter a 4 digit ID number for " + firstName + " " + lastName + ". ");
		String ID = Employee.userInputID();
		double hourlyPay = Employee.userInputHourlyPay();
		int defaultHours = 0;
		
		FileManager.createNewEmployeeID(ID, firstName, lastName, hourlyPay, defaultHours);
	}
	
	public static void option4() throws IOException { //"Delete an Employee ID"; TODO
		System.out.println("Enter an existing ID that you would like to remove. ");
		
		String[] IDs = FileManager.getIDsOnly(); //creates the array to find the existing ID numbers.
		for (int i = 0; i < IDs.length; ++i) {
			System.out.print(IDs[i] + "\t");
		} // ^ displays available IDs to the user.
		System.out.print("\n");
		
		String removeID = Employee.userInputID();
		// System.out.println(removeID);  ID is retrieved correctly at this point.
		FileManager.removeEmployee(removeID, FileManager.filePath);
	}
	
	public static void option5() throws IOException { //"Check the details of a certain employee";
		
		String[] IDs = FileManager.getIDsOnly(); //creates the array to find the existing ID numbers.
		System.out.println("Enter a 4 digit ID for the employee's details you want to see. ");
		String ID_searchedFor = Employee.userInputID_withExistingID(IDs);
		System.out.println("Option 5 testing      ...");
		FileManager.readTextFileID(ID_searchedFor, FileManager.filePath);
	}
	
	public static void option6() throws IOException { //"Check the details of all employees";
		FileManager.readEntireTextFile(FileManager.filePath);
	}
	
	public static void option7() { //option[7] = "Check total amount paid";
		//TODO (this week || this year || life of the employee)
		System.out.println("Option 7 was called. ");
	}
	
	public static void option8() {
		System.out.println("end of program. ");
		System.exit(0);
	}
	
	//Completed and tested #s: 1,2
	
	/*@Override
	public double amountPaid() {
		double amountPaid = hours * hourlyPay;
		return amountPaid;
	}*/
}

//Scanner input = new Scanner(System.in);
//int userInput = input.nextInt();
