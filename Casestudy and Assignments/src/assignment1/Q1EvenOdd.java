package assignment1;

import java.util.Scanner;
public class Q1EvenOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number:");
		int n = sc.nextInt();
		System.out.println("The number " + n + " is: " + evenOdd(n));
	}

	private static String evenOdd(int n) {
		String x = (n%2==0)? "Even" : "Odd" ;
		return x;
	}

}
