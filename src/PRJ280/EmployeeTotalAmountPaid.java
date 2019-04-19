package PRJ280;

import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class EmployeeTotalAmountPaid implements Interface
{
	private static Scanner reader;
	
	@Override
	public void save(String searchTerm, String filePath) // abstract method
	{ 
		// creating a new file and using the employee ID and their total amount paid.
		boolean found = false;
		String ID = searchTerm;
		
		try 
		{
			reader = new Scanner(new File(FileManager.filePath));  // "C:\\EmployeeInfo\\EmployeeInfo.txt"
			reader.useDelimiter("[,]"); // this helps the scanner separate values by either a "," or a "\n". // default delimiter is a space.
			
			while( reader.hasNext() && !found )
			{
				ID = reader.next();
				//++x; //ID + 3 = hourlyPay..  ID + 4 = hours..
				int Hours;
				
				if (ID.equals(searchTerm)) { found = true; }
				
			}
			
			if (found == true) 
			{
				JOptionPane.showMessageDialog(null, ID + " was found. "); //remove later TODO
			}
			else { JOptionPane.showMessageDialog(null, "ID not found");}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Error on reading file;");
		}
		
		if (found == true) 
		{
			// make the array (similar to 
			
		}
		
			
	}
	
}

