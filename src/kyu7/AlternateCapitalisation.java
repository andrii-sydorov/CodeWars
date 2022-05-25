package kyu7;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Given a string, capitalize the letters that occupy even indexes and odd
 * indexes separately, and return as shown below. Index 0 will be considered
 * even.
 * 
 * For example, capitalize("abcdef") = ['AbCdEf', 'aBcDeF']. See test cases for
 * more examples.
 * 
 * The input will be a lowercase string with no spaces.
 * 
 * Good luck!
 * 
 * If you like this Kata, please try:
 * 
 * Indexed capitalization
 * 
 * Even-odd disparity
 */

public class AlternateCapitalisation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        System.out.println(Arrays.toString(capitalize(s)));
    }

    private static String[] capitalize(String s) {
        String[] ans = new String[] { "", "" };
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < s.length(); j++) {
                String temp = Character.toString(s.charAt(j));
                if (j % 2 == 0 && i % 2 == 0) {
                    ans[i] += temp.toUpperCase();
                } else if (j % 2 == 1 && i % 2 == 1) {
                    ans[i] += temp.toUpperCase();
                } else {
                    ans[i] += temp;
                }
            }
        }
        return ans;
    }
}
