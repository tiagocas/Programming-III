package guiao04;

import guiao02.Date;

public class Professor extends Pessoa {
	private static int nMecStarts = 100;
	private int salary = 0;
	
	public Professor(String name, int bi, Date birthday) {
		super(bi, name, birthday);
	}
	
	public int nMec() {
		return super.id();
	}
	
	public String name() {
		return super.name();
	}
	
	@Override
	public String toString() {
		int personalNMEC = nMecStarts + this.id();
		return "nMec: " + personalNMEC + ", " + super.toString();
	}
}
