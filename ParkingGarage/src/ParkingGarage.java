
public class ParkingGarage {
	
	Car[] cars;
	//ParkingSpot[] parkingSpots;
	
	public ParkingGarage(int spotNumber) {
		cars = new Car[spotNumber];
		//parkingSpots = new ParkingSpot[spotNumber];		
		
	}


	public void park(Car car, int spot) {
		//ParkingSpots keep tracks of if the spot is occupied or not
		if (car.getParkStatus() == false)) {
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
	
	public void vacate(int spot) {
		cars[spot] = null;
	}
	
	public void printInventory() {
		for (int i=0; i< cars.length; i++) {
			System.out.println("Spot number: " + i);
			System.out.println("Car's color: " + cars[i].getColor());
			System.out.println("Car's license#: " + cars[i].getLicenseNumber());
			System.out.println("Car's make: " + cars[i].getMake());
			System.out.println("Car's model: " + cars[i].getModel());

		}
	}
	
	
	
	
	

}
