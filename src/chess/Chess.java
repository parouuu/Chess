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
			Graphics2D g2d = (Graphics2D)g;
			drawPieces(g2d);
			g.drawImage(this.background, 0, 0, null);
			drawPieces(g);
			if (!clic)
				printTransparency(g);
			g2d.setFont(new Font("Tahoma", Font.BOLD, 18));		// change font and size of next text draw
			g2d.drawString("Player's turn", 795, 77);
			g2d.drawLine(787, 57, 917, 57);
			g2d.drawLine(787, 84, 917, 84);
			g2d.drawLine(787, 200, 917, 200);
			g2d.drawLine(787, 57, 787, 200);
			g2d.drawLine(917, 57, 917, 200);
			if (player == false)
				g.drawImage(new ImageIcon("Image/BlackPawn.png").getImage(), 812,100, null);
			else
				g.drawImage(new ImageIcon("Image/WhitePawn.png").getImage(), 812,100, null);	
		}
	
	private void drawPieces(Graphics g) {
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				if (board[i][j] != null)
					g.drawImage(board[i][j].getImage(), (i * (675 / 8)) + 48, (j * (682 / 8)) + 47, null);
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

	void printTransparency(Graphics g) {
		if (pl != null) {
			for (pos p : pl)
			{
				//System.out.print("\npos = (" + p.getX() + ";" + p.getY() + ")");
				g.drawImage(transparency, (p.getX() * (675 / 8)) + 50, (p.getY() * (682 / 8)) + 49, null);
			}
		}
	}
	
	private boolean isPosInArray(pos pclic) {
		for (pos p : pl)
		{
			//System.out.print("\nP.getX() = " + p.getX() + "        Pclic.getX() = " + pclic.getX() + "     &&       P.getY() = " + p.getY() + "     Pclic.getY()" + pclic.getY());
			if (p.getX() == pclic.getX() && p.getY() == pclic.getY())
				return (true);
		}
		return (false);
	}
	
	private String pawnChoice() {
		String choices[] = {"rook", "knight", "bishop", "queen"};
		String input = (String)JOptionPane.showInputDialog(this, "Choose your piece", "Promotion !", JOptionPane.QUESTION_MESSAGE, null, choices, choices[3]);
		return input;
	}
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
	
	@Override
	public void mousePressed(MouseEvent event) {
		if (event.getButton() == MouseEvent.BUTTON1 && (event.getX() - 48) > 0 && (event.getX() < (44 + 675)) && (event.getY() - 47) > 0 && event.getY() < (682 + 44)) {		// if left button is pressed and the clic is in the board limits
			this.x = (event.getX() - 48) / (675 / 8);		// get the X on the board 48
			this.y = (event.getY() - 47)/ (682 / 8);			// get the Y on the game board 47
			if (clic && board[x][y] != null && board[x][y].getPlayer() == player ) {
				this.oldx = (event.getX() - 48) / (675 / 8);		// get the X on the board 48
				this.oldy = (event.getY() - 47)/ (682 / 8);			// get the Y on the game board 47
					pl = ref.checkMove(board[oldx][oldy], board.clone(), true);
					clic = !clic;
					System.out.print("\nCLIC:(" + oldx + ";" + oldy + ")" + " = " + board[oldx][oldy].name + " | position piece = " + board[oldx][oldy].getPos().getX() + ":" + board[oldx][oldy].getPos().getY());
				}
			else if (!clic && isPosInArray(new pos(x, y))) {
				board[x][y] = board[oldx][oldy];
				board[oldx][oldy] = null;
				board[x][y].move(new pos(x, y));
				clic = !clic;
				player = !player;
				if (board[x][y].getName() == "pawn" && ((board[x][y].getPlayer() == false && y == 7) || (board[x][y].getPlayer() == true && y == 0))) 
					createPiece(pawnChoice(), board[x][y]);
				repaint();
				int checkState = ref.checkMate(board, player);
				if (checkState == 1)
				JOptionPane.showMessageDialog(this, "Check!!", "Information",
						JOptionPane.INFORMATION_MESSAGE);
				else if (checkState == 2)
				{
					JOptionPane.showMessageDialog(this, "Checkmate!!", "Information",
						JOptionPane.INFORMATION_MESSAGE);
					this.initGame();
				}
				}
			}
		if (!clic && event.getButton() == MouseEvent.BUTTON3)
			clic = !clic;
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/** private fields **/
	piece board[][];
	int oldx, oldy;		// denotes where the player clicked when he pressed the mouse button
	int x, y;
	int oldposx, oldposy;
	Image background, transparency;
	boolean player, clic;
	referee ref;
	ArrayList<pos> pl; // List of possible moves for the last piece clicked
}
