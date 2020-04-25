import java.util.ArrayList;
import java.util.List;

import maze.NormalMaze;
import mazeGenerator.HuntAndKillGenerator;

public class TestClasses {

	public static void main(String[] args) {
		NormalMaze maze = new NormalMaze();
		List<int[]> list = new ArrayList<int[]>();
		int[] temp = new int[4];
		temp[0] = 1;
		temp[1] = 2;
		temp[2] = 3;
		temp[3] = 4;
		
		maze.initMaze(30, 30, 0, 0, 30, 30, list);
		HuntAndKillGenerator gen = new HuntAndKillGenerator();
//		gen.generateMaze(maze);
//		gen.HuntMode(maze);
		
		
		if(maze.isPerfect() == true)
		{
			System.out.println("PASSED");
		}
		else
		{
			System.out.println("FAILED");
			System.out.println(gen.HuntMode(maze).c +" "+ gen.HuntMode(maze).r);
		}

	}

}
