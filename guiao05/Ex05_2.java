package guiao05;

public class Ex05_2 {

	public static void main(String[] args) {
		IVeiculo a = new Aviao("Antonov", "23-01-2000", 16, 11);
		
		Policia b = new Aviao("Antonov", "23-01-2000", 16, 11);
		
		ColecaoVeiculos veiculos = new ColecaoVeiculos(10);
		veiculos.addVeiculo(a);
		
		System.out.println(a.getName());
	}

}
