import java.util.ArrayList;

public class LicenseProgram {

	
	public static void main(String[] args) {
		
		ArrayList<DriversLicense> drivers = new ArrayList<DriversLicense>();
		
		DriversLicense firstPerson = new DriversLicense("Sujan","Aryal");		
		firstPerson.setDateOfBirth(07, 3, 1994);
		firstPerson.setGender("Male");
		drivers.add(firstPerson);
		
		DriversLicense secondPerson = new DriversLicense("Julie","Doe");				
		secondPerson.setDateOfBirth(10, 21, 1993);
		firstPerson.setGender("Female");
		drivers.add(secondPerson);
		
		DriversLicense thirdPerson = new DriversLicense("John", "Darwin");		
		thirdPerson.setDateOfBirth(10, 21, 1995);
		thirdPerson.setGender("other");
		drivers.add(thirdPerson);
		
		for (DriversLicense driver :drivers) {
			driver.printNameAge();
		}
	}
}
