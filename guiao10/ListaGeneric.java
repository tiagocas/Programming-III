package guiao10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaGeneric<T> {
	private List<T> lst;
	
	public ListaGeneric() {
		lst = new ArrayList<T>();
	}
	
	public boolean addElem(T elem) {
		return lst.add(elem);
	}
	
	public boolean removeElem(T elem) {
		return lst.remove(elem);
	}
	
	public int totalElem() {
		return this.lst.size();
	}
	
	public Iterator iterator() {
		return this.lst.iterator();
	}
	
}
