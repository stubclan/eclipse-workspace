
public class ParkingGarage {
	
	Car[] cars;
	
	//ParkingGarage constructor
	public ParkingGarage(int spotNumber) {
		cars = new Car[spotNumber];
		
		//???/?How to instantiate classes for an array? 
		
		//Using default constructor to instantiate cars in Cars array
		for (Car car: cars ) {
			car = new Car();
		}
	}

	//Method to add car into the cars array
	public void park(Car car, int spot) {
		//ParkingSpots keep tracks of if the spot is occupied or not
		if (car.getParkStatus() == false) {
			try {
				this.cars[spot] = car;
			}
			catch (IndexOutOfBoundsException e) {
				System.out.println("There is no spot like that.ha!");
			}
		}
		else {
			System.out.println("This parking space is occupied! Please find another parking spot.");
		}
		
	}
	//Method to remove the item from the array
	public void vacate(int spot) {
		cars[spot] = null;
	}
	
	//Method to print all the cars in the car array
	public void printInventory() {
		for (int i=0; i< cars.length; i++) {
			if (cars[i] != null) {
				System.out.println("Spot number: " + i);
				System.out.println("Car's color: " + cars[i].getColor());
				System.out.println("Car's license#: " + cars[i].getLicenseNumber());
				System.out.println("Car's make: " + cars[i].getMake());
				System.out.println("Car's model: " + cars[i].getModel());
				System.out.println("");
			}			

		}
	}
	
	
	
	
	

}
