package PRJ280;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class FileManager { //this file can be used to edit the text files by copying the information in the text file and putting it into a temporary array.
	
	private static Scanner reader;
	public final static String folderPath = "C:\\EmployeeInfo";
	public final static String filePath = folderPath + "\\EmployeeInfo.csv";
	public final static String filePath2 = folderPath + "\\EmployeeTotalAmountPaid.csv";
	// TODO create an array[dataEntries] long and get all the info from the reader...
	
	public FileManager() {}
	public FileManager(String filePath) throws FileNotFoundException //only constructor needed to set to default employee options.
    {
		reader = new Scanner(new File(filePath));  // "C:\\EmployeeInfo\\EmployeeInfo.txt"
		reader.useDelimiter("[,\n]"); // this helps the scanner separate values by either a "," or a "\n". // default delimiter is a space.
		int dataEntries = 0; // the number of text pieces in the text document.
		while( reader.hasNext()) {
			dataEntries++;
			reader.next();
		}
		--dataEntries; //off by one error because there's a comma after the last entry.
		System.out.println(dataEntries + " data entries"); // TODO testing.
		
		
		// create an array with a length of the total amount of "dataEntries".
		String[] textInFile = new String[dataEntries];
		
		reader = new Scanner(new File(filePath)); // reset the reader.
		int i = 0;
		while (reader.hasNext()) {
			textInFile[i] = reader.next();
			++i;
		}
    }
	
	//TODO could have another method to read only ID's by adding a starting term in the reading array and increment by multiples of 4 to only read one information type.  Ex: for (x=startingTerm; x < fullArray.length; x + 4) to read only whatever the starting term's value is, like only IDs or only First names.   
	
	//read the text file for a given ID number
	public static void readTextFileID(String searchTerm, String filePath) 
	{
		boolean found = false;
		String ID = null, firstName = null, lastName = null, hourlyPay = null, hours = null; // TODO Add all values that will be used in the file.
		
		try
		{
			reader = new Scanner(new File(FileManager.filePath));  // "C:\\EmployeeInfo\\EmployeeInfo.txt"
			reader.useDelimiter("[,\n]"); // this helps the scanner separate values by either a "," or a "\n". // default delimiter is a space.
			
			while( reader.hasNext() && !found )
			{
				ID = reader.next();
				firstName = reader.next();
				lastName = reader.next();
				hourlyPay = reader.next(); // TODO add more values if more info is added to the text file.
				hours = reader.next();
				
				if (ID.equals(searchTerm)) { found = true; }
			}
			
			if (found == true) 
			{
				JOptionPane.showMessageDialog(null, "ID:  " + ID + ";  " + "First Name:  " + firstName + ";  " + "Last Name:  " + lastName + ";  " + "Hourly Pay:  " + hourlyPay + ";  " + "Hours Worked: " + hours + ";");
			}
			else { JOptionPane.showMessageDialog(null, "ID not found");}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Error on reading file;");
		}
	}
	
	//read the text file for all IDs
	public static void readEntireTextFile(String filePath) throws IOException
	{
		reader = new Scanner(new File(filePath));  // "C:\\EmployeeInfo\\EmployeeInfo.txt"
		reader.useDelimiter("[,\n]"); // this helps the scanner separate values by either a "," or a "\n". // default delimiter is a space.
		int dataEntries = 0; // the number of text pieces in the text document.
		while( reader.hasNext()) {
			dataEntries++;
			reader.next();
		}
		--dataEntries; //off by one error because there's a comma after the last entry.
		System.out.println(dataEntries + " data entries"); // TODO testing.
		
		
		// create an array with a length of the total amount of "dataEntries".
		String[] textInFile = new String[dataEntries];
		
		reader = new Scanner(new File(filePath)); // reset the reader.
		int i = 0;
		while (reader.hasNext()) {
			textInFile[i] = reader.next();
			System.out.print(textInFile[i]);
			++i;
		}
		System.out.print("\n");
	}
	
	// write new employee info to the file
	public static void createNewEmployeeID(int ID, String firstName, String lastName, double hourlyPay, int hours) 
	{
		try {
			FileWriter fWriter = new FileWriter(FileManager.filePath, true);
			//if true, then add text to bottom of the text file.  If set to false, it would completely replace the file.
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			PrintWriter pWriter = new PrintWriter(fWriter);
			pWriter.print(ID + "," + firstName + "," + lastName + "," + hourlyPay + "," + hours + ","); //last "," to \n if using \n in the Delimiter
			pWriter.flush();
			pWriter.close();
			
			JOptionPane.showMessageDialog(null, "Employee Information Added");
		}
		catch(Exception E) {
			JOptionPane.showMessageDialog(null, "Employee Information FAILED to add info");
		}
	}
	
	// Edits the text file // TODO  newest addition.  Appears to be functional now
	public static void editTextFile(String filePath, String ID_toEdit, String newHourlyPay)
	{
		String tempFile = /*FileManager.folderPath + */ "temp.txt";
		File oldFile = new File(filePath);
		File newFile = new File(tempFile);
		String ID, firstName, lastName, hourlyPay, hours; //TODO add more fields if needed.
		
		try 
		{
			FileWriter fw = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			Scanner scanner = new Scanner(new File(filePath));
			//scanner.useDelimiter("[,\n]");
			scanner.useDelimiter(",");
			while (scanner.hasNext())
			{
				ID = scanner.next();
				//System.out.println(ID); //testing
				firstName = scanner.next();
				//System.out.println(firstName); //testing //TODO appears to be an error on the Delimiter
				lastName = scanner.next();
				//System.out.println(lastName); //testing
				hourlyPay = scanner.next();
				//System.out.println(hourlyPay); //testing
				hours = scanner.next();
				if (ID.equals(ID_toEdit)) { //if the searched for ID is found, edit that line.
					pw.print( ID + "," + firstName + "," + lastName + "," + newHourlyPay + "," + hours + ",");  //change last "," to \n if using \n in the Delimiter
				}
				else {
					pw.print(ID + "," + firstName + "," + lastName + "," + hourlyPay + "," + hours + ",");  //change last "," to \n if using \n in the Delimiter
				}
			}
			scanner.close();
			pw.flush();
			pw.close();
			oldFile.delete();
			File dump = new File(filePath);
			newFile.renameTo(dump);
		}
		catch(Exception e) { System.out.println("error in \"editTextFile\" method."); }
	}
	
	// creates folder
	public static void createFolder(String folderPath) throws IOException // creates program file that holds all information from this program.
	{
		// create a folder to keep employee text file.
		File managementFolder = new File (folderPath);
		if(managementFolder.exists()) {
			System.out.println("EmployeeInfo directory already exists.");
        } 
		else {
        	managementFolder.mkdir();
        	System.out.println("EmployeeInfo directory created. ");
        }
	}
	
	// create a text file
	public static void createFile(String fileName) throws IOException // .text file with employee information.
	{	
		// create a text file within folder above to keep employee information.
    	File textFile = new File( fileName );
    	
    	if( textFile.exists() ) {
    		System.out.println("Employee record already exists in " + fileName + ".");  
    	} else {
    		textFile.createNewFile();  // create a new file
    		System.out.println("Employee record created under " + fileName + ".");
    	}
	}
}
