package guiao1;
import java.util.Scanner;

public class ex2 {

	public static void main(String[] args) {
			
		Scanner input = new Scanner(System.in);
		peopleList pl = new peopleList();
		
		while(true) {
			showActions();
			String action = input.nextLine();
			switch(action) {
			case "1" : 
				Person p = addPerson(pl);
				if(p != null)  {
					System.out.println(pl.getPersonInfo(p));
				}
				else {
					System.out.println("Algum erro ocorreu");
				}
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
			}
			
		}
	}
	public static Boolean deletePeople(peopleList pl) {
		Scanner input = new Scanner(System.in);
		System.out.printf("Introduza o numero do cc da pessoa q pretende apagar: ");
		String cc = input.nextLine();
		return pl.deletePeople(cc);
	}
	public static Person addPerson(peopleList pl) {
		Scanner input = new Scanner(System.in);
		System.out.println("Nome:");
		String nome = input.nextLine();
		System.out.println("cc:");
		String cc = input.nextLine();
		System.out.println("Data de nascimento");
		String data = input.nextLine();
		try {
			Person person = new Person(nome,cc,new Date(data));
			pl.addPerson(person);
			return person;
		}
		catch(Exception e) {
		}
		return null;
	}
	public static void showActions() {
		System.out.println("1 - adicionar pessoa");
		System.out.println("2 - mostrar pessoas");
		System.out.println("3 - eliminar pessoa\n");
		System.out.printf("Action: ");
	}
}
