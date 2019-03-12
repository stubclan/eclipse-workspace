
public class ParkingSpot {

	boolean occupied;
	
	public ParkingSpot() {
		this.occupied = false;
	}
	
	public void occupy() {
		this.occupied = true;
	}
	
	public boolean isOccupied() {
		return this.occupied;
	}
	
	public void vacate() {
		this.occupied = false;
	}
}
