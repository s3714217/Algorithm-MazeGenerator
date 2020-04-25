package mazeGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import maze.Cell;
import maze.Maze;

public class HuntAndKillGenerator implements MazeGenerator {

	List<Cell> visited = new ArrayList<Cell>();
	List<Cell> unvisited = new ArrayList<Cell>();
	Cell checkingCell = new Cell();
	Random rand = new Random();
	private Set<ArrayList<Cell>> SetTree = new HashSet<ArrayList<Cell>>();
	@Override
	public void generateMaze(Maze maze) {
		
		for (int x =0; x < maze.sizeR; x++)
		{
			for (int y = 0; y < maze.sizeC; y++)
			{
				Cell tempCell = maze.map[x][y];
			if(x < maze.sizeR-1) {
				tempCell.neigh[0] = maze.map[x+1][y];
				}
			if(y < maze.sizeC-1) {
				tempCell.neigh[2] = maze.map[x][y+1];
				}
			if(x >0) {
				tempCell.neigh[3] = maze.map[x-1][y];
				}
			if(y >0) {
				tempCell.neigh[5] = maze.map[x][y-1];
				}
				this.unvisited.add(tempCell);
			if(this.unvisited.contains(maze.entrance) == true)
				{
					this.checkingCell = maze.entrance;
				}
			}
		}
		//Test
		visited.add(checkingCell);
		unvisited.remove(checkingCell);
		
		while (this.unvisited.size() > 0)
		{
			
			
		Cell randNeigh = this.randomPickNeigh(this.checkingCell);	
		if(randNeigh != null)
		{
			
			if(unvisited.contains(randNeigh) == true)
			{
				this.checkingCell = this.carving(checkingCell, randNeigh);
				this.checkingCell = randNeigh;
				visited.add(checkingCell);
				unvisited.remove(checkingCell);
			}
			
		}
		else
		{
			if(this.HuntMode(maze) != null)
			{
				this.checkingCell = this.HuntMode(maze);
				visited.add(checkingCell);
				unvisited.remove(checkingCell);
				
			}
			else
			{
				visited.add(checkingCell);
				unvisited.remove(checkingCell);
				break;
				
		   }
		}
		
		}
		

	} 
	
	private Cell carving(Cell originC, Cell neighC)
	{
		
		if(originC.neigh[0] == neighC)
		{
			originC.wall[3].present = false;
		}
		else if(originC.neigh[2] == neighC)
		{
			originC.wall[5].present = false;
		}
		else if(originC.neigh[3] == neighC)
		{
			originC.wall[0].present = false;
		}
		else if(originC.neigh[5] == neighC)
		{
			originC.wall[2].present = false;
		}
		
		return originC;
	}
	
	public Cell randomPickNeigh(Cell cell)
	{	
		ArrayList<Integer> shuffleBag = new ArrayList<Integer>();
		
		if(unvisited.contains(cell.neigh[0]) == true)
		{
			shuffleBag.add(0);
		}
		if(unvisited.contains(cell.neigh[2]) == true)
		{
			shuffleBag.add(2);
		}
		if(unvisited.contains(cell.neigh[3]) == true)
		{
			shuffleBag.add(3);
		}
		if(unvisited.contains(cell.neigh[5]) == true)
		{
			shuffleBag.add(5);
		}
		
		if(shuffleBag.size() > 0)
		{
			Collections.shuffle(shuffleBag);
			return cell.neigh[shuffleBag.get(0)];
		}
		else
		{
			return null;
		}
		
		
		
	}
	
	public Cell HuntMode(Maze maze)
	{
		Cell returnCell = new Cell();
		for (int x =0; x < maze.sizeR; x++)
		{
			for (int y = 0; y < maze.sizeC; y++)
			{
				if(visited.contains(maze.map[x][y]) == true);
				{
					if(unvisited.contains(maze.map[x][y].neigh[0]) == true)
					{
						returnCell = maze.map[x][y].neigh[0];
						break;
					}
					else if(unvisited.contains(maze.map[x][y].neigh[3]) == true)
					{
						returnCell = maze.map[x][y].neigh[3];
						break;
					}
					else if(unvisited.contains(maze.map[x][y].neigh[5]) == true)
					{
						returnCell = maze.map[x][y].neigh[5];
						break;
					}
					else if(unvisited.contains(maze.map[x][y].neigh[2]) == true)
					{
						returnCell = maze.map[x][y].neigh[2];
						break;
					}
				}
			}
		}
		
		return returnCell;
	}
	
} // end of class HuntAndKillGenerator
