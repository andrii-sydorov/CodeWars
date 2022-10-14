package kyu7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * You are given two arrays a1 and a2 of strings. Each string is composed with
 * letters from a to z. Let x be any string in the first array and y be any
 * string in the second array.
 * 
 * Find max(abs(length(x) − length(y)))
 * 
 * If a1 and/or a2 are empty return -1 in each language except in Haskell (F#)
 * where you will return Nothing (None).
 * 
 * Example:
 * a1 = ["hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt",
 * "znnnnfqknaz", "qqquuhii", "dvvvwz"]
 * a2 = ["cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"]
 * mxdiflg(a1, a2) --> 13
 * 
 * @author SMD_ASY
 *
 */

public class MaximumLengthDifference {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        String[] a1 = sc.nextLine().split("\\s+");
        String[] a2 = sc.nextLine().split("\\s+");
        sc.close();
        System.out.println(mxdiflg(a1, a2));
    }

    public static int mxdiflg(String[] a1, String[] a2) {
        if (a1 == null || a2 == null || a1.length == 0 || a2.length == 0) {
            return -1;
        }
        Comparator<String> cmp = (x, y) -> x.length() > y.length() ? 1 : x.length() < y.length() ? -1 : 0;
        Arrays.sort(a1, cmp);
        Arrays.sort(a2, cmp);
        int diff1 = Math.abs(a1[a1.length - 1].length() - a2[0].length());
        int diff2 = Math.abs(a1[0].length() - a2[a2.length - 1].length());
        return diff1 > diff2 ? diff1 : diff2;
    }

}
