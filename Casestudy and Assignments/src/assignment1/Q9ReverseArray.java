package assignment1;

import java.util.Scanner;

public class Q9ReverseArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array: ");
		int n = sc.nextInt();
		int a[]=new int[n];
		System.out.println("Enter the array elements:");
		for(int i=0; i<n;i++)
			a[i] = sc.nextInt();
		System.out.println("original array: ");
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
		int i=0,j=n-1;
		while(i<j)
		{
			int t = a[i];
			a[i] = a[j];
			a[j] = t;
			i++;
			j--;
		}
		System.out.println("\nreversed array: ");
		for(int k=0;k<n;k++)
			System.out.print(a[k]+" ");
	}

}
