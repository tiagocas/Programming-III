package guiao03;

public class LightCar extends Vehicle {

	public LightCar(String name, double power, double displacement, int lotation, int weight, Driver driver) {
		super(name, power, displacement, lotation, weight, driver);
	}
	
	public LightCar(LightCar lc) {
		super(lc);
	}
	
	public void setDriver(Driver d) {
		super.setDriver(d);
	}
	
	public boolean equals(Vehicle v) {
		return super.equals(v);
	}
	
	public String toString() {
		return "LightCar -> " + super.toString();
	}
	
}
