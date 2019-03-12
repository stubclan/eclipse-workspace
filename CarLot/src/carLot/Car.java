package carLot;

public class Car extends Vehicle{

	public enum CarType {coupe, hatchback, sedan};
	
	int numberOfDoors;
	CarType type;
	
	public Car(String licenseNumber, String make, String model, double price, CarType type, int numberOfDoors) {
		super(licenseNumber, make, model, price);
		this.type = type;
		this.numberOfDoors = numberOfDoors;
	}
	
	public void printDescription() {
		System.out.println("Make: " + this.make + "\t Model: " + this.model + 
				"\t License: " + this.licenseNumber + "\t Price: " + this.price + "\t No of doors: " + this.numberOfDoors + "\t Car Type : " + this.type);
	}

	
	
}
