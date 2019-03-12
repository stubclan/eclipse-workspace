import java.util.ArrayList;


/**
 * A class to record Drivers License
 * @author Sujan_Aryal
 *
 */
public class LicenseProgram {

	
	public static void main(String[] args) {
		
		ArrayList<DriversLicense> drivers = new ArrayList<DriversLicense>();
		
		DriversLicense firstPerson = new DriversLicense("Sujan","Aryal", "Male", "06/03/1994");	
		drivers.add(firstPerson);
		
		DriversLicense secondPerson = new DriversLicense("Julie","Doe", "Female", "10/21/1993");				
		drivers.add(secondPerson);
		
		DriversLicense thirdPerson = new DriversLicense("John", "Darwin", "Other", "10/25/1995");		
		drivers.add(thirdPerson);
		
		for (DriversLicense driver :drivers) {
			driver.printNameAge();
		}
	}
}
