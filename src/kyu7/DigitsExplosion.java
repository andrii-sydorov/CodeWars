package kyu7;

import java.util.Scanner;

/**
 * Given a string made of digits [0-9], return a string where each digit is
 * repeated a number of times equals to its value.
 * 
 * Examples
 * explode("312")
 * should return :
 * 
 * "333122"
 * explode("102269")
 * should return :
 * 
 * "12222666666999999999"
 */

public class DigitsExplosion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String digits = sc.nextLine();
        sc.close();
        System.out.println(explode(digits));
    }

    public static String explode(String digits) {
        StringBuilder sb = new StringBuilder();
        String[] arr = digits.split("");
        for (String s : arr) {
            int t = Integer.valueOf(s);
            for (int i = 1; i <= t; i++) {
                sb.append(s);
            }
        }
        return sb.toString();
    }
}
