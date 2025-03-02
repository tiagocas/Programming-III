package guiao03_ex3;
//import guiao1.Date;

public class Loan {
	private int id;
	private Video video;
	private Person person;
	private Date checkIn;
	private Date checkOut;
	private boolean booked;
	
	public Loan(int id, Video video, Person person, Date checkIn, Date checkOut) {
		this.id = id;
		this.video = video; // video.id();
		this.person = person; //person.id();
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.booked = false;
	}
	
	public Person person() {
		return this.person;
	}
	
	public Video video() {
		return this.video;
	}
	
	public boolean isBooked() {
		return this.booked;
	}
	
	public boolean loanPaid(int rating) {
		boolean old = this.booked;
		this.booked = true;
		if(old != true) {
			this.video.rating(rating);
		}
		return old != true;
	}
	
	private String bookedValue() {
		if(this.booked) {
			return "Payed";
		}
		return "Not payed";
	}
	
	public String toString() {
		return "id: " + this.id + "\tVideo name: " + this.video.name() + "\tClient: " + this.person.name() + "\tState: " + this.bookedValue() + "\tCheck-in:" + this.checkIn.toString()+ "\tCheck-out: " + this.checkOut.toString();
	}
	
}
