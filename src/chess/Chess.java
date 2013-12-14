package chess;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Chess extends JPanel implements MouseListener {
	Image background;
	
	/** constructors **/
	public Chess() {
		this.background = new ImageIcon("Image/chessboard.jpg").getImage();
		initGame();
		addMouseListener(this);
		this.setMinimumSize(new Dimension(641, 641));
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
		board[0][0] = new piece(new pos(0,0), "tower", true, null);
		board[0][1] = new piece(new pos(0,1), "cheval", true, null);
		board[0][2] = new piece(new pos(0,2), "bishop", true, null);
		board[0][3] = new piece(new pos(0,3), "king", true, null);
		board[0][4] = new piece(new pos(0,4), "queen", true, null);
		board[0][5] = new piece(new pos(0,5), "bishop", true, null);
		board[0][6] = new piece(new pos(0,6), "cheval", true, null);
		board[0][7] = new piece(new pos(0,7), "tower", true, null);
	}
	
	// repaints the widget when an update of any kind is made
	public void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D)g;
			drawPieces(g2d);
			g.drawImage(this.background, 0, 0, null);
		}
	
	private void drawPieces(Graphics2D g2d) {
			// TODO Auto-generated method stub
			
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
		//System.out.print("CLIC:(" + event.getX() + ";" + event.getY() + ")");
		if (event.getButton() == MouseEvent.BUTTON1 && (event.getX() - 48) > 0 && (event.getX() < (44 + 675)) && (event.getY() - 47) > 0 && event.getY() < (682 + 44)) {		// if left button is pressed and the clic is in the board limits
		this.oldx = (event.getX() - 48) / (675 / 8);		// get the X on the board 48
		this.oldy = (event.getY() - 47)/ (682 / 8);		// get the Y on the game board 47
		System.out.print("\nCLIC:(" + oldx + ";" + oldy + ")" + " = " + board[oldy][oldx]);
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/** private fields **/
	piece board[][];
	int oldx, oldy;		// denotes where the player clicked when he pressed the mouse button

}
