package teste;

import java.io.Serializable;

public class Mobiliario implements Serializable {
	private String designacao;
	private int id;
	
	public Mobiliario(String nome, int id) {
		this.designacao = nome;
		this.id = id;
	}
	
	public enum TipoCadeira {
		Madeira, Plastico, Metal, Sintetico
	}
	
	public boolean equals(Mobiliario m) {
		return m.id == this.id;
	}
	
}
