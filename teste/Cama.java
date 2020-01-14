package teste;

import java.io.Serializable;

public class Cama extends Mobiliario implements Serializable {
	private Mobiliario.TipoCadeira material;
	private double comprimento;
	private double largura;
	private boolean temColchao;
	
	public Cama(String nome, int id, Mobiliario.TipoCadeira material, double comprimento, double largura, boolean temColchao) {
		super(nome, id);
		this.material = material;
		this.comprimento = comprimento;
		this.largura = largura;
		this.temColchao = temColchao;		
	}

}