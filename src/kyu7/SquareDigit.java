package kyu7;

import java.util.Scanner;

/**
 * 
 * Square Every Digit
 * 
 * Welcome. In this kata, you are asked to square every digit of a number and
 * concatenate them.
 * 
 * For example, if we run 9119 through the function, 811181 will come out,
 * because 92 is 81 and 12 is 1.
 * 
 * Note: The function accepts an integer and returns an integer
 * 
 */

public class SquareDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        sc.close();
        System.out.println(squareDigits(n));
    }

    private static int squareDigits(int n) {
        if (n == 0) {
            return n;
        }
        String s = String.valueOf(n);
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            ans += Character.getNumericValue(s.charAt(i)) * Character.getNumericValue(s.charAt(i));
        }
        return Integer.valueOf(ans);
    }
}
