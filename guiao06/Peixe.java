package guiao06;

public class Peixe extends Alimento {
	private TipoPeixe tp;
	public Peixe(TipoPeixe tp, double proteins, double calories, double weight) {
		super(proteins, calories, weight);
		this.tp = tp;
	}
	
}
