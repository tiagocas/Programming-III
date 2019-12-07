package guiao09;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListaPessoas implements Iterable {
	private List<Pessoa> lp;
	
	public ListaPessoas() {
		lp = new LinkedList<Pessoa>();
	}
	
	public void addPessoa(Pessoa p) {
		lp.add(p);
	}
	
	public boolean containsPessoa(Pessoa p) {
		return lp.contains(p);
	}
	
	public void removePessoa(Pessoa p) {
		lp.remove(p);
	}
	
	@Override
	public Iterator iterator() {
		return lp.iterator();
	}
	
}
