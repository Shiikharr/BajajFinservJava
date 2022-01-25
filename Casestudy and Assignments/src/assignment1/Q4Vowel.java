package assignment1;

import java.util.Scanner;

public class Q4Vowel {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char ch = sc.next().charAt(0);
		System.out.println("Vowel or not using switch case : "+vowelSwitch(ch));
		System.out.println("Vowel or not using if and else : "+vowelifElse(ch));
	}

	private static String vowelifElse(char ch) {
		ch = Character.toLowerCase(ch);
		return (ch == 'a' || ch == 'e' || ch == 'i' || 
				ch == 'o' || ch == 'u')? "yes" : "no";
	}

	private static String vowelSwitch(char ch) {
		ch = Character.toLowerCase(ch);
		switch(ch)
		{
		case 'a':
			return "yes";
		case 'e':
			return "yes";
		case 'i':
			return "yes";
		case 'o':
			return "yes";
		case 'u':
			return "yes";
		default:
			return "no";
		}
	}

}
