package main.java;

public class Display {
	
	public static void number_display() {
		for (int y=0; y<9; y++) {
			for (int x=0; x<9; x++) {
				
				//Stuff happens per line
				System.out.print(y * 9 + x + 1 + ", ");
			}
			//Resets to next line
			System.out.println("");
		}
	}
	
	public static void position_display() {
		for (int y=0; y<9; y++) {
			for (int x=0; x<9; x++) {
				
				//Stuff happens per line
				System.out.print((y+1)+","+ (x+1) + " | ");
			}
			//Resets to next line
			System.out.println("");
		}
	}
	
	public static void gamestate_display(int[][] input) {
		
		int[][] nums = input;
		
		for (int y=0; y<9; y++) {
			
			String lineVal = "";
			
			for (int x=0; x<9; x++) {
				
				int z = nums[y][x];
				
				
				//###Stuff happens per line###
				
				//System.out.print(z);
				//System.out.print(z + " | ");
				//System.out.print(nums[y][x] + " | ");
				
				
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

	
	public static void gamestate_display_verbose(int[][] input) {
		
		int[][] nums = input;
		
		for (int y=0; y<9; y++) {
			
			String lineVal = "";
			
			for (int x=0; x<9; x++) {
				
				int z = nums[y][x];
				
				
				//###Stuff happens per line###
				
				//System.out.print(z);
				//System.out.print(z + " | ");
				//System.out.print(nums[y][x] + " | ");
				
				
				//if the number is 0 or >9 print a *
				
				{
					System.out.print(z + " | ");
					//add each solved number to the lineVal
					lineVal = lineVal + z;
				}
				
				
			}
			System.out.println();
		}
	}
	
	
}


