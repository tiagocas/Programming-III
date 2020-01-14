package teste;

import java.io.Serializable;

public class CamaArticulada extends Cama implements Serializable {
	private boolean eletrica;

	public CamaArticulada(String nome, int id, Mobiliario.TipoCadeira material, double comprimento, double largura, boolean temColchao, boolean eletrica) {
		super(nome, id, material, comprimento, largura, temColchao);
		this.eletrica = eletrica;
	}
	
}