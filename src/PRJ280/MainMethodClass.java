package PRJ280;
import java.io.IOException;
import java.util.Scanner;

public class MainMethodClass
{
	public static void main(String[] args) throws IOException 
	{	
		FileManager.createEmployeeFolder(); // create files and folders if they are not already created.
		FileManager.createFile(FileManager.filePath);
		//FileManager.createFile(FileManager.tempFilePath);
		
		
		String ID_SearchingFor = "1234"; //testing reader
		//FileManager.readTextFileID(searchTerm,FileManager.filePath); 								//testing reader
		//int ID = 1234; String firstName = "first"; String lastName = "last"; int hourlyPay = 7;	//testing writer //Run this line and next line if needed information in the file for testing.
		//FileManager.createNewEmployeeID(ID, firstName, lastName, hourlyPay); 						//testing writer
		FileManager.editTextFile(FileManager.filePath, ID_SearchingFor, "1234", "newFName", "newLName", "newHourlyPay" ); //testing editor
		
		while (true) // while the user wants to use the program.
		{
			UserInterface.mainMenu();
			
			
			//System.out.println("do you wish to do another task within this file?\t" + "Type \"1\" to continue or type \"0\" to exit.");
			String userInput = "0"; // add real user input once testing is finished.
			if (userInput == "0") { break; }
		}
		//System.out.println("end of program. ");
	}
}
