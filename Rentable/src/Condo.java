
public class Condo implements Rentable{

	double weeklyRate;
	String name;
	String location;
	
	public Condo(String name, String location, double weeklyRate) {
		this.weeklyRate = weeklyRate;
		
		this.name = name;
		this.location = location;
	}	
	
	public String getDescription() {
		return (this.getClass().getName() + "-\t" + "Name: " + this.name + "\t Location : " + this.location + 
				"\t Daily Rate: " + getDailyRate());
	}

	public double getDailyRate() {
		return this.weeklyRate / 7.00;
	}

	public double getPrice(double days) {
		return this.getDailyRate() * days;
	}

}
