package guiao05_ex2;

public abstract class Automovel extends Motorizado {
	private String matricula;
	
	public Automovel(String name, double potencia, double consumo, String combustivel, double height, double width, boolean airConditioner, double emissoes,String matricula , String date) {
		super(name, potencia, consumo, combustivel, height, width, emissoes, date);
		this.matricula = matricula;
	}
	
	@Override
	public String toString() {
		return  super.toString()
				+ "matricula: " + this.matricula + StringFormat.downAndSpace();
	}
	
}
