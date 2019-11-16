package guiao07;
import java.util.ArrayList;
import java.util.HashMap;

public class Companies {
	private HashMap<String, Company> ht;
	private ArrayList al = new ArrayList();
	
	public Companies() {
		ht = new HashMap<String, Company>();
	}
	
	public void addCompany(String sig, String name) {
		if(!ht.containsKey(sig)) {
			ht.put(sig, new Company(sig,name));
			if(!al.contains(sig)) {
				al.add(sig);
			}
		}
	}
	
	public String[] keys() {
		String keys[] = new String[this.ht.size()];
		for(int i=0;i<al.size();i++) {
			if(this.ht.containsKey(al.get(i))) {
				keys[i] = (String) al.get(i);
 			}
		}
		return keys;
	}
	
	public Company getCompany(String sig) {
		if(ht.containsKey(sig)) {
			return ht.get(sig);
		}
		return null;
	}
	
	public String getCompanyName(String sig) {
		if(ht.containsKey(sig)) {
			return ht.get(sig).getName();
		}
		return "Not Found";
	}
	
	public String toString() {
		return "There are " + this.ht.size() + " companies listed";
	}
	
}
