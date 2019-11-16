package guiao06;

public class Carne extends Alimento {
	private VariedadeCarne vc;
	
	public Carne(VariedadeCarne vc, double proteins, double calories, double weight) {
		super(proteins, calories, weight);
		this.vc = vc;
	}
	
	public String toString() {
		return "Carne  -->  Variedade: " + this.vc + "\n" + super.toString();
	}
	/*
	public boolean equals(Carne a) {
		return super.equals((Alimento)a);
	}
	*/
}
