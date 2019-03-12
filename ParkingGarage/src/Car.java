import java.time.LocalDate;

public class Car {

	//variables
	String color;
	String licenseNumber;
	
	String make;
	String model;
	
	boolean parkStatus = false;
	
	//default constructor for Car class
	public Car() {
		this.make = "";
		this.model = "";
		
		this.color = "";
		this.licenseNumber = "";
		
		this.parkStatus = false;
	}
	
	// Constructor with variables
	public Car(String make, String model, String color, String licenseNumber) {
		this.make = make;
		this.model = model;
		
		this.color = color;
		this.licenseNumber = licenseNumber;
		
	}	
	
	//Accessors for Car class
	public boolean getParkStatus() {
		return this.parkStatus;
	}
	
	public String getColor() {
		return color;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}
	
}
