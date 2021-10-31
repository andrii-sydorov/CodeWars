package kyu6;

import java.util.Scanner;

/**
 * For a given string s find the character c (or C) with longest consecutive
 * repetition and return:
 * 
 * Object[]{c, l}; 
 * where l (or L) is the length of the repetition. If there are
 * two or more characters with the same l return the first in order of
 * appearance.
 * 
 * For empty string return:
 * 
 * Object[]{"", 0} Happy coding! :)
 */

public class CharacterWithTheLongestConsequitive {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your's String");
        String s = sc.nextLine();
        sc.close();
        longestRepetition(s);
        System.out.println(s);
    }

    private static Object[] longestRepetition(String s) {
        String ch = null;
        int number = 0;
        String[] st = s.split("");
        int tempMax = 1;
        String temp = null;
        for (int i = 0; i < st.length - 1; i++) {
            temp = st[i];
            if (temp.equals(st[i + 1])) {
                tempMax++;
            } else {
                tempMax = 1;
            }
            if (tempMax > number) {
                number = tempMax;
                ch = temp;
            }

        }
        return new Object[] { ch, number };
    }

}
