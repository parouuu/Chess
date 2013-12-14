package chess;

import java.util.ArrayList;

public class piece {
	
	boolean player;
	pos		position;
	String	name;
	
	public piece(pos newPos, String newName, boolean newPlayer)
	{
		position = newPos.clone();
		name = newName;
		player = newPlayer;
	}

	public void 	move(pos newPos)
	{
		position = newPos.clone();
	}
	
	private	boolean checkBoard(pos checkPos)
	{
		if (checkPos.getX() < 0 || checkPos.getX() > 7)
			return (false);
		if (checkPos.getY() < 0 || checkPos.getY() > 7)
			return (false);
		return (true);
	}
	
	public ArrayList<ArrayList<pos>>	checkMove()
	{
		if (name == "pawns")
			return (checkPawns());
		else if (name == "rooks")
			return (checkRocks());
		else if (name == "knights")
			return (checkKnights());
		else if (name == "bishops")
			return (checkBishops());
		else if (name == "queen")
			return (checkQueen());
		else if (name == "king")
			return (checkKing());
		else
			return (null);
	}

	private ArrayList<ArrayList<pos>> checkKing() {
		// TODO Auto-generated method stub
		return null;
	}

	private ArrayList<ArrayList<pos>> checkQueen() {
		ArrayList<ArrayList<pos>>	tmp = new ArrayList<ArrayList<pos>>();
		for (int i = -1; i <= 1; i++)
		{
			ArrayList<pos> tmpDir = new ArrayList<pos>();
			for (int j = -1; checkBoard(new pos(position.getX()-1, position.getY()+j)); j++)
			{
				tmpDir.add(new pos(position.getX()-1, position.getY()));
			}
			tmp.add(tmpDir);
		}
		return (tmp);
	}

	private ArrayList<ArrayList<pos>> checkBishops() {
		ArrayList<ArrayList<pos>>	tmp = new ArrayList<ArrayList<pos>>();
		ArrayList<pos> tmpDir1 = new ArrayList<pos>();
		for (int i=0, j = 0; checkBoard(new pos(position.getX()+i, position.getY()+j));++i, ++j)
				{
					if (checkBoard(new pos(position.getX()+i, position.getY()+j)))
						tmpDir1.add(new pos(position.getX()+i, position.getY()+j));
				}
		tmp.add(tmpDir1);
		ArrayList<pos> tmpDir2 = new ArrayList<pos>();
		for (int i=0, j = 0; checkBoard(new pos(position.getX()+i, position.getY()+j));--i, ++j)
		{
			if (checkBoard(new pos(position.getX()+i, position.getY()+j)))
				tmpDir2.add(new pos(position.getX()+i, position.getY()+j));
		}
		tmp.add(tmpDir2);
		ArrayList<pos> tmpDir3 = new ArrayList<pos>();
		for (int i=0, j = 0; checkBoard(new pos(position.getX()+i, position.getY()+j));--i, --j)
		{
			if (checkBoard(new pos(position.getX()+i, position.getY()+j)))
				tmpDir3.add(new pos(position.getX()+i, position.getY()+j));
		}
		tmp.add(tmpDir3);
		ArrayList<pos> tmpDir4 = new ArrayList<pos>();
		for (int i=0, j = 0; checkBoard(new pos(position.getX()+i, position.getY()+j));++i, --j)
		{
			if (checkBoard(new pos(position.getX()+i, position.getY()+j)))
				tmpDir4.add(new pos(position.getX()+i, position.getY()+j));
		}
		tmp.add(tmpDir4);
		return tmp;
	}

	private ArrayList<ArrayList<pos>> checkKnights() {
		ArrayList<ArrayList<pos>>	tmp = new ArrayList<ArrayList<pos>>();
		ArrayList<pos> tmpDir1 = new ArrayList<pos>();
		if (checkBoard(new pos(position.getX()-2, position.getY()-1)))
			tmpDir1.add(new pos(position.getX()-2, position.getY()-1));
		if (checkBoard(new pos(position.getX()-2, position.getY()+1)))
			tmpDir1.add(new pos(position.getX()-2, position.getY()+1));
		tmp.add(tmpDir1);
		ArrayList<pos> tmpDir2 = new ArrayList<pos>();
		if (checkBoard(new pos(position.getX()-1, position.getY()-2)))
			tmpDir2.add(new pos(position.getX()-1, position.getY()-2));
		if (checkBoard(new pos(position.getX()+1, position.getY()-2)))
			tmpDir2.add(new pos(position.getX()+1, position.getY()-2));
		tmp.add(tmpDir2);
		ArrayList<pos> tmpDir3 = new ArrayList<pos>();
		if (checkBoard(new pos(position.getX()+2, position.getY()-1)))
			tmpDir3.add(new pos(position.getX()+2, position.getY()-1));
		if (checkBoard(new pos(position.getX()+2, position.getY()+1)))
			tmpDir3.add(new pos(position.getX()+2, position.getY()+1));
		tmp.add(tmpDir3);
		ArrayList<pos> tmpDir4 = new ArrayList<pos>();
		if (checkBoard(new pos(position.getX()-1, position.getY()+2)))
			tmpDir4.add(new pos(position.getX()-1, position.getY()+2));
		if (checkBoard(new pos(position.getX()+1, position.getY()+2)))
			tmpDir4.add(new pos(position.getX()+1, position.getY()+2));
		tmp.add(tmpDir4);
		return null;
	}

	private ArrayList<ArrayList<pos>> checkRocks() {
		ArrayList<ArrayList<pos>>	tmp = new ArrayList<ArrayList<pos>>();
		ArrayList<pos> tmpDir1 = new ArrayList<pos>();
		for (int i=0; checkBoard(new pos(position.getX()+i, position.getY()));++i)
				{
					if (checkBoard(new pos(position.getX()-1, position.getY())))
						tmpDir1.add(new pos(position.getX()-1, position.getY()));
				}
		tmp.add(tmpDir1);
		ArrayList<pos> tmpDir2 = new ArrayList<pos>();
		for (int i=0; checkBoard(new pos(position.getX(), position.getY()+i));++i)
				{
					if (checkBoard(new pos(position.getX(), position.getY()+i)))
						tmpDir2.add(new pos(position.getX(), position.getY()+i));
				}
		tmp.add(tmpDir2);
		ArrayList<pos> tmpDir3 = new ArrayList<pos>();
		for (int i=0; checkBoard(new pos(position.getX()-i, position.getY()));++i)
				{
					if (checkBoard(new pos(position.getX()-i, position.getY())))
						tmpDir3.add(new pos(position.getX()-i, position.getY()));
				}
		tmp.add(tmpDir3);
		ArrayList<pos> tmpDir4 = new ArrayList<pos>();
		for (int i=0; checkBoard(new pos(position.getX(), position.getY()-i));++i)
				{
					if (checkBoard(new pos(position.getX(), position.getY()-i)))
						tmpDir4.add(new pos(position.getX(), position.getY()-i));
				}
		tmp.add(tmpDir4);
		return tmp;
	}

	private ArrayList<ArrayList<pos>> checkPawns() {
		/*
		 * first check to move pawn into the board
		 * Check for the player One or Two
		 * */
		ArrayList<ArrayList<pos>>	tmp = new ArrayList<ArrayList<pos>>();
		if (player)
		{
			for (int j = -1; j <= 1; j++)
			{
				ArrayList<pos> tmpDir = new ArrayList<pos>();
				if (checkBoard(new pos(position.getX()-1, position.getY()+j)))
					tmpDir.add(new pos(position.getX()-1, position.getY()));
				tmp.add(tmpDir);
			}
			return (tmp);
		}
		else
		{
			ArrayList<pos> tmpDir = new ArrayList<pos>();
			for (int j = -1; j <= 1; j++)
			{
				if (checkBoard(new pos(position.getX()+1, position.getY()+j)))
					tmpDir.add(new pos(position.getX()+1, position.getY()));
				tmp.add(tmpDir);
			}
			return (tmp);
		}
	}
	
}
