package guiao08;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameWindow implements ActionListener {
	private static JToggleButton[] buttons = new JToggleButton[9];
	private JTextField player1NameField;
	private JTextField player2NameField;
	private JogoDoGalo JogoDoGalo;
	private JLabel currentPlayerName;
	private JButton startButton;
	private JLabel player1Score;
	private JLabel player2Score;
	private boolean gameAlreadyStarted;
	
	public GameWindow() {
		this.gameAlreadyStarted = false;
		
		JFrame frame = new JFrame("Jogo do Galo");						// create main frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,400);
		
		JPanel infoPanel = createInfoPanel();
		JPanel gamePanel = createGamePanel();	
		
		frame.add(infoPanel, BorderLayout.NORTH);				// mix panels on main frame
		frame.add(gamePanel, BorderLayout.CENTER);

		frame.setVisible(true);
	}
	
	private JPanel createGamePanel() {
		JPanel gamePanel = new JPanel();
		gamePanel.setLayout(new GridLayout(3, 3));
		for(int i = 0; i < 9; i++) {
			this.buttons[i] = new JToggleButton();
			this.buttons[i].setFont(new Font("Arial", Font.BOLD, 50));
			this.buttons[i].setEnabled(false);
			buttons[i].addActionListener(this);
			gamePanel.add(this.buttons[i]);
		}		
		return gamePanel;
	}
	
	private JPanel createInfoPanel() {
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new BorderLayout());
		
		// Game name -> middle
		JPanel centerGameNamePanel = new JPanel();
		JLabel gameName = new JLabel("Jogo do galo !!!");
		gameName.setFont(new Font("Arial", Font.ITALIC, 30));
		centerGameNamePanel.add(gameName, BorderLayout.CENTER);
		infoPanel.add(centerGameNamePanel, BorderLayout.NORTH);
		
		// player's names
		JPanel playersNamesPanel = new JPanel();
		playersNamesPanel.setLayout(new BorderLayout());
		JTextField p1 = new JTextField();
		p1.setText("Player 1");
		p1.isEditable();
		JTextField p2 = new JTextField();
		p2.setText("Player 2");
		p2.isEditable();
		player1NameField = p1;
		player2NameField = p2;
		playersNamesPanel.add(p1,BorderLayout.NORTH);
		playersNamesPanel.add(p2,BorderLayout.SOUTH);
		infoPanel.add(playersNamesPanel,BorderLayout.WEST);
		
		
		// Current player holder
		this.currentPlayerName = new JLabel("");
		infoPanel.add(currentPlayerName,BorderLayout.CENTER);
		
		JPanel currentPlayerHolder = new JPanel();
		currentPlayerHolder.setLayout(new BorderLayout());
		this.currentPlayerName = new JLabel("");
		currentPlayerHolder.add(this.currentPlayerName,BorderLayout.CENTER);
		infoPanel.add(currentPlayerHolder,BorderLayout.CENTER);		
		
		// Add start button
		JButton startButton = new JButton("Start");
		this.startButton = startButton;
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!gameAlreadyStarted) {
					JogoDoGalo = new GameEngine(player1NameField.getText(), player2NameField.getText(),'X');		// 'X' or 'O' or nothing for random
					startButton.setEnabled(false);
					player1NameField.setEditable(false);
					player2NameField.setEditable(false);
					gameAlreadyStarted = true;
				}
				
				enableButtons();
				
				// show current Player
				currentPlayerName.setText(JogoDoGalo.getCurrentPlayerName());
				
				// restart buttons
				flushButtons();
				
				// populate scores
				updateScores();
			}
		});
		infoPanel.add(startButton, BorderLayout.EAST);
		
		// add scores
		JPanel scoresBoardPanel = new JPanel();
		scoresBoardPanel.setLayout(new BorderLayout());
		this.player1Score = new JLabel("");
		this.player2Score = new JLabel("");
		scoresBoardPanel.add(this.player1Score, BorderLayout.NORTH);
		scoresBoardPanel.add(this.player2Score, BorderLayout.SOUTH);
		currentPlayerHolder.add(scoresBoardPanel, BorderLayout.EAST);
		
		return infoPanel;
	}
	
	public void updateScores() {
		player1Score.setText(JogoDoGalo.getPlayer1() + ": " + JogoDoGalo.getPlayer1Score());
		player2Score.setText(JogoDoGalo.getPlayer2() + ": " + JogoDoGalo.getPlayer2Score());
	}
	
	public void enableButtons() {
		for(int i=0;i<this.buttons.length;i++) {
			this.buttons[i].setEnabled(true);
		}
	}
	
	public void blockButtons() {
		for(int i=0;i<this.buttons.length;i++) {
			this.buttons[i].setEnabled(false);
		}
	}
	
	public void restartGame() {
		JogoDoGalo.restartGame();
		this.startButton.setEnabled(true);
		enableButtons();
		flushButtons();
		updateScores();
	}
	
	public void flushButtons() {
		for(int i=0;i<buttons.length;i++) {
			buttons[i].setText("");
		}
	}
	
	public void actionPerformed(ActionEvent event) {
		JToggleButton button = (JToggleButton) event.getSource();
		button.setEnabled(false);
		if(button == buttons[0]) {
			JogoDoGalo.play(1,1);
		}else if(button == buttons[1]) {
			JogoDoGalo.play(2,1);
		}else if(button == buttons[2]) {
			JogoDoGalo.play(3,1);
		}else if(button == buttons[3]) {
			JogoDoGalo.play(1,2);
		}else if(button == buttons[4]) {
			JogoDoGalo.play(2,2);
		}else if(button == buttons[5]) {
			JogoDoGalo.play(3,2);
		}else if(button == buttons[6]) {
			JogoDoGalo.play(1,3);
		}else if(button == buttons[7]) {
			JogoDoGalo.play(2,3);
		}else if(button == buttons[8]) {
			JogoDoGalo.play(3,3);
		}
		button.setText(String.valueOf(JogoDoGalo.getLastPlayerChar()));
		if(JogoDoGalo.gameOver()) {
			if(JogoDoGalo.checkIfLastPlayerWon())	
				JOptionPane.showMessageDialog(null,"O jogador " + JogoDoGalo.getLastPlayerName() + " ganhou!");
			else
				JOptionPane.showMessageDialog(null,"Empate!");
			blockButtons();
			restartGame();
		}
		else {
			currentPlayerName.setText(JogoDoGalo.getCurrentPlayerName());
		}
	}
	
}
