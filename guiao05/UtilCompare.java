package guiao05;

import guiao05_ex2.ColecaoVeiculos;
import guiao05_ex2.Veiculo;

public class UtilCompare {
	
	public static <E> Comparable<E> findMax( Comparable<E>[] e){
		int max = 0;
		for(int i=1;i<e.length;i++) {
			if(e[i] != null && e[i].compareTo((E)e[max])>0 ) {
				max = i;
			}
		}
		return e[max];
	}
	
	// bubble sort
	public static <E> void sortArray(Comparable<E>[] e){
		boolean change = true;
		while(change) {
			change = false;
			for(int i=0;i<e.length-1;i++) {
				if(e[i].compareTo((E)e[i+1]) > 0) {
					change = true;
					Comparable<E> aux = e[i];
					e[i] = e[i+1];
					e[i+1] = aux;
				}
			}
		}
	}

	public static <E> Comparable<E>[] sortArrayAndReturn(Comparable<E>[] e){
		boolean change = true;
		while(change) {
			change = false;
			for(int i=0;i<e.length-1;i++) {
				if(e[i].compareTo((E)e[i+1]) > 0) {
					change = true;
					Comparable<E> aux = e[i];
					e[i] = e[i+1];
					e[i+1] = aux;
				}
			}
		}
		return e;
	}
}
