package kyu6;

import java.util.Scanner;

/**
 * Consider a sequence made up of the consecutive prime numbers. This infinite
 * sequence would start with:
 * 
 * "2357111317192329313741434753596167717379..."
 * You will be given two numbers: a and b, and your task will be to return b
 * elements starting from index a in this sequence.
 * 
 * For example:
 * solve(10,5) == `19232` Because these are 5 elements from index 10 in the
 * sequence.
 * Tests go up to about index 20000.
 * 
 * More examples in test cases. Good luck!
 * 
 * Please also try Simple time difference
 */

public class SimplePrimeStreaming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = Integer.valueOf(sc.nextLine());
        int b = Integer.valueOf(sc.nextLine());
        sc.close();
        System.out.println(solve(a, b));
    }

    private static String solve(int a, int b) {
        StringBuilder sbPrimes = buildStringBuilder(a, b);
        return sbPrimes.substring(a, a + b).toString();
    }

    private static StringBuilder buildStringBuilder(int a, int b) {
        StringBuilder sb = new StringBuilder();
        int start = 2;
        int limit = a + b;
        while (sb.length() < limit) {
            if (isPrime(start)) {
                sb.append(String.valueOf(start));
            }
            start++;
        }
        return sb;
    }

    private static boolean isPrime(int i) {
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}
