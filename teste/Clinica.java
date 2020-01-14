package teste;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Clinica implements Serializable{
	private String nome;
	private List<Mobiliario> mobiliarioList;
	
	public Clinica(String nome) {
		this.nome = nome;
		this.mobiliarioList = new LinkedList<Mobiliario>();
	}
	
	public boolean addMobiliario(Mobiliario mobilia) {
		if(!exists(mobilia)) {
			mobiliarioList.add(mobilia);
			return true;
		}
		return false;
	}
	
	private boolean exists(Mobiliario mobilia) {
		for(Mobiliario m: this.mobiliarioList) {
			if(m.equals(mobilia)) {
				return true;
			}
		}
		return false;
	}
	
	public void saveClinica(String fileName) throws FileNotFoundException, IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
		out.writeObject(this);
		out.close();
	}
	
	public Clinica rescueClinica(String file) throws IOException, ClassNotFoundException{
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
		return (Clinica)in.readObject();
	}
	
	public List<Transporte> listTransportes() {
		List<Transporte> lt = new LinkedList<>();
		for(Mobiliario m: this.mobiliarioList) {
			if(m instanceof Transporte) {
				lt.add((Transporte)m);
			}
		}
		return lt;
	}
	
	
	/*
	public Iterator<Mobiliario> Iterator() {
		return this.mobiliarioList.iterator();
	}
	*/
	
	public boolean removeMobiliario(Mobiliario mobilia) {
		this.mobiliarioList.remove(mobilia);
		return exists(mobilia);
	}
	
}
