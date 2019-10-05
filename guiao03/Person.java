package guiao03;
import java.util.Calendar;

import guiao02.Date;

public class Person {
	private int bi;
	private String name;
	private Date birthday;
	private Date inscription;
	
	public Person(int bi, String name, Date birthday, Date inscription) {
		this.bi = bi;
		this.name = name;
		this.birthday = birthday;
		this.inscription = inscription;
	}
	
	public Person(int bi, String name, Date birthday) {
		this.bi = bi;
		this.name = name;
		this.birthday = birthday;
		this.inscription = getCurrentDate();
	}
	
	private Date getCurrentDate() {
		Calendar c = Calendar.getInstance();
		int dd = c.DAY_OF_MONTH;
		int mm = c.MONTH;
		int yyyy = c.YEAR;
		return new Date(dd, mm, yyyy);
	}
	
	public String name() {
		return this.name;
	}
	
	public int id() {
		return this.bi;
	}
	
	@Override
	public String toString() {
		return this.name + ", BI: " + this.bi + ", Data: " + this.birthday.toString("/") + ", Date inscription: " + this.inscription.toString("/");
	}
	
}