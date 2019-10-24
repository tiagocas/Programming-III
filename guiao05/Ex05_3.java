package guiao05;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

public class Ex05_3 {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) throws FileNotFoundException, Exception {
		String base = "/home/tiagorainho/Desktop/Uni/p3/eclipse-workspace/p3/src/guiao05/";
		String fileName = base + "people.txt";
		
		peopleList pl = new peopleList();
		pl.getInfoFromFile(fileName);
		
		while(true) {
			showActions();
			String action = input.nextLine();
			switch(action) {
			case "1" :
				addPerson(pl);
				break;
			case "2" :
				System.out.printf("%s",pl.list());
				break;
			case "3" :
				if(deletePeople(pl)) {
					System.out.println("Pessoa eliminada com sucesso");
				}
				else {
					System.out.println("Pessoa nao encontrada");
				}
				break;
			case "4":
				pl.save(fileName);
				break;
			default:
				System.out.println("Comando nao reconhecido");
			}
		}
	}
	public static Boolean deletePeople(peopleList pl) {
		Scanner input = new Scanner(System.in);
		System.out.printf("Introduza o numero do cc da pessoa q pretende apagar: ");
		String cc = input.nextLine();
		return pl.deletePeople(cc);
	}
	public static void addPerson(peopleList pl) {
		Scanner input = new Scanner(System.in);
		System.out.println("Nome:");
		String nome = input.nextLine();
		System.out.println("cc:");
		String cc = input.nextLine();
		System.out.println("Data de nascimento");
		String date = input.nextLine();
		try {
			Person person = new Person(nome,cc,date);
			pl.addPerson(person);
			System.out.println(pl.getPersonInfo(person));
		}
		catch(Exception e) {
			System.out.println("Pessoa nao adicionada - " + e.getMessage());
		}
	}
	public static void showActions() {
		System.out.println("1 - adicionar pessoa");
		System.out.println("2 - mostrar pessoas");
		System.out.println("3 - eliminar pessoa");
		System.out.println("4 - Gravar\n");
		System.out.printf("Action: ");
	}
	
}
