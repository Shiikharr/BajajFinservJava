package assignment1;

import java.util.Scanner;

public class Q8PatternA {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of N: ");
		int n = sc.nextInt();
		
		for(int i=1;i<=n ; i++)
		{
			for(int j=1; j<=i;j++)
			{
				System.out.print(i);
			}
			System.out.println();
		}
	}

}
