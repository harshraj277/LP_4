package DAA;

import java.util.Scanner;

public class NQueenProblem 
{
	static int n;
	static int board[][];
	static int fixedRow;
	
	// Check whether a queen can be placed safely

	static boolean isSafe(int row, int col) {

	    // Check entire column
	    for (int i = 0; i < n; i++) {
	        if (board[i][col] == 1)
	            return false;
	    }

	    // Check upper-left diagonal
	    for (int i = row - 1, j = col - 1;
	         i >= 0 && j >= 0; i--, j--) {

	        if (board[i][j] == 1)
	            return false;
	    }

	    // Check upper-right diagonal
	    for (int i = row - 1, j = col + 1;
	         i >= 0 && j < n; i--, j++) {

	        if (board[i][j] == 1)
	            return false;
	    }

	    return true;
	}
	
	
	static boolean solve(int row) 
	{
		//All queens placed 
		if(row==n)
			return true;
		
		 // Skip the row containing the fixed queen
        if (row == fixedRow)
            return solve(row + 1);
		
		//try each column
		for (int col = 0; col < n; col++) 
		{
			if(isSafe(row, col))
			{
				board[row][col]=1;
				
				if(solve(row+1))
					return true;
				
				//backtracking
				board[row][col]=0;
			}
		}
		return false;
	}

	static void printBoard() {
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < n; j++) {
	            System.out.print(board[i][j] + " ");
	        }
	        System.out.println();
	    }
	}
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the value of N : ");
		n = sc.nextInt();
		
		if(n<=0)
		{
			System.out.println("Enter a positive no. ");
			sc.close();
			return ;
		}
		
		 board = new int[n][n];
		
		 System.out.println("Enter position of first queen (row and column) : ");
		 int row = sc.nextInt();
		 int col=sc.nextInt();
		 
		 //validate position
		 if(row<1||row>n||col<1||col>n)
		 {
			 System.out.println("Invalid Position !");
			 sc.close();
			 return;
		 }
		 
		 
		   // Place first queen (1-based input)
			 fixedRow = row - 1;
			 board[fixedRow][col - 1] = 1;
			 
			// Display initial board
			 System.out.println("\nInitial Board:");
			 printBoard();
	       
	       //Solve remaining queens 
	       if(solve(0))
	       {
	    	   System.out.println("\nFinal N-Queen Matrix : ");
	    	   printBoard();
	       }
	       else
	       {
	    	   System.out.println("no solution exist for this position !");
	       }
	       
	       sc.close();
		 
		 }
	
}
