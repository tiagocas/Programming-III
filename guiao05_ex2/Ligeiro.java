package guiao05_ex2;

public class Ligeiro extends Automovel {
	private int numberOfDoors;
	private boolean airConditioner;
	
	public Ligeiro(String name, double potencia, double consumo, String combustivel, double height, double width, int numberOfDoors, boolean airConditioner, double emissoes, String matricula, String date) {
		super(name, potencia, consumo, combustivel, height, width, airConditioner, emissoes, matricula, date);
		this.numberOfDoors = numberOfDoors;
		this.airConditioner = airConditioner;
	}
	
	@Override
	public String toString() {
		String AC = "Nao tem";
		if(this.airConditioner) {
			AC = "Tem";
		}
		return "Automovel Ligeiro -> " + StringFormat.downAndSpace()
				+ super.toString()
				+ "numberOfDoors: " + this.numberOfDoors + StringFormat.downAndSpace()
				+ "Ar condicionado: " + AC;
	}
}
