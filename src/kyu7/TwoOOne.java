package kyu7;

import java.util.*;

/**
 * Take 2 strings s1 and s2 including only letters from a to z. Return a new
 * sorted string, the longest possible, containing distinct letters - each taken
 * only once - coming from s1 or s2.
 * 
 * Examples:
 * a = "xyaabbbccccdefww"
 * b = "xxxxyyyyabklmopq"
 * longest(a, b) -> "abcdefklmopqwxy"
 * 
 * a = "abcdefghijklmnopqrstuvwxyz"
 * longest(a, a) -> "abcdefghijklmnopqrstuvwxyz"
 */

public class TwoOOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        sc.close();
        System.out.println(longest(a, b));
    }

    private static String longest(String s1, String s2) {
        TreeSet<String> set = new TreeSet<>();
        String[] arr = (s1 + s2).split("");
        for (String s : arr) {
            set.add(s);
        }
        String ans = "";
        for (String s : set) {
            ans += s;
        }
        return ans;
    }
}
