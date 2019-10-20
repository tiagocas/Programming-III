package guiao05_ex2;
import guiao05.UtilCompare;

import java.util.Random;

import guiao04.Figura;

public class Ex05_02 {

	public static void main(String[] args) {
		
		// Avioes
		Veiculo a1 = new Aviao("Antonov",2000, 120, "Diesel", 12, 26, 1.4, 29.9, randomDate(2010,2019));
		Aviao a2 = new Aviao("Boing",2000, 120, "diesel", 9, 24, 1.5, 7.1, randomDate(2010,2019));
		Aviao a3 = new Aviao("Boing",2000, 120, "diesel", 10, 26, 1.3, 8.7, randomDate(2010,2019));
		
		// Carros
		Veiculo c1 = new Ligeiro("A80", 130, 30, "Gasolina", 2.3, 4.5, 5, false, 3.1, Matricula.random(),randomDate(2010,2019));
		Veiculo c2 = new Ligeiro("720di", 250, 30, "Diesel", 2.1, 4.4, 3, true, 3.1, Matricula.random(),randomDate(2010,2019));
		Veiculo c3 = new Ligeiro("Allroad 6x", 190, 30, "Gasolina", 2.3, 4.5, 5, true, 3.1, Matricula.random(),randomDate(2010,2019));
	
		// Motas
		Veiculo m1 = new Mota("IY220", 75, 14, "Gasolina", 1.1, 2.1, false, 225, 3.1, Matricula.random(),randomDate(2010,2019));
		Veiculo m2 = new Mota("RX650", 165, 14, "Diesel", 1.3, 2.9 , false, 420, 4.1, Matricula.random(),randomDate(2010,2019));
		Veiculo m3 = new Mota("YK1200", 225, 14, "Diesel", 1.7, 3.1, false, 1200, 4.9, Matricula.random(),randomDate(2010,2019));
		
		// Motas Policia
		Veiculo mp1 = new MotaPolicia("Bombeiros", "P-Yk990", 315, 14, "Diesel", 1.7, 3.1, false, 1200, 4.9, Matricula.random(),randomDate(2010,2019));
		Veiculo mp2 = new MotaPolicia("INEM", "P-RX650", 290, 14, "Diesel", 1.5, 3.0, false, 1000, 4.4, Matricula.random(),randomDate(2010,2019));
		Veiculo mp3 = new MotaPolicia("PSP", "P-KW100", 220, 12, "Diesel", 1.4, 2.8, false, 915, 3.9, Matricula.random(),randomDate(2010,2019));
		
		ColecaoVeiculos veiculos = new ColecaoVeiculos(20);
		veiculos.addVeiculo(a1);
		veiculos.addVeiculo(a2);
		veiculos.addVeiculo(a3);
		veiculos.addVeiculo(c1);
		veiculos.addVeiculo(c2);
		veiculos.addVeiculo(c3);
		veiculos.addVeiculo(m1);
		veiculos.addVeiculo(m2);
		veiculos.addVeiculo(m3);
		veiculos.addVeiculo(mp1);
		veiculos.addVeiculo(mp2);
		veiculos.addVeiculo(mp3);
		
		Veiculo[] v = veiculos.getVeiculos();
		
		showVeiculosOrdenadosPorData(veiculos);
		
		
		/*
		Veiculo[] v1 = (Veiculo[])UtilCompare.sortArrayAndReturn(v);
		ColecaoVeiculos veiculos2 = new ColecaoVeiculos(20);
		for(int i=0;i<v1.length;i++) {
			System.out.println(v1[i].toString());
		}*/		
		//System.out.println(veiculos.toString());		// Nao ordenado
		//System.out.println(veiculos2.toString());		// Ordenado
		
	}
	
	public static String randomDate(int minYear, int maxYear) {
		return generateNumber(1,31) + "-"+ generateNumber(1,12) + "-" + generateNumber(minYear, maxYear);
	}
	
	public static String generateNumber(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		if(randomNum < 10) {
			return "0" + String.valueOf(randomNum);
		}
		return String.valueOf(randomNum);
	}
	
	public static void showVeiculosOrdenadosPorData(ColecaoVeiculos veiculos) {
		Veiculo[] v = veiculos.getVeiculos();
		UtilCompare.sortArray(v);
		for(int i=0;i<v.length;i++) {
			System.out.println(v[i].toString() + "\t\t\t -> date: " + v[i].getDateUTC());
		}
	}

}
