package ChessGame;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import chess.Chess;

public class Game extends JFrame {
	
	/** private fields **/
	Chess		widget;	// where the game is being played
	JPanel		mainPanel; // Main panel of the app
	
	/** constructors **/
	public Game() {
		setTitle("Chess");	// Set the title of the window
		setSize(950, 821);	// Set default size of window
		setDefaultCloseOperation(EXIT_ON_CLOSE);	// set proper exit operation
		
		mainPanel = new JPanel();	// Create main panel
		widget = new Chess();		// Create the chess panel
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));		//Set panel's layout
		mainPanel.add(widget);		// add the chess panel to main panel
		this.setResizable(false);	// Disable resize on window
		getContentPane().add(mainPanel);	//add mainpanel to frame
	}
	
	/** public functions **/
	public static void main(String[] args) {
		Game window = new Game();	// Create game object
		window.setVisible(true);	// Set the window to visible
	}
}
