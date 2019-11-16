package guiao06;

public class Cereal extends Alimento implements Vegetariano {
	private String name;
	
	public Cereal(String name, double proteins, double calories, double weight) {
		super(proteins, calories, weight);
		this.name = name;
	}
	
	public String toString() {
		return "Cereal  -->  Nome: " + this.name + super.toString();
	}
	
}
