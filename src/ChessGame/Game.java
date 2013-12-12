package ChessGame;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import chess.Chess;

public class Game extends JFrame {
	
	/** private fields **/
	Chess		widget;	// where the game is being played
	JPanel		mainPanel;
	JPanel	chat;
	
	/** constructors **/
	public Game() {
		setTitle("Chess");
		setSize(680, 730);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		mainPanel = new JPanel();
		widget = new Chess();
		chat = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(widget);
		JScrollPane scrollPane = new JScrollPane(chat);
		scrollPane.setMaximumSize(new Dimension(50, scrollPane.WIDTH));
		mainPanel.add(scrollPane);
		
		getContentPane().add(mainPanel);
	}
	
	/** public functions **/
	public static void main(String[] args) {
		Game window = new Game();
		window.setVisible(true);
	}
}
