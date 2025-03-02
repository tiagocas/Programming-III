package guiao02;
//import guiao1.Date;

public class Student extends Person{
	private int nMec;
	private String course;
	
	public Student(int id, String name, int cc, Date birthday, String course, int nMec) {
		super(id, name, cc, birthday);
		this.nMec = nMec;
		this.course = course;
	}
	
	public String toString() {
		return super.toString() + "\t -> Course: " + this.course + "\t nMec: " + this.nMec;
	}
}
