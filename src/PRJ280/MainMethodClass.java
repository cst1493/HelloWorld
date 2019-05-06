package PRJ280;
import java.io.IOException;
import java.util.Scanner;

public class MainMethodClass
{	
	public static void main(String[] args) throws IOException 
	{	
		//create the files.
		FileManager.createFolder(FileManager.folderPath); // create files and folders if they are not already created.
		FileManager.createFile(FileManager.filePath);
		
		while (true) // option 8 inside mainMenu exits the program.
		{
			UserInterface.mainMenu();
		}
	}
}