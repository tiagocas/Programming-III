package guiao03;

public class Driver {
	private String drivingLicenseType;
	private String name;
	
	public Driver(String name, String drivingLicenceType) {
		this.name = name;
		this.drivingLicenseType = drivingLicenceType;
	}
	
	public boolean equals(Driver d) {
		return this.name == d.name && this.drivingLicenseType == d.drivingLicenseType;
	}
	
	public String toString() {
		return "Name: " + this.name + "\tDriving License Type: " + this.drivingLicenseType;
	}
	
}
