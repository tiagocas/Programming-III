package guiao13;

public class Estado extends Regiao {
	private Localidade capital;
	
	public Estado(String name, int population, Localidade localidade) {
		super(name, population);
		this.capital = localidade;
	}
	
	public Localidade getCapital() {
		return this.capital;
	}
	
	public boolean equals(Estado localidade) {
		return this.capital.equals(localidade);
	}
	
	public String toString() {
		return "Populacao: " + super.populacao() + "  Estado " + super.nome();
	}
	
}
