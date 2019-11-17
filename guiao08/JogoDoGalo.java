package guiao08;

public interface JogoDoGalo {
	void play(int height, int width);
	void restartGame();
	boolean gameOver();
	boolean checkIfLastPlayerWon();
	
	String getPlayer1();
	String getPlayer2();
	
	char getPlayer1Char();
	char getPlayer2Char();
	
	int getPlayer1Score();
	int getPlayer2Score();
	
	char getLastPlayerChar();
	String getCurrentPlayerName();
	String getLastPlayerName();
}
