package PRJ280;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class FileManager {
	
	FileManager FM = new FileManager();
	private static Scanner reader;
	public final static String folderPath = "C:\\EmployeeInfo";
	public final static String filePath = folderPath + "\\EmployeeInfo.csv";
	public final static String filePath2 = folderPath + "\\EmployeeTotalAmountPaid.csv";
	
	//control+shift+numLock/ to collapse all in eclipse.
	public FileManager() {}
	
	// get all of the info from the file and put it into an array.
	public FileManager(String filePath) throws FileNotFoundException //only constructor needed to set to default employee options.
    {
		reader = new Scanner(new File(filePath));  // "C:\\EmployeeInfo\\EmployeeInfo.txt"
		reader.useDelimiter("[,\n]"); // this helps the scanner separate values by either a "," or a "\n". // default delimiter is a space.
		int dataEntries = 0; // the number of text pieces in the text document.
		while( reader.hasNext()) {
			dataEntries++;
			reader.next();
		}
		System.out.println(dataEntries + " data entries");
		
		// create an array with a length of the total amount of "dataEntries".
		String[] textInFile = new String[dataEntries];
		
		reader = new Scanner(new File(filePath)); // reset the reader.
		int i = 0;
		while (reader.hasNext()) {
			textInFile[i] = reader.next();
			++i;
		}
		reader.close();
    }
	
	// this creates an array of all the IDs in FileManager.filePath.  This is needed to show the user what their available options are to select/edit and do check if that option is a valid option.
	public static String[] getIDsOnly() throws IOException
	{	
		reader = new Scanner(new File(FileManager.filePath));
		reader.useDelimiter("[,\n]");
		int dataEntries = 0; // the number of text pieces in the whole text document.
		while( reader.hasNext()) {
			dataEntries++;
			reader.next();
		} 
		int numOfIDs = dataEntries/5; // to get the amount of IDs only.
		
		// create the return array with a length of the total amount of "numOfIDs".
		String[] IDsInFile = new String[numOfIDs];
		Scanner reader2 = new Scanner(new File(FileManager.filePath)); // reset the reader or make a new one.
		reader2.useDelimiter("[,\n]");
		
		for (int i = 0; i < numOfIDs; ++i) {
			IDsInFile[i] = reader2.next();
			reader2.next(); reader2.next(); reader2.next(); reader2.next(); // to get every 5th element in the file to only get IDs.
		}
		reader.close();
		reader2.close();
		Arrays.sort(IDsInFile); // sort the array.
		return IDsInFile;
    }
	
	//read the text file info for a given ID number
	public static void readTextFileID(String searchTerm, String filePath) 
	{
		boolean found = false;
		String ID = null, firstName = null, lastName = null, hourlyPay = null, hours = null;
		
		try
		{
			reader = new Scanner(new File(FileManager.filePath));  // "C:\\EmployeeInfo\\EmployeeInfo.txt"
			reader.useDelimiter("[,\n]"); // this helps the scanner separate values by either a "," or a "\n". // default delimiter is a space.
			
			while( reader.hasNext() && !found )
			{
				ID = reader.next();
				firstName = reader.next();
				lastName = reader.next();
				hourlyPay = reader.next();
				hours = reader.next();
				
				if (ID.equals(searchTerm)) { found = true; }
			}
			
			if (found == true) 
			{
				System.out.println("ID: " + ID + ";  " + "First Name:  " + firstName + ";  " + "Last Name:  " + lastName + ";  " + "Hourly Pay:  " + hourlyPay + ";  " + "Hours Worked: " + hours + "; ");
				//JOptionPane.showMessageDialog(null, "ID:  " + ID + ";  " + "First Name:  " + firstName + ";  " + "Last Name:  " + lastName + ";  " + "Hourly Pay:  " + hourlyPay + ";  " + "Hours Worked: " + hours + ";");
			}
			else { 
				System.out.println("ID " + ID + " not found.  ");
				//JOptionPane.showMessageDialog(null, "ID not found");
				}
			reader.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Error on reading file;");
		}
	}
	
	//read the text file for all IDs
	public static void readEntireTextFile(String filePath) throws IOException // ALL of the employee information data is put into an array here and printed out to the user when called.  reads entire file.
	{
		reader = new Scanner(new File(filePath));  // "C:\\EmployeeInfo\\EmployeeInfo.txt"
		reader.useDelimiter("[,\n]"); // this helps the scanner separate values by either a "," or a "\n". // default delimiter is a space.
		int dataEntries = 0; // the number of text pieces in the text document.
		while( reader.hasNext()) {
			dataEntries++;
			reader.next();
		}
		// create an array with a length of the total amount of "dataEntries".
		String[] textInFile = new String[dataEntries];
		
		Scanner reader2 = new Scanner(new File(FileManager.filePath)); // reset the reader or make a new one.
		reader2.useDelimiter("[,\n]");
		System.out.println("ID\t\tFirst\t\tLast\t\tHourly\t\tHours");
		int i = 0;
		while (reader2.hasNext()) {
			textInFile[i] = reader2.next();
			System.out.print(textInFile[i] + "\t\t");
			++i;
			if ((i % 5) == 0) {System.out.print("\n");}
		}
		reader.close();
		reader2.close();
		System.out.print("\n");
	}
	
	// write new employee info to the file
	public static void createNewEmployeeID(String ID, String firstName, String lastName, double hourlyPay, int hours)
	{
		try {
			FileWriter fWriter = new FileWriter(FileManager.filePath, true);
			//if true, then add text to bottom of the text file.  If set to false, it would completely replace the file.
			PrintWriter pWriter = new PrintWriter(fWriter);
			pWriter.print(ID + "," + firstName + "," + lastName + "," + hourlyPay + "," + hours + ","); //last "," to \n if using \n in the Delimiter
			pWriter.flush();
			pWriter.close();
			//JOptionPane.showMessageDialog(null, "Employee Information Added"); //not needed check box.
		}
		catch(Exception E) {
			//JOptionPane.showMessageDialog(null, "Employee Information FAILED to add info");
		}
	}
	
	// Edits the text file hourly pay
	public static void editHourlyPay(String filePath, String ID_toEdit, double newHourlyPay)
	{
		String tempFile = "temp.txt";
		File oldFile = new File(filePath);
		File newFile = new File(tempFile);
		String ID, firstName, lastName, hourlyPay, hours;
		
		try 
		{
			FileWriter fw = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			Scanner scanner = new Scanner(new File(filePath));
			scanner.useDelimiter(",");
			while (scanner.hasNext())
			{
				ID = scanner.next();
				if (scanner.hasNext()) { //fixed the error due to finding a blank slot in the file (after the ",").
					firstName = scanner.next();
					lastName = scanner.next();
					hourlyPay = scanner.next();
					hours = scanner.next();
					if (ID.equals(ID_toEdit)) { //if the searched for ID is found, edit that line.
						pw.print( ID + "," + firstName + "," + lastName + "," + newHourlyPay + "," + hours + ",");  //change last "," to \n if using \n in the Delimiter
					}
					else {
						pw.print(ID + "," + firstName + "," + lastName + "," + hourlyPay + "," + hours + ",");  //change last "," to \n if using \n in the Delimiter
					}
				}
			}
			scanner.close();
			pw.flush();
			pw.close();
			oldFile.delete();
			File dump = new File(filePath);
			newFile.renameTo(dump);
		}
		catch(Exception e) { System.out.println("Invalid input, put an integer for hourly pay. "); }
	}
	
	// Edits the text file hourly pay
	public static void addHours(String filePath, String ID_toEdit, int hoursAdded)
		{
			String tempFile = "temp.txt";
			File oldFile = new File(filePath);
			File newFile = new File(tempFile);
			String ID, firstName, lastName, hourlyPay, hours;
			
			try 
			{
				FileWriter fw = new FileWriter(tempFile, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);
				
				Scanner scanner = new Scanner(new File(filePath));
				scanner.useDelimiter(",");
				while (scanner.hasNext())
				{
					ID = scanner.next();
					if (scanner.hasNext()) { //fixed the error due to finding a blank slot in the file (after the ",").
						firstName = scanner.next();
						lastName = scanner.next();
						hourlyPay = scanner.next();
						hours = scanner.next();
						int numHours = Integer.parseInt(hours);
						int newHours = hoursAdded + numHours;
						
						if (ID.equals(ID_toEdit)) { //if the searched for ID is found, edit that line.
							pw.print( ID + "," + firstName + "," + lastName + "," + hourlyPay + "," + newHours + ",");  //change last "," to \n if using \n in the Delimiter
						}
						else {
							pw.print(ID + "," + firstName + "," + lastName + "," + hourlyPay + "," + hours + ",");  //change last "," to \n if using \n in the Delimiter
						}
					}
				}
				scanner.close();
				pw.flush();
				pw.close();
				oldFile.delete();
				File dump = new File(filePath);
				newFile.renameTo(dump);
			}
			catch(Exception e) { System.out.println("Invalid input, put an integer for hours. "); }
		}
	
	// Returns the hours of a given employee ID...  copy this method to get any certain value if needed later.
	public static int getHours(String searchTerm) {
		boolean found = false;
		@SuppressWarnings("unused")
		String ID = null, firstName = null, lastName = null, hourlyPay = null, hours = null;
		
		try
		{
			reader = new Scanner(new File(FileManager.filePath));  // "C:\\EmployeeInfo\\EmployeeInfo.txt"
			reader.useDelimiter("[,\n]"); // this helps the scanner separate values by either a "," or a "\n". // default delimiter is a space.
			
			while( reader.hasNext() && !found )
			{
				ID = reader.next();
				firstName = reader.next();
				lastName = reader.next();
				hourlyPay = reader.next();
				hours = reader.next();
				
				if (ID.equals(searchTerm)) { found = true; }
			}
			
			if (found == false)  {
				JOptionPane.showMessageDialog(null, "ID not found");
				}
			reader.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Error on reading file;");
		}
		int hoursInt = Integer.parseInt(hours);
		return hoursInt;
	}
	
	// Returns the hourly pay of a given employee ID
	public static double getHourlyPay(String searchTerm) {
			boolean found = false;
			@SuppressWarnings("unused")
			String ID = null, firstName = null, lastName = null, hourlyPay = null, hours = null;
			
			try
			{
				reader = new Scanner(new File(FileManager.filePath));  // "C:\\EmployeeInfo\\EmployeeInfo.txt"
				reader.useDelimiter("[,\n]"); // this helps the scanner separate values by either a "," or a "\n". // default delimiter is a space.
				
				while( reader.hasNext() && !found )
				{
					ID = reader.next();
					firstName = reader.next();
					lastName = reader.next();
					hourlyPay = reader.next();
					hours = reader.next();
					
					if (ID.equals(searchTerm)) { found = true; }
				}
				
				if (found == false)  {
					JOptionPane.showMessageDialog(null, "ID not found");
					}
				reader.close();
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Error on reading file;");
			}
			double hourlyPayDouble = Double.parseDouble(hourlyPay);
			return hourlyPayDouble;
		}
	
	// Removes an Employee ID
	public static void removeEmployee(String removeID, String filePath) // Removes an employee's information from the file
	{
		String tempFile = "temp.txt";
		File oldFile = new File(filePath);
		File newFile = new File(tempFile);
		String ID = "", firstName = "", lastName = "", hourlyPay = "", hours = "";
		
		try 
		{
			FileWriter fw = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			reader = new Scanner(new File(filePath));
			reader.useDelimiter("[,\n]");
			while (reader.hasNext())
			{
				ID = reader.next();
				if (reader.hasNext()) { //fixed the error due to finding a blank slot in the file (after the ",").
					firstName = reader.next();
					lastName = reader.next();
					hourlyPay = reader.next();
					hours = reader.next();
					if(!ID.equals(removeID)) {
						pw.print( ID + "," + firstName + "," + lastName + "," + hourlyPay + "," + hours + ",");
					}
					else{System.out.println("Employee deleted successfully. ");}
				}
			}
			reader.close();
			pw.flush();
			pw.close();
			oldFile.delete();
			File dump = new File(filePath);
			newFile.renameTo(dump);
		}
		catch(Exception e) { System.out.println("Invalid input, put a valid employee ID. "); } 
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