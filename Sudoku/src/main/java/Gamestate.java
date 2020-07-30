package main.java;

import java.util.ArrayList;

public class Gamestate {
	
	public static void main(String[] args) {

		Grid grid1 = new Grid();
		int passes = 1;
		
		Grid gridBackOne = new Grid();
		Grid gridBackTwo = new Grid(); 
		
		
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
				
		grid1.nums = Tests.setupUnsolvedNumbers(grid1.nums);
		
		Display.gamestateDisplay(grid1.nums);
		System.out.println();
		
		
		do { 
		
		System.out.println("Pass: " + passes);
		passes++;
		gridBackTwo.nums = gridBackOne.nums;
		gridBackOne.nums = grid1.nums;
		
		Tests.eliminationTest(grid1.nums);
		System.out.println();
		Display.gamestateDisplayVerbose(grid1.nums);
		System.out.println();
		Tests.deductionTest(grid1.nums);
		System.out.println();
		Display.gamestateDisplayVerbose(grid1.nums);
		System.out.println();
		
		/*
		// NEEDS WORK ON UNDERSTANDING WHEN STUCK INTELLIGENTLY
		if (grid1.nums.equals(gridBackOne.nums) && grid1.nums.equals(gridBackTwo.nums)) {
			System.out.println("Game is stuck! Breaking process");
			break;
		}*/
		
		} while (!Tests.checkIfComplete(grid1.nums) && (passes < 10));
		

	}

}
