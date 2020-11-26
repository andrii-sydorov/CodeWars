package tasks;

import java.util.Arrays;
import java.util.Scanner;
import static java.util.stream.Stream.of;

/**
 * Given a lowercase string that has alphabetic characters only and no spaces,
 * return the highest value of consonant substrings. Consonants are any letters
 * of the alphabet except "aeiou".
 * 
 * We shall assign the following values: a = 1, b = 2, c = 3, .... z = 26.
 * 
 * For example, for the word "zodiacs", let's cross out the vowels. We get: "z o
 * d ia cs"
 * 
 * -- The consonant substrings are: "z", "d" and "cs" and the values are z = 26,
 * d = 4 and cs = 3 + 19 = 22. The highest is 26. solve("zodiacs") = 26
 * 
 * For the word "strength", solve("strength") = 57 -- The consonant substrings
 * are: "str" and "ngth" with values "str" = 19 + 20 + 18 = 57 and "ngth" = 14 +
 * 7 + 20 + 8 = 49. The highest is 57.
 * 
 * @author Zver
 *
 */
public class ConsonantValue {
	public static void main(String[] args) {
		System.out.print("Enter your's expression:");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(solve(s));
		// System.out.println(sumOfCharWithoutVowel(s));
		Solution sol = new Solution();
		System.out.println(sol.solve(s));
		System.out.println(Arrays.toString(s.split("[aeiou]")));
		sc.close();
	}

	public static int solve(final String s) {
		char[] alphabet = new char[26];
		char start = 'a';
		for (int i = 0; i < alphabet.length; i++) {
			alphabet[i] = start;
			start++;
		}
		String[] stArr = s.replaceAll("[aeiou]", " ").split("\\s+");
		int[] maxVal = new int[stArr.length];
		for (int i = 0; i < stArr.length; i++) {
			char[] chArr = stArr[i].toCharArray();
			for (int j = 0; j < chArr.length; j++) {
				for (int k = 0; k < alphabet.length; k++) {
					if (chArr[j] == alphabet[k]) {
						maxVal[i] += k + 1;
						break;
					}
				}
			}

		}
		Arrays.sort(maxVal);
		return maxVal[maxVal.length - 1];
	}

	public static int sumOfCharWithoutVowel(final String s) {
		char[] alphabet = new char[26];
		char start = 'a';
		for (int i = 0; i < alphabet.length; i++) {
			alphabet[i] = start;
			start++;
		}
		char[] phrase = s.toCharArray();
		int res = 0;
		char[] vowel = new char[] { 'a', 'e', 'i', 'o', 'u' };
		for (int i = 0; i < phrase.length; i++) {
			int temp = 0;
			for (int k = 0; k < alphabet.length; k++) {
				if (phrase[i] == alphabet[k]) {
					temp = k + 1;
				}
			}
			boolean isVowel = false;
			for (int j = 0; j < vowel.length; j++) {
				if (phrase[i] == vowel[j]) {
					isVowel = true;
					break;
				}
			}
			if (isVowel) {
				continue;
			}
			res += temp + 1;
		}
		return res;
	}
}

/**
 * not my from best codewars solution
 * 
 * @author Zver
 *
 */
class Solution {
	static int solve(String s) {
		return of(s.split("[aeiou]")).mapToInt(con -> con.chars().map(c -> c - 96).sum()).max().orElse(0);
	}

	public static int solve2(final String s) {
		int sum = 0, maxsum = 0;
		char[] arr = s.toCharArray();
		for (char c : arr) {
			if ("aeiou".indexOf(c) >= 0)
				sum = 0;
			else {
				sum += c - 'a' + 1;
				maxsum = Math.max(sum, maxsum);
			}
		}
		return maxsum;
	}

	public static int solve3(final String s) {
		String s2 = "aeiou";
		int sum = 0, x = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s2.contains("" + s.charAt(i))) {
				sum = Math.max(sum, x);
				x = 0;
			} else {
				x += (int) s.charAt(i) - 96;
			}
		}
		sum = Math.max(sum, x);
		return sum;
	}
}
