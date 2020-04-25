package mazeGenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import maze.Cell;
import maze.Maze;


public class KruskalGenerator implements MazeGenerator {

	
	@Override
	public void generateMaze(Maze maze) {
		
		this.GeneratorInitializer(maze);
		
		while(unvisited.size() != 0)
		{
			this.checkingCell = this.unvisited.get(rand.nextInt(this.unvisited.size()));
			TreeSet<Cell> treeSet = new TreeSet<Cell>();
			treeSet.add(this.checkingCell);
			this.unvisited.remove(this.checkingCell);
			if(this.randomPickNeigh(checkingCell, maze) != null)
			{
				Cell TempN = this.randomPickNeigh(checkingCell, maze);
				treeSet.add(TempN);
				this.unvisited.remove(TempN);
				this.carvingTo(this.checkingCell, TempN);
			}
			
			SetList.add(treeSet);
		}
		
		
		
		
			
			
		
		
		
	} 
	private Cell carvingTo(Cell originC, Cell neighC)
	{
		for(int x = 0; x < originC.wall.length; x++)
		{
			
			if(originC.neigh[x] != null)
			{
			
					if(originC.neigh[x] == neighC)
					{	
						
						 originC.wall[x].present = false;break;
						
					}
				
			}
			
		}
		return originC;
	}
	
	private void GeneratorInitializer(Maze maze)
	{
		for (int x =0; x < maze.sizeR; x++)
		{
		for (int y = 0; y < maze.sizeC; y++)
		{
			Cell tempCell = maze.map[x][y];
			
		if(x < maze.sizeR- 1) {
			tempCell.neigh[maze.NORTH] = maze.map[x+1][y];
			
			}
		if(y < maze.sizeC- 1) {
			tempCell.neigh[maze.EAST] = maze.map[x][y+1];
			 }
		if(x > 0) {
			tempCell.neigh[maze.SOUTH] = maze.map[x-1][y];
			 }
		if(y > 0) {
			tempCell.neigh[maze.WEST] = maze.map[x][y-1];
			 }
	
			this.unvisited.add(tempCell);
			 }
	}

	this.checkingCell = maze.entrance;
	}

	private Cell randomPickNeigh(Cell cell, Maze maze)
	{	
		ArrayList<Integer> shuffleBag = new ArrayList<Integer>();
		
		if(unvisited.contains(cell.neigh[maze.EAST]) == true)
		{
			shuffleBag.add(maze.EAST);
		}
		
		if(unvisited.contains(cell.neigh[maze.NORTH]) == true)
		{
			shuffleBag.add(maze.NORTH);
		}
		
		if(unvisited.contains(cell.neigh[maze.WEST]) == true)
		{
			shuffleBag.add(maze.WEST);
		}
		
		if(unvisited.contains(cell.neigh[maze.SOUTH]) == true)
		{
			shuffleBag.add(maze.SOUTH);
		}
//		if(cell.tunnelTo != null)
//		{
//			if(unvisited.contains(cell.tunnelTo))
//			{
//				return cell.tunnelTo;
//			}
//		}
		
		if(shuffleBag.size() > 1)
		{
			Collections.shuffle(shuffleBag);
			return cell.neigh[shuffleBag.get(0)];
		}
		
		
		
		else
		{
			return null;
		}
		
		
		
	}
} // end of class KruskalGenerator
