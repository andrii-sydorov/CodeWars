package kyu7;

import java.util.Scanner;

/**
 * Return the number (count) of vowels in the given string.
 * 
 * We will consider a, e, i, o, u as vowels for this Kata (but not y).
 * 
 * The input string will only consist of lower case letters and/or spaces.
 */

public class VowelCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        System.out.println(getCount(str));
    }

    private static int getCount(String str) {
        int count = 0;
        StringBuilder sb = new StringBuilder("aeiouAEIOU");
        for (int i = 0; i < str.length(); i++) {
            if (sb.indexOf(Character.toString(str.charAt(i))) >= 0) {
                count++;
            }
        }
        return count;
    }
}
