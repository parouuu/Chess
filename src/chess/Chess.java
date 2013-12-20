package chess;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Chess extends JPanel implements MouseListener {
	
	/** constructors **/
	public Chess() {
		this.background = new ImageIcon("Image/chessboard.jpg").getImage(); 	// Save background's image
		this.transparency = new ImageIcon("Image/transparency.png").getImage();	// Save Transparency's image
		initGame();		// Initialize the game
		addMouseListener(this);	// Add a mouse listener to this
		this.setMinimumSize(new Dimension(641, 641));	// Set a minimum size to panel
		ref = new referee();		// Create a referee
	}
	
	// Initialize the game
	private void initGame() {
		board = new piece[8][8];		//Create the board
		player = true;		// Set the first player to act
		clic = true;		// Set the state of player's clic (if the player already made a valide clic, clic becomes false)
		setPieces();		// Create and set pieces on the board
	}

	// Create all the default pieces and set them in the board
	private void setPieces() {
		board[0][0] = new piece(new pos(0,0), "rook", false, new ImageIcon("Image/BlackTower.png").getImage());
		board[1][0] = new piece(new pos(1,0), "knight", false, new ImageIcon("Image/BlackHorse.png").getImage());
		board[2][0] = new piece(new pos(2,0), "bishop", false, new ImageIcon("Image/BlackBishop.png").getImage());
		board[3][0] = new piece(new pos(3,0), "king", false, new ImageIcon("Image/BlackKing.png").getImage());
		board[4][0] = new piece(new pos(4,0), "queen", false, new ImageIcon("Image/BlackQueen.png").getImage());
		board[5][0] = new piece(new pos(5,0), "bishop", false, new ImageIcon("Image/BlackBishop.png").getImage());
		board[6][0] = new piece(new pos(6,0), "knight", false, new ImageIcon("Image/BlackHorse.png").getImage());
		board[7][0] = new piece(new pos(7,0), "rook", false, new ImageIcon("Image/BlackTower.png").getImage());
		board[0][1] = new piece(new pos(0,1), "pawn", false, new ImageIcon("Image/BlackPawn.png").getImage());
		board[1][1] = new piece(new pos(1,1), "pawn", false, new ImageIcon("Image/BlackPawn.png").getImage());
		board[2][1] = new piece(new pos(2,1), "pawn", false, new ImageIcon("Image/BlackPawn.png").getImage());
		board[3][1] = new piece(new pos(3,1), "pawn", false, new ImageIcon("Image/BlackPawn.png").getImage());
		board[4][1] = new piece(new pos(4,1), "pawn", false, new ImageIcon("Image/BlackPawn.png").getImage());
		board[5][1] = new piece(new pos(5,1), "pawn", false, new ImageIcon("Image/BlackPawn.png").getImage());
		board[6][1] = new piece(new pos(6,1), "pawn", false, new ImageIcon("Image/BlackPawn.png").getImage());
		board[7][1] = new piece(new pos(7,1), "pawn", false, new ImageIcon("Image/BlackPawn.png").getImage());
		board[0][7] = new piece(new pos(0,7), "rook", true, new ImageIcon("Image/WhiteTower.png").getImage());
		board[1][7] = new piece(new pos(1,7), "knight", true, new ImageIcon("Image/WhiteHorse.png").getImage());
		board[2][7] = new piece(new pos(2,7), "bishop", true, new ImageIcon("Image/WhiteBishop.png").getImage());
		board[3][7] = new piece(new pos(3,7), "queen", true, new ImageIcon("Image/WhiteQueen.png").getImage());
		board[4][7] = new piece(new pos(4,7), "king", true, new ImageIcon("Image/WhiteKing.png").getImage());
		board[5][7] = new piece(new pos(5,7), "bishop", true, new ImageIcon("Image/WhiteBishop.png").getImage());
		board[6][7] = new piece(new pos(6,7), "knight", true, new ImageIcon("Image/WhiteHorse.png").getImage());
		board[7][7] = new piece(new pos(7,7), "rook", true, new ImageIcon("Image/WhiteTower.png").getImage());
		board[0][6] = new piece(new pos(0,6), "pawn", true, new ImageIcon("Image/WhitePawn.png").getImage());
		board[1][6] = new piece(new pos(1,6), "pawn", true, new ImageIcon("Image/WhitePawn.png").getImage());
		board[2][6] = new piece(new pos(2,6), "pawn", true, new ImageIcon("Image/WhitePawn.png").getImage());
		board[3][6] = new piece(new pos(3,6), "pawn", true, new ImageIcon("Image/WhitePawn.png").getImage());
		board[4][6] = new piece(new pos(4,6), "pawn", true, new ImageIcon("Image/WhitePawn.png").getImage());
		board[5][6] = new piece(new pos(5,6), "pawn", true, new ImageIcon("Image/WhitePawn.png").getImage());
		board[6][6] = new piece(new pos(6,6), "pawn", true, new ImageIcon("Image/WhitePawn.png").getImage());
		board[7][6] = new piece(new pos(7,6), "pawn", true, new ImageIcon("Image/WhitePawn.png").getImage());
	}
	
	// repaints the widget when an update of any kind is made
	public void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D)g;  //cast Graphics into Graphics2D
			g.drawImage(this.background, 0, 0, null);	// draw background
			drawPieces(g);		
			if (!clic)		// if this is the first valid clic of a player this turn
				printTransparency(g);
			g2d.setFont(new Font("Tahoma", Font.BOLD, 18));		// change font and size of next text draw
			g2d.drawString("Player's turn", 795, 77);	// write player's turn on the top right 
			g2d.drawLine(787, 57, 917, 57);		//draw lines next to player's turn
			g2d.drawLine(787, 84, 917, 84);
			g2d.drawLine(787, 200, 917, 200);
			g2d.drawLine(787, 57, 787, 200);
			g2d.drawLine(917, 57, 917, 200);
			if (player == false)	//if player 1's turn
				g.drawImage(new ImageIcon("Image/BlackPawn.png").getImage(), 812,100, null);
			else	// if player 2's turn
				g.drawImage(new ImageIcon("Image/WhitePawn.png").getImage(), 812,100, null);	
		}
	
	// Draw all the pieces
	private void drawPieces(Graphics g) {
		for (int i = 0; i < 8; i++) // Go through every cell and draw pieces
		{
			for (int j = 0; j < 8; j++)
			{
				if (board[i][j] != null) // if there is a piece
					g.drawImage(board[i][j].getImage(), (i * (675 / 8)) + 48, (j * (682 / 8)) + 47, null); // draw piece
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	//print possible move choices for a piece
	void printTransparency(Graphics g) {
		if (pl != null) {	//  if there is at least one possible choice
			for (pos p : pl)	// go through every possible choice and print them by transparency
				g.drawImage(transparency, (p.getX() * (675 / 8)) + 50, (p.getY() * (682 / 8)) + 49, null);
		}
	}
	
	// check is the desired move is possible by going through the "possible moves" array
	private boolean isPosInArray(pos pclic) {
		for (pos p : pl)
			if (p.getX() == pclic.getX() && p.getY() == pclic.getY())
				return (true); // return true is pclic is a valid move
		return (false);
	}
	
	// pop up with dropdown menu to choose which piece we want to transform the pawn into
	private String pawnChoice() {
		String choices[] = {"rook", "knight", "bishop", "queen"}; // different type of pieces available
		String input = (String)JOptionPane.showInputDialog(this, "Choose your piece", "Promotion !", JOptionPane.QUESTION_MESSAGE, null, choices, choices[3]); // display the pop up and return the result
		return input;
	}
	
	// transform the pawn into the player's desired piece
	private void createPiece(String name, piece p) {
		if (name == "rook") {
			p.name = "rook";
			if (p.getPlayer() == false)
				p.img = new ImageIcon("Image/BlackTower.png").getImage();
			else
				p.img = new ImageIcon("Image/WhiteTower.png").getImage();
		}
		else if (name == "knight") {
			p.name = "knight";
			if (p.getPlayer() == false)
				p.img = new ImageIcon("Image/BlackHorse.png").getImage();
			else
				p.img = new ImageIcon("Image/WhiteHorse.png").getImage();
				
		}
		else if (name == "bishop") {
			p.name = "bishop";
			if (p.getPlayer() == false)
				p.img = new ImageIcon("Image/BlackBishop.png").getImage();
			else
				p.img = new ImageIcon("Image/WhiteBishop.png").getImage();
		}
		else if (name == "queen") {
			p.name = "queen";
			if (p.getPlayer() == false)
				p.img = new ImageIcon("Image/BlackQueen.png").getImage();
			else
				p.img = new ImageIcon("Image/WhiteQueen.png").getImage();
				
		}
	}
	
	// the game loop, depends on the player's clics
	@Override
	public void mousePressed(MouseEvent event) {
		if (event.getButton() == MouseEvent.BUTTON1 && (event.getX() - 48) > 0 && (event.getX() < (44 + 675)) && (event.getY() - 47) > 0 && event.getY() < (682 + 44)) {		// if left button is pressed and the clic is in the board limits
			this.x = (event.getX() - 48) / (675 / 8);		// get the X on the board 48
			this.y = (event.getY() - 47)/ (682 / 8);			// get the Y on the game board 47
			if (clic && board[x][y] != null && board[x][y].getPlayer() == player ) { // if the player clicked on one of his pieces
				this.oldx = (event.getX() - 48) / (675 / 8);		// get the X on the board 48
				this.oldy = (event.getY() - 47)/ (682 / 8);			// get the Y on the game board 47
					pl = ref.checkMove(board[oldx][oldy], board.clone(), true); // get an array filled with the possible moves for this piece
					clic = !clic;	// means that the player already made a valid clic, the program now waits for the second clic, which should be a move
				}
			else if (!clic && isPosInArray(new pos(x, y))) { // if this is the second clic and this clic is valid
				board[x][y] = board[oldx][oldy];	//move the piece
				board[oldx][oldy] = null; // empty the old cell
				board[x][y].move(new pos(x, y)); // update the piece X;Y informations
				clic = !clic;	// means that the program is now waiting for the other player to clic on one of his units
				player = !player; // change the current player's turn
				if (board[x][y].getName() == "pawn" && ((board[x][y].getPlayer() == false && y == 7) || (board[x][y].getPlayer() == true && y == 0))) // if a pawn reaches the end of the board, he can transform into an other piece
					createPiece(pawnChoice(), board[x][y]);
				repaint(); // redraw the board
				int checkState = ref.checkMate(board, player);
				if (checkState == 1) // if there is a check
				JOptionPane.showMessageDialog(this, "Check!!", "Information",
						JOptionPane.INFORMATION_MESSAGE);
				else if (checkState == 2) // if there is a checkmate
					{
						JOptionPane.showMessageDialog(this, "Checkmate!!", "Information",
							JOptionPane.INFORMATION_MESSAGE);
						this.initGame();
					}
				}
			}
		if (!clic && event.getButton() == MouseEvent.BUTTON3) // if right clic, cancel the player's first clic
			clic = !clic;
		repaint(); // redraw the board
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/** private fields **/
	piece board[][];	// saves the board
	int oldx, oldy;		// denotes where the player clicked when he pressed the mouse button
	int x, y;			// used to get mouse clic infos
	int oldposx, oldposy;	// used to get old mouse clic infos
	Image background, transparency;		// Background image and transparency image
	boolean player, clic;		//  denotes which player's turn is it and what the program expects him to do (clic state)
	referee ref; // check possible moves for a unit & check & checkmate
	ArrayList<pos> pl; // List of possible moves for the last piece clicked
}
