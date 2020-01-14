package guiao13;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class BrincaBeira {
	private String[] workers = {"Tiago Rainho", "José Maria", "Justino André"};
	private String[] toys = {"carrinho", "Hulk", "cinderela"};
	private Set<String> names;
	
	public BrincaBeira() {
		addWorkers();
	}
	
	private void addWorkers() {
		names = new TreeSet<>();
		Arrays.stream(workers).forEach(x -> addWorker(x));
	}
	
	public void addWorker(String name) {
		names.add(name);
	}
	
	public void removeWorker(String name) {
		names.remove(name);
	}
	
}
