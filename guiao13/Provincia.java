package guiao13;

public class Provincia extends Regiao {
	private String president;
	
	public Provincia(String name, int population, String president) {
		super(name, population);
		this.president = president;
	}
}
