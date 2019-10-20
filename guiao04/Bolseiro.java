package guiao04;

import guiao02.Date;

public class Bolseiro extends Estudante{
	private static int nMecStarts = 100;
	private int salary = 0;
	
	public Bolseiro(String name, int bi, Date birthday) {
		super(name, bi, birthday);
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
		return "nMec: " + personalNMEC + ", " + super.toString() + ", Bolseiro com bolsa de " + this.salary;
	}
	
}