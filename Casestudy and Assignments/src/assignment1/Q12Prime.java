package assignment1;

import java.util.Scanner;

public class Q12Prime {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number:");
		int n=sc.nextInt();
		int x=0;
		for(int i=2;i*i<n;i++)
		{
			if(n%i==0)
			{
				x++;
			}
		}
		if(x==0 && n!=1 && n!=0)
			System.out.println("It is a prime number.");
		else
			System.out.println("It is not a prime number.");
	}

}
