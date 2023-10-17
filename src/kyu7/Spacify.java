package kyu7;

import java.util.Scanner;

/**
 * Modify the spacify function so that it returns the given string with spaces
 * inserted between each character.
 * 
 * spacify("hello world") // returns "h e l l o w o r l d"
 */

public class Spacify {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        System.out.println(spacify(s));
    }

    private static String spacify(String s) {
        return String.join(" ", s.split(""));
    }
}
