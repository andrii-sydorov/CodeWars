package kyu5;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Your task is to Combine two Strings. But consider the rule...
 * 
 * By the way you don't have to check errors or incorrect input values,
 * everything is ok without bad tricks, only two input strings and as result one
 * output string;-)...
 * 
 * And here's the rule: Input Strings a and b: For every character in string a
 * swap the casing of every occurrence of the same character in string b. Then
 * do the same casing swap with the inputs reversed. Return a single string
 * consisting of the changed version of a followed by the changed version of b.
 * A char of a is in b regardless if it's in upper or lower case - see the
 * testcases too. I think that's all;-)...
 * 
 * Some easy examples:
 * 
 * Input: "abc" and "cde" => Output: "abCCde" 
 * Input: "ab" and "aba" => Output:  "aBABA" 
 * Input: "abab" and "bababa" => Output: "ABABbababa"
 * 
 * Once again for the last example - description from KenKamau, see
 * discourse;-):
 * 
 * a) swap the case of characters in string b for every occurrence of that
 * character in string a char 'a' occurs twice in string a, so we swap all 'a'
 * in string b twice. This means we start with "bababa" then "bAbAbA" =>
 * "bababa" char 'b' occurs twice in string a and so string b moves as follows:
 * start with "bababa" then "BaBaBa" => "bababa"
 * 
 * b) then, swap the case of characters in string a for every occurrence in
 * string b char 'a' occurs 3 times in string b. So string a swaps cases as
 * follows: start with "abab" then => "AbAb" => "abab" => "AbAb" char 'b' occurs
 * 3 times in string b. So string a swaps as follow: start with "AbAb" then =>
 * "ABAB" => "AbAb" => "ABAB".
 * 
 * c) merge new strings a and b return "ABABbababa"
 * 
 * There are some static tests at the beginning and many random tests if you
 * submit your solution.
 * 
 * @author ASY
 *
 */
public class PlayWithTwoStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your's String: ");
		String[] strArr = sc.nextLine().split(" ");
		String a = strArr[0];
		String b = strArr[1];
		sc.close();
		System.out.println(workOnStrings(a, b));
	}

	public static String workOnStrings(String a, String b) {
		HashMap<Integer, Character> hsChA = new HashMap<Integer, Character>();
		HashMap<Integer, Character> hsChB = new HashMap<Integer, Character>();
		char[] chA = a.toCharArray();
		char[] chB = b.toCharArray();
		for (int i = 0; i < chA.length; i++) {
			hsChA.put(i, chA[i]);
		}
		for (int i = 0; i < chB.length; i++) {
			hsChB.put(i, chB[i]);
		}
		// String a -> String b
		for (int i = 0; i < hsChA.size(); i++) {
			for (int j = 0; j < hsChB.size(); j++) {
				if (Character.toUpperCase(hsChA.get(i)) == Character.toUpperCase(hsChB.get(j))) {
					if (Character.isUpperCase(hsChB.get(j))) {
						hsChB.put(j, Character.toLowerCase(chB[j]));
					} else {
						hsChB.put(j, Character.toUpperCase(chB[j]));
					}
				}
			}
		}
		// String b -> String a
		for (int i = 0; i < hsChB.size(); i++) {
			for (int j = 0; j < hsChA.size(); j++) {
				if (Character.toUpperCase(hsChB.get(i)) == Character.toUpperCase(hsChA.get(j))) {
					if (Character.isUpperCase(hsChA.get(j))) {
						hsChA.put(j, Character.toLowerCase(chA[j]));
					} else {
						hsChA.put(j, Character.toUpperCase(chA[j]));
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < hsChA.size(); i++) {
			sb.append(hsChA.get(i));
		}
		for (int i = 0; i < hsChB.size(); i++) {
			sb.append(hsChB.get(i));
		}
		return sb.toString();
	}
}
