package kyu8;

import java.util.Scanner;

/**
 * 
 * Can you find the needle in the haystack?
 * 
 * Write a function findNeedle() that takes an array full of junk but containing
 * one "needle"
 * 
 * After your function finds the needle it should return a message (as a string)
 * that says:
 * 
 * "found the needle at position " plus the index it found the needle, so:
 * 
 * findNeedle(new Object[] {"hay", "junk", "hay", "hay", "moreJunk", "needle", "randomJunk"})
 * should return "found the needle at position 5" (in COBOL "found the needle at
 * position 6"
 */

public class FindNeedle {
    public static void main(String[] ans) {
        Scanner sc = new Scanner(System.in);
        Object[] haystack = sc.nextLine().split("\\s+");
        sc.close();
        System.out.println(findNeedle(haystack));
    }

    private static String findNeedle(Object[] haystack) {
        String a = "found the needle at position ";
        for (int i = 0; i < haystack.length; i++) {
            if (haystack[i] != null && haystack[i].equals("needle")) {
                return a + i;
            }
        }
        return null;
    }
}
