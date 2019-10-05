package guiao03;

public class Bus extends Vehicle {

	public Bus(String name, double power, double displacement, int lotation, int weight, Driver driver) {
		super(name, power, displacement, lotation, weight, driver);
	}
	
	public Bus(Bus lc) {
		super(lc);
	}
	
	public void setDriver(Driver d) {
		super.setDriver(d);
	}
	
	public boolean equals(Vehicle v) {
		return super.equals(v);
	}
	
	public String toString() {
		return "Bus -> " + super.toString();
	}
	
}
