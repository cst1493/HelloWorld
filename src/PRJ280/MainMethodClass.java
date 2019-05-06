package PRJ280;
import java.io.IOException;
import java.util.Scanner;
import PRJ280.EmployeeTotalAmountPaid;
// TODO upon pushing... edits made to readTextFileID, readEntireTextFile
public class MainMethodClass
{	//TODO //fileManger...  readTextFileID...  readEntireTextFile... getHours... getHourlyPay all got a reader.close(); added.  if there's any errors, check there 1st...
	public static void main(String[] args) throws IOException 
	{	
		//create the files.
		FileManager.createFolder(FileManager.folderPath); // create files and folders if they are not already created.
		FileManager.createFile(FileManager.filePath);
		//FileManager.createFile(FileManager.filePath2);
		
		//testing
		//int gottenHours = FileManager.getHours("1234");
		//System.out.println(gottenHours);
		
		//double gottenHourlyPay = FileManager.getHourlyPay("1234");
		//System.out.println(gottenHourlyPay);
		//testing
		
		while (true) // option 8 inside mainMenu exits the program.
		{
			UserInterface.mainMenu();
		}
	}
}