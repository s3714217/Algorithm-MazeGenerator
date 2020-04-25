package mazeGenerator;

import maze.Cell;

public class Edge 
{
	public Cell firstCell = null;
	public Cell secondCell = null;
	
	public Edge (Cell firstCell, Cell secondCell)
	{
		this.firstCell = firstCell;
		this.secondCell = secondCell;
		
	}
	
	public boolean isEqual(Cell cell1, Cell cell2)
	{
		if(cell1 == this.firstCell)
		{
			if(cell2 == this.secondCell)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if(cell2 == this.firstCell)
		{
			if(cell1 == this.secondCell)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	

}
