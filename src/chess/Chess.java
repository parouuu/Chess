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
		setPieces();
	}

	private void setPieces() {
		board[0][0] = new piece(new pos(0,0), "rook", true, new ImageIcon("Image/BlackTower.png").getImage());
		board[0][1] = new piece(new pos(0,1), "knight", true, new ImageIcon("Image/BlackHorse.png").getImage());
		board[0][2] = new piece(new pos(0,2), "bishop", true, new ImageIcon("Image/BlackBishop.png").getImage());
		board[0][3] = new piece(new pos(0,3), "king", true, new ImageIcon("Image/BlackKing.png").getImage());
		board[0][4] = new piece(new pos(0,4), "queen", true, new ImageIcon("Image/BlackQueen.png").getImage());
		board[0][5] = new piece(new pos(0,5), "bishop", true, new ImageIcon("Image/BlackBishop.png").getImage());
		board[0][6] = new piece(new pos(0,6), "knight", true, new ImageIcon("Image/BlackHorse.png").getImage());
		board[0][7] = new piece(new pos(0,7), "rook", true, new ImageIcon("Image/BlackTower.png").getImage());
		board[1][0] = new piece(new pos(1,0), "pawn", true, new ImageIcon("Image/BlackPawn.png").getImage());
		board[1][1] = new piece(new pos(1,1), "pawn", true, new ImageIcon("Image/BlackPawn.png").getImage());
		board[1][2] = new piece(new pos(1,2), "pawn", true, new ImageIcon("Image/BlackPawn.png").getImage());
		board[1][3] = new piece(new pos(1,3), "pawn", true, new ImageIcon("Image/BlackPawn.png").getImage());
		board[1][4] = new piece(new pos(1,4), "pawn", true, new ImageIcon("Image/BlackPawn.png").getImage());
		board[1][5] = new piece(new pos(1,5), "pawn", true, new ImageIcon("Image/BlackPawn.png").getImage());
		board[1][6] = new piece(new pos(1,6), "pawn", true, new ImageIcon("Image/BlackPawn.png").getImage());
		board[1][7] = new piece(new pos(1,7), "pawn", true, new ImageIcon("Image/BlackPawn.png").getImage());
		board[7][0] = new piece(new pos(7,0), "rook", true, new ImageIcon("Image/WhiteTower.png").getImage());
		board[7][1] = new piece(new pos(7,1), "knight", true, new ImageIcon("Image/WhiteHorse.png").getImage());
		board[7][2] = new piece(new pos(7,2), "bishop", true, new ImageIcon("Image/WhiteBishop.png").getImage());
		board[7][3] = new piece(new pos(7,3), "Queen", true, new ImageIcon("Image/WhiteQueen.png").getImage());
		board[7][4] = new piece(new pos(7,4), "king", true, new ImageIcon("Image/WhiteKing.png").getImage());
		board[7][5] = new piece(new pos(7,5), "bishop", true, new ImageIcon("Image/WhiteBishop.png").getImage());
		board[7][6] = new piece(new pos(7,6), "knight", true, new ImageIcon("Image/WhiteHorse.png").getImage());
		board[7][7] = new piece(new pos(7,7), "rook", true, new ImageIcon("Image/WhiteTower.png").getImage());
		board[6][0] = new piece(new pos(6,0), "pawn", true, new ImageIcon("Image/WhitePawn.png").getImage());
		board[6][1] = new piece(new pos(6,1), "pawn", true, new ImageIcon("Image/WhitePawn.png").getImage());
		board[6][2] = new piece(new pos(6,2), "pawn", true, new ImageIcon("Image/WhitePawn.png").getImage());
		board[6][3] = new piece(new pos(6,3), "pawn", true, new ImageIcon("Image/WhitePawn.png").getImage());
		board[6][4] = new piece(new pos(6,4), "pawn", true, new ImageIcon("Image/WhitePawn.png").getImage());
		board[6][5] = new piece(new pos(6,5), "pawn", true, new ImageIcon("Image/WhitePawn.png").getImage());
		board[6][6] = new piece(new pos(6,6), "pawn", true, new ImageIcon("Image/WhitePawn.png").getImage());
		board[6][7] = new piece(new pos(6,7), "pawn", true, new ImageIcon("Image/WhitePawn.png").getImage());
	}
	
	// repaints the widget when an update of any kind is made
	public void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D)g;
			drawPieces(g2d);
			g.drawImage(this.background, 0, 0, null);
			drawPieces(g);
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

	@Override
	public void mousePressed(MouseEvent event) {
		if (event.getButton() == MouseEvent.BUTTON1 && (event.getX() - 48) > 0 && (event.getX() < (44 + 675)) && (event.getY() - 47) > 0 && event.getY() < (682 + 44)) {		// if left button is pressed and the clic is in the board limits
			this.oldx = (event.getX() - 48) / (675 / 8);		// get the X on the board 48
			this.oldy = (event.getY() - 47)/ (682 / 8);		// get the Y on the game board 47
			oldposx = event.getX();
			oldposy = event.getY();
			if (board[oldy][oldx] != null) {
				ArrayList<pos> poslist = ref.checkMove(board[oldy][oldx], board.clone());
				System.out.print("\nCLIC:(" + oldx + ";" + oldy + ")" + " = " + board[oldy][oldx].name);
				/*for (pos p : poslist)
				    {
						System.out.print("\npos = (" + p.x + ";" + p.y + ")");
				    }*/
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
	Image background;
	referee ref;
}
