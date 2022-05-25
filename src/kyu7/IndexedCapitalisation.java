package kyu7;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Given a string and an array of integers representing indices, capitalize all
 * letters at the given indices.
 * 
 * For example:
 * 
 * capitalize("abcdef",[1,2,5]) = "aBCdeF"
 * capitalize("abcdef",[1,2,5,100]) = "aBCdeF". There is no index 100.
 * The input will be a lowercase string with no spaces and an array of digits.
 * 
 * Good luck!
 * 
 * Be sure to also try:
 * 
 * Alternate capitalization
 * 
 * String array revisal
 */

public class IndexedCapitalisation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] index = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        System.out.println(capitalize(s, index));
    }

    private static String capitalize(String s, int[] index) {
        String ans = "";
        for (int i = 0, j = 0; i < s.length(); i++) {
            String str = Character.toString(s.charAt(i));
            if (j < index.length && i == index[j]) {
                ans += str.toUpperCase();
                j++;
                continue;
            }
            ans += str;
        }
        return ans;
    }
}
