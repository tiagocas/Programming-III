package guiao2;
//import guiao1.Date;

public class Staff extends Person{
	private int fiscalNumber;
	
	public Staff(int id, String name, int cc, Date birthday, int fiscalNumber){
		super(id, name, cc, birthday);
		this.fiscalNumber = fiscalNumber;
	}
	@Override
	public String toString() {
		return super.toString() + "\t -> Fiscal number: " + this.fiscalNumber;
	}
}
