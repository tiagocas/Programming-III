package guiao03;

public class HeavyTruck extends Vehicle {

	public HeavyTruck(String name, double power, double displacement, int lotation, int weight, Driver driver) {
		super(name, power, displacement, lotation, weight, driver);
	}
	
	public HeavyTruck(HeavyTruck lc) {
		super(lc);
	}
	
	public void setDriver(Driver d) {
		super.setDriver(d);
	}
	
	public boolean equals(Vehicle v) {
		return super.equals(v);
	}
	
	public String toString() {
		return "HeavyTruck -> " + super.toString();
	}
	
}
