package assignment1;

import java.util.Scanner;
public class Q3GreatestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the three numbers: ");
		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		System.out.println("The greatest number is: " + great(x,y,z));
	}

	private static String great(int x, int y, int z) 
	{
		if(x>y && x>z)
			return ("x : " + x);
		else if(y>x && y>z)
			return ("y : " + y);
		else
			return ("z : " + z);
	}

}
