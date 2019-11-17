package guiao08;

public class GameEngine implements JogoDoGalo {
	private final static char[] possibleCharValues = {'X','O'};
	private GameGrid grid;
	private int currentPlayer;
	private Player player1;
	private Player player2;
	
	public GameEngine(String player1, String player2) {
		this(player1, player2, possibleCharValues[(int) Math.random()]);		// default is 'X'
	}
	
	public GameEngine(String player1, String player2, char c) {
		if(c != possibleCharValues[0] && c != possibleCharValues[1]) {
			System.out.println("Erro com o valor dos chars (construtor do game engine)");
			System.exit(0);
		}
		this.player1 = new Player(player1);
		this.player2 = new Player(player2);
		
		this.grid = new GameGrid(3,3);
		if(Math.random()>0.5) {
			this.currentPlayer = 1;
			this.player1.playerChar = c;
			this.player2.playerChar = getOtherPlayerChar(c);
		}
		else {
			this.currentPlayer = 2;
			this.player2.playerChar = c;
			this.player1.playerChar = getOtherPlayerChar(c);
		}		
	}
	
	public boolean gameOver() {
		return this.grid.checkIfEnded();
	}
	
	public boolean checkIfLastPlayerWon() {
		if(this.grid.checkIfLastPlayerWon()) {
			if(getLastPlayerName().compareTo(this.player1.name)==0) {
				this.player1.score++;
			}
			else {
				this.player2.score++;
			}
		}
		return this.grid.checkIfLastPlayerWon();
	}
	
	private int getNextPlayer() {
		if(this.currentPlayer == 1) {
			return 2;
		}
		return 1;
	}
	
	public void play(int height, int width) {
		this.grid.mark(height, width, this.currentPlayer);
		this.currentPlayer = getNextPlayer();
	}
	
	public void restartGame() {
		this.grid.refresh();
	}
	
	public String getCurrentPlayerName() {
		if(this.currentPlayer == 1) {
			return this.player1.name;
		}
		return this.player2.name;
	}
	
	public String getLastPlayerName() {
		if(this.currentPlayer == 2) {
			return this.player1.name;
		}
		return this.player2.name;
	}
	
	private int getOtherPlayer() {
		if(this.currentPlayer == 1) {
			return 2;
		}
		return 1;
	}
	
	public char getLastPlayerChar() {
		if(getCurrentPlayerName().compareTo(this.player1.name)!=0) {
			return this.player1.playerChar;
		}
		return this.player2.playerChar;
	}
	
	public char getOtherPlayerChar(char c) {
		if(Character.toString(possibleCharValues[0]).equals(Character.toString(c))) {
			return possibleCharValues[1];
		}
		return possibleCharValues[0];
	}
	
	public char getPlayer1Char() {return this.player1.playerChar;};
	public char getPlayer2Char() {return this.player2.playerChar;};
	public int getPlayer1Score() {return this.player1.score;};
	public int getPlayer2Score() {return this.player2.score;};
	public String getPlayer1() {return this.player1.name;}
	public String getPlayer2() {return this.player2.name;}

}
