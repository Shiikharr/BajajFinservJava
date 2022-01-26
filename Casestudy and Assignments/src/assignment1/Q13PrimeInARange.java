package assignment1;

import java.util.Scanner;

public class Q13PrimeInARange {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the range from 2 to ");
		int n =sc.nextInt();
		for(int i=2;i<=n;i++)
		{
			if(isPrime(i))
				System.out.print(i+" ");
		}
	}

	private static boolean isPrime(int n) 
	{
		int x=0;
		for(int i=2;i<n;i++)
		{
			if(n%i==0)
			{
				x++;
			}
		}
		if(x==0)
			return true;
		else
			return false;
	}

}
