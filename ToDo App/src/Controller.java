import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
	private static Scanner in;
	
	public static void main(String[] args) throws SQLException {
		in = new Scanner(System.in);
		
		boolean badSelection = true;
		
		System.out.println("Memory[m] or SQLite[s] based? [q] for quit");
		
		while (badSelection) {
			char response = in.nextLine().toLowerCase().charAt(0);
			if (response == 'm') {
				badSelection = false;
				runMemoryBasedStorage();
			}
			else if(response == 's') {
				badSelection = false;
				runSQLBasedStorage();
			}
			else {
				badSelection = true;
				System.out.println("Invalid selection! Type [m] for Memory Based and [s] for SQLite Based");
			}
		}
		
	}
	
	//Method to run SQL Based storage
	public static void runSQLBasedStorage() throws SQLException {
		DAO_SQL sqlDAO = new DAO_SQL();
		sqlDAO.connect();
		
		boolean quitProgram = false;
		
		System.out.println("Welcome to TODO App");
		
		//Loop until user types quit
		while (!quitProgram) {
			System.out.println("Please enter command add/update/delete/list or quit");		

			String[] inputLine = in.nextLine().split(" ");
			String inputCommand = inputLine[0].trim();
			
			
			// If User action is add - Do this
			if (inputCommand.equals("add")) {
				System.out.println("Input To Do item description");
				String toDoItemDesc = in.nextLine();
				ToDoItem item = new ToDoItem(toDoItemDesc);
				sqlDAO.createToDoItem(item);

			// If User action is delete - Do this
			} else if (inputCommand.equals("delete")) {
				System.out.println("Input ID to delete");
				try {
					int deleteID = in.nextInt();
					in.nextLine();
					sqlDAO.deleteToDoItem(deleteID);
					//If user doesn't input Integer do exception
				} catch (InputMismatchException e) {
					System.out.println("Please enter proper ID. Try again!");
				}				
			// If User action is update
			} else if (inputCommand.equals("update")) {
				System.out.println("Input ID to update");
				try {
					int toUpdatedID = in.nextInt();	
					in.nextLine();
					sqlDAO.updateToDoItem(toUpdatedID);	
					//If user doesn't input Integer do exception
				} catch (InputMismatchException e) {
					System.out.println("Please enter proper ID. Try again!");
				}
							
			// If User action is to list
			} else if (inputCommand.equals("list")) {
				sqlDAO.listToDoItems();
			} else if (inputCommand.equals("quit")) {

				quitProgram = true;

			} else if(inputCommand.length() == 0 ){

				// do nothing.

			} else {

				sqlDAO.closeConn();

			}
		}
		
		
	}
	
	
	
	
	
	//Method to run Memory based Storage
	public static void runMemoryBasedStorage() {
		DAO dao = new DAO();
		
		boolean quitProgram = false;
		
		System.out.println("Welcome to TODO App");
		
		//Loop until user types quit
		while (!quitProgram) {
			System.out.println("Please enter command add/update/delete/list or quit");		

			String[] inputLine = in.nextLine().split(" ");
			String inputCommand = inputLine[0].trim();
			
			
			// If User action is add - Do this
			if (inputCommand.equals("add")) {
				System.out.println("Input To Do item description");
				String toDoItemDesc = in.nextLine();
				//ToDoItem toDoItem = new ToDoItem(toDoItemDesc);
				dao.add(toDoItemDesc);

			// If User action is delete - Do this
			} else if (inputCommand.equals("delete")) {
				System.out.println("Input ID to delete");
				try {
					int deleteID = in.nextInt();
					in.nextLine();
					dao.delete(deleteID);
				} catch (InputMismatchException e) {
					System.out.println("Please enter proper ID. Look below for reference:");
					dao.list();
				}				
			// If User action is update
			} else if (inputCommand.equals("update")) {
				System.out.println("Input ID to update");
				try {
					int toUpdatedID = in.nextInt();	
					in.nextLine();
					dao.update(toUpdatedID);	
				} catch (InputMismatchException e) {
					System.out.println("Please enter proper ID. Look below for reference:");
					dao.list();
				}
							
			// If User action is to list
			} else if (inputCommand.equals("list")) {
				dao.list();				

			} else if (inputCommand.equals("quit")) {

				quitProgram = true;

			} else if(inputCommand.length() == 0 ){

				// do nothing.

			} else {

				// Your code here

			}
		}
		
	}
	
	//A simple method to return user input	
	public static String askConsoleForInput(String prompt) {
		System.out.println(prompt);
		String newDesc = in.nextLine();
		return newDesc;
	}
}
