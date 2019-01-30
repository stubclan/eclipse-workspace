import java.time.LocalDate;

public class Car {

	String color;
	String licenseNumber;
	
	String make;
	String model;
	
	boolean parkStatus = false;
	
	public Car(String make, String model, String color, String licenseNumber) {
		this.make = make;
		this.model = model;
		
		this.color = color;
		this.licenseNumber = licenseNumber;
		
	}
	
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
