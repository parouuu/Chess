package chess;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Chess extends JPanel implements MouseListener {
	
	/** constructors **/
	public Chess() {
		this.background = new ImageIcon("Image/chessboard.jpg").getImage();
		this.transparency = new ImageIcon("Image/transparency.png").getImage();
		initGame();
		addMouseListener(this);
		this.setMinimumSize(new Dimension(641, 641));
		ref = new referee();
	}
	
	private void initGame() {
		board = new piece[8][8];
		for (int i = 2; i < 6; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				board[i][j] = null;
			}
		}
		player = true;
		setPieces();
	}

	private void setPieces() {
		board[0][0] = new piece(new pos(0,0), "rook", false, new ImageIcon("Image/BlackTower.png").getImage());
		board[0][1] = new piece(new pos(0,1), "knight", false, new ImageIcon("Image/BlackHorse.png").getImage());
		board[0][2] = new piece(new pos(0,2), "bishop", false, new ImageIcon("Image/BlackBishop.png").getImage());
		board[0][3] = new piece(new pos(0,3), "king", false, new ImageIcon("Image/BlackKing.png").getImage());
		board[0][4] = new piece(new pos(0,4), "queen", false, new ImageIcon("Image/BlackQueen.png").getImage());
		board[0][5] = new piece(new pos(0,5), "bishop", false, new ImageIcon("Image/BlackBishop.png").getImage());
		board[0][6] = new piece(new pos(0,6), "knight", false, new ImageIcon("Image/BlackHorse.png").getImage());
		board[0][7] = new piece(new pos(0,7), "rook", false, new ImageIcon("Image/BlackTower.png").getImage());
		board[1][0] = new piece(new pos(1,0), "pawn", false, new ImageIcon("Image/BlackPawn.png").getImage());
		board[1][1] = new piece(new pos(1,1), "pawn", false, new ImageIcon("Image/BlackPawn.png").getImage());
		board[1][2] = new piece(new pos(1,2), "pawn", false, new ImageIcon("Image/BlackPawn.png").getImage());
		board[1][3] = new piece(new pos(1,3), "pawn", false, new ImageIcon("Image/BlackPawn.png").getImage());
		board[1][4] = new piece(new pos(1,4), "pawn", false, new ImageIcon("Image/BlackPawn.png").getImage());
		board[1][5] = new piece(new pos(1,5), "pawn", false, new ImageIcon("Image/BlackPawn.png").getImage());
		board[1][6] = new piece(new pos(1,6), "pawn", false, new ImageIcon("Image/BlackPawn.png").getImage());
		board[1][7] = new piece(new pos(1,7), "pawn", false, new ImageIcon("Image/BlackPawn.png").getImage());
		board[7][0] = new piece(new pos(7,0), "rook", true, new ImageIcon("Image/WhiteTower.png").getImage());
		board[7][1] = new piece(new pos(7,1), "knight", true, new ImageIcon("Image/WhiteHorse.png").getImage());
		board[7][2] = new piece(new pos(7,2), "bishop", true, new ImageIcon("Image/WhiteBishop.png").getImage());
		board[7][3] = new piece(new pos(7,3), "queen", true, new ImageIcon("Image/WhiteQueen.png").getImage());
		board[7][4] = new piece(new pos(7,4), "king", true, new ImageIcon("Image/WhiteKing.png").getImage());
		board[7][5] = new piece(new pos(7,5), "bishop", true, new ImageIcon("Image/WhiteBishop.png").getImage());
		board[7][6] = new piece(new pos(7,6), "knight", true, new ImageIcon("Image/WhiteHorse.png").getImage());
		board[7][7] = new piece(new pos(7,7), "rook", true, new ImageIcon("Image/WhiteTower.png").getImage());
		/*board[6][0] = new piece(new pos(6,0), "pawn", true, new ImageIcon("Image/WhitePawn.png").getImage());
		board[6][1] = new piece(new pos(6,1), "pawn", true, new ImageIcon("Image/WhitePawn.png").getImage());
		board[6][2] = new piece(new pos(6,2), "pawn", true, new ImageIcon("Image/WhitePawn.png").getImage());
		board[6][3] = new piece(new pos(6,3), "pawn", true, new ImageIcon("Image/WhitePawn.png").getImage());
		board[6][4] = new piece(new pos(6,4), "pawn", true, new ImageIcon("Image/WhitePawn.png").getImage());
		board[6][5] = new piece(new pos(6,5), "pawn", true, new ImageIcon("Image/WhitePawn.png").getImage());
		board[6][6] = new piece(new pos(6,6), "pawn", true, new ImageIcon("Image/WhitePawn.png").getImage());
		board[6][7] = new piece(new pos(6,7), "pawn", true, new ImageIcon("Image/WhitePawn.png").getImage());*/
	}
	
	// repaints the widget when an update of any kind is made
	public void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D)g;
			drawPieces(g2d);
			g.drawImage(this.background, 0, 0, null);
			drawPieces(g);
			printTransparency(g);
		}
	
	private void drawPieces(Graphics g) {
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				if (board[j][i] != null)
					g.drawImage(board[j][i].getImage(), (i * (675 / 8)) + 48, (j * (682 / 8)) + 47, null);
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
				System.out.print("\npos = (" + p.getX() + ";" + p.getY() + ")");
				g.drawImage(transparency, (p.getY() * (675 / 8)) + 50, (p.getX() * (682 / 8)) + 49, null);
			}
		}
	}
	
	@Override
	public void mousePressed(MouseEvent event) {
		if (event.getButton() == MouseEvent.BUTTON1 && (event.getX() - 48) > 0 && (event.getX() < (44 + 675)) && (event.getY() - 47) > 0 && event.getY() < (682 + 44)) {		// if left button is pressed and the clic is in the board limits
			this.oldx = (event.getX() - 48) / (675 / 8);		// get the X on the board 48
			this.oldy = (event.getY() - 47)/ (682 / 8);		// get the Y on the game board 47
			oldposx = event.getX();
			oldposy = event.getY();
			if (board[oldy][oldx] != null && board[oldy][oldx].getPlayer() == player ) {
					pl = ref.checkMove(board[oldy][oldx], board.clone());
					System.out.print("\nCLIC:(" + oldy + ";" + oldx + ")" + " = " + board[oldy][oldx].name + " | position piece = " + board[oldy][oldx].getPos().getX() + ":" + board[oldy][oldx].getPos().getY());
				}
			}
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/** private fields **/
	piece board[][];
	int oldx, oldy;		// denotes where the player clicked when he pressed the mouse button
	int oldposx, oldposy;
	Image background, transparency;
	boolean player;
	referee ref;
	ArrayList<pos> pl; // List of possible moves for the last piece clicked
}
