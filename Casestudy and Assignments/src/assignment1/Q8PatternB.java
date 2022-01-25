package assignment1;

import java.util.Scanner;

public class Q8PatternB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of N: ");
		int n = sc.nextInt();
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(n);
			}
			System.out.println();
		}
	}

}
