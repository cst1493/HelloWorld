package PRJ280;
import java.io.File;
import java.io.IOException;
//import java.lang.StackWalker.Option;

public class UserInterface {
	
	public static void mainMenu() throws IOException
	{
		System.out.println("This is the employee information managment system. Please select an option.\n");
		
		int numberOfOptions = 8;
		String option[] = new String[numberOfOptions + 1];
		option[0] = null;
		option[1] = "Add hours to an employee ID";
		option[2] = "Edit hourly pay for an employee";
		option[3] = "Create a new Employee ID";  //calls CreateNewEmployeeID(ID,FN,LN,Pay)
		option[4] = "Delete an Employee ID";
		option[5] = "Check the details of a certain employee";
		option[6] = "Check the details of all employees";
		//option[7] = "Check total amount paid"; //TODO (this week || this year || life of the employee)
		option[8] = "Exit program";
		
		for (int i = 1; i < numberOfOptions + 1; i++) {
			System.out.print( i + ": " + option[i] + "\n" );
		}
		
		System.out.print("\n");
		
		boolean foundValidOption = false;
		while(foundValidOption == false) 
		{
		
			String userInput = "4"; //TODO make this user input
			
			//TODO prevent error below when user types in a letter by using a try/catch
			int i = Integer.valueOf(userInput); //cast user input String to integer. 
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
		       default:
		    	   System.out.println("Please type a number that's between 1 & 8. ");
		       }
		       
		       if (i > 0 && i <= numberOfOptions) { //break out of while loop if valid input.
		    	   foundValidOption = true;
		       } 
		} //end of while
	}
}
