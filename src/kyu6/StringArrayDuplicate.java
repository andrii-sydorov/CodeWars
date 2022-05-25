package kyu6;

import java.util.*;

/**
 * In this Kata, you will be given an array of strings and your task is to
 * remove all consecutive duplicate letters from each string in the array.
 * 
 * For example:
 * 
 * dup(["abracadabra","allottee","assessee"]) = ["abracadabra","alote","asese"].
 * 
 * dup(["kelless","keenness"]) = ["keles","kenes"].
 * 
 * Strings will be lowercase only, no spaces. See test cases for more examples.
 * 
 * Good luck!
 * 
 * If you like this Kata, please try:
 * 
 * Alternate capitalization
 * 
 * Vowel consonant lexicon
 */

public class StringArrayDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split("\\s+");
        sc.close();
        System.out.println(Arrays.toString(dup(arr)));
    }

    private static String[] dup(String[] arr) {
        String[] ans = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            String t = arr[i];
            ans[i] = "";
            //arr[i] = arr[i].replaceAll("(.)\\1+", "$1");
            for (int j = 0; j < t.length(); j++) {
                if (j == 0) {
                    ans[i] += Character.toString(t.charAt(j));
                }
                if (ans[i].lastIndexOf(Character.toString(t.charAt(j))) != ans[i].length() - 1) {
                    ans[i] += Character.toString(t.charAt(j));
                }
            }
        }
        return ans;
    }
}
