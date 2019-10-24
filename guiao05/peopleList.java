package guiao05;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class peopleList {
	private int peopleCount;
	private int maxPeople;
	private ArrayList<Person> pl;
	
	peopleList(int maxPeople) {
		this.pl = new ArrayList<Person>();
		this.maxPeople = maxPeople;
		this.peopleCount = 0;
	}
	peopleList() {
		this.pl = new ArrayList<Person>();
		this.maxPeople = 100;
		this.peopleCount = 0;
	}
	
	public void save(String fileName) throws Exception {
		Scanner sc = new Scanner(new File(fileName));
		Files f = null;
		switch(sc.nextLine()) {
		case "CSV":
			f = new CSV();
			break;
		case "vCard":
			f = new vCard();
			break;
		case "Nokia":
			f = new Nokia();
			break;
		default:
			System.out.println("Nenhum metodo encontrado");
			break;
		}
		try {
			f.writeToFile(fileName, pl);
			System.out.println("Gravado com sucesso!");
		}
		catch(Exception e) {
			System.out.println("Algum erro ao efetuar a gravacao - " + e.getMessage());
		}
	}
	
	public void getInfoFromFile(String fileName) throws Exception {
		File file = new File(fileName);
		Scanner sc = new Scanner(file);
		Files f = null;
		
		switch(sc.nextLine()) {
		case "CSV":
			f = new CSV();
			break;
		case "vCard":
			f = new vCard();
			break;
		case "Nokia":
			f = new Nokia();
			break;
		default:
			System.out.println("Nenhum metodo encontrado");
			break;
		}
		this.pl = f.readFromFile(fileName);
		this.peopleCount = 0;
		this.maxPeople = 1000;
	}
	
	public void addPerson(Person person) {
		if(this.maxPeople > peopleCount) {
			pl.add(person);
			this.peopleCount++;
		}
		else {
			System.out.println("Pessoa nao adicionada por ter chegado ao limite da lista de pessoas");
		}
	}
	
	public boolean deletePeople(String string) {
		if(isInteger(string)) {
			int cc = Integer.parseInt(string);
			Person p = getPerson(cc);
			if(p == null) {
				return false;
			}
			pl.remove(p);
			
			return !pl.contains(p);
		}
		return false;
	}
	
	public Person getPerson(int cc) {
			for(int i=0;i<pl.size();i++) {
				if(pl.get(i).cc() == cc) {
					return pl.get(i);
				}
			}
		return null;
	}
	public String list() {
		String content = "";
		for(int i=0;i<pl.size();i++) {
			content += pl.get(i).toString() + "\n\n";
		}
		return content;
	}
	private Person[] orderList() {
		@SuppressWarnings("unchecked")
		ArrayList<Person> aux = (ArrayList<Person>) pl.clone();
		boolean change = true;
		/*
		while(change) {
			change = false;
			for(int i=0;i<aux.size()-1;i++) {
				if(aux.get(i).cc() > aux.get(i+1).cc()) {
					Person pAux = aux.get(i);
					aux.get(i) = aux.get(i+1);
					aux.get(i+1) = pAux;
					change = true;
				}
			}
		}*/
		return null;
		//return (Person[]) aux.toArray();
	}
	public Person getPerson(Date birthday) {
		for(int i=0;i<pl.size();i++) {
			if(pl.get(i).birthday().equals(birthday)) {
				return pl.get(i);
			}
		}
		return null;
	}
	public Person getPerson(String name) {
		for(int i=0;i<pl.size();i++) {
			if(pl.get(i).name().equals(name)) {
				return pl.get(i);
			}
		}
		return null;
	}
	public String getPersonInfo(Person p) {
		for(int i=0;i<pl.size();i++) {
			if(p.equals(pl.get(i))) {
				return p.toString();
			}
		}
		return null;
	}
	private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        }
        catch(Exception e) { 
            return false;
        }
    }
	
}
