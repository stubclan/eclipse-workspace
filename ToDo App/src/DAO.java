import java.util.ArrayList;

public class DAO {
	
	ArrayList<ToDoItem> toDoList;
	
	public DAO() {
		this.toDoList = new ArrayList<ToDoItem>();
	}	
	
	/**
	 * A method to update the ToDoItem as completed. 
	 * @param id ID for the ToDoItem to be marked complete
	 */
	public void update(int id) {
		try {
			if (this.toDoList.get(id).isCompleted() != true) {
				this.toDoList.get(id).setDone(true);
				System.out.println("ID: " + id + " was updated.");
			}
			else {
				System.out.println("To Do Item with ID: " + id + " was already updated.");
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("ID: " + id + " not found.");
		}
	}
	
	/**
	 * A method to add a ToDoItem to ArrayList of ToDOItems
	 * @param item Instance of ToDoItem class to be added to the list.
	 * @return boolean true if the ToDOITem was added, false otherwise
	 */
	public boolean add(String desc) {
		ToDoItem item = new ToDoItem(this.toDoList.size() + 1, desc);
		if (this.toDoList.add(item)) {
			System.out.println("To Do Item - " + item.getDescription() + " has been added.");
			return true;
		}
		System.out.println("To Do Item: " + item.getDescription() + " wasn't added.");
		return false;
	}
	
	/**
	 * A method to delete ToDoItem from ToDoItems ArrayList
	 * @param id ID of the item to be deleted
	 * @return boolean true if the ToDoItem was deleted, false otherwise.
	 */
	public boolean delete(int id) {
		try {
			this.toDoList.remove(id); //Subtracting 1 to match with ArrayList id
			
			System.out.println("Item with ID: " + id + " was deleted.");
		} catch (Exception e) {
			System.out.println("Couldn't delete item with ID: " + id + 
					" . Either the item doesn't exit or there's an error. Please recheck!!");
			return false;	
		}
		return true;
	}
	
	/**
	 * A method to list all the ToDoItems nicely.
	 */
	public void list() {
		if (this.toDoList.isEmpty()) {
			System.out.println("No To Do Item on list. Please 'add' first."); 
		}
		else {
			for (ToDoItem singleItem : toDoList) {
				System.out.println("ID: " + toDoList.indexOf(singleItem) + "\t Description: " + singleItem.getDescription() + "\t Completed: " + singleItem.isCompleted());
			}
		}
		
	}	

}
