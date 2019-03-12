
public class GarageManager {

	public static void main(String[] args) {
		ParkingGarage garage = new ParkingGarage(3);
		
		Car firstCar = new Car("Nissan", "Altima", "Silver", "JHS");
		Car secondCar = new Car("BMW", "Altima", "Black", "JHS");
		Car thirdCar = new Car("VW", "Altima", "White", "JHS");
		
		garage.park(firstCar, 0);
		garage.park(secondCar, 1);
		garage.park(thirdCar, 2);
		
		garage.printInventory();
		
		System.out.println("*******************************************");
		
		garage.vacate(1);
		garage.vacate(2);
				
		garage.printInventory();
		
		System.out.println("******************************************** After removing adding cars back");
		
		garage.park(secondCar, 1);
		garage.park(thirdCar, 2);
		
		garage.printInventory();
		
		System.out.println("*******************************************");
		
	}
}
