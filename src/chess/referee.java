package chess;

import java.util.ArrayList;

public class referee {
	
	public referee()
	{
		
	}
	
	private void			simulMove(piece toMove, piece[][] cloneBoard,  pos newPos)
	{
		int x = toMove.getPos().getX();
		int y = toMove.getPos().getY();

		int newX = newPos.getX();
		int newY = newPos.getY();

		cloneBoard[newX][newY] = new piece(newPos, toMove.getName(), toMove.getPlayer(), toMove.getImage());
		cloneBoard[x][y] = null;
	}
	
	private ArrayList<pos>	getAllPossibleMove(piece[][] cloneBoardTmp, boolean player)
	{
		ArrayList<pos> possiblePos = new ArrayList<pos>();
		
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				if (cloneBoardTmp[i][j] != null && cloneBoardTmp[i][j].getPlayer() == player)
					possiblePos.addAll(this.checkMove(cloneBoardTmp[i][j], cloneBoardTmp, false));
			}
		}
		return (possiblePos);
	}
	
	private pos				getPosKing(piece[][] cloneBoard, boolean player)
	{
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				if (cloneBoard[i][j] != null && cloneBoard[i][j].getPlayer() == player && cloneBoard[i][j].getName() == "king")
					return (cloneBoard[i][j].getPos().clone());
			}
			
		}
		return (null);
	}
	
	public	int					checkMate(piece[][] board, boolean player)
	{
		piece[][] tmp = this.cloneBoard(board);
		int	posibility = 0;
		int checkCase = 0;
		
		if (this.checkMateAfterMove(tmp, player) == false)
		{
			for (int i = 0; i < 8; i++)
			{
				for (int j = 0; j < 8; j++)
				{
					if (tmp[i][j] != null && tmp[i][j].getPlayer() == player)
						{
						if (this.checkMove(tmp[i][j], tmp, true).size() == 0)
							checkCase++;
						posibility++;
						}
				}
			}
		}
		if (checkCase == 0)
			return (0);
		else if (posibility == checkCase)
			return (2);
		else
			return (1);
	}
	
	private boolean				checkMateAfterMove(piece[][] cloneBoard, boolean player)
	{
		pos	king = this.getPosKing(cloneBoard, player);
		ArrayList<pos> EnnemiesPos = this.getAllPossibleMove(cloneBoard, !player);
		boolean checkPos = true;
		
		for (int i = 0; i < EnnemiesPos.size(); i++)
		{
			if (EnnemiesPos.get(i).getX() == king.getX() && EnnemiesPos.get(i).getY() == king.getY())
				checkPos = false;
		}
		return (checkPos);
	}

	public ArrayList<pos> checkMove(piece toMove, piece board[][], boolean checkMate)
	{
		piece	cloneBoard[][] = board;
		ArrayList<ArrayList<pos>> tmp = toMove.checkMove();
		ArrayList<pos> ret;
		
		ret = this.cutView(tmp, cloneBoard, toMove);
		if (checkMate)
			ret = this.cutMate(ret, board.clone(), toMove);
		return ret;
	}

	private piece[][]	cloneBoard(piece[][] board)
	{
		piece[][] tmp = new piece[8][8];
		for (int i = 0; i < board.length; i++)
		{
			tmp[i] = board[i].clone();
		}
		return (tmp);
	}
	
	private ArrayList<pos> cutMate(ArrayList<pos> ret, piece[][] cloneBoard, piece toMove) {
		ArrayList<pos> tmp = new ArrayList<pos>();
		for (int i = 0; i < ret.size();i++)
		{
			piece[][] cloneBoardTmp = this.cloneBoard(cloneBoard);
			this.simulMove(toMove, cloneBoardTmp, ret.get(i));
			if (this.checkMateAfterMove(cloneBoardTmp, toMove.getPlayer()) != false)
				tmp.add(ret.get(i).clone());
		}
		return (tmp);
	}

	private ArrayList<pos> cutView(ArrayList<ArrayList<pos>> possiblePos, piece[][] cloneBoard, piece toMove) {
		ArrayList<pos> posAfterCutView = new ArrayList<pos>();
		
		if (toMove.getName() == "pawn")
		{
			for (int i = 0; i < possiblePos.size(); i++)
			{
				ArrayList<pos> tmp = possiblePos.get(i);
				int j = 0;
				if (tmp.get(j).getX() != toMove.getPos().getX() && cloneBoard[tmp.get(j).getX()][tmp.get(j).getY()] != null && cloneBoard[tmp.get(j).getX()][tmp.get(j).getY()].getPlayer() != toMove.getPlayer())
					{
						posAfterCutView.add(tmp.get(j).clone());
					}
				else if (tmp.get(j).getX() == toMove.getPos().getX())
				{
					while (j < tmp.size() && cloneBoard[tmp.get(j).getX()][tmp.get(j).getY()] == null)
					{
						posAfterCutView.add(tmp.get(j).clone());
						j++;
					}
				}
			}
		}
		else if (toMove.getName() == "knight")
		{
			for (int i = 0; i < possiblePos.size(); i++)
			{
				ArrayList<pos> tmp = possiblePos.get(i);
				for (int j = 0; j < tmp.size(); j++)
				{
					if (cloneBoard[tmp.get(j).getX()][tmp.get(j).getY()] == null || (cloneBoard[tmp.get(j).getX()][tmp.get(j).getY()] != null && cloneBoard[tmp.get(j).getX()][tmp.get(j).getY()].getPlayer() != toMove.getPlayer()))
						posAfterCutView.add(tmp.get(j).clone());
				}
			}
		}
		else
		{
			for (int i = 0; i < possiblePos.size(); i++)
			{
				ArrayList<pos> tmp = possiblePos.get(i);
				int j = 0;
				while (j < tmp.size() && cloneBoard[tmp.get(j).getX()][tmp.get(j).getY()] == null)
				{
					posAfterCutView.add(tmp.get(j).clone());
					j++;
				}
				if (j < tmp.size() && cloneBoard[tmp.get(j).getX()][tmp.get(j).getY()].getPlayer() !=  toMove.getPlayer())
					posAfterCutView.add(tmp.get(j).clone());
			}
		}
		return posAfterCutView;
	}
	
}
