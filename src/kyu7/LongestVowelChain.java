package kyu7;

import java.util.Scanner;
import static java.util.stream.Stream.of;

/**
 * The vowel substrings in the word codewarriors are o,e,a,io. The longest of
 * these has a length of 2. Given a lowercase string that has alphabetic
 * characters only (both vowels and consonants) and no spaces, return the length
 * of the longest vowel substring. Vowels are any of aeiou.
 * 
 * Good luck!
 * 
 * If you like substring Katas, please try:
 * 
 * Non-even substrings
 * 
 * Vowel-consonant lexicon
 */

public class LongestVowelChain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(solve(s));
        sc.close();
    }

    public static int solve(String s) {
        String vowels = "aeiou";
        int result = 0;
        int currentResult = 0;
        for (int i = 0; i < s.length(); i++) {
            String temp = Character.toString(s.charAt(i));
            if (vowels.contains(temp)) {
                currentResult++;
            } else {
                if (currentResult > result) {
                    result = currentResult;
                }
                currentResult = 0;
            }
        }
        return result > currentResult ? result : currentResult;
    }

    static int solve1(String s) {
        return of(s.split("[^aeiou]")).mapToInt(String::length).max().orElse(0);
      }
}
