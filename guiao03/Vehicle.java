package guiao03;

public class Vehicle {
	private String name;
	private double displacement;
	private double power;
	private int lotation;
	private int weight;
	private Driver driver;
	
	public Vehicle(String name, double power, double displacement, int lotation, int weight, Driver driver) {
		this.name = name;
		this.displacement = displacement;
		this.power = power;
		this.lotation = lotation;
		this.weight = weight;
		this.driver = driver;
	}
	
	public Vehicle(Vehicle v) {
		this.name = v.name;
		this.displacement = v.displacement;
		this.power = v.power;
		this.lotation = v.lotation;
		this.weight = v.weight;
		this.driver = v.driver;
	}
	
	public void setDriver(Driver d) {
		this.driver = d;
	}
	
	public boolean equals(Vehicle v) {
		return this.name.equals(v.name) && this.displacement == v.displacement && this.power == v.power && this.lotation == v.lotation && this.weight == v.weight && this.driver.equals(v.driver);
	}
	
	public String toString() {
		return "Name: " + this.name + "\tDisplacement: " + this.displacement + "\tPower: " + this.power + "\tWeight: " + this.weight + "\tDriver -> " + this.driver.toString();
	}
	
}
