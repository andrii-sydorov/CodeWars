package kyu6;

import java.util.Scanner;

/**
 * Given a string of words, you need to find the highest scoring word.
 * 
 * Each letter of a word scores points according to its position in the
 * alphabet: a = 1, b = 2, c = 3 etc.
 * 
 * You need to return the highest scoring word as a string.
 * 
 * If two words score the same, return the word that appears earliest in the
 * original string.
 * 
 * All letters will be lowercase and all inputs will be valid.
 */

public class HighingScoringWorld {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your word's");
        String s = sc.nextLine();
        System.out.println(high(s));
    }

    private static String high(String s) {
        String res = null;
        String[] words = s.split(" ");
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        int maxSum = 0;
        for (int i = 0; i < words.length; i++) {
            char[] ch = words[i].toCharArray();
            int currentSum = 0;
            for (int j = 0; j < ch.length; j++) {
                currentSum += alphabets.indexOf(Character.toString(ch[j])) + 1;
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                res = words[i];
            }
        }
        return res;
    }
}