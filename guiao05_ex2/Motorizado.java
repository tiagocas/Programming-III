package guiao05_ex2;

public abstract class Motorizado extends Veiculo {
	private double potencia;
	private double consumo;
	private String combustivel;
	private double emissoes;
	
	public Motorizado(String name, double potencia, double consumo, String combustivel, double height, double width, double emissoes,String date) {
		super(name, height, width, date);
		this.potencia = potencia;
		this.consumo = consumo;
		this.combustivel = combustivel;
		this.emissoes = emissoes;
	}
	
	public String toString() {
		return super.toString()
		+ "potencia: " + this.potencia + " cv" + StringFormat.downAndSpace()
		+ "consumo: " + this.consumo + " l/100 km" + StringFormat.downAndSpace()
		+ "combustivel: " + this.combustivel + StringFormat.downAndSpace()
		+ "emissoes: " + this.emissoes + " CO2 g/km" + StringFormat.downAndSpace();
	}
	
	public double getPotencia() {
		return this.potencia;
	}
	
	public double getConsumo() {
		return this.consumo;
	}
	
	public String getCombustivel() {
		return this.combustivel;
	}
}
