package kyu7;

import java.util.Scanner;

/**
 * Implement the function which should return true if given object is a vowel
 * (meaning a, e, i, o, u, uppercase or lowercase), and false otherwise.
 * 
 * 
 */

public class Redexpvowel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        System.out.println(isVowel(s));
    }

    public static boolean isVowel(String s) {
        if (s.length() != 1) {
            return false;
        }
        s = s.toLowerCase();
        return "aeiou".indexOf(s) >= 0;
    }
}
