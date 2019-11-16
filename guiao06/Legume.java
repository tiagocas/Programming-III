package guiao06;

public class Legume extends Alimento implements Vegetariano {
	private String name;

	public Legume(String name, double proteins, double calories, double weight) {
		super(proteins, calories, weight);
		this.name = name;
	}
	
	public String toString() {
		return "Vegetariano";
	}
	
}
