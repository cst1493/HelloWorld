package PRJ280;

import java.util.Scanner;

abstract class Employee //SuperClass
{
	// use this class to get user input and use the user input in the subclass

	private static Scanner input = new Scanner(System.in);
	protected String ID;
    protected String firstName;
    protected String lastName;
    protected int hour;
    protected int pay;
    
    protected static String userInputID() {
    	String ID = "";
    	boolean validInput = false;
    	while (validInput == false) 
    	{
    		@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
    		ID = input.next();
    		try {
    			
    			int validID = Integer.parseInt(ID);
    			
    			if ( (validID >= 0) && (validID <= 9999) ) {
    				validInput = true;
    			}
    			else System.out.println("invalid input. Enter a 4 digit ID number.");
    		}
    		
    		catch(Exception e) { System.out.println("invalid input. Enter a 4 digit ID number."); }
    	}
    	return ID;
    }
    
    protected static String userInputID_withExistingID(String[] IDs) {
    	//list all existing IDs 1st.
    	String ID = "";
    	boolean validInput = false;
    	System.out.print("\n");
    	while (validInput == false)
    	{
    		for (int i = 0; i < IDs.length; ++i) {
    			System.out.print( IDs[i] + "\t" );
    		}
    		System.out.print("\n");
    		ID = input.next();
    		boolean ID_exists = false;
    		for (int i = 0; i < IDs.length; ++i) {
    			if (IDs[i].equals(ID)) { 
    				ID_exists = true; 
    				}
    		}
    		
    		try {
    			int validID = Integer.parseInt(ID);
    			if ( (validID >= 0) && (validID <= 9999) && (ID_exists == true) ) {
    				validInput = true;
    			}
    			else System.out.println("invalid input. Enter a 4 digit ID number.");
    		}
    		
    		catch(Exception e) { System.out.println("invalid input. Enter a 4 digit ID number."); }
    	}
		return ID;
    }
    
    protected static double userInputHourlyPay() {
    	System.out.println("Enter the houly pay that you want to use here. ");
    	double hourlyPay = -1;
    	boolean validInput = false;
    	while (validInput == false) 
    	{
    		try {
    			@SuppressWarnings("resource")
				Scanner scanner = new Scanner(System.in);
    			hourlyPay = scanner.nextDouble();
    			if ( (hourlyPay >= 0) && (hourlyPay < 100) ) {
        			validInput = true;
    			}
    			else System.out.println("invalid input. Enter a valid hourly pay. ");
    		}
    		
    		catch(Exception e) { System.out.println("invalid input. Enter a valid hourly pay. "); }
    	}
    	return hourlyPay;
    }
    
    protected static int userInputAddHours() {
    	System.out.println("Enter the amount of hours that you want to add to the ID. ");
    	int hoursToAdd = 0;
    	boolean validInput = false;
    	while (validInput == false) 
    	{
    		try {
    			@SuppressWarnings("resource")
				Scanner scanner = new Scanner(System.in);
    			hoursToAdd = scanner.nextInt();
    			if ( (hoursToAdd >= 0) && (hoursToAdd < 100) ) {
        			validInput = true;
    			}
    			else System.out.println("invalid input. Enter a valid amount of hours to add. ");
    		}
    		
    		catch(Exception e) { System.out.println("invalid input. Enter a valid amount of hours to add. "); }
    	}
    	return hoursToAdd;
    }
    
    protected static String userInputName() {
    	String name = input.next();
		return name;
    }
    
    
    /*
    public String getID() 
    {
        return ID;
    }
    
    public void setID(String setID) {
    	String setID = userInputID();
        ID = setID;
    }
    */
}
