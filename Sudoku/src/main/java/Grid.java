package main.java;

import java.util.List;

public class Grid {
	
	int[][] nums = new int[9][9];
	/*
	void setup_Grid() {
		for (int y=0; y<9; y++) {
			for (int x=0; x<9; x++) {
				Arraylist <Integer>  = 
			}
		}
	}
	
	List<Integer> grid_content = new ArrayList<>() {
		
	}
	
	*/
	
	
	
	int[][] solvedRows = new int[9][9];
	int[][] solvedColumns = new int[9][9];
	int[][] solvedBlocks = new int[9][9];
	
	void simpleNumsDisplay() {
		System.out.println(nums[0][0]);
		System.out.println(nums[0][0]);
		System.out.println(nums[0][1]);
	}

	public int[][] getNums() {
		return nums;
	}

	public void setNums(int[][] grid) {
		this.nums = grid;
	}
	
	public void setNumsOne(int[][] grid) {
		this.nums = grid;
	}
	
}
