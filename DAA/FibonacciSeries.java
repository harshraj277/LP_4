package DAA;

import java.util.Scanner;

public class FibonacciSeries {

	
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter no. of terms :");
		int n = sc.nextInt();
		
		if(n<0)
		{
			System.out.println("Enter a non-negative integer ");
			sc.close();
			return;
		}
		
		nonRecursive(n);
		
		System.out.println("Fibonacci Series Using Recursive Method : ");
		for (int i = 0; i < n; i++) 
		{
			System.out.print(recursive(i)+" ");
		}
		
		sc.close();
	}

	private static int  recursive(int n) 
	{
		if(n<=1)
		{
			return n;
		}
		
		return recursive(n-1) + recursive(n-2);
		
	}

	private static void nonRecursive(int n) 
	{
		int a=0 ,b=1;
		
		System.out.println("Fibonacci Series Using Non-recursive Method : ");
		for (int i = 0; i < n; i++) 
		{
			System.out.print(a+" ");
			int c=a+b;
			a=b;
			b=c;
			
		}
		
		System.out.println();
		
	
	}

	
	
}
