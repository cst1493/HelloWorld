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
	
	private int hours = 2; //TODO
	private double hourlyPay = 2.5;
	
	public static void option1() {//option[1] = "Add hours to an employee ID"; TODO
		System.out.println("Choose the employee ID: "); 
        String userInput = "7942";  //TODO get user input
        
        //FileManager.editTextFile(FileManager.filePath, userInput, "ManageEmployee option 1");
	}
	
	public static void option2() { //"Edit hourly pay for an employee";
		String userInputID = "9999"; // TODO get user input in a while(true) loop until they find a valid ID... could also read out the ID's 1st....
		String userInput_NewHourlyPay = "7.99"; // TODO get user input in a while(true) loop into a try/catch that checks if the string can be converted to a double...
		// they search for an ID...  that ID becomes ID_toKeep
		FileManager.editTextFile(FileManager.filePath, userInputID, userInput_NewHourlyPay);
	}
	
	public static void option3() { //"Create a new Employee ID";
		int ID = 1234; String firstName = "F", lastName = "L"; double hourlyPay = 9.99; int hours = 40; //TODO get user input, then get user to confirm after repeating it back to the user.
		FileManager.createNewEmployeeID(ID, firstName, lastName, hourlyPay, hours);
	}
	
	public static void option4() {
		//option[4] = "Delete an Employee ID";
		String removeID = "9922"; //TODO get user input
		FileManager.removeEmployee(removeID, FileManager.filePath);
	}
	
	public static void option5() { //"Check the details of a certain employee";
		String ID_searchedFor = "1234";  //TODO Get user input
		FileManager.readTextFileID(ID_searchedFor, FileManager.filePath);
	}
	
	public static void option6() throws IOException {
		//"Check the details of all employees";
		FileManager.readEntireTextFile(FileManager.filePath);
	}
	
	public static int option7() {
		//option[7] = "Check total amount paid"; //TODO (this week || this year || life of the employee)
		System.out.println("Option 7 was called. ");
		return 0;
	}
	
	public static void option8() {
		System.out.println("end of program. ");
		System.exit(0);
	}
	
	@Override
	public double amountPaid() {
		double amountPaid = hours * hourlyPay;
		return amountPaid;
	}
}

//Scanner input = new Scanner(System.in);
//int userInput = input.nextInt();
//input.close();
