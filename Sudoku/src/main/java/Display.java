package main.java;

public class Display {
	
	// Dev-Only. Method outputs each cell number, 1-81.
	public static void numberDisplay() {
		for (int y=0; y<9; y++) {
			for (int x=0; x<9; x++) {
				
				//Stuff happens per line
				System.out.print(y * 9 + x + 1 + ", ");
			}
			//Resets to next line
			System.out.println("");
		}
	}
	
	// Dev-Only. Method outputs each cell position reference 0,0 to 8,8.
	public static void positionDisplay() {
		for (int y=0; y<9; y++) {
			for (int x=0; x<9; x++) {
				
				//Stuff happens per line
				System.out.print((y)+","+ (x) + " | ");
			}
			//Resets to next line
			System.out.println("");
		}
	}
	
	// Functional. Method outputs 2D int array data as a grid. Values edited to show unsolved squares as a *.
	public static void gamestateDisplay(int[][] input) {
		
		int[][] nums = input;
		
		for (int y=0; y<9; y++) {
			
			String lineVal = "";
			
			for (int x=0; x<9; x++) {
				
				int z = nums[y][x];
				
				//Stuff happens per line
				//if the number is 0 or >9 print a *
				if ((z == 0) || (z > 9)) {
					System.out.print("*" + " | ");
				} else {
					System.out.print(z + " | ");
					//add each solved number to the lineVal
					lineVal = lineVal + z;
				}
			}
			//System.out.print(lineVal);
			//Resets to next line
			System.out.println("");
		}
	}

	// Functional. Method outputs 2D int array data as a grid. Values are not edited and so show a very messy, but informative, grid.
	public static void gamestateDisplayVerbose(int[][] input) {
		
		int[][] nums = input;
		
		for (int y=0; y<9; y++) {
			
			String lineVal = "";
			
			for (int x=0; x<9; x++) {
				
				int z = nums[y][x];
				
				//Stuff happens per line
				{
					System.out.print(z + " | ");
					//add each solved number to the lineVal
					lineVal = lineVal + z;
				}
			}
			//Reset to next line.
			System.out.println();
		}
	}
	
}


