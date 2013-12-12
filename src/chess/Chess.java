package chess;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Chess extends JPanel implements MouseListener {

	/** constructors **/
	public Chess() {
		initGame();
		addMouseListener(this);
		this.setMinimumSize(new Dimension(641, 641));
		
	}
	
	private void initGame() {
		board = new piece[8][8];
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				board[i][j] = null;
			}
		}
		
	}

	// repaints the widget when an update of any kind is made
	public void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D)g;
			drawGrid(g2d);
			drawPieces(g2d);
		}
	
	private void drawPieces(Graphics2D g2d) {
			// TODO Auto-generated method stub
			
		}

	private void drawGrid(Graphics2D g2d) {
		g2d.setColor(Color.BLACK);
		int x = 0;
		int y = 0;
		while (x <= 640)
		{
			g2d.drawLine(x, y, x, y + 640);
			x = x + 80;
		}
		x = 0;
		while (y <= 640)
		{
			g2d.drawLine(x, y, x + 640, y);
			y = y + 80;
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
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/** private fields **/
	piece board[][];

}
