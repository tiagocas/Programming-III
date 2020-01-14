package teste;

public class Maca extends Marquesa implements Transporte{
	private int numeroGrades;
	private TipoTransporte tipoTransporte;
	
	public Maca(String nome, int id, Mobiliario.TipoCadeira material, double comprimento, double largura, boolean temColchao, int numeroGrades) {
		super(nome, id, material, comprimento, largura, temColchao, false);
		this.numeroGrades = numeroGrades;
	}
	
	public void setTipo(TipoTransporte tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}

	@Override
	public TipoTransporte getTipo() {
		return this.tipoTransporte;
	}
}