package guiao05_ex2;

public class Mota extends Automovel {
	private int cilindrada;
	
	public Mota(String name, double potencia, double consumo, String combustivel, double height, double width, boolean airConditioner,int cilindrada, double emissoes, String matricula,String date) {
		super(name, potencia, consumo, combustivel, height, width, airConditioner, emissoes, matricula, date);
		this.cilindrada = cilindrada;
	}
	
	@Override
	public String toString() {
		String nome = "Mota";
		if(this instanceof MotaPolicia) {
			nome += " Policia";
		}
		return nome + " -> " + StringFormat.downAndSpace()
				+ super.toString()
				+ "cilindrada: " + this.cilindrada + " cc";
	}
}
