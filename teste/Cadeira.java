package teste;

import java.io.Serializable;

public class Cadeira extends Mobiliario implements Serializable{
	private Mobiliario.TipoCadeira material;
	private TipoCadeira tipo;
	private int numeroApoios;
	private double altura;
	
	
	public Cadeira(String nome, int id, Mobiliario.TipoCadeira material, TipoCadeira tipo, double altura, int numeroApoios) {
		super(nome, id);
		this.material = material;
		this.tipo = tipo;
		this.altura = altura;
		this.numeroApoios = numeroApoios;
	}
	
	public enum TipoCadeira {
		Escritorio, Espera, Atendimento;
	}
	
}

