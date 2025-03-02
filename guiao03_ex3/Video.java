package guiao03_ex3;
import java.util.Scanner;

public class Video {
	private int id;
	private String name;
	private String category;
	private String minimalAge;
	private double rating;
	private int ratingIndex;
	static Scanner input = new Scanner(System.in);
	
	public Video(int id, String name, String category, String minimalAge) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.minimalAge = minimalAge;
		this.rating = 0;
		this.ratingIndex = 0;
	}
	
	public void update(String name, String category, String minimalAge) {
		this.name = name;
		this.category = category;
		this.minimalAge = minimalAge;
	}
	
	public void rating(int rating) {
		this.ratingIndex++;
		this.rating += rating;
	}
	
	public double rating() {
		if(this.ratingIndex == 0) {
			return 0;
		}
		return this.rating/this.ratingIndex;
	}
	
	public static String getMinimalAge() {
		String content = "";
		String[] ages = {"ALL", "M6", "M12", "M16", "M18"};
		
		int index = 0;
		for(int i=0;i<ages.length;i++) {
			index = i + 1;
			content += "[" + index + "] " + ages[i] + "\n";
		}
		
		System.out.println(content);
		int id = input.nextInt() - 1;
		input.nextLine();
		
		return ages[id];
	}
	
	public static String getCategory() {
		String content = "";
		String[] categories = {"Acao", "Comedia", "Infantil", "Drama"};
		
		int index = 0;
		for(int i=0;i<categories.length;i++) {
			index = i + 1;
			content += "[" + index + "] " + categories[i] + "\n";
		}
		
		System.out.println(content);
		int idCategory = input.nextInt() - 1;
		input.nextLine();
		
		return categories[idCategory];
	}
	
	public int id() {
		return this.id;
	}
	
	public String name() {
		return this.name;
	}
	
	public String toString() {
		return "id: " + this.id + "\t" + "rating:" + this.rating() + "\t" + this.name + "\t" + this.category + "\t" + this.minimalAge;
	}
	
	
}
