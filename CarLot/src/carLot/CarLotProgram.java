package carLot;

public class CarLotProgram {
	
	public static void main(String[] args) {
		
		CarLot firstLot = new CarLot("First Parking Lot");
		CarLot secondLot = new CarLot("Second Parking Lot");
		//String licenseNumber, String make, String model, double price
		Vehicle firstVehicle = new Car("APP1LO","Nissan", "Altima", 15000.00, Car.CarType.sedan,5);
		Vehicle secondVehicle = new Truck(5, "APP1LO","Nissan", "Armada", 25000.00);	
		
		firstLot.addVehicle(firstVehicle);		
		firstLot.addVehicle(secondVehicle);
		
		secondLot.addVehicle(firstVehicle);
		
		firstLot.printInventory();
		
		
	}

}