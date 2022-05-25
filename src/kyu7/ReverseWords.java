package kyu7;

import java.util.Scanner;

/**
 * Complete the function that accepts a string parameter, and reverses each word
 * in the string. All spaces in the string should be retained.
 * Examples
 * 
 * "This is an example!" ==> "sihT si na !elpmaxe"
 * "double spaces" ==> "elbuod secaps"
 * 
 * 
 */

public class ReverseWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        System.out.println(reverseWords(str));
        System.out.println(reverseWordsWithoutMarks(str));
    }

    private static String reverseWordsWithoutMarks(final String original) {
        StringBuilder sb = new StringBuilder();
        char[] data = original.toCharArray();
        StringBuilder t = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            if (data[i] != ' ') {
                t.append(data[i]);
                continue;
            }
            if (t.length() != 0) {
                t.reverse();
                sb.append(t);
                t.setLength(0);
            }
            sb.append(data[i]);
        }
        return sb.append(t.reverse()).toString();
    }

    private static String reverseWords(final String original) {
        String[] data = original.split("\\s+");
        String[] ans = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            StringBuilder sb = new StringBuilder(data[i]);
            ans[i] = sb.reverse().toString();
        }
        return String.join(" ", ans);
    }
}
