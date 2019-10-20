package guiao05_ex2;

public class MotaPolicia extends Mota implements IPolicia {
	private String tipo;
	
	public MotaPolicia(String tipo, String name, double potencia, double consumo, String combustivel, double height, double width, boolean airConditioner,int cilindrada,double emissoes, String matricula,String date) {
		super(name, potencia, consumo, combustivel, height, width, airConditioner, cilindrada, emissoes, matricula, date);
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return super.toString() + StringFormat.downAndSpace()
				+ "Tipo: " + this.getServicoEmergencia();
	}
	
	public String getServicoEmergencia() {
		return this.tipo;
	}
	
}
