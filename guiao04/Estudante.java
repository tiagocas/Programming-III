package guiao04;
import guiao02.Date;

public class Estudante extends Pessoa {
	private static int nMecStarts = 100;
	private int nMec;
	
	public Estudante(String name, int bi, Date birthday) {
		super(bi, name, birthday);		
	}
	
	public int nMec() {
		return nMec;
	}
	
	@Override
	public String toString() {
		int personalNMEC = nMecStarts + this.nMec;
		return "nMec: " + personalNMEC + ", " + super.toString();
	}
	
	public String name() {
		return super.name();
	}
	
}