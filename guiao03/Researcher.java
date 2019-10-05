package guiao03;

import guiao02.Date;

public class Researcher extends Person{
	private static int nMecStarts = 100;
	private int salary;
	
	public Researcher(String name, int id, Date birthday, Date inscription) {
		super(id, name, birthday, inscription);	
		this.salary = 0;
	}
	
	public Researcher(String name, int bi, Date birthday) {
		super(bi, name, birthday);
	}
	
	public void setBolsa(int value) {
		this.salary = value;
	}
	
	public int nMec() {
		return super.id();
	}
	
	public int bolsa() {
		return this.salary;
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