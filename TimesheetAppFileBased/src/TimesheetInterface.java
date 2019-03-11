import java.util.List;

public interface TimesheetInterface {
	
	public boolean add(String project, String task);
	
	public List<TimesheetEntry> list();
	
	public TimesheetEntry get(int id);
	
	public boolean delete(TimesheetEntry entry);
	
	public boolean stop(TimesheetEntry entry);


}
