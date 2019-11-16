package guiao06;

public abstract class Alimento {
	private double proteins;
	private double calories;
	private double weight;
	
	public Alimento(double proteins, double calories, double weight) {
		this.proteins = proteins;
		this.calories = calories;
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "proteinas: " + this.proteins + "\ncalories: " + this.getCalories() + "\nweight: " +this.weight;
	}
	
	public double getCalories() {
		return this.calories * (1/100) * this.weight;
	}
	
	public boolean equals(Alimento a) {
		return this.proteins == a.proteins && this.calories == a.calories && this.weight == a.weight;
	}
	
}
