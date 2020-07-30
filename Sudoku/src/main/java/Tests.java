package main.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tests {
		
	// Dev-Only. Reference Code for iterating through the 2D grid.
	public static void iterateThroughGrid(int[][] input) {
		
		int[][] nums = input;
		
		for (int y=0; y<9; y++) {
			
			for (int x=0; x<9; x++) {
				
				int z = nums[y][x];
			}
		}
	}
	
	// Functional. Iterates through whole grid to check for any unsolved numbers. Returns boolean to let the game know if it is completed yet.
	public static boolean checkIfComplete(int[][] input) {
			
			boolean complete = true;
			
			int[][] nums = input;
			
			System.out.print("Checking if board is complete... ");
			
			for (int y=0; y<9; y++) {
				
				for (int x=0; x<9; x++) {
					
					int z = nums[y][x];
					
					if (z > 9) {
						complete = false;
						System.out.println("Unsolved square found!");
						System.out.println("");
						return complete;
					}
				}
			}
			
			System.out.println("Game Completed");
			
			return complete;
		}
	
	// Functional. Sets every blank square to have all unsolved options (123456789).
	public static int[][] setupUnsolvedNumbers(int[][] grid) {
		
		int[][] nums = grid;
		
		for (int y=0; y<9; y++) {
			
			for (int x=0; x<9; x++) {
				
				int z = nums[y][x];
				
				if (z == 0) {
					nums[y][x] = 123456789;
				}
			}
		}
		System.out.println("Line setup complete.");
		return nums;
	}
	
	// Functional. Iterates through whole grid scanning each square's row/column/block and updating it as it goes. (Elimination)
	public static int[][] eliminationTest(int[][] input) {

		int[][] nums = input;
		boolean change_occured = false;
		
		for (int y=0; y<9; y++) {
			
			for (int x=0; x<9; x++) {
				
				int z = nums[y][x];

				// check number in current square is not solved
				if (z > 9) {  
					
					// check row for solved numbers
					for (int a=0; a<9; a++) {   
						int c = nums[y][a];
						if (c < 10) {           // if solved number found, remove from current unsolved number.
							String str = Integer.toString(z);            
							if (str.contains(Integer.toString(c))) { 	// check that it exists in the current cell
								str = str.replace(Integer.toString(c), "");
								if (!str.isEmpty()) {z = Integer.parseInt(str);}
								nums[y][x] = z;
								System.out.println("Row: " + y + "|" + x + " (" + z + ") Removing: " + c + " New value: " + nums[y][x]); // Output message confirming change made.
								change_occured = true;
							}
						}
					}
					
					// check column for solved numbers
					for (int a=0; a<9; a++) {   
						int c = nums[a][x];
						if (c < 10) {           // if solved number found, remove from current unsolved number.
							String str = Integer.toString(z);
							if (str.contains(Integer.toString(c))) { 	// check that it exists in the current cell
								str = str.replace(Integer.toString(c), "");
								if (!str.isEmpty()) {z = Integer.parseInt(str);}
								nums[y][x] = z;
								System.out.println("Col: " + y + "|" + x + " (" + z + ") Removing: " + c + " New value: " + nums[y][x]); // Output message confirming change made.
								change_occured = true;
							}
						}
					}
					
					// check block for solved numbers
					if (x<3) {
						//block 1 / 2 / 3
						if (y < 3 ) {
							//block 1
							for (int a=0; a<3; a++) {
								for (int b=0; b<3; b++) {
									int c = nums[a][b];
									if (c < 10) {           // if solved number found, remove from current unsolved number.
										String str = Integer.toString(z);
										if (str.contains(Integer.toString(c))) { 	// check that it exists in the current cell
											str = str.replace(Integer.toString(c), "");
											if (!str.isEmpty()) {z = Integer.parseInt(str);}
											nums[y][x] = z;
											System.out.println("Blk: " + y + "|" + x + " (" + z + ") Removing: " + c + " New value: " + nums[y][x]);
											change_occured = true;
										}
									}
								}
							}
							
						} else if (y < 6) {
							//block 2
							for (int a=3; a<6; a++) {
								for (int b=0; b<3; b++) {
									int c = nums[a][b];
									if (c < 10) {           // if solved number found, remove from current unsolved number.
										String str = Integer.toString(z);
										if (str.contains(Integer.toString(c))) { 	// check that it exists in the current cell
											str = str.replace(Integer.toString(c), "");
											if (!str.isEmpty()) {z = Integer.parseInt(str);}
											nums[y][x] = z;
											System.out.println("Blk: " + y + "|" + x + " (" + z + ") Removing: " + c + " New value: " + nums[y][x]);
											change_occured = true;
										}
									}
								}
							}
						} else {
							//block 3
							for (int a=6; a<9; a++) {
								for (int b=0; b<3; b++) {
									int c = nums[a][b];
									if (c < 10) {           // if solved number found, remove from current unsolved number.
										String str = Integer.toString(z);
										if (str.contains(Integer.toString(c))) { 	// check that it exists in the current cell
											str = str.replace(Integer.toString(c), "");
											if (!str.isEmpty()) {z = Integer.parseInt(str);}
											nums[y][x] = z;
											System.out.println("Blk: " + y + "|" + x + " (" + z + ") Removing: " + c + " New value: " + nums[y][x]);
											change_occured = true;
										}
									}
								}
							}
						}

					} else if (x < 6) {
						//block 4 / 5 / 6
						if (y < 3 ) {
							//block 4
							for (int a=0; a<3; a++) {
								for (int b=3; b<6; b++) {
									int c = nums[a][b];
									if (c < 10) {           // if solved number found, remove from current unsolved number.
										String str = Integer.toString(z);
										if (str.contains(Integer.toString(c))) { 	// check that it exists in the current cell
											str = str.replace(Integer.toString(c), "");
											if (!str.isEmpty()) {z = Integer.parseInt(str);}
											nums[y][x] = z;
											System.out.println("Blk: " + y + "|" + x + " (" + z + ") Removing: " + c + " New value: " + nums[y][x]);
											change_occured = true;
										}
									}
								}
							}
						} else if (y < 6) {
							//block 5
							for (int a=3; a<6; a++) {
								for (int b=3; b<6; b++) {
									int c = nums[a][b];
									if (c < 10) {           // if solved number found, remove from current unsolved number.
										String str = Integer.toString(z);
										if (str.contains(Integer.toString(c))) { 	// check that it exists in the current cell
											str = str.replace(Integer.toString(c), "");
											if (!str.isEmpty()) {z = Integer.parseInt(str);}
											nums[y][x] = z;
											System.out.println("Blk: " + y + "|" + x + " (" + z + ") Removing: " + c + " New value: " + nums[y][x]);
											change_occured = true;
										}
									}
								}
							}
						} else {
							//block 6
							for (int a=6; a<9; a++) {
								for (int b=3; b<6; b++) {
									int c = nums[a][b];
									if (c < 10) {           // if solved number found, remove from current unsolved number.
										String str = Integer.toString(z);
										if (str.contains(Integer.toString(c))) { 	// check that it exists in the current cell
											str = str.replace(Integer.toString(c), "");
											if (!str.isEmpty()) {z = Integer.parseInt(str);}
											nums[y][x] = z;
											System.out.println("Blk: " + y + "|" + x + " (" + z + ") Removing: " + c + " New value: " + nums[y][x]);
											change_occured = true;
										}
									}
								}
							}
						}
					} else {
						//block 7 / 8 / 9
						if (y < 3 ) {
							//block 7
							for (int a=0; a<3; a++) {
								for (int b=6; b<9; b++) {
									int c = nums[a][b];
									if (c < 10) {           // if solved number found, remove from current unsolved number.
										String str = Integer.toString(z);
										if (str.contains(Integer.toString(c))) { 	// check that it exists in the current cell
											str = str.replace(Integer.toString(c), "");
											if (!str.isEmpty()) {z = Integer.parseInt(str);}
											nums[y][x] = z;
											System.out.println("Blk: " + y + "|" + x + " (" + z + ") Removing: " + c + " New value: " + nums[y][x]);
											change_occured = true;
										}
									}
								}
							}
						} else if (y < 6) {
							//block 8
							for (int a=3; a<6; a++) {
								for (int b=6; b<9; b++) {
									int c = nums[a][b];
									if (c < 10) {           // if solved number found, remove from current unsolved number.
										String str = Integer.toString(z);
										if (str.contains(Integer.toString(c))) { 	// check that it exists in the current cell
											str = str.replace(Integer.toString(c), "");
											if (!str.isEmpty()) {z = Integer.parseInt(str);}
											nums[y][x] = z;
											System.out.println("Blk: " + y + "|" + x + " (" + z + ") Removing: " + c + " New value: " + nums[y][x]);
											change_occured = true;
										}
									}
								}
							}
						} else {
							//block 9
							for (int a=6; a<9; a++) {
								for (int b=6; b<9; b++) {
									int c = nums[a][b];
									if (c < 10) {           // if solved number found, remove from current unsolved number.
										String str = Integer.toString(z);
										if (str.contains(Integer.toString(c))) { 	// check that it exists in the current cell
											str = str.replace(Integer.toString(c), "");
											if (!str.isEmpty()) {z = Integer.parseInt(str);}
											nums[y][x] = z;
											System.out.println("Blk: " + y + "|" + x + " (" + z + ") Removing: " + c + " New value: " + nums[y][x]);
											change_occured = true;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		if (change_occured == false) {
			System.out.println("(" + change_occured + ") No changes found!");
		} else {
			System.out.println("(" + change_occured + ") Changes found!");
		}
		return nums;
	}
	
	// Functional. Iterates through whole grid checking whether any row/column/block has a number that appears only once among the unsolved numbers. (Deduction)
	public static int[][] deductionTest(int[][] input) {
		
		int[][] nums = input;
		String lineValue = "";
		
		//######## Row Deduction #######
		
		for (int y=0; y<9; y++) {
			
			for (int x=0; x<9; x++) {
				
				int z = nums[y][x];
				
				if (z > 9) {  // Check number is unsolved.
					
					lineValue = lineValue + z; // Add the whole line to a String
					
					//System.out.println(lineValue);
					
				}
				
			}
			
			for (int i = 1; i < 10; i++) { // Look for numbers 1-9 in String
				
				if (lineValue.indexOf(String.valueOf(i)) != -1) { // Check the target number appears at all.
					
					//System.out.println("First occurrence of " + i + " @ " + lineValue.indexOf(String.valueOf(i))); // Debug output
					//System.out.println("Last occurrence of " + i + " @ " + lineValue.lastIndexOf(String.valueOf(i))); // Debug output
						
					if (lineValue.indexOf(String.valueOf(i)) == lineValue.lastIndexOf(String.valueOf(i))) { // Look for single occurrence numbers
						//System.out.println("Only one instance of " + i + " found!"); // Notify when a isolated number is found
						
						//Method that takes 'i', finds the cell with it in, changes the value to 'i'
						
						//solveDeduction(nums, y, i); //Experimental method to save repetition
						
						for (int x=0; x<9; x++) { // Iterate through current row again...
							
							int z = nums[y][x];
							
							if (z > 9) {  // Check number is unsolved.
								
								if (String.valueOf(z).contains(String.valueOf(i))) { // Check whether this unsolved number has the single occurrence number in it.
									
									//System.out.println("Number: " + i + " is in cell: " + y + " | " + x); // Dev info.
									
									nums[y][x] = i; // Set square to just the single occurrence number.
									
									System.out.println("Ded: " + y + "|" + x + " Solved. Was only (" + i + ") remaining in Row."); // Dev info.
									
								}
								
							}
							
						}
					}
				}
				
			
			}
			
			lineValue = ""; // Clear String for next row
			
		}
		
		// ####### Column Deduction ######
		
		for (int y=0; y<9; y++) {
			
			for (int x=0; x<9; x++) {
				
				int z = nums[x][y];
				
				if (z > 9) {  // Check number is unsolved.
					
					lineValue = lineValue + z; // Add the whole line to a String
					
					//System.out.println(lineValue);
					
				}
				
			}
			
			for (int i = 1; i < 10; i++) { // Look for numbers 1-9 in String
				
				if (lineValue.indexOf(String.valueOf(i)) != -1) { // Check the target number appears at all.
					
					//System.out.println("First occurrence of " + i + " @ " + lineValue.indexOf(String.valueOf(i))); // Debug output
					//System.out.println("Last occurrence of " + i + " @ " + lineValue.lastIndexOf(String.valueOf(i))); // Debug output
						
					if (lineValue.indexOf(String.valueOf(i)) == lineValue.lastIndexOf(String.valueOf(i))) { // Look for single occurrence numbers
						//System.out.println("Only one instance of " + i + " found!"); // Notify when a isolated number is found
						
						//Method that takes 'i', finds the cell with it in, changes the value to 'i'
						
						//solveDeduction(nums, y, i); //Experimental method to save repetition
						
						for (int x=0; x<9; x++) { // Iterate through current column again...
							
							int z = nums[x][y];
							
							if (z > 9) {  // Check number is unsolved.
								
								if (String.valueOf(z).contains(String.valueOf(i))) { // Check whether this unsolved number has the single occurrence number in it.
									
									//System.out.println("Number: " + i + " is in cell: " + y + " | " + x); // Dev info.
									
									nums[x][y] = i; // Set square to just the single occurrence number.
									
									System.out.println("Ded: " + y + "|" + x + " Solved. Was only (" + i + ") remaining in Column."); // Dev info.
									
								}
								
							}
							
						}
					}
				}
				
			
			}
			
			lineValue = ""; // Clear String for next column
			
		}

		//##### Block Deduction #####
		
		int x = 0;
		int y = 0;
		
		for (int a=0; a<3; a++) {
			for (int b=0; b<3; b++) {
		
				for (int c=0; c<3; c++) {
					for (int d=0; d<3; d++) {
						
						//Stuff happens per line
						
						x = b*3 + d;
						y = a*3 + c;
						
						//System.out.print((y)+","+ (x) + " | ");
						
						int z = nums[y][x];
						
						if (z > 9) {
						
							lineValue = lineValue + z; // Add the whole line to a String
							
							//System.out.println(lineValue);
							
						}


					}
				}
					
				for (int i = 1; i < 10; i++) { // Look for numbers 1-9 in String
					
					if (lineValue.indexOf(String.valueOf(i)) != -1) { // Check the target number appears at all.
						
						//System.out.println("First occurrence of " + i + " @ " + lineValue.indexOf(String.valueOf(i))); // Debug output
						//System.out.println("Last occurrence of " + i + " @ " + lineValue.lastIndexOf(String.valueOf(i))); // Debug output
							
						if (lineValue.indexOf(String.valueOf(i)) == lineValue.lastIndexOf(String.valueOf(i))) { // Look for single occurrence numbers
							//System.out.println("Only one instance of " + i + " found!"); // Notify when a isolated number is found
							
							//Method that takes 'i', finds the cell with it in, changes the value to 'i'
							
							//solveDeduction(nums, y, i); //Experimental method to save repetition
							
							for (int c=0; c<3; c++) {
								for (int d=0; d<3; d++) {
									
									x = b*3 + d;
									y = a*3 + c;
									
									//System.out.println("a: " + a + " b: " + b + " c: " + c + " d: " + d); // Dev info.
									
									int z = nums[y][x];
									
									if (z > 9) {  // Check number is unsolved.
										
										if (String.valueOf(z).contains(String.valueOf(i))) { // Check whether this unsolved number has the single occurrence number in it.
											
											//System.out.println("Number: " + i + " is in cell: " + y + " | " + x); // Dev info.
											
											nums[y][x] = i; // Set square to just the single occurrence number.
											
											System.out.println("Ded: " + y + "|" + x + " Solved. Was only (" + i + ") remaining in Block."); // Dev info.
										}
									}
								}
							}
						}
					}
					//Resets to next line
				}
				//Resets to next block
				lineValue = ""; // Clear string for next block;
				//System.out.println("");
			}
		}
			
		return nums;
		
	}
	
			
	// WIP For refactoring code to avoid repetition. Unsure if this will work as Row Deduction exclusively uses y as a variable coord and columns use x exclusively.
	//
	public static void solveDeduction(int[][] grid_input, int row_input, int number_input) {
		
		int[][] nums = grid_input;
		int y = row_input;
		int i = number_input;
		
		
		for (int x=0; x<9; x++) { // Iterate through current row again...
			
			int z = nums[y][x];
			
			if (z > 9) {  // Check number is unsolved.
				
				if (String.valueOf(z).contains(String.valueOf(i))) { // Check whether this unsolved number has the single occurrence number in it.
					
					System.out.println("Number: " + i + " is in cell: " + y + " | " + x); // Dev info.
					
					nums[y][x] = i; // Set square to just the single occurrence number.
					
					System.out.println("Cell " + y + "|" + x + " set to: " + i); // Dev info.
					
				}
				
			}
			
		}
		
	}
	
	// Deduction Method
	// Iterate through each row. 
	// For each square in the row >9 add the numbers to a String.
	// After checking the whole row, check String for any number that only appears once, 'solve' those squares.
	// Repeat for columns.
	// Repeat for blocks.
	
	
	
	
	
	// ############################## WIP Automatic Trial and Error Testing #################################
	// Create solverNums[][]
	// solverNums.spares = nums.value
	// Iterate through whole grid
	// When reaching a solved number (<10) add it to choice and remove it from spares. 
	// When reaching an unsolved number, select the lowest option, add it to choice, remove it from spares, increment counter.
	// After an unsolved number, update whole grid by removing options from spares. 
	
	// If reached a cell with no options, back up to last decision made
	// If successfully reached last cell, completed successfully.
	
	public static void numSolver() {
		
		
		Solver test2 = new Solver();
		int moo = test2.getChoice();
		System.out.println(moo);
		
		ArrayList<Integer>[][] test = new ArrayList[9][9];
		
		List<Solver>[][] solver = new List[9][9];
		
		solver[0][0].set(0, test2);
		
		Solver test3 = new Solver();
		test3 = (Solver) solver[0][0];
		
		int quack = test3.getChoice();
		System.out.println(quack);
		
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {}
			}
		
		
		
		
		for (Object next : solver[0][0]) {
			System.out.println(next);
		}
		
		/*
		List myList = new ArrayList();
		
		myList.add("Object 1");
		myList.add("Object 2");
		myList.add("Object 3");
		
		myList.remove(2);
		
		Object firstObject = myList.get(0);
		String secondObject = (String) myList.get(1);
		System.out.println(firstObject);
		System.out.println(secondObject);
		
		int size = myList.size();
		System.out.println("Array size = " + size);
		
		Iterator iterator = myList.iterator();
		while(iterator.hasNext()) {
			Object next = iterator.next();
			System.out.println(next);
		}
		
		for(Object next : myList) {
			System.out.println(next);
		}
		
		for(int i=0; i<myList.size(); i++) {
			Object next = myList.get(i);
			System.out.println(next);
		}*/
		
	}
		//################### Deprecated Code that got used in EliminationTest Instead #####################
		// Deprecated method. Replaced with eliminationTest. Update Row Solved Arrays.
		public static int[][] updateRowSolvedArrays(int[][] grid) {
			int[][] nums = grid;
			int[][] result = new int[9][9];
			
			for (int y=0; y<9; y++) {
				
				for (int x=0; x<9; x++) {
					
					int z = nums[y][x];
					
					if (z < 10) {
						//System.out.println("grid y = " + y + ", grid x = " + x + ", val = " + z);
						result[y][z-1] = z;
						//System.out.println("result: (row)[" + y + "], (index)[" + (z-1) + "], (value) = " + z);
						//System.out.println("grid y = " + y + ", grid x = " + x + ", val = " + z);
					}
				}
				
				String returnString = Tests.displayArrayAsString(result, y);
				//String returnString = Tests.displayArrayAsString(result);
				System.out.println("Row " + (y+1) + " Solved Numbers = " + returnString);
			}
			
			return result;
		}
		
		// Deprecated method. Replaced with eliminationTest. Update Column Solved Arrays
		public static int[][] updateColumnSolvedArrays(int[][] grid) {
				int[][] nums = grid;
				int[][] result = new int[9][9];			
				
				for (int x=0; x<9; x++) {
					
					for (int y=0; y<9; y++) {
						
						int z = nums[y][x];
						
						if (z < 10) {
							//System.out.println("grid y = " + y + ", grid x = " + x + ", val = " + z);
							result[x][z-1] = z;
							//System.out.println("result: (column)[" + x + "], (index)[" + (z-1) + "], (value) = " + z);
							//System.out.println("grid y = " + y + ", grid x = " + x + ", val = " + z);
						}
					}
					String returnString = Tests.displayArrayAsString(result, x);
					System.out.println("Column " + (x+1) + " Solved Numbers = " + returnString);
				}
				
				return result;
			}
			
		// Deprecated method. Replaced with eliminationTest. Update Block Solved Arrays
		public static int[][] updateBlockSolvedArrays(int[][] grid) {
						int[][] nums = grid;
						int[][] result = new int[9][9];			
						
						for (int y=0; y<9; y++) {
							
							for (int x=0; x<9; x++) {
								
								int z = nums[y][x];
								
								if (z < 10) {
									if (x<3) {
										//block 1 / 2 / 3
										if (y < 3 ) {
											//block 1
											result[0][z-1] = z;
											//System.out.println("Block 1 assigned: " + z);
										} else if (y < 6) {
											//block 2
											result[1][z-1] = z;
											//System.out.println("Block 2 assigned: " + z);
										} else {
											//block 3
											result[2][z-1] = z;
											//System.out.println("Block 3 assigned: " + z);
										}

									} else if (x < 6) {
										//block 4 / 5 / 6
										if (y < 3 ) {
											//block 4
											result[3][z-1] = z;
											//System.out.println("Block 4 assigned: " + z);
										} else if (y < 6) {
											//block 5
											result[4][z-1] = z;
											//System.out.println("Block 5 assigned: " + z);
										} else {
											//block 6
											result[5][z-1] = z;
											//System.out.println("Block 6 assigned: " + z);
										}
									} else {
										//block 7 / 8 / 9
										if (y < 3 ) {
											//block 7
											result[6][z-1] = z;
											//System.out.println("Block 7 assigned: " + z);
										} else if (y < 6) {
											//block 8
											result[7][z-1] = z;
											//System.out.println("Block 8 assigned: " + z);
										} else {
											//block 9
											result[8][z-1] = z;
											//System.out.println("Block 9 assigned: " + z);
										}
									}
									
									//System.out.println("grid y = " + y + ", grid x = " + x + ", val = " + z);
									result[x][z-1] = z;
									//System.out.println("result: (column)[" + x + "], (index)[" + (z-1) + "], (value) = " + z);
									//System.out.println("grid y = " + y + ", grid x = " + x + ", val = " + z);
								}
							}
						}
						
						for(int i=0; i<9; i++) {
							String returnString = Tests.displayArrayAsString(result, i);
							System.out.println("Block " + (i+1) + " Solved Numbers = " + returnString);
						}
						
						return result;
					}		
		
		// Deprecated method part of the above. Not used in eliminationTest. Display Array as String (with row Ref)
		public static String displayArrayAsString(int[][] inputArray, int y) {
			int[][] array = inputArray;
			String returnString = "";
			
			for (int x = 0; x < array.length; x++) {
				if(array[y][x] != 0) {
					returnString += Integer.toString(array[y][x]);
				}
			}
			//System.out.println(returnString);
			return returnString;
		}
		
		// Deprecated method part of the above. Not used in eliminationTest. Remove potential options from unsolved squares based upon Solved Number Arrays
		public static void updateCellOptions(int[][] input) {
			
			int[][] nums = input;
			
			for (int y=0; y<9; y++) {
				
				for (int x=0; x<9; x++) {
					
					int z = nums[y][x];
					
					if (z > 10) {
						System.out.println(y + "|" + x + " unsolved number currently " + z);
						cullSolvedNums(z);
					}
				}
			}
		}
		
		// Deprecated method part of the above. Not used in eliminationTest. Takes int, converts to string, 
		public static int cullSolvedNums(int input) {
			
			String string = Integer.toString(input);
			string = string.replace("3", "");
					
			int output = Integer.parseInt(string);
			
			System.out.println("outputting: " + output);
					
			return output;
		}
		
	
}
