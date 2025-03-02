package guiao03_ex3;
import java.util.HashMap;
import guiao01.Date;

public class ClientList {
	private HashMap<Integer,Person> cl;
	private int id = 0;
	
	ClientList(){
		cl = new HashMap<Integer,Person>();
	}
	
	public void add(Person p) {
		cl.put(this.id,p);
		this.id++;
		System.out.println("Person added successfully");
	}
	
	public void remove(int numMember) {
		if(cl.remove(numMember) != null) {
			System.out.println("Person deleted");
		}
		else {
			System.out.println("Person not found");
		}
	}
	
	public String list() {
		String content = "\tClients\n";
		for(int i = 0 ; i < cl.size(); i++){
			if(cl.containsKey(i)) {
				content += "id: " + i + "\t" + cl.get(i).toString() + "\n";
			}
		}
		return content;
	}
	public Person search(int numMember) {
		/*if(cl.containsKey(numMember)) {
			return cl.get(numMember);
		}*/
		return cl.get(numMember);
		//return null;
	}
	public int nextId(){
		return this.id;
	}
	
}
