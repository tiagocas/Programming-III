package teste;

import java.io.Serializable;

public class Marquesa extends Cama {
	private boolean temInclinacao;
	
	public Marquesa(String nome, int id, Mobiliario.TipoCadeira material, double comprimento, double largura, boolean temColchao, boolean temInclinacao) {
		super(nome, id, material, comprimento, largura, temColchao);
		this.temInclinacao = temInclinacao;
	}

}