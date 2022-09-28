package kyu7;

import java.util.Scanner;

/**
 * Your task is to write function factorial.
 */

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        sc.close();
        System.out.println(factorial(n));
    }

    private static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1L;
        }
        return n * factorial(n - 1);
    }
}
