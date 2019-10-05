package guiao03;
import guiao02.Date;

public class Student extends Person {
	private static int nMecStarts = 100;
	private int nMec;
	
	public Student(String name, int bi, Date birthday, Date inscription) {
		super(bi, name, birthday, inscription);
	}
	
	public Student(String name, int bi, Date birthday) {
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