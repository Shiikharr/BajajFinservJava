package assignment1;

import java.util.Scanner;

public class Q14Reverse {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number:");
		int n=sc.nextInt();
		System.out.println("Reverse of "+n+" : "+reverse(n));
	}

	private static int reverse(int n) {
		int s=0;
		while(n!=0)
		{
			int r=n%10;
			s=s*10+r;
			n=n/10;
		}
		return s;
	}

}
