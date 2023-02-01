package kyu7;

import java.util.Scanner;

/**
 * When provided with a String, capitalize all vowels
 * 
 * For example:
 * 
 * Input : "Hello World!"
 * 
 * Output : "HEllO WOrld!"
 * 
 * Note: Y is not a vowel in this kata.
 */

public class ChangingLetter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        sc.close();
        System.out.println(swap(st));
    }

    public static String swap(String st) {
        char[] ch = st.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (isVowel(ch[i])) {
                ch[i] = Character.toUpperCase(ch[i]);
            }
        }
        return new String(ch);
    }

    public static boolean isVowel(char ch) {
        String vowels = "aeiou";
        ch = Character.toLowerCase(ch);
        return vowels.indexOf(ch) >= 0;
    }
}
