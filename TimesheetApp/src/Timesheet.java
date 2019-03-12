import java.util.ArrayList;
import java.util.List;

public class Timesheet {

	private List<TimesheetEntry> database;

	public Timesheet() {
		this.database = new ArrayList<TimesheetEntry>();
	}


	/** 
	 * Method to add Timesheet entry to the database
	 * @param project Name of the timesheet entry
	 * @param task Description of the timesheet Entry
	 */
	public boolean add(String project, String task) {
		TimesheetEntry newEntry = new TimesheetEntry(project, task);

		if (this.database.add(newEntry)) {
			return true;
		}
		return false;
	}

	/**
	 * A function to return List of timesheet entries
	 * @return List
	 */
	public List<TimesheetEntry> list() {
		return this.database;
	}

	/**
	 * A function to return arraylist of timesheet entries
	 * @param boolean true if ONLY unfinished items are requested
	 * @return List<TimesheetEntry> list timesheet entries return only active projects 
	 * 									 if none, return the full list
	 */
	public List<TimesheetEntry> list(boolean activeOnly) {
		List<TimesheetEntry> activeOnlyList = new ArrayList<TimesheetEntry>();
		if (activeOnly) {
			for (TimesheetEntry single : this.database) {
				if (single.getEndTime() == null ) {
					activeOnlyList.add(single);
				}
			}			
		}

		if (!activeOnlyList.isEmpty()) {
			return activeOnlyList;
		}
		return this.database;
	}

	/**
	 * A function to return arraylist of timesheet entries
	 * @param name Namew of the project
	 * @return List<TimesheetEntry> list timesheet entries return only matches project name 
	 * 									 if none, return the full list
	 */
	public List<TimesheetEntry> list(String name) {
		List<TimesheetEntry> activeOnlyList = new ArrayList<TimesheetEntry>();

		for (TimesheetEntry single : this.database) {
			if (single.getProjectName().equals(name) ) {
				activeOnlyList.add(single);
			}
		}				

		if (!activeOnlyList.isEmpty()) {
			return activeOnlyList;
		}
		return this.database;
	}

	/**
	 * A overloaded method for getting list of Active projeccts with project name
	 * @param activeOnly True the Timesheet entry is active, false if not
	 * @param name Name of the Project from TimesheetEntry
	 * @return TimesheetEntry list of active projects that matches the name;
	 * 						  If none, return the full list
	 */

	public List<TimesheetEntry> list(boolean activeOnly, String name) {
		List<TimesheetEntry> activeOnlyList = new ArrayList<TimesheetEntry>();
		if (!name.equals(null)) {
			for (TimesheetEntry single : this.database) {
				if (single.getEndTime() == null && single.getProjectName().equals(name)) {
					activeOnlyList.add(single);
				}
			}

		}
		if (!activeOnlyList.isEmpty()) {
			return activeOnlyList;
		}
		return this.database;
	}


	/**
	 * Method to get a specific TimeSheet Entry
	 * @param id ID of the entry
	 * @return if found return id, else return null
	 */
	public TimesheetEntry get(int id) {
		for (TimesheetEntry single: database) {
			if (single.getId() == id) {
				return single;
			}
		}
		return null;
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
