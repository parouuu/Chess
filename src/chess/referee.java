package chess;

import java.util.ArrayList;

public class referee {
	
	public referee()
	{
		
	}

	public ArrayList<pos> checkMove(piece toMove, piece board[][])
	{
		piece	cloneBoard[][] = board;
		ArrayList<ArrayList<pos>> tmp = toMove.checkMove();
		ArrayList<pos> ret;
		
		ret = this.cutView(tmp, cloneBoard, toMove);
		this.cutMate(ret, cloneBoard);
		return ret;
	}

	private void cutMate(ArrayList<pos> ret, piece[][] cloneBoard) {
		// TODO Auto-generated method stub
		
	}

	private ArrayList<pos> cutView(ArrayList<ArrayList<pos>> possiblePos, piece[][] cloneBoard, piece toMove) {
		ArrayList<pos> posAfterCutView = new ArrayList<pos>();
		
		if (toMove.getName() == "pawn")
		{
			for (int i = 0; i < possiblePos.size(); i++)
			{
				ArrayList<pos> tmp = possiblePos.get(i);
				int j = 0;
				//System.out.print("test pion : " + tmp.get(j).getX() + "" + tmp.get(j).getY() + "\n");
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
					System.out.print("test : " + tmp.get(j).getX() + ":"+ tmp.get(j).getY() +"\n");
					j++;
				}
				if (j < tmp.size() && cloneBoard[tmp.get(j).getX()][tmp.get(j).getY()].getPlayer() !=  toMove.getPlayer())
					posAfterCutView.add(tmp.get(j).clone());
			}
		}
		return posAfterCutView;
	}
	
}
