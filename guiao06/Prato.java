package guiao06;
import java.util.ArrayList;

public class Prato {
	private String name;
	private ArrayList<Alimento> al;
	
	public Prato(String name) {
		this.al = new ArrayList<Alimento>();
		this.name = name;
	}
	
	public boolean addIngrediente(Alimento a) {
		this.al.add(a);
		return al.contains(a);
	}
	
	public String toString() {
		return this.name + " composto por " + this.al.size() + " ingredientes";
	}
	
}
