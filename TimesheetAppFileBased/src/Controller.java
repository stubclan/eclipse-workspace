import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {

	/* Member variables */

	TimesheetInterface timesheet;
	ConsoleUtils consoleUtils;

	/* Constructor */

	public Controller() throws IOException{
		this.timesheet = new FileBasedTimesheet();
		this.consoleUtils = new ConsoleUtils();
	}

	/* Methods */

	/*
	 * Runs the program
	 */
	public void start() {

		consoleUtils.printHelp(); // Print the action menu

		boolean quit = false;
		while(!quit) {

			// Prompt the user for input, collect input, parse into parts
			String input = consoleUtils.promptString("> ");
			String[] actionParts = input.split(" ");
			String action = actionParts[0].trim(); // Primary action

			// Figure out what to do depending on the user's primary action
			if (action.equals("add")) {

				processAddAction();

			} else if (action.equals("delete")) {

				processDeleteAction(actionParts);

			} else if (action.equals("stop")) {

				processStopAction(actionParts);

			} else if (action.equals("list")) {

				processListAction(actionParts);

			} else if (action.equals("quit")) {

				quit = true;

			} else if (action.equals("help")) {

				consoleUtils.printHelp();

			} else if(action.length() ==0 ){

				// do nothing.

			} else {

				// Your code here

			}
		}

	}

	/*
	 * The user requested that a given TimesheetEntry be stopped (marked as complete)
	 * This method conveys that request to the Timesheet
	 */
	public void processStopAction(String[] actionParts){

		if(actionParts.length > 2){
			consoleUtils.error("Too many inputs to stop command");
			return;
		}

		int id = Integer.parseInt(actionParts[1]);

		if (this.timesheet.stop(this.timesheet.get(id))) {
			consoleUtils.info("The time has been successfully updated for project " + this.timesheet.get(id).getProjectName());
		}
		else {
			consoleUtils.info("The time was not updated for project " + this.timesheet.get(id).getProjectName());
		}
	}

	/*
	 * The user requested that a given TimesheetEntry be deleted
	 * This method conveys that request to the Timesheet
	 */
	public void processDeleteAction(String[] actionParts){

		if(actionParts.length > 2){
			consoleUtils.error("Too many inputs to delete command");
			return;
		}

		int id = Integer.parseInt(actionParts[1]);

		String toBeDeleted = this.timesheet.get(id).getProjectName();

		if (this.timesheet.delete(this.timesheet.get(id))) {
			consoleUtils.info("Your project " + toBeDeleted + " has been deleted.");
		}
		else {
			consoleUtils.info("Your project " + toBeDeleted + " was not deleted.");
		}
	}

	/*
	 * The user wants to view a list of timesheet entries
	 * This method conveys that request to the Timesheet,
	 * along with any special options (active-only, filter by project name)
	 */
	public void processListAction(String[] actionParts){

//		if(actionParts.length > 3){
//			consoleUtils.error("Too many inputs to list command");
//			return;
//		}
//
//		List<String> actionPartsArray = new ArrayList<String>();
//
//		for (String singleString: actionParts) {
//			actionPartsArray.add(singleString.toLowerCase());
//		}   
//
//		if (actionParts.length == 2) {
//			// for list -a
//			if (actionPartsArray.contains("-a")) {
//				consoleUtils.printList(this.timesheet.list(true));
//			}
//			//for list [PROJECT]
//			else {
//				consoleUtils.printList(this.timesheet.list(actionParts[1]));
//			}
//		}
//		else if (actionParts.length == 3) {
//			// for list [PROJECT] -a
//			if (actionPartsArray.contains("-a")) {
//				consoleUtils.printList(this.timesheet.list(true, actionParts[1]));
//			}
//		}
//		else {
//			consoleUtils.printList(this.timesheet.list());
//		}









	}

	/*
	 * The user wants to add a new entry to the Timesheet
	 * This method conveys that request to the Timesheet, along with
	 * the specified project name and task description 
	 */
	public void processAddAction(){
		String project = consoleUtils.promptString("Project Name (one word only):");

		String description = consoleUtils.promptString("Task:");

		if (this.timesheet.add(project, description)) {
			consoleUtils.info("Your project " + project + " has been added.");
		}
		else {
			consoleUtils.info("Your project " + project + " was not added.");
		}
	}
}