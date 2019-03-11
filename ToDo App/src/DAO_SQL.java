
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList; 

public class DAO_SQL {
	private Connection conn = null;
	
	public void connect() {
		try {
			// db parameters
			String url = "jdbc:sqlite:sample.db";
			// create a connection to the database
			conn = DriverManager.getConnection(url);
			
			 Statement statement = conn.createStatement();
	         statement.setQueryTimeout(30);  // set timeout to 30 sec.


	         statement.executeUpdate("DROP TABLE IF EXISTS ToDoItems");
	         statement.executeUpdate("CREATE TABLE ToDoItems (id INTEGER PRIMARY KEY AUTOINCREMENT, name varchar(255), completed boolean)");

			System.out.println("Connection to SQLite has been established.");
			// run some more code use the same connection...

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}

	/**
	 * A method to create a ToDoItem and save it in SQL db
	 * @param item ToDoItem class
	 * @throws SQLException Exception thrown by SQLite
	 */
	public void createToDoItem(ToDoItem item)
			throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(
				"insert into ToDoItems values (?,?,?);"
				);
		try {
			stmt.setNull(1, java.sql.Types.INTEGER);
			stmt.setString(2, item.getDescription());
			stmt.setBoolean(3, false);
			stmt.executeUpdate();
		}
		catch (SQLException e) {
			System.out.println("Could not create the ToDoItem");
		}		
		finally {
			stmt.close();
		}
	}

	/**
	 * A method to update the ToDoitem to be completed
	 * @param id ID for the ToDoItem to be updated
	 * @throws SQLException
	 */
	public void updateToDoItem(int id)
			throws SQLException {
		
		boolean completed = true;
		try {
			PreparedStatement stmt = conn.prepareStatement(
					"update ToDoItems set completed = ? where id = ?;"
					);
			stmt.setBoolean(1, completed);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			stmt.close();
		}
		catch (SQLException e) {
			System.out.println("Cannont update ToDoItem with ID: " + id + ". Please try again!");
		}
		
		
	}
	
	/**
	 * A method to Delete ToDoItem	
	 * @param id ID for the ToDoItem to be deleted
	 * @throws SQLException SQLException from SQLite
	 */
	public void deleteToDoItem(int id)
			throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(
				"delete from ToDoItems where id = ?;"
				);
		try {
			
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Cannont delete ToDoItem with ID: " + id + ". Please try again!");
		} finally {
			stmt.close();
		}
		
		
	}
	
	/**
	 * A method to list all the ToDoItems nicely
	 * @throws SQLException
	 */
		
	public void listToDoItems() 
			throws SQLException {
		List<ToDoItem> results = new ArrayList<>();

		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = 
					stmt.executeQuery("select id, name, completed from ToDoItems");
			while(rs.next()){
				int id = rs.getInt("id"); // rs.getInt(1);
				String name = rs.getString("name"); // rs.getString();
				boolean completed = rs.getBoolean("completed");
				ToDoItem emp = new ToDoItem(id, name);
				emp.setDone(completed);
				results.add(emp);
			}
			rs.close();
			stmt.close();
		}
		
		catch (SQLException e) {
			System.out.println("Cannont list ToDoItems. Please try again!");
		}
		finally {
			if (results.isEmpty()) {
				System.out.println("No To Do Item on list. Please 'add' first."); 
			}
			else {
				for (ToDoItem singleItem : results) {
					System.out.println("ID: " + singleItem.getID() + "\t Description: " + singleItem.getDescription() + "\t Completed: " + singleItem.isCompleted());
				}
			}
			
		}	

		
	}
	
	/**
	 * A method to close SQLite Connection
	 */
	protected void closeConn() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}


}
