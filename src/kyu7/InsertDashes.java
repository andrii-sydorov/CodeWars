package kyu7;

import java.util.Scanner;

/**
 * Write a function insert_dash(num) / insertDash(num) / InsertDash(int num)
 * that will insert dashes ('-') between each two odd digits in num. For
 * example: if num is 454793 the output should be 4547-9-3. Don't count zero as
 * an odd digit.
 * 
 * Note that the number will always be non-negative (>= 0).
 */

public class InsertDashes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.valueOf(sc.nextLine());
        sc.close();
        System.out.println(insertDash(num));
    }

    public static String insertDash(int num) {
        StringBuilder sb = new StringBuilder();
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) {
                sb.append(s.charAt(i));
                break;
            }
            if (Character.getNumericValue(s.charAt(i)) % 2 != 0
                    && Character.getNumericValue(s.charAt(i + 1)) % 2 != 0) {
                sb.append(s.charAt(i) + "-");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
