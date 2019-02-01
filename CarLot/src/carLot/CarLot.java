package carLot;
import java.util.ArrayList;

public class CarLot {
	
	String name;
	ArrayList<Vehicle> vehicles;
	
	public CarLot(String name) {
		this.name = name;
		this.vehicles = new ArrayList<Vehicle>();
	}
	
	public void addVehicle(Vehicle vehicle) {
		this.vehicles.add(vehicle);
	}
	
	public void printInventory() {
		System.out.println("Total vehicles: " + this.vehicles.size());
		for (Vehicle vehicle: this.vehicles) {
			vehicle.printDescription();
		}
	}
	

}
