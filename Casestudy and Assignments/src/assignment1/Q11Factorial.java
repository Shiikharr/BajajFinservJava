package assignment1;

import java.util.Scanner;

public class Q11Factorial {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int n=sc.nextInt();
		System.out.println("Factorial of "+n+" is: " + factorial(n));
	}

	private static int factorial(int n) 
	{
		int fact=1;
		for(int i=1;i<=n;i++)
			fact = fact*i;
		return fact;
	}

}
