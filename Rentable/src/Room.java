
public class Room implements Rentable{
	
	public enum BedType {Twin, Single, Queen};
	
	double dailyRate;
	
	String roomName;
	BedType bedType;
	
	public Room(String roomName, BedType bedType, double dailyRate) {
		this.roomName = roomName;
		this.bedType = bedType;	
		this.dailyRate = dailyRate;
	}

	public String getDescription() {
		return (this.getClass().getName() + "-\t" + "Name: " + this.roomName + "\t Bed Type: " + this.bedType + 
				"\t Daily Rate: " + this.dailyRate);
	}

	public double getDailyRate() {
		return this.dailyRate;
	}

	public double getPrice(double days) {
		return this.getDailyRate() * days;
	}

}
