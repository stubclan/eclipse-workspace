package carLot;

public abstract class Vehicle {
	
	String licenseNumber;
	String make;
	String model;
	
	double price;
	
	//Default constructor
	public Vehicle() {
		this.licenseNumber = "";
		this.make = "";
		this.model = "";
		
		this.price = 0.0;
	}
	
	public Vehicle(String licenseNumber, String make, String model, double price) {
		this.licenseNumber = licenseNumber;
		this.make = make;
		this.model = model;
		
		this.price = price;
	}
	
	public abstract void printDescription();
	
	
}
