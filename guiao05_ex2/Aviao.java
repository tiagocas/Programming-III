package guiao05_ex2;

public class Aviao extends Motorizado {
	private double bladeSize;
	
	public Aviao(String name, double potencia, double consumo, String combustivel, double height, double width, double bladeSize, double emissoes, String date) {
		super(name, potencia, consumo, combustivel, height, width, emissoes,date);
		this.bladeSize = bladeSize;
	}

	@Override
	public String toString() {
		return "Aviao -> " + StringFormat.downAndSpace()
				+ super.toString()
				+ "blade size: " + this.bladeSize + " m";
	}
	
}
