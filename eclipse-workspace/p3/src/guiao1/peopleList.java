package guiao1;

public class peopleList {
	private int index = 0;
	private int peopleCount = 0;
	private int maxPeople = 0;
	private Person[] person = new Person[100];
	
	peopleList(int maxPeople) {
		this.person = new Person[maxPeople];
		this.maxPeople = maxPeople;
		this.peopleCount = 0;
		this.index = 0;
	}
	peopleList() {
		this.maxPeople = 100;
		this.person = new Person[this.maxPeople];
		this.peopleCount = 0;
		this.index = 0;
	}
	
	public Person addPerson(Person person) {
		this.person[index] = person;
		this.index++;
		this.peopleCount++;
		return this.person[index-1];
	}
	public boolean deletePeople(String string) {
		if(isInteger(string)) {
			int cc = Integer.parseInt(string);
			for(int i=0;i<index;i++) {
				if(person[i].cc() == cc) {
					person[i] = null;
					return true;
				}
			}
		}
		return false;
	}
	
	public Person getPerson(int cc) {
		for(int i=0;i<index;i++) {
			if(person[i].cc() == cc) {
				return person[i];
			}
		}
		return null;
	}
	public String list() {
		Person[] p = this.person;	//orderList();
		String slash = "----------------------\n";
		String content = "--- List of people ---\n";
		content += "Name \t cc \t Birtyday\n\n";
		if(this.peopleCount > 0) {
			for(int i=0;i<index;i++) {
				if(p[i] != null) {
					content += p[i].name() + " \t " + p[i].cc() + " \t " + p[i].birthday().toString() + "\n";
					//content += slash;
				}
			}
		}
		return content + "\n";
	}
	private Person[] orderList() {
		Person[] p = new Person[index]; //acabar
		
		
		return p;
	}
	public Person getPerson(Date birthday) {
		for(int i=0;i<index;i++) {
			if(person[i].birthday() == birthday) {
				return person[i];
			}
		}
		return null;
	}
	public Person getPerson(String name) {
		for(int i=0;i<index;i++) {
			if(person[i].name() == name) {
				return person[i];
			}
		}
		return null;
	}
	public String getPersonInfo(Person p) {
		for(int i=0;i<index;i++) {
			if(p == person[i]) {
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
