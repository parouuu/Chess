package chess;

import java.awt.Image;
import java.util.ArrayList;

public class piece {
	
	boolean player;
	boolean hasMoved;
	pos		position;
	String	name;
	Image	img;
	
	public piece(pos newPos, String newName, boolean newPlayer, Image newImg)
	{
		position = newPos.clone();
		name = newName;
		player = newPlayer;
		img = newImg;
		hasMoved = false;
	}

	public String	getName()
	{
		return (name);
	}
	
	public Image 	getImage() {
		return (img);
	}
	
	public boolean	getPlayer()
	{
		return (player);
	}
	
	public	pos		getPos()
	{
		return (position.clone());
	}
	
	public void 	move(pos newPos)
	{
		position = newPos.clone();
		hasMoved = true;
	}
	
	private	boolean checkBoard(pos checkPos)
	{
		if (checkPos.getX() < 0 || checkPos.getX() > 7)
			return (false);
		if (checkPos.getY() < 0 || checkPos.getY() > 7)
			return (false);
		return (true);
	}
	
	/*
	 * return all moves of the piece
	 * */
	public ArrayList<ArrayList<pos>>	checkMove()
	{
		if (name == "pawn")
			return (checkPawns());
		else if (name == "rook")
			return (checkRocks());
		else if (name == "knight")
			return (checkKnights());
		else if (name == "bishop")
			return (checkBishops());
		else if (name == "queen")
			return (checkQueen());
		else if (name == "king")
			return (checkKing());
		else
			return (null);
	}

	/*
	 * return all moves of the piece if it's a king
	 * */
	private ArrayList<ArrayList<pos>> checkKing() {
		ArrayList<ArrayList<pos>>	tmp = new ArrayList<ArrayList<pos>>();
		for (int i = -1; i <= 1; i++)
		{
			for (int j = -1; j <= 1; j++)
			{
				if (i == 0 && j == 0)
				{}
				else if (checkBoard(new pos(position.getX()+i, position.getY()+j)))
					{
						ArrayList<pos> tmpDir = new ArrayList<pos>();
						tmpDir.add(new pos(position.getX()+i, position.getY()+j));
						if (tmpDir.size() > 0)
							tmp.add(tmpDir);
					}
			}
		}
		return (tmp);
	}

	/*
	 * return all moves of the piece if it's a Queen
	 * */
	private ArrayList<ArrayList<pos>> checkQueen() {
		ArrayList<ArrayList<pos>>	tmp = new ArrayList<ArrayList<pos>>();
		
		tmp.addAll(checkRocks());
		tmp.addAll(checkBishops());
		return (tmp);
	}

	/*
	 * return all moves of the piece if it's a bishop
	 * */
	private ArrayList<ArrayList<pos>> checkBishops() {
		ArrayList<ArrayList<pos>>	tmp = new ArrayList<ArrayList<pos>>();
		ArrayList<pos> tmpDir1 = new ArrayList<pos>();
		for (int i=1, j = 1; checkBoard(new pos(position.getX()+i, position.getY()+j));i++, j++)
				{
						tmpDir1.add(new pos(position.getX()+i, position.getY()+j));
				}
		if (tmpDir1.size() > 0)
			tmp.add(tmpDir1);
		ArrayList<pos> tmpDir2 = new ArrayList<pos>();
		for (int i=-1, j = 1; checkBoard(new pos(position.getX()+i, position.getY()+j));i--, j++)
		{
				tmpDir2.add(new pos(position.getX()+i, position.getY()+j));
		}
		if (tmpDir2.size() > 0)
			tmp.add(tmpDir2);
		ArrayList<pos> tmpDir3 = new ArrayList<pos>();
		for (int i=-1, j = -1; checkBoard(new pos(position.getX()+i, position.getY()+j));i--, j--)
		{
				tmpDir3.add(new pos(position.getX()+i, position.getY()+j));
		}
		if (tmpDir3.size() > 0)
			tmp.add(tmpDir3);
		ArrayList<pos> tmpDir4 = new ArrayList<pos>();
		for (int i=1, j = -1; checkBoard(new pos(position.getX()+i, position.getY()+j));i++, j--)
		{
				tmpDir4.add(new pos(position.getX()+i, position.getY()+j));
		}
		if (tmpDir4.size() > 0)
			tmp.add(tmpDir4);
		return tmp;
	}

	/*
	 * return all moves of the piece if it's a knight
	 * */
	private ArrayList<ArrayList<pos>> checkKnights() {
		ArrayList<ArrayList<pos>>	tmp = new ArrayList<ArrayList<pos>>();
		ArrayList<pos> tmpDir1 = new ArrayList<pos>();
		if (checkBoard(new pos(position.getX()-2, position.getY()-1)))
			tmpDir1.add(new pos(position.getX()-2, position.getY()-1));
		if (checkBoard(new pos(position.getX()-2, position.getY()+1)))
			tmpDir1.add(new pos(position.getX()-2, position.getY()+1));
		if (tmpDir1.size() > 0)
			tmp.add(tmpDir1);
		ArrayList<pos> tmpDir2 = new ArrayList<pos>();
		if (checkBoard(new pos(position.getX()-1, position.getY()-2)))
			tmpDir2.add(new pos(position.getX()-1, position.getY()-2));
		if (checkBoard(new pos(position.getX()+1, position.getY()-2)))
			tmpDir2.add(new pos(position.getX()+1, position.getY()-2));
		if (tmpDir2.size() > 0)
			tmp.add(tmpDir2);
		ArrayList<pos> tmpDir3 = new ArrayList<pos>();
		if (checkBoard(new pos(position.getX()+2, position.getY()-1)))
			tmpDir3.add(new pos(position.getX()+2, position.getY()-1));
		if (checkBoard(new pos(position.getX()+2, position.getY()+1)))
			tmpDir3.add(new pos(position.getX()+2, position.getY()+1));
		if (tmpDir3.size() > 0)
			tmp.add(tmpDir3);
		ArrayList<pos> tmpDir4 = new ArrayList<pos>();
		if (checkBoard(new pos(position.getX()-1, position.getY()+2)))
			tmpDir4.add(new pos(position.getX()-1, position.getY()+2));
		if (checkBoard(new pos(position.getX()+1, position.getY()+2)))
			tmpDir4.add(new pos(position.getX()+1, position.getY()+2));
		if (tmpDir4.size() > 0)
			tmp.add(tmpDir4);
		return tmp;
	}

	/*
	 * return all moves of the piece if it's a rock
	 * */
	private ArrayList<ArrayList<pos>> checkRocks() {
		ArrayList<ArrayList<pos>>	tmp = new ArrayList<ArrayList<pos>>();
		ArrayList<pos> tmpDir1 = new ArrayList<pos>();
		for (int i=1; checkBoard(new pos(position.getX()+i, position.getY()));i++)
				{
					tmpDir1.add(new pos(position.getX()+i, position.getY()));
				}
		if (tmpDir1.size() > 0)
			tmp.add(tmpDir1);
		ArrayList<pos> tmpDir2 = new ArrayList<pos>();
		for (int i=1; checkBoard(new pos(position.getX(), position.getY()+i));i++)
				{
					tmpDir2.add(new pos(position.getX(), position.getY()+i));
				}
		if (tmpDir2.size() > 0)
			tmp.add(tmpDir2);
		ArrayList<pos> tmpDir3 = new ArrayList<pos>();
		for (int i=1; checkBoard(new pos(position.getX()-i, position.getY()));i++)
				{
					tmpDir3.add(new pos(position.getX()-i, position.getY()));
				}
		if (tmpDir3.size() > 0)
			tmp.add(tmpDir3);
		ArrayList<pos> tmpDir4 = new ArrayList<pos>();
		for (int i=1; checkBoard(new pos(position.getX(), position.getY()-i));i++)
				{
					tmpDir4.add(new pos(position.getX(), position.getY()-i));
				}
		if (tmpDir4.size() > 0)
			tmp.add(tmpDir4);
		return tmp;
	}

	/*
	 * return all moves of the piece if it's a pawn
	 * */
	private ArrayList<ArrayList<pos>> checkPawns() {
		/*
		 * first check to move pawn into the board
		 * Check for the player One or Two
		 * */
		int j = -1;
		if (!player)
			j = 1;
			
		ArrayList<ArrayList<pos>>	tmp = new ArrayList<ArrayList<pos>>();
		for (int i = -1; i <= 1; i++)
			{
				ArrayList<pos> tmpDir = new ArrayList<pos>();
				if (checkBoard(new pos(position.getX()+i, position.getY()+j)))
					tmpDir.add(new pos(position.getX()+i, position.getY()+j));
				if (hasMoved == false && checkBoard(new pos(position.getX()+i, position.getY()+j+j)))
					tmpDir.add(new pos(position.getX()+i, position.getY()+j+j));
				if (tmpDir.size() > 0)
					tmp.add(tmpDir);
			}
		return (tmp);
	}
	
}
