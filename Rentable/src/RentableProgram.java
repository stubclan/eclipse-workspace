import java.util.ArrayList;

public class RentableProgram {

	
	public static void main(String[] args) {
		
		ArrayList<Rentable> rentables = new ArrayList<Rentable>();
		Rentable queenRoom = new Room("Queen Victoria", Room.BedType.Queen,40.00);
		Rentable singleRoom = new Room("Single Jonhs", Room.BedType.Single,80.00);
		Rentable twinRoom = new Room("Baba Twins", Room.BedType.Twin,20.00);
		
		Rentable austinCondo = new Condo("Austin Condo","Austin",1000.00);
		
		Rentable firstTool = new Tool("Wrench", "John Saint", 2.00);


		rentables.add(queenRoom);
		rentables.add(singleRoom);
		rentables.add(twinRoom);
		
		rentables.add(austinCondo);
		
		rentables.add(firstTool);
		
		for (Rentable rentable : rentables) {
			System.out.println(rentable.getDescription());
		}
		
	}
}
