package guiao05;
import guiao04.Circulo;
import guiao04.Quadrado;
import guiao04.Rectangulo;
import guiao04.ColecaoFiguras;
import guiao04.Figura;

public class Ex05_1 {

	public static void main(String[] args) {
		Circulo c1 = new Circulo(2);
		Circulo c2 = new Circulo(1, 3, 2);
		Quadrado q1 = new Quadrado(2);
		Quadrado q2 = new Quadrado(3, 4, 2);
		Rectangulo r1 = new Rectangulo(2, 3);
		Rectangulo r2 = new Rectangulo(3, 4, 2, 3);
		ColecaoFiguras col = new ColecaoFiguras(42.0);
		System.out.println(col.addFigura(c2));
		System.out.println(col.addFigura(r1));
		System.out.println(col.addFigura(r1));
		System.out.println(col.addFigura(r2));
		System.out.println(col.addFigura(c1));
		System.out.println(col.addFigura(q2));
		System.out.println(col.addFigura(q1));
		System.out.println(col.delFigura(r1));
		System.out.println(col.addFigura(q1));

		System.out.println("\nÁrea Total da Lista de Figuras: " + col.areaTotal());
		Figura[] listaFig = col.getFiguras();
		System.out.println("\nLista de Figuras:");
		for (Figura f: listaFig) {
			System.out.println(f);
		}
		System.out.println("\nComparacao da area do primeiro elemento com todos");
		for (int i = 0; i < listaFig.length; i++) {
			System.out.printf("%2d %12s de area %6.2f compareTo(listaFig[0]) = %2d\n", i,
			listaFig[i].getClass().getSimpleName(),
			listaFig[i].area(),
			listaFig[i].compareTo(listaFig[0]));
		}
		System.out.println("\nFigura com maior Area: " + UtilCompare.findMax( listaFig ) );
		// Ordena (crescente) o array de Figuras por areas
		UtilCompare.sortArray(listaFig);
		System.out.println ("\nLista de Figuras Ordenadas por Area:");
		for (Figura f: listaFig) {
			System.out.println (f + " -> area: " + String.format("%2.2f", f.area()) + " e perimetro: " + String.format("%2.2f", f.perimetro()));
		}
	}

}
