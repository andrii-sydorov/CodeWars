package kyu6;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * You are given an array(list) strarr of strings and an integer k. Your task is
 * to return the first longest string consisting of k consecutive strings taken
 * in the array.
 * 
 * Examples:
 * strarr = ["tree", "foling", "trashy", "blue", "abcdef", "uvwxyz"], k = 2
 * 
 * Concatenate the consecutive strings of strarr by 2, we get:
 * 
 * treefoling (length 10) concatenation of strarr[0] and strarr[1]
 * folingtrashy (" 12) concatenation of strarr[1] and strarr[2]
 * trashyblue (" 10) concatenation of strarr[2] and strarr[3]
 * blueabcdef (" 10) concatenation of strarr[3] and strarr[4]
 * abcdefuvwxyz (" 12) concatenation of strarr[4] and strarr[5]
 * 
 * Two strings are the longest: "folingtrashy" and "abcdefuvwxyz".
 * The first that came is "folingtrashy" so
 * longest_consec(strarr, 2) should return "folingtrashy".
 * 
 * In the same way:
 * longest_consec(["zone", "abigail", "theta", "form", "libe", "zas", "theta",
 * "abigail"], 2) --> "abigailtheta"
 * n being the length of the string array, if n = 0 or k > n or k <= 0 return ""
 * (return Nothing in Elm, "nothing" in Erlang).
 * 
 * Note
 * consecutive strings : follow one after another without an interruption
 * 
 * @author SMD_ASY
 *
 */

public class ConsecutiveStrings {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        String[] strarrStrings = scanner.nextLine().split("\\s+");
        int k = Integer.valueOf(scanner.nextLine());
        scanner.close();
        System.out.println(longestConsec(strarrStrings, k));
    }

    public static String longestConsec(String[] strarr, int k) {
        if (k <= 0 || k > strarr.length) {
            return "";
        }
        if (strarr == null || strarr.length == 0) {
            return "";
        }
        List<String> ls = new LinkedList<>();
        for (int i = 0; i <= strarr.length - k; i++) {
            String string = "";
            for (int j = i; j < i + k; j++) {
                string += strarr[j];
            }
            ls.add(string);
        }
        ls.sort((x, y) -> x.length() > y.length() ? 1 : x.length() < y.length() ? -1 : 0);
        int max = ls.get(ls.size() - 1).length();
        for (String string : ls) {
            if (string.length() == max) {
                return string;
            }
        }
        return null;
    }

}
