package mazeSolver;

import java.util.ArrayList;
import java.util.List;

import maze.Cell;
import maze.Maze;

/**
 * Implements the recursive backtracking maze solving algorithm.
 */
public class RecursiveBacktrackerSolver implements MazeSolver {

	private List<Cell> visited = new ArrayList<Cell>();
	private boolean isSolved = true;
	private Cell checkingCell = new Cell();
	private 
	
	
	@Override
	public void solveMaze(Maze maze) {
		// TODO Auto-generated method stub
		maze.
	} // end of solveMaze()

	public void recursiveSolving(Maze maze, )

	@Override
	public boolean isSolved() {
		// TODO Auto-generated method stub
		return this.isSolved;
	} // end if isSolved()


	@Override
	public int cellsExplored() {
		// TODO Auto-generated method stub
		return this.visited.size();
	} // end of cellsExplored()

} // end of class RecursiveBackTrackerSolver
