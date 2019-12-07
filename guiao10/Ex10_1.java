package guiao10;

import java.util.Iterator;
import java.util.List;

import guiao06.Circulo;
import guiao06.Data;
import guiao06.Figura;
import guiao06.Pessoa;
import guiao06.Quadrado;
import guiao06.Rectangulo;

public class Ex10_1 {
	public static void main(String[] args) {
		
		VectorGeneric<Pessoa> vp = new VectorGeneric<Pessoa>();
		for (int i=0; i<10; i++) {
			vp.addElem(new Pessoa("Bebé no Vector "+i,1000+i, today()));
		}
		Iterator<Pessoa> vec = vp.iterator();
		printSet(vp.iterator());
		
		
		ListaGeneric<Pessoa> lp = new ListaGeneric<Pessoa>();
		while ( vec.hasNext() ) {
			lp.addElem( vec.next() );
		}
		Iterator<Pessoa> lista = lp.iterator();
		while ( lista.hasNext() ) {
			System.out.println( lista.next().toString());
		}
		
		ListaGeneric<Figura> figList = new ListaGeneric<Figura>();
		figList.addElem(new Circulo (1,3, 1));
		figList.addElem(new Quadrado(3,4, 2));
		figList.addElem(new Rectangulo(1,2, 2,5));
		printSet(figList.iterator());
		System.out.println("Soma da Area de Lista de Figuras: " + sumArea(figList));
		// Partindo do principio que Quadrado extends Rectangulo:
		ListaGeneric< Rectangulo > quadList = new ListaGeneric<Rectangulo>();
		quadList.addElem(new Quadrado(3,4, 2));
		quadList.addElem(new Rectangulo(1,2, 2,5));
		System.out.println("Soma da Area de Lista de Quadrados: " + sumArea(quadList));
		
		
	}
	
	public static double sumArea(ListaGeneric<? extends Figura> figList) {
		Iterator i = figList.iterator();
		double count = 0;
		while(i.hasNext()) {
			count += ((Figura) i.next()).Area();
		}
		return count;
	}
	
	public static void printSet(Iterator iterator) {
		while(iterator.hasNext()) {
			System.out.println(iterator.next().toString());
		}
	}
	
	public static Data today() {
		return new Data(12,2,2019);
	}
	
}
