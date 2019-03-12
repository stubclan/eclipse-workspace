
public class Tool implements Rentable {
	double hourlyRate;
	String name;
	String nameOfRenter;
	
	public Tool(String name, String nameOfRenter, double hourlyRate) {
		this.hourlyRate = hourlyRate;
		
		this.name = name;
		this.nameOfRenter = nameOfRenter;
	}	
	
	public String getDescription() {
		return (this.getClass().getName() + "-\t" + "Name: " + this.name + "\t Name of Renter: " + this.nameOfRenter + 
				"\t Daily Rate: " + getDailyRate());
	}

	public double getDailyRate() {
		return this.hourlyRate * 24.00;
	}

	public double getPrice(double days) {
		return this.getDailyRate() * days;
	}
	

}
