package guiao02;
//import guiao1.Date;

public class Person {
	private String name;
	private int cc;
	private Date birthday;
	private int id;
	//private Date registrationDate;
	
	Person(int id, String name, int cc, Date birthday){
		if(Date.validDate(birthday.day(),birthday.month(),birthday.year())) {
			this.name = name;
			this.cc = cc;
			this.birthday = birthday;
			this.id = id;
		}
		else {
			System.out.println("Person not added");
		}
		
	}
	
	Person(String name, String cc, Date birthday){
		this.name = name;
		this.cc = Integer.parseInt(cc);
		this.birthday = birthday;
	}
	
	public void add(int id, String name, int cc, Date birthday) {
		this.id = id;
		this.name = name;
		this.cc = cc;
		this.birthday = birthday;
	}
	
	public void update(String name, int cc, Date birthday) {
		this.name = name;
		this.cc = cc;
		this.birthday = birthday;
	}
	
	public int id() {
		return this.id;
	}
	
	public int cc() {
		return this.cc;
	}
	
	public String name() {
		return this.name;
	}
	
	public Date birthday() {
		return this.birthday;
	}
	
	public String toString() {
		return this.name + "\t" + this.cc + "\t" + this.birthday;
	}
	
	
}
