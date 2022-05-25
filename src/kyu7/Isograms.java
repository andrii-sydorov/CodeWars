package kyu7;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

/**
 * An isogram is a word that has no repeating letters, consecutive or
 * non-consecutive. Implement a function that determines whether a string that
 * contains only letters is an isogram. Assume the empty string is an isogram.
 * Ignore letter case.
 * 
 * Example: (Input --> Output)
 * 
 * "Dermatoglyphics" --> true
 * "aba" --> false
 * "moOse" --> false (ignore letter case)
 * 
 * 
 */

public class Isograms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        System.out.println(isIsogram(str));
    }

    private static boolean isIsogram(String str) {
        Set<String> set = new HashSet<>();
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            set.add(Character.toString(str.charAt(i)));
        }
        return str.length() == set.size();
    }
}
