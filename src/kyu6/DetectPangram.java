package kyu6;

import java.util.Scanner;

public class DetectPangram {
	/**
	 * A pangram is a sentence that contains every single letter of the alphabet at
	 * least once. For example, the sentence "The quick brown fox jumps over the
	 * lazy dog" is a pangram, because it uses the letters A-Z at least once (case
	 * is irrelevant).
	 * 
	 * Given a string, detect whether or not it is a pangram. Return True if it is,
	 * False if not. Ignore numbers and punctuation.
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your sentence:");
		String sentence = sc.nextLine();
		System.out.println(check(sentence));
		sc.close();
	}

	public static boolean check(String sentence) {
		sentence = sentence.toUpperCase();
		for (char i = 'A'; i <= 'Z'; i++) {
			if (sentence.contains(Character.toString(i))) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
}
