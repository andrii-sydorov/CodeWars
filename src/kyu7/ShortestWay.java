package kyu7;

import java.util.Scanner;

/**
 * Simple, given a string of words, return the length of the shortest word(s).
 * 
 * String will never be empty and you do not need to account for different data
 * types.
 */

public class ShortestWay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(findShort(s));
    }

    private static int findShort(String s) {
        String[] arr = s.split("\\s+");
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() < min) {
                min = arr[i].length();
            }
        }
        return min;
    }
}
