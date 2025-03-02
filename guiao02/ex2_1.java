package guiao02;
//import guiao1.Date;
//import guiao1.Menu;
import java.util.Scanner;

public class ex2_1 {
	
	static Scanner input;
	static ClientList cl = new ClientList();
	static Catalog ctl = new Catalog();
	static LoansList ll = new LoansList();
	static Store store = new Store(cl, ctl, ll);
	
	public static void main(String[] args) {
		
		addSomeInfo();	// comment if no information in the begining is needed
		
		input = new Scanner(System.in);
		String option;
		String content = "\n"
				+ "[1] Add Client\n"
				+ "[2] Add Video\n"
				+ "[3] List Catalog\n"
				+ "[4] List Clients\n"
				+ "[5] Search Client\n"
				+ "[6] Delete Client\n"
				+ "[7] Delete Videos\n"
				+ "[8] Register a loan\n"
				+ "[9] List Loans\n"
				+ "[10] Receive video from a loan\n"
				+ "[11] Edit videos information\n"
				+ "[12] Edit Client information\n"
				+ "[13] Check specific loan information\n"
				+ "[14] Check Video historial\n"
				+ "[15] List Videos by Rating\n"
				+ "[16] Search Loans By Person\n"
				+ "[99] Exit";
		Menu menu = new Menu(content);
		
		do {
			option = menu.showMenu();
			
			switch(option) {
			case "1":
				
				addClient();
				break;
				
			case "2":
				
				addVideo();
				break;
				
			case "3":
				
				listCatalog();
				break;
				
			case "4":
				listClients();
				break;
				
			case "5":
				
				searchClientById();
				break;
				
			case "6":
				
				deleteClient();
				break;
				
			case "7":
				
				deleteVideo();
				break;
				
			case "8":
				
				registerLoan();
				break;
				
			case "9":
				
				listLoans();
				break;
				
			case "10":
				
				receiveLoan();
				break;
				
			case "11":
				
				editVideo();
				break;
				
			case "12":
				
				editClient();
				break;
			
			case "13":
				
				checkLoan();
				break;
				
			case "14":
				
				getVideoHistorial();
				break;
				
			case "15":
				
				listVideosByRating();
				break;
				
			case "16":
				
				listLoansByPerson();
				break;
				
			case "99":
				
				System.out.println("\n\n\n\n\n\n\nU will be missed Sir!");
				System.exit(0);
				
			default:
				
				System.out.println("Command not recognized");
				break;
				
			}
			
		}
		while(true);
	}
	public static void addSomeInfo() {
		cl.add(new Student(cl.nextId(), "Tiago", 204814, new Date("24-01-2000"), "CT", 92984));
		cl.add(new Student(cl.nextId(), "Filipe", 194731, new Date("18-05-2000"), "LEI", 93721));
		cl.add(new Student(cl.nextId(), "Jose", 142534, new Date("23-01-2001"), "ET", 97529));
		cl.add(new Student(cl.nextId(), "Andre", 141345, new Date("01-02-2002"), "ET", 92019));
		cl.add(new Student(cl.nextId(), "Rui", 182634, new Date("04-02-2003"), "ET", 102426));
		
		ctl.add("Rambo", "Acao", "M12");
		ctl.add("Titanic", "Drama", "M16");
		ctl.add("Avatar", "Acao", "M18");
		ctl.add("Endgame", "Acao", "M12");
		
		ll.add(ctl.search(0), cl.search(0), new Date("23-01-2017"), new Date("07-02-2017"));
		ll.add(ctl.search(1), cl.search(1), new Date("20-03-2018"), new Date("27-03-2018"));
		ll.add(ctl.search(0), cl.search(2), new Date("10-02-2017"), new Date("21-03-2017"));
		ll.add(ctl.search(2), cl.search(3), new Date("19-02-2019"), new Date("23-05-2019"));
		ll.add(ctl.search(1), cl.search(1), new Date("25-01-2017"), new Date("01-03-2017"));
				
		ll.search(cl.search(2), ctl.search(0)).loanPaid(6);
		ll.search(cl.search(3), ctl.search(2)).loanPaid(9);
		
	}
	
	public static void listLoansByPerson() {
		Person person = getPerson();
		if(person == null) {
			return;
		}
		System.out.println(ll.showHistorial(person));		
	}
	
	public static void listVideosByRating() {
		System.out.println(ctl.listByRating());
	}
	
	public static void getVideoHistorial() {
		Video video = getVideo();
		if(video == null) {
			return;
		}
		System.out.println(ll.showHistorial(video));
	}
	
	public static void checkLoan() {
		Video video = getVideo();
		if(video != null) {
			System.out.println(video.toString());
		}
	}
	
	public static Video getVideo() {
		boolean err = true;
		Video video = null;
		while(err) {
			System.out.println("Video id ('cancel' to cancel operation):");
			String id = input.nextLine();
			if(isNumeric(id)) {
				int idVideo = Integer.parseInt(id);
				if(cl.search(idVideo) != null) {
					video = ctl.search(idVideo);
					err = false;
				}
				else {
					System.out.println("Video not found");
				}
			}
			else {
				if(id.compareTo("cancel") == 0) {
					System.out.println("Operation canceled");
					return null;
				}
			}
		}
		return video;
	}
	
	public static Person getPerson() {
		boolean err = true;
		Person person = null;
		while(err) {
			System.out.println("Client id ('cancel' to cancel operation):");
			String id = input.nextLine();
			if(isNumeric(id)) {
				int idPerson = Integer.parseInt(id);
				if(cl.search(idPerson) != null) {
					person = cl.search(idPerson);
					err = false;
				}
				else {
					System.out.println("Person not found");
				}
			}
			else {
				if(id.compareTo("cancel") == 0) {
					System.out.println("Operation canceled");
					return null;
				}
			}
		}
		return person;
	}
	
	public static void editClient() {
		Person person = getPerson();
		if(person == null) {
			return;
		}
		System.out.println("Name:");
		String name = input.nextLine();
		if(name.length() == 0) {
			name = person.name();
		}
		
		System.out.println("CC:");
		String ccString = input.nextLine();
		int cc = 0;
		if(ccString.length() == 0) {
			cc = person.cc();
		}
		else {
			cc = Integer.parseInt(ccString);
		}
		
		Date date = null;
		boolean cont = true;
		while(cont) {
			System.out.println("Birthday:");
			String dateString = input.nextLine();
			if(dateString.length() == 0) {
				date = person.birthday();
				cont = false;
			}
			else {
				date = new Date(dateString);
				if(date.validDate(date.day(), date.month(), date.year())) {
					cont = false;
				}
				else {
					System.out.println("Invalid Date");
				}
			}
		}
		
		person.update(name, cc, date);
		System.out.println("Client updated");
	}
	
	public static void editVideo() {
		Video video = getVideo();
		if(video == null) {
			return;
		}
		System.out.println("Name:");
		String name = input.nextLine();
		if(name.length() == 0) {
			name = video.name();
		}
		String category = Video.getCategory();
		
		String minimalAge = Video.getMinimalAge();
		
		video.update(name, category, minimalAge);
		System.out.println("Video updated");		
	}
	
	public static void receiveLoan() {
		boolean err = true;
		Video video = null;
		Person person = null;
		
		while(err) {
			System.out.println("ID of the video ('cancel' to cancel operation):");
			String id = input.nextLine();
			if(isNumeric(id)) {
				int idVideo = Integer.parseInt(id);
				if(ctl.search(idVideo) != null) {
					video = ctl.search(idVideo);
					err = false;
				}
				else {
					System.out.println("Video not found");
				}
			}
			else {
				System.out.println("Operation canceled");
				return;
			}
		}
		err = true;
		
		while(err) {
			System.out.println("ID of the person ('cancel' to cancel operation):");
			String id = input.nextLine();
			if(isNumeric(id)) {
				int idPerson = Integer.parseInt(id);
				if(cl.search(idPerson) != null) {
					person = cl.search(idPerson);
					err = false;
				}
				else {
					System.out.println("Person not found");
				}
			}
			else {
				if(id.compareTo("cancel") == 0) {
					System.out.println("Operation canceled");
					return;
				}
			}
		}
		
		boolean cont = true;
		int rating = 0;
		while(cont) {
			System.out.println("Rating (1-10): ");
			rating = input.nextInt();
			if(rating <= 10 && rating >= 0) {
				cont = false;
			}
		}
		
		Loan loan = ll.search(person, video);
		if(loan != null) {
			if(loan.loanPaid(rating)) {
				System.out.println("Loan received successfully");
			}
			else {
				System.out.println("Loan already payed");
			}
		}
		else {
			System.out.println("Loan not found");
		}
		
		
	}
	
	public static void listLoans() {
			System.out.println(ll.list());
	}
	
	public static void registerLoan() {
		boolean err = true;
		Video video = null;
		Person person = null;
		
		while(err) {
			System.out.println("ID of the video ('cancel' to cancel operation):");
			String id = input.nextLine();
			if(isNumeric(id)) {
				int idVideo = Integer.parseInt(id);
				if(ctl.search(idVideo) != null) {
					video = ctl.search(idVideo);
					err = false;
				}
				else {
					System.out.println("Video not found");
				}
			}
			else {
				System.out.println("Operation canceled");
				return;
			}
		}
		err = true;
		
		while(err) {
			System.out.println("ID of the person ('cancel' to cancel operation):");
			String id = input.nextLine();
			if(isNumeric(id)) {
				int idPerson = Integer.parseInt(id);
				if(cl.search(idPerson) != null) {
					person = cl.search(idPerson);
					err = false;
				}
				else {
					System.out.println("Person not found");
				}
			}
			else {
				if(id.compareTo("cancel") == 0) {
					System.out.println("Operation canceled");
					return;
				}
			}
		}
		
		Date delivery = Date.getDate("Date of the delivery:");
		Date receive = Date.getDate("Date of the receiving");
		
		ll.add(video, person, delivery, receive);
	}
	public static boolean isNumeric(String strNum) {
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException | NullPointerException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public static void deleteVideo() {
		System.out.println("Id of the video to delete:");
		int id = input.nextInt();
		ctl.remove(id);
	}
	
	public static void listCatalog() {
		System.out.println(ctl.list());
	}
	
	public static void addClient() {
		String content =  "[1] Student\n"
						+ "[2] Staff\n";
		System.out.println(content);
		String option = input.nextLine();
		switch(option) {
		case "1":
			addStudent();
			break;
			
		case "2":
			addStaff();
			break;
			
		default:
			System.out.println("Command not recognized, going back to the main menu");
			break;
		}
		
	}
	
	public static void addVideo() {
		System.out.println("Name:");
		String name = input.nextLine();
		
		String category = Video.getCategory();
		
		String minimalAge = Video.getMinimalAge();
		
		ctl.add(name, category, minimalAge);
	}
	
	public static void listClients() {
		System.out.println(cl.list());
	}
	
	public static void addStaff() {
		System.out.println("Name: ");
		String name = input.nextLine();
		
		System.out.println("CC:");
		int cc = input.nextInt();
		input.nextLine();
		
		Date birthday = Date.getDate("Birthday:");
		if(birthday == null) {
			return;
		}
		
		System.out.println("Fiscal Number:");
		int fiscalNumber = input.nextInt();
		input.nextLine();
		
		Staff staff = new Staff(cl.nextId(), name, cc, birthday, fiscalNumber);
		cl.add(staff);
	}
	
	public static void addStudent() {
		
		System.out.println("Name: ");
		String name = input.nextLine();
		
		System.out.println("CC:");
		int cc = input.nextInt();
		input.nextLine();
		
		Date birthday = Date.getDate("Birthday:");
		if(birthday == null) {
			return;
		}
		
		System.out.println("Course:");
		String course = input.nextLine();
		
		System.out.println("Mec number:");
		int nMec = input.nextInt();
		input.nextLine();
		
		Student student = new Student(cl.nextId(), name, cc, birthday, course, nMec);
		cl.add(student);
	}
	public static void searchClientById() {
		System.out.println("Search client by id");
		int id = input.nextInt();
		input.nextLine();
		Person p = cl.search(id);
		System.out.println(p.toString());
		}
	
	public static void deleteClient() {
		System.out.println("Id if the client to delete");
		int id = input.nextInt();
		input.nextLine();
		cl.remove(id);
	}

}
