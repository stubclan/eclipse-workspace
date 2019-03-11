import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileBasedTimesheet implements TimesheetInterface{

	private List<TimesheetEntry> database;

	

	public FileBasedTimesheet() throws IOException {
		this.database = new ArrayList<TimesheetEntry>();
		
	}
	

	/** 
	 * Method to add Timesheet entry to the database
	 * @param project Name of the timesheet entry
	 * @param task Description of the timesheet Entry
	 * @throws IOException 
	 */
	public boolean add(String project, String task){
		boolean done = false;
		TimesheetEntry single = new TimesheetEntry(project, task);
		
		try {
			single.updateEndTime();	
			
			BufferedWriter bufferWriter = new BufferedWriter(new FileWriter("db.txt", true));


			bufferWriter.write(single.getId() + "|" + single.getProjectName() + "|" + 
					single.getTask() + "|" +  single.getStartTime() + "|" +
					single.getEndTime());
			bufferWriter.newLine();
			bufferWriter.close();
			done = true;
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			done = false;
		}
	
		
		return done;
		
	}

	/**
	 * A function to return List of timesheet entries
	 * @return List
	 */
	public List<TimesheetEntry> list() {
//		FileReader reader = new FileReader("database.txt");
//		
//		BufferedReader file = new BufferedReader(reader);
//		
//		while (file.read)
		
		List<TimesheetEntry> entries = new ArrayList<TimesheetEntry>();
		
		
		Scanner scanner = new Scanner("database.txt");
		
		while (scanner.hasNextLine()) {
			String data = scanner.nextLine();
			
			String[] dataArray = data.split("|");
			
			TimesheetEntry entry = new TimesheetEntry(dataArray[1], dataArray[2]);
			entries.add(entry);
		}
		
		scanner.close();
		
		return entries;
				
	}

	/**
	 * Method to get a specific TimeSheet Entry
	 * @param id ID of the entry
	 * @return if found return id, else return null
	 */
	public TimesheetEntry get(int id) {
		
		Scanner scanner = new Scanner("database.txt");
		
		TimesheetEntry entry;
		
		entry = null;

		
		while (scanner.hasNextLine()) {
			String data = scanner.nextLine();
			
			String[] dataArray = data.split("|");
			if (Integer.parseInt(dataArray[0]) == id) {
				
				entry = new TimesheetEntry(dataArray[1] , dataArray[2]);
			}
			else {
			}
		}
		
		return entry;
	}

	/** 
	 * Method to delete a given Timesheet entry
	 * @param entry Timesheet entry which has to be deleted
	 * @return True if delete action successfully completed, false otherwise
	 */
	public boolean delete(TimesheetEntry entry) {
		if (this.database.remove(entry)) {
			return true;
		}
		return false;
	}

	/**
	 * Method to stop entry time
	 * @param entry Entry for which end time has to be updated
	 * @return True if time has been updated successfully, false if it fails
	 */
	public boolean stop(TimesheetEntry entry) {

		try {
			if (entry.updateEndTime()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

		return false;
	}


}
