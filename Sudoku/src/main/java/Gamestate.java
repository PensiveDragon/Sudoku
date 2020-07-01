package main.java;

import java.util.ArrayList;

public class Gamestate {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Grid grid1 = new Grid();
		
		//grid1.grid[0][0][ = 1;
		
		//grid1.simpleDisplay();
		
		
		grid1.nums[0][0] = 1;
		grid1.nums[0][1] = 3;
		grid1.nums[0][2] = 4;
		grid1.nums[0][3] = 5;
		grid1.nums[1][1] = 9;
		grid1.nums[1][2] = 2;
		grid1.nums[3][3] = 7;
		grid1.nums[3][6] = 6;
		grid1.nums[4][5] = 3;
		grid1.nums[4][6] = 9;
		grid1.nums[4][7] = 8;
		grid1.nums[5][0] = 4;
		grid1.nums[5][1] = 2;
		grid1.nums[5][2] = 6;
		grid1.nums[6][1] = 7;
		grid1.nums[6][2] = 5;
		grid1.nums[6][5] = 2;
		grid1.nums[7][4] = 6;
		grid1.nums[7][6] = 2;
		grid1.nums[7][8] = 9;
		grid1.nums[8][4] = 1;
		grid1.nums[8][5] = 5;
		grid1.nums[8][6] = 3;
		grid1.nums[8][8] = 4;
		
		/*
		grid1.nums[0][0] = 8;
		grid1.nums[1][2] = 3;
		grid1.nums[1][3] = 6;
		grid1.nums[2][1] = 7;
		grid1.nums[2][4] = 9;
		grid1.nums[2][6] = 2;
		grid1.nums[3][1] = 5;
		grid1.nums[3][5] = 7;
		grid1.nums[4][4] = 4;
		grid1.nums[4][5] = 5;
		grid1.nums[4][6] = 7;
		grid1.nums[5][3] = 1;
		grid1.nums[5][7] = 3;
		grid1.nums[6][3] = 1;
		grid1.nums[6][7] = 6;
		grid1.nums[6][8] = 8;
		grid1.nums[7][2] = 8;
		grid1.nums[7][3] = 5;
		grid1.nums[7][7] = 1;
		grid1.nums[8][1] = 9;
		grid1.nums[8][6] = 4;
		*/
		
		//grid1.simpleNumsDisplay();
		grid1.nums = Tests.setupUnsolvedNumbers(grid1.nums);
		
		Display.gamestate_display(grid1.nums);
		System.out.println();
		
		System.out.println("Pass One");
		Tests.megaOptionsCull(grid1.nums);
		System.out.println();
		Display.gamestate_display_verbose(grid1.nums);
		
		System.out.println();
		
		System.out.println("Pass Two");
		Tests.megaOptionsCull(grid1.nums);
		System.out.println();
		Display.gamestate_display_verbose(grid1.nums);
		
		
		
		//Tests.numSolver();
		/*
		grid1.solvedRows = Tests.updateRowSolvedArrays(grid1.nums);
		System.out.println();
		grid1.solvedColumns = Tests.updateColumnSolvedArrays(grid1.nums);
		System.out.println();
		grid1.solvedBlocks = Tests.updateBlockSolvedArrays(grid1.nums);
		System.out.println();
		
		Tests.updateCellOptions(grid1.nums);
		*/
		
		/*
		System.out.println("meow");
		
		int testInt = 123456789;
		
		System.out.println(testInt);
		
		String testString = Integer.toString(testInt);
		String removeVal = 
		
		testString = testString.replace("3", "");
		
		testInt = Integer.parseInt(testString);
		
		System.out.println(testInt);*/
		
		
	
	}
	
	public static void create_gamestate() {
		
	}

	
}




/*
int[][][] grid = {
		{{1}, {}, {}, {8}, {}, {}, {3}, {4}, {}},
		{{}, {2}, {}, {9}, {3}, {4}, {}, {}, {}},
		{{3}, {}, {}, {}, {}, {2}, {}, {7}, {}},
		{{}, {}, {9}, {7}, {}, {}, {}, {}, {}},
		{{}, {8}, {}, {4}, {}, {}, {5}, {}, {}},
		{{}, {}, {1}, {}, {}, {9}, {}, {}, {}},
		{{}, {5}, {}, {}, {6}, {}, {}, {}, {}},
		{{}, {4}, {8}, {}, {}, {}, {}, {}, {}},
		{{}, {}, {}, {}, {}, {}, {2}, {8}, {9}},
};*/

//System.out.println(grid[0][0][0]);

//int[][][] nums = new int[9][9][9];
