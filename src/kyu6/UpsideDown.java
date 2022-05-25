package kyu6;

import java.util.*;

/**
 * 
 * Consider the numbers 6969 and 9116. When you rotate them 180 degrees (upside
 * down), these numbers remain the same. To clarify, if we write them down on a
 * paper and turn the paper upside down, the numbers will be the same. Try it
 * and see! Some numbers such as 2 or 5 don't yield numbers when rotated.
 * 
 * Given a range, return the count of upside down numbers within that range. For
 * example, solve(0,10) = 3, because there are only 3 upside down numbers >= 0
 * and < 10. They are 0, 1, 8.
 * 
 * More examples in the test cases.
 * 
 * Good luck!
 * 
 * If you like this Kata, please try
 * 
 * Simple Prime Streaming
 * 
 * Life without primes
 * 
 * Please also try the performance version of this kata at Upside down numbers -
 * Challenge Edition
 */

public class UpsideDown {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.close();
        System.out.println(solve(x, y));
    }

    private static int solve(int x, int y) {
        String s = "01689";
        int count = 0;
        while (x < y) {
            if (isRotatible(x, s)) {
                count++;
            }
            x++;
        }
        return count;
    }

    private static boolean isRotatible(int x, String s) {
        String[] sx = String.valueOf(x).split("");
        for (String t : sx) {
            if (s.indexOf(t) < 0) {
                return false;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String t : sx) {
            switch (t) {
                case "1":
                case "0":
                case "8":
                    sb.append(t);
                    break;
                case "6":
                    sb.append("9");
                    break;
                case "9":
                    sb.append("6");
                    break;
            }
        }
        String toCompare = String.valueOf(x);
        return sb.reverse().toString().equals(toCompare);
    }
}
