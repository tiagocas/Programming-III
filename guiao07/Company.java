package guiao07;

public class Company {
	private String name;
	private String sig;
	
	public Company(String sig, String name) {
		this.name = name;
		this.sig = sig;
	}
	
	public String getSigla() {
		return this.sig;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		return this.sig + " " + this.name;
	}
	
}
