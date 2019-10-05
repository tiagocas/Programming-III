package guiao03;

import guiao02.Date;

public class Ex3_1 {

	public static void main(String[] args) {
		
		Student est = new Student ("Andreia", 9855678, new Date(18, 7, 1974));
		Researcher bls = new Researcher ("Maria", 8976543, new Date(11, 5, 1976));
		bls.setBolsa(745);
		
		System.out.println("Estudante: " + est.name());
		System.out.println(est);
		
		System.out.println("Bolseiro: " + bls.name() + ", NMec: " + bls.nMec() + ", Bolsa: " + bls.bolsa());
		System.out.println(bls);
	}
		
}