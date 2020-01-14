package guiao13;

public class Localidade extends Regiao {
	private TipoLocalidade tipo;
	
	public Localidade(String name, int population, TipoLocalidade tipoLocalidade) {
		super(name, population);
		this.tipo = tipoLocalidade;
	}
	
	public String toString() {
		return this.tipo + ": " + super.nome() + ", " + "populacao: " + super.populacao();
	}
	
	public TipoLocalidade tipo() {
		return tipo;
	}
	
	private String name() {
		return super.nome();
	}
	
	private int population() {
		return super.populacao();
	}
	
	public boolean equals(Localidade localidade) {
		return this.name().equals(localidade.name()) && this.population() == localidade.population();
	}
	
}
