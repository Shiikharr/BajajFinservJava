package assignment1;

import java.util.Scanner;
public class Q2SwapNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the numbers: ");
		int x= sc.nextInt();
		int y= sc.nextInt();
		System.out.println("Before swapping");
		System.out.println("x: "+x+" y: "+y);
		System.out.println("After swapping");
		swap(x,y);
	}

	private static void swap(int x, int y) {
		int t=x;
		x=y;
		y=t;
		System.out.println("x: "+x+" y: "+y);
	}

}
