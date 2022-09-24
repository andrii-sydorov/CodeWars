package kyu6;

import java.util.Scanner;

/**
 * Jamie is a programmer, and James' girlfriend. She likes diamonds, and wants a
 * diamond string from James. Since James doesn't know how to make this happen,
 * he needs your help.
 * 
 * Task
 * You need to return a string that looks like a diamond shape when printed on
 * the screen, using asterisk (*) characters. Trailing spaces should be removed,
 * and every line must be terminated with a newline character (\n).
 * 
 * Return null/nil/None/... if the input is an even number or negative, as it is
 * not possible to print a diamond of even or negative size.
 * 
 * Examples
 * A size 3 diamond:
 *    *
 *   ***
 *    *
 * 
 * ...which would appear as a string of " *\n***\n *\n"
 * 
 * A size 5 diamond:
 *    *
 *   ***
 *  *****
 *   ***
 *    *
 * 
 * ...that is:
 * 
 * " *\n ***\n*****\n ***\n *\n"
 */

public class Diamond {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        System.out.println(print(n));
        sc.close();
    }

    private static String print(int n) {
        if (n <= 0 || n % 2 == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int starNumber = 0;
        boolean half = false;
        for (int i = 1; i <= n; i++) {
            half = (n / 2 + 1) >= i;
            if (half) {
                starNumber = 1 + (i - 1) * 2;
            } else {
                starNumber -= 2;
            }
            int left = (n - starNumber) / 2;
            int right = n - (n - starNumber) / 2;
            for (int j = 0; j < n; j++) {
                if (j < left) {
                    sb.append(" ");
                } else if (j >= right) {
                    continue;
                    // sb.append("");
                } else {
                    sb.append("*");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
