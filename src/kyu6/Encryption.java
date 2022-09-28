package kyu6;

import java.util.Scanner;

/**
 * Acknowledgments:
 * I thank yvonne-liu for the idea and for the example tests :)
 * 
 * Description:
 * Encrypt this!
 * 
 * You want to create secret messages which can be deciphered by the Decipher
 * this! kata. Here are the conditions:
 * 
 * Your message is a string containing space separated words.
 * You need to encrypt each word in the message using the following rules:
 * The first letter must be converted to its ASCII code.
 * The second letter must be switched with the last letter
 * Keepin' it simple: There are no special characters in the input.
 * Examples:
 * Kata.encryptThis("Hello") => "72olle"
 * Kata.encryptThis("good") => "103doo"
 * Kata.encryptThis("hello world") => "104olle 119drlo"
 */

public class Encryption {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        sc.close();
        System.out.println(encryptThis(text));
        System.out.println(
                "65 119esi 111dl 111lw 108dvei 105n 97n 111ka".equals(encryptThis("A wise old owl lived in an oak")));
        System.out.println("65 119esi 111dl 111lw 108dvei 105n 97n 111ka".length());
        System.out.println(encryptThis("A wise old owl lived in an oak").length());
    }

    private static String encryptThis(String text) {
        String[] data = text.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            String s = data[i];
            for (int j = 0; j < s.length(); j++) {
                if (j == 0) {
                    sb.append(String.valueOf((int) s.charAt(j)));
                } else if (j == 1) {
                    sb.append(s.charAt(s.length() - 1));
                } else if (j == s.length() - 1) {
                    sb.append(s.charAt(1));
                } else {
                    sb.append(s.charAt(j));
                }
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
