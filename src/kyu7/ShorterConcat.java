package kyu7;

import java.util.Scanner;

/**
 * Given 2 strings, a and b, return a string of the form:
 * shorter+reverse(longer)+shorter.
 * 
 * In other words, the shortest string has to be put as prefix and as suffix of
 * the reverse of the longest.
 * 
 * Strings a and b may be empty, but not null (In C# strings may also be null.
 * Treat them as if they are empty.).
 * If a and b have the same length treat a as the longer producing
 * b+reverse(a)+b
 */

public class ShorterConcat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        sc.close();
        System.out.println(shorterReverseLonger(a, b));
    }

    public static String shorterReverseLonger(String a, String b) {
        if (a.length() == b.length()) {
            return b + reverse(a) + b;
        } else if (a.length() > b.length()) {
            return b + reverse(a) + b;
        }
        return a + reverse(b) + a;
    }

    public static String reverse(String s) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length / 2; i++) {
            char temp = ch[i];
            ch[i] = ch[ch.length - 1 - i];
            ch[ch.length - 1 - i] = temp;
        }
        return new String(ch);
    }
}
