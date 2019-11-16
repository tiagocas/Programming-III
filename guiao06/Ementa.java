package guiao06;
import java.util.ArrayList;
import java.util.HashMap;

public class Ementa {
	private String name;
	private String local;
	private ArrayList<ArrayList<Prato>> ementas;
	
	
	public Ementa(String name, String local) {
		this.ementas = new ArrayList<ArrayList<Prato>>();		
		this.name = name;
		this.local = local;
	}
	
	public void addPrato(Prato p, int dia) {
		ArrayList<Prato> al = null;
		if(this.ementas.contains(dia)) {
			al = this.ementas.get(dia);
		}
		else {
			al = new ArrayList();
		}
		al.add(p);
		this.ementas.add(dia, al);
	}
	
	public String toString() {
		String content = "";
		
		for(int i=0;i<this.ementas.size();i++) {
			if(this.ementas.contains(i)) {
				ArrayList<Prato> alaux = this.ementas.get(i);
				for(int j=0;j<alaux.size();i++) {
					if(alaux.contains(j)) {
						content += alaux.get(j).toString() + "\n";
					}
				}
			}
		}
		return content;
	}
	
	
	/*
	public Ementa(String name, String local) {
		this.ementas = new HashMap<Prato, Integer>();
		this.name = name;
		this.local = local;
	}
	
	public void addPrato(Prato p, int dia) {
		if(this.ementas.size() == 0) {
			this.ementas.put(p, dia);
		}
		else {
			for(int i=0;i<this.ementas.size()-1;i++) {
				if(this.ementas.get(i) > this.ementas.get(i+1) ) {
					this.ementas.put(p, DiaSemana.getNextDay(dia));
				}
			}
		}	
	}
	
	public String toString() {
		String content = "";
		for(int i=0;i<this.ementas.size();i++) {
			if(this.ementas.containsKey(i)) {
				content += this.ementas.get(i).toString();
			}
		}
		return content;
	}
	*/
	
}
