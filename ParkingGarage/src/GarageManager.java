
public class GarageManager {

	public static void main(String[] args) {
		ParkingGarage garage = new ParkingGarage(3);
		
		Car firstCar = new Car("Nissan", "Altima", "Silver", "JHS");
		Car secondCar = new Car("BMW", "Altima", "Black", "JHS");
		Car thirdCar = new Car("VW", "Altima", "White", "JHS");
		
		garage.park(firstCar, 1);
		garage.park(secondCar, 2);
		garage.park(thirdCar, 3);
		
		garage.printInventory();
		
		garage.vacate(1);
		garage.vacate(3);
		
		garage.printInventory();
		
	}
}
