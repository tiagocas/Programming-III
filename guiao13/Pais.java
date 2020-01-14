package guiao13;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Pais {
	private Localidade capital;
	private String name;
	private List<Regiao> region;
	
	public Pais(String name, Localidade capital) {
		this(name);
		if(capital != null) {
			this.capital = capital;
			region.add(capital);
			if(!capital.tipo().equals(TipoLocalidade.Cidade)) throw new IllegalArgumentException("Capital Inválida -> " + capital.tipo());
		}
	}
	
	public Pais(String name) {
		this.name = name;
		region = new LinkedList<Regiao>();
	}
	
	public void addRegiao(Regiao regiao) {
		region.add(regiao);
	}
	
	private int population() {
		return region.stream().collect(Collectors.summingInt(Regiao::populacao));
	}
	
	public String toString() {
		String capAux = null;
		try {
			capAux = this.capital.toString();
		}
		catch(Exception e) {
			capAux = "*Indefinida*";
		}
		return "pais: " + this.name + ", Populacao: " + this.population() + " (Capital: " + capAux + " )";
	}
	
}
