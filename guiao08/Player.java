package guiao08;

public class Player {
	public String name;
	public char playerChar;
	public int index;
	public int score;
	
	public Player(String name, char sign, int index) {
		this.name = name;
		this.playerChar = sign;
		this.index = index;
		this.score = 0;
	}
	
	public Player(String name) {
		this(name, 'X', 1);
	}
	
}
