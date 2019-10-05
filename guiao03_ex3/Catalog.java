package guiao03_ex3;
import java.util.HashMap;

public class Catalog {
	private HashMap<Integer,Video> ctl;
	private int id;
	
	public Catalog() {
		this.id = 0;
		ctl = new HashMap<Integer,Video>();
	}
	
	public void add(String name, String category, String minimalAge) {
		ctl.put(this.id,new Video(id, name, category, minimalAge));
		this.id++;
		System.out.println("Video added successfuly");
	}
	
	public String listByRating() {
		HashMap<Integer, Video> ctlAux = this.ctl;
		for(int i=0; i<ctlAux.size()-1;i++) {
			for(int j=0; j<ctlAux.size()-i-1;j++) {
				if(ctlAux.get(j).rating() < ctlAux.get(j+1).rating()) {
					Video vAux = ctlAux.get(j);
					ctlAux.put(j,ctlAux.get(j+1));
					ctlAux.put(j+1,vAux);
				}
			}
		}
		return listHashMap(ctlAux);
	}
	
	public String listHashMap(HashMap<Integer, Video> ct) {
		String content = "";
		for(int i = 0 ; i < ct.size(); i++){
			if(ct.containsKey(i)) {
				content += ct.get(i).toString() + "\n";
			}
		}
		return content;
	}
	
	public void remove(int id) {
		if(ctl.remove(id) != null) {
			System.out.println("Video deleted");
		}
		else {
			System.out.println("Video not found");
		}
	}
	
	public String list() {
		String content = "\tCatalog\n";
		for(int i = 0 ; i < ctl.size(); i++){
			if(ctl.containsKey(i)) {
				content += ctl.get(i).toString() + "\n";
			}
		}
		return content;
	}
	
	public Video search(int id) {
		return ctl.get(id);
	}
	
}
