package main.java;

import java.util.List;

public class Grid {
	
	int[][] nums = new int[9][9];
	
	int[][] solvedRows = new int[9][9];
	int[][] solvedColumns = new int[9][9];
	int[][] solvedBlocks = new int[9][9];

	public int[][] getNums() {
		return nums;
	}

	public void setNums(int[][] grid) {
		this.nums = grid;
	}
		
}
