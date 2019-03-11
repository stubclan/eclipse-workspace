
public class ToDoItem {
	
	public static int NEXTID = 1;
	
	private int id;
	private String description;
	private boolean isComplete;
	
	/**
	 * Constructor for ToDoItem
	 * @param description Description for the TODOITEM to be created
	 */
	public ToDoItem(String description) {
		this.description = description;	
		this.isComplete = false;		
	}
	
	public ToDoItem(int id, String description) {
		this.id = id;
		this.description = description;
		
		this.isComplete = false;
	}
	
	//Accessors
	
	//Getters	
	public int getID() {
		return this.id;
	}
	
	public String getDescription() {
		return this.description;
	}	
	
	public boolean isCompleted() {
		return this.isComplete;
	}
	
	//Setters
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setDone(boolean isComplete) {
		this.isComplete = isComplete;
	}
	
	
	

}
