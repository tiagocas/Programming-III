package guiao03;

public class Motorcycle extends Vehicle {

	public Motorcycle(String name, double power, double displacement, int lotation, int weight, Driver driver) {
		super(name, power, displacement, lotation, weight, driver);
	}
	
	public Motorcycle(Motorcycle lc) {
		super(lc);
	}
	
	public void setDriver(Driver d) {
		super.setDriver(d);
	}
	
	public boolean equals(Vehicle v) {
		return super.equals(v);
	}
	
	public String toString() {
		return "motorcycle -> " + super.toString();
	}
	
}
