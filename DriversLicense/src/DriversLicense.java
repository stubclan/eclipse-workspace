import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;


/**
 * A class to store Drivers License information
 * @author Sujan_Aryal
 *
 */
public class DriversLicense {

	//variables
	String firstName;
	String lastName;
	LocalDate dateOfBirth;

	String height;
	String gender;

	//Constructor 
	public DriversLicense(String firstName, String lastName, String gender, String dateOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		
		String[] dateOfBirthIndex = dateOfBirth.split("/");
		this.setDateOfBirth(Integer.parseInt(dateOfBirthIndex[0]), Integer.parseInt(dateOfBirthIndex[1]), Integer.parseInt(dateOfBirthIndex[2]));
	}
	
	//single method to print name and age
	public void printNameAge() {
		System.out.println("Name: "+ this.getFullName() + "\tAge: " + this.getAge() + " year/s.\n");
	}
	
	//method to return Full Name
	public String getFullName() {
		return (this.getFirstName() + " " + this.getLastName());
	}
	//method to return age
	public int getAge() {
		return (Period.between(this.dateOfBirth, LocalDate.now()).getYears());
	}
	
	//method returns firstName
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public LocalDate getDateOfBirth() {
		return this.dateOfBirth;
	}

	public String getHeight() {
		return height;
	}	

	public String getGender() {
		return gender;
	}
	
	//Private setter methods
	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	private void setDateOfBirth(int month, int day, int year) {
		this.dateOfBirth = (LocalDate.of(year, month, day));
	}

	private void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	private void setHeight(String height) {
		this.height = height;
	}
	
	private void setGender(String gender) {
		this.gender = gender;
	}
	


}
