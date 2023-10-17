package kyu6;

import java.util.Scanner;

/**
 * Given a variable n,
 * 
 * If n is an integer, Return a string with dash'-'marks before and after each
 * odd integer, but do not begin or end the string with a dash mark. If n is
 * negative, then the negative sign should be removed.
 * 
 * If n is not an integer, return an empty value.
 * 
 * Ex:
 * 
 * dashatize(274) -> '2-7-4'
 * dashatize(6815) -> '68-1-5'
 */

public class Dash {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.valueOf(sc.nextLine());
        sc.close();
        System.out.println(dashatize(num));
    }

    private static String dashatize(int num) {
        String s = null;
        if (num < 0) {
            s = String.valueOf(num).substring(1);
        } else {
            s = String.valueOf(num);
        }
        if (s.length() == 1) {
            return s;
        }
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            if (Character.getNumericValue(ch[i]) % 2 != 0) {
                if (i == 0) {
                    sb.append(Character.toString(ch[i]) + "-");
                } else if (i == ch.length - 1) {
                    sb.append("-" + Character.toString(ch[i]));
                } else {
                    sb.append("-" + Character.toString(ch[i]) + "-");
                }
            } else {
                sb.append(Character.toString(ch[i]));
            }
        }
        return sb.toString().replaceAll("--", "-");
    }
}
