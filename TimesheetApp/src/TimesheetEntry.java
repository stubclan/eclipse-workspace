import java.time.LocalDateTime;

public class TimesheetEntry {

	private static int NEXTID = 1;


	private String projectName;
	private String task;
	private int id;
	private LocalDateTime startTime;
	private LocalDateTime endTime;

	public TimesheetEntry( String myProject, String myTask) {
		this.projectName = myProject;
		this.task = myTask;

		this.startTime = LocalDateTime.now();

		this.id = NEXTID;
		NEXTID++;

	}

	public String getProjectName() {
		return projectName;
	}

	public String getTask() {
		return task;
	}

	public int getId() {
		return id;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	/**
	 * Method to update End time
	 * @return true if update was successfull, false otherwise
	 * @throws Exception exception if the end time was already set
	 */
	public boolean updateEndTime() throws Exception {

		if (this.endTime == null) {
			this.endTime = LocalDateTime.now();
			return true;
		}
		else if (this.endTime != null) {
			throw new Exception("End time already set");
		}
		return false;
	}



}
