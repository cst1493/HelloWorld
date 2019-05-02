package PRJ280;
import java.io.IOException;
import java.util.Scanner;
import PRJ280.EmployeeTotalAmountPaid;

public class MainMethodClass
{
	public static void main(String[] args) throws IOException 
	{	
		FileManager.createFolder(FileManager.folderPath); // create files and folders if they are not already created.
		FileManager.createFile(FileManager.filePath);
		FileManager.createFile(FileManager.filePath2);
		
		EmployeeTotalAmountPaid file = new EmployeeTotalAmountPaid();
		//file.save("1234", FileManager.filePath);											//testing 2nd hours file
		
		while (true) // while the user wants to use the program.
		{
			UserInterface.mainMenu();
			
			
			//System.out.println("do you wish to do another task within this file?\t" + "Type \"1\" to continue or type \"0\" to exit.");
			String userInput = "0"; // add real user input once testing is finished.
			if (userInput == "0") { break; }
		}
		System.out.println("end of program. ");
	}
}
