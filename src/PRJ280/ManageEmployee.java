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
	
	
	public static void option1() {
		System.out.println("Choose the employee ID: ");
        String userInput = "7942";  //TODO get user input
        
        FileManager.editTextFile(FileManager.filePath, userInput, "ManageEmployee option 1");
	}
	public static int option2() {
		System.out.println("Option 2 was called. ");
		return 0;
	}
	public static int option3() { // TODO call CreateNewEmployeeID(ID,firstName,lastName,hourlyPay)
		System.out.println("Option 3 was called. ");
		return 0;
	}
	public static int option4() {
		System.out.println("Option 4 was called. ");
		return 0;
	}
	public static int option5() { //up to option 8//
		System.out.println("Option 5 was called. ");
		return 0;
	}
	public static int option6() {
		System.out.println("Option 6 was called. ");
		return 0;
	}
	public static int option7() {
		System.out.println("Option 7 was called. ");
		return 0;
	}
	public static int option8() {
		System.out.println("Option 8 was called. ");
		return 0;
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
