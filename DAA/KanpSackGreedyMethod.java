package DAA;

import java.util.Arrays;
import java.util.Scanner;

class Items
{
	int weight , profit;
	double ratio;
	public Items(int weight, int profit) {
		super();
		this.weight = weight;
		this.profit = profit;
		this.ratio = (double)profit/weight;
	}
	
	
}

public class KanpSackGreedyMethod 
{

	public static void main(String[] args) 
	{
		Scanner	sc  = new Scanner(System.in);
		
		System.out.println("Enter no. of items : ");
		int n = sc.nextInt();
		
		Items[] items = new Items[n];
		
		for (int i = 0; i < n; i++) 
		{
			System.out.println("Enter wright of item "+(i+1)+" :");
			int weight = sc.nextInt();
			System.out.println("Enter profit of item "+(i+1)+" :");
			int profit = sc.nextInt();
			
			items[i]=new Items(weight, profit);
			
		}
		
		System.out.println("Enter knapsack capacity : ");
		int capacity = sc.nextInt();
		
		//sort array by profit/weight ratio in descending order 
		
		Arrays.sort(items,(a,b)-> Double.compare(b.ratio, a.ratio));
		
		double totalProfit = 0;
		
		System.out.println("\nSelected Items : ");
		
		for (int i = 0; i < n; i++) 
		{
			if(capacity==0)
			{
				break;
			}
			
			if(items[i].weight<=capacity)
			{
				//take complete item
				capacity -= items[i].weight;
				totalProfit +=items[i].profit;
				
				System.out.println("Full item taken : weight ="
						+items[i].weight+" ,Profit = "
						+items[i].profit);
			}
			else
			{
				//take fraction of item
				double fraction = (double) capacity/items[i].weight;
				
				totalProfit+=items[i].profit*fraction;
				
				System.out.println("Fraction taken : "+fraction);
				
				capacity =0;
					
			}
			
			System.out.println("\nMaximum Profit"+totalProfit);
			
			sc.close();
			
			
		}
	}

}
