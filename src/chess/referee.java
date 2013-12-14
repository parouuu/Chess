package chess;

import java.util.ArrayList;

public class referee {
	
	public referee()
	{
		
	}

	public ArrayList<pos> checkMove(piece toMove, piece board[][])
	{
		piece	cloneBoard[][] = board.clone();
		ArrayList<ArrayList<pos>> tmp = toMove.checkMove();
		ArrayList<pos> ret;
		
		ret = this.cutView(tmp, cloneBoard);
		this.cutMate(ret, cloneBoard);
		return ret;
	}

	private void cutMate(ArrayList<pos> ret, piece[][] cloneBoard) {
		// TODO Auto-generated method stub
		
	}

	private ArrayList<pos> cutView(ArrayList<ArrayList<pos>> tmp, piece[][] cloneBoard) {
		
		return null;
	}
	
}
