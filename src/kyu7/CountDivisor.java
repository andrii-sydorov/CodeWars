package kyu7;

import java.util.Scanner;

/**
 * Count the divisors of a number
 * 
 * Count the number of divisors of a positive integer n.
 * 
 * Random tests go up to n = 500000.
 * 
 * Examples (input --> output)
 * 4 --> 3 (1, 2, 4)
 * 5 --> 2 (1, 5)
 * 12 --> 6 (1, 2, 3, 4, 6, 12)
 * 30 --> 8 (1, 2, 3, 5, 6, 10, 15, 30)
 */

public class CountDivisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(numberOfDivisors(n));
        sc.close();
    }

    private static int numberOfDivisors(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                res++;
            }
        }
        return res;
    }
}
