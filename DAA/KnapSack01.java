package DAA;

import java.util.Scanner;

public class KnapSack01 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter no. of items : ");
		int n =sc.nextInt();
		
		int weight[] = new int[n];
		int profit[] = new int[n];
		
		//input weights and profits
		
		for (int i = 0; i < n; i++) 
		{
			System.out.println("Enter weight of item "+(i+1)+" : ");
			weight[i]=sc.nextInt();
			
			System.out.println("Enter profit of item "+(i+1)+" : ");
			profit[i]=sc.nextInt();
			
		}
		System.out.println("Enter KnapSack capacity : ");
		int capacity =sc.nextInt();
		
		//Create DP table
		int[][] dp = new int[n+1][capacity+1];
		
		//Dynamic Programming 
		for (int i = 1; i <= n; i++) 
		{
			for (int j = 0; j <=capacity; j++) 
			{
				if(weight[i-1]<=j) 
				{
				
					dp[i][j]=Math.max(
						profit[i-1]+dp[i-1][j-weight[i-1]],
						dp[i-1][j]
								);
				}
				else
				{
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		
		//Display maximum profit
		System.out.println("\nMaximum Profit : "+dp[n][capacity]);
		//find selected items
		System.out.println("Selected Items : ");
		int Cap = capacity;
		
		for (int i = n; i > 0; i--) {

            if (dp[i][Cap] != dp[i - 1][Cap]) {

                System.out.println("Item " + i
                    + " (Weight = " + weight[i - 1]
                    + ", Profit = " + profit[i - 1] + ")");

                Cap = Cap - weight[i - 1];
            }
            
        }

		sc.close();
		
	}

}
