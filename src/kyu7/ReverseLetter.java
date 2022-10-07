package kyu7;

import java.util.Scanner;

/**
 * Task
 * Given a string str, reverse it and omit all non-alphabetic characters.
 * 
 * Example
 * For str = "krishan", the output should be "nahsirk".
 * 
 * For str = "ultr53o?n", the output should be "nortlu".
 * 
 * Input/Output
 * [input] string str
 * A string consists of lowercase latin letters, digits and symbols.
 * 
 * [output] a string
 * 
 * @author SMD_ASY
 *
 */

public class ReverseLetter {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        scanner.close();
        System.out.println(reverseLetter(string));
    }

    public static String reverseLetter(String str) {
        str = str.replaceAll("[^a-zA-Z]", "");
        StringBuilder sBuilder = new StringBuilder(str);
        return sBuilder.reverse().toString();
    }

}
