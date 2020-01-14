package teste;

import java.io.Serializable;

public class CadeiraRodas extends Cadeira implements Transporte, Serializable{
	private int numeroRodas;
	private boolean isEletric;
	private TipoTransporte tipoTransporte;
	
	
	public CadeiraRodas(String nome, int id, Mobiliario.TipoCadeira material, Cadeira.TipoCadeira tipo, double altura, int numApoios, int numeroRodas, boolean eletric) {
		super(nome, id, material, tipo, altura, numApoios);
		this.numeroRodas = numeroRodas;
		this.isEletric = eletric;
	}
	
	public void setTipo(TipoTransporte tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}

	@Override
	public TipoTransporte getTipo() {
		return this.tipoTransporte;
	}
	
}