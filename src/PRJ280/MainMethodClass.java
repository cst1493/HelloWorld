package PRJ280;
import java.io.IOException;
import java.util.Scanner;
import PRJ280.EmployeeTotalAmountPaid;

public class MainMethodClass
{	//TODO 1st... fix option 4 inside the FileManager.removeEmployee method.  Hard coding the ID in option 4 doesn't fix the problem.  Most likely inside the method.
	public static void main(String[] args) throws IOException 
	{	
		//create the files.
		FileManager.createFolder(FileManager.folderPath); // create files and folders if they are not already created.
		FileManager.createFile(FileManager.filePath);
		FileManager.createFile(FileManager.filePath2);
		
		//testing
		int gottenHours = FileManager.getHours("1234");
		System.out.println(gottenHours);
		
		double gottenHourlyPay = FileManager.getHourlyPay("1234");
		System.out.println(gottenHourlyPay);
		//testing
		
		
		while (true) // while the user wants to use the program.
		{
			UserInterface.mainMenu();
		}
	}
}