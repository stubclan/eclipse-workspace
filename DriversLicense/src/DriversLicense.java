import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class DriversLicense {

	//variables

	String firstName;
	String lastName;
	LocalDate dateOfBirth;

	String height;

	String gender;

	public DriversLicense() {

	}

	public DriversLicense(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;

	}

	public void printNameAge() {
		System.out.println("Name: "+ this.getFullName() + "\tAge: " + this.getAge() + " year/s.\n");
	}

	public String getFullName() {
		return (this.firstName + " " + this.lastName);
	}

	public int getAge() {
		return (Period.between(this.dateOfBirth, LocalDate.now()).getYears());
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(int month, int day, int year) {
		this.dateOfBirth = (LocalDate.of(year, month, day));
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


}
