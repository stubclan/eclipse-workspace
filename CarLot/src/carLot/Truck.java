package carLot;

public class Truck extends Vehicle{

	int bedSize;
	
	public Truck(int bedSize, String licenseNumber, String make, String model, double price) {
		super(licenseNumber, make, model, price);
		this.bedSize = bedSize;
	}
	
	public void printDescription() {
		System.out.println("Make: " + this.make + "\t Model: " + this.model + 
				"\t License: " + this.licenseNumber + "\t Price: " + this.price + "\t Bed Size: " + this.bedSize);
	}

}
