package assignment1;

import java.util.Scanner;

public class Q8PatternC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of N: ");
		int n = sc.nextInt();
		for(int i = n;i>=0;i--)
		{
			for(int j=i;j>0;j--)
				System.out.print(" ");
			for(int j = 0;j<n-i;j++)
				System.out.print("*");
			System.out.println();
		}
	}

}
