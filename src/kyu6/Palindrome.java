package kyu6;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * Longest Palindrome
 * 
 * Find the length of the longest substring in the given string s that is the
 * same in reverse.
 * 
 * As an example, if the input was “I like racecars that go fast”, the substring
 * (racecar) length would be 7.
 * 
 * If the length of the input string is 0, the return value must be 0. Example:
 * 
 * "a" -> 1 
 * "aab" -> 2 
 * "abcde" -> 1 
 * "zzbaabcd" -> 4 
 * "" -> 0
 * 
 * 
 */

public class Palindrome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindromeV1(s));
        sc.close();
    }

    /**
     * The first version of solution. The first we build the list of all substring
     * and then check if the elements of thi list palindrome is. If yes, wt choose
     * the longest palindrome
     * 
     * @param s The input string
     * @return the length of the longest palindrome
     */
    private static int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 1; // while in every line is many Palindromes with length equals 1
        List<String> ls = new ArrayList<>();
        for (int i = 2; i <= s.length(); i++) {
            for (int j = 0; j <= s.length() - i; j++) {
                ls.add(s.substring(j, i + j));
            }
        }
        for (String str : ls) {
            if (isPalindrome(str) && str.length() > max) {
                max = str.length();
            }
        }
        return max;
    }

    /**
     * another versio the function longestpalindrome. We started from the longest
     * substring. It is not yet optimal.
     * 
     * @param s Input String
     * @return The length of the longest palindrome
     */
    private static int longestPalindromeV1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 1; // while in every line is many Palindromes with length equals 1
        for (int i = s.length(); i >= 2; i--) {
            for (int j = 0; j <= s.length() - i; j++) {
                String subString = s.substring(j, j + i);
                if (isPalindrome(subString)) {
                    return subString.length();
                }
            }
        }
        return max;
    }

    private static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder sbr = new StringBuilder(s).reverse();
        if (sb.compareTo(sbr) == 0) {
            return true;
        }
        return false;
    }

}
