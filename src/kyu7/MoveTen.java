package kyu7;

import java.util.Scanner;

/**
 * Move every letter in the provided string forward 10 letters through the
 * alphabet.
 * 
 * If it goes past 'z', start again at 'a'.
 * 
 * Input will be a string with length > 0.
 * 
 * 
 */

public class MoveTen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        System.out.println(moveTen(s));
    }

    public static String moveTen(String s) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            ch[i] = (char) (ch[i] + 10);
            if (ch[i] > 'z') {
                ch[i] = (char) ('a' + ch[i] - 'z' - 1);
            }
        }
        return new String(ch);
    }
}
