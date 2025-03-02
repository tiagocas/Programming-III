package guiao02;
import java.util.HashMap;
//import guiao1.Date;

public class LoansList {
	private HashMap<Integer, Loan> ll;
	private int id;
	
	public LoansList() {
		ll = new HashMap<Integer, Loan>();
		this.id = 0;
	}
	
	public void add(Video video, Person person, Date checkIn, Date checkOut) {
		ll.put(this.id, new Loan(this.id ,video, person,checkIn, checkOut));
		this.id++;
		System.out.println("Loan registered successfully");
	}
	
	public String list() {
		String content = "\tLoans\n";
		for(int i=0;i<ll.size();i++) {
			if(ll.containsKey(i)) {
				content += ll.get(i).toString() + "\n";
			}
		}
		return content;
	}
	
	public String showHistorial(Person person) {
		String content = "Historial of the person \"" + person.name() + "\"\n";
		for(int i=0;i<ll.size();i++) {
			if(ll.get(i).person().equals(person)) {
				content += ll.get(i).toString() + "\n";
			}
		}
		return content;
	}
	
	public String showHistorial(Video video) {
		String content = "Historial of the video \"" + video.name() + "\"\n";
		for(int i=0;i<ll.size();i++) {
			if(ll.get(i).video().equals(video)) {
				content += ll.get(i).toString() + "\n";
			}
		}
		return content;
	}
	
	public Loan search(Person p, Video v) {
		Person pAux = null;
		Video vAux = null;
		for(int i=0;i<ll.size();i++) {
			if(ll.containsKey(i)) {
				pAux = ll.get(i).person();
				vAux = ll.get(i).video();
				if(pAux.id() == p.id() && vAux.id() == v.id()) {
					return ll.get(i);
				}
			}
		}
		return null;
	}

	public Loan search(int id) {
		return ll.get(id);
	}
	
}
