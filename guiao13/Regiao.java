package guiao13;

public abstract class Regiao {
	private String name;
	private int population;
	
	public Regiao(String name, int population) {
		this.name = name;
		this.population = population;
	}
	
	public String nome() {
		return name;
	}
	
	public int populacao() {
		return population;
	} 
	
}
