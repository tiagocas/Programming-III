package guiao01;
import java.util.Scanner;

public class Menu {
	static Scanner input;
	private String menu;
	
	public Menu(String content){
		this.menu = content;
	}
	public String showMenu() {
		input = new Scanner(System.in);
		System.out.println(menu);
		return input.nextLine();
	}	
}
