package PRJ280;

import java.io.IOException;
import java.util.Scanner;

public class UserInterface {
	
	public static void mainMenu() throws IOException {	
		System.out.println("This is the employee information managment system. Please select an option.\n");
		
		int numberOfOptions = 8;
		String option[] = new String[numberOfOptions + 1];
		option[0] = null;
		option[1] = "Add hours to an employee ID";
		option[2] = "Edit hourly pay for an employee";
		option[3] = "Add a new Employee ";
		option[4] = "Remove an Employee ";
		option[5] = "Check the details of a certain employee";
		option[6] = "Check the details of all employees";
		option[7] = "Check total amount paid"; 
		option[8] = "Exit program";
		
		displayOptions(option, numberOfOptions);
		System.out.print("\n");
		
		int selection = promptUser(option, numberOfOptions);
		System.out.print("\n");
		
		int i = Integer.valueOf(selection); //cast user input String to integer. 
			switch (i) {
			case 1: 
				ManageEmployee.option1();
				break; 
			case 2: 
				ManageEmployee.option2();
				break; 
			case 3: 
				ManageEmployee.option3();
				break; 
			case 4: 
				ManageEmployee.option4();
				break; 
			case 5: 
				ManageEmployee.option5();
				break; 
			case 6: 
				ManageEmployee.option6();
				break; 
			case 7: 
				ManageEmployee.option7();
				break; 
			case 8: 
				ManageEmployee.option8();
				break;
			}
	}
	
	private static void displayOptions(String[] option, int numOfOptions) {
		for (int i = 1; i < numOfOptions + 1; i++) {
			System.out.print( i + ": " + option[i] + "\n" );
		}
	}
		
	private static int promptUser(String[] option, int numOfOptions) {
		int selection = 0;
		System.out.print("Select an option: ");
		
		boolean validOption = false;
		while( validOption == false )
		{
			try 
			{
				@SuppressWarnings("resource")
				Scanner s = new Scanner(System.in);
				selection = s.nextInt();
				if ( (selection <= 8) && (selection > 0) ) {
					validOption = true;
				}
				else {
					System.out.println("\nInvalid input.  Select a valid number option from the option menu.\n");
					displayOptions(option, numOfOptions);
				}
			}
			catch(Exception e) 
			{
				System.out.println("\nInvalid input.  Select a valid number option from the option menu.\n");
				displayOptions(option, numOfOptions);
			}
		}
		return selection;
	}
}
