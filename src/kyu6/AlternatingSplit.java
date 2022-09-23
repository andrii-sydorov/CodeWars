package kyu6;

import java.util.Scanner;

/**
 * Implement a pseudo-encryption algorithm which given a string S and an integer
 * N concatenates all the odd-indexed characters of S with all the even-indexed
 * characters of S, this process should be repeated N times.
 * 
 * Examples:
 * 
 * encrypt("012345", 1) => "135024"
 * encrypt("012345", 2) => "135024" -> "304152"
 * encrypt("012345", 3) => "135024" -> "304152" -> "012345"
 * 
 * encrypt("01234", 1) => "13024"
 * encrypt("01234", 2) => "13024" -> "32104"
 * encrypt("01234", 3) => "13024" -> "32104" -> "20314"
 * Together with the encryption function, you should also implement a decryption
 * function which reverses the process.
 * 
 * If the string S is an empty value or the integer N is not positive, return
 * the first argument without changes.
 * 
 * This kata is part of the Simple Encryption Series:
 * 
 * Simple Encryption #1 - Alternating Split
 * Simple Encryption #2 - Index-Difference
 * Simple Encryption #3 - Turn The Bits Around
 * Simple Encryption #4 - Qwerty
 * Have fun coding it and please don't forget to vote and rank this kata! :-)
 */

public class AlternatingSplit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(encrypt(text, n));
        System.out.println(decrypt(encrypt(text, n), n));
        sc.close();
    }

    private static String encrypt(String text, int n) {
        if (n <= 0 || text == null) {
            return text;
        }
        String res = text;
        for (int i = 0; i < n; i++) {
            StringBuilder odd = new StringBuilder();
            StringBuilder even = new StringBuilder();
            for (int j = 0; j < res.length(); j++) {
                if (j % 2 == 0) {
                    even.append(Character.toString(res.charAt(j)));
                } else {
                    odd.append(Character.toString(res.charAt(j)));
                }
            }
            res = odd.toString() + even.toString();
        }
        return res;
    }

    public static String decrypt(final String encryptedText, final int n) {
        if (n <= 0 || encryptedText == null) {
            return encryptedText;
        }
        String res = encryptedText;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.setLength(0);
            int index1 = 0;
            int index2 = 0;
            for (int j = 0; index1 + index2 < res.length(); j++) {
                if (j % 2 == 0) {
                    sb.append(Character.toString(res.charAt(index1 + res.length() / 2)));
                    index1++;
                } else {
                    sb.append(Character.toString(res.charAt(index2)));
                    index2++;
                }
            }
            res = sb.toString();
        }
        return res;
    }
}
