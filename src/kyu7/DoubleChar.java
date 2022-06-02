package kyu7;

import java.util.Scanner;

/**
 * Double Char
 * 
 * Given a string, you have to return a string in which each character
 * (case-sensitive) is repeated once.
 * Examples (Input -> Output):
 * 
 * "String" -> "SSttrriinngg"
 * "Hello World" -> "HHeelllloo WWoorrlldd"
 * "1234!_ " -> "11223344!!__ "
 * 
 * Good Luck!
 * 
 */

public class DoubleChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(doubleChar(s));
    }

    private static String doubleChar(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String str = Character.toString(s.charAt(i));
            for (int j = 0; j < 2; j++) {
                sb.append(str);
            }
        }
        return sb.toString();
    }
}
