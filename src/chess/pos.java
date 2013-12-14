package chess;

public class pos {
	int	x;
	int	y;

	public pos(int newX, int newY)
	{
		x = newX;
		y = newY;
	}
	
	public int getX()
	{
		return (x);
	}
	
	public int getY()
	{
		return (y);
	}
	
	public pos clone()
	{
		return (new pos(x, y));
	}
}
