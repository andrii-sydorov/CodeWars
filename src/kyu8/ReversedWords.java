package kyu8;

import java.util.Scanner;

/**
 * Complete the solution so that it reverses all of the words within the string
 * passed in.
 * 
 * Example:
 * 
 * ReverseWords.reverseWords("The greatest victory is that which requires no
 * battle"); 
 * // should return "battle no requires which that is victory greatest The"
 * 
 * @author Zver
 *
 */
public class ReversedWords {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter toyr phrase:");
		String str = sc.nextLine();
		System.out.println(reverseWords(str));
		sc.close();
	}

	public static String reverseWords(String str) {
		StringBuilder sb = new StringBuilder();
		String[] arrStr = str.split(" ");
		for (int i = 0; i < arrStr.length; i++) {
			sb.append(arrStr[arrStr.length - 1 - i] + " ");
		}
		return sb.toString().trim();
	}
}
