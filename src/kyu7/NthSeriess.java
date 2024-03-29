package kyu7;

import java.util.Scanner;

/**
 * Task:
 * Your task is to write a function which returns the sum of following series
 * upto nth term(parameter).
 * 
 * Series: 1 + 1/4 + 1/7 + 1/10 + 1/13 + 1/16 +...
 * Rules:
 * You need to round the answer to 2 decimal places and return it as String.
 * 
 * If the given value is 0 then it should return 0.00
 * 
 * You will only be given Natural Numbers as arguments.
 * 
 * Examples:(Input --> Output)
 * 1 --> 1 --> "1.00"
 * 2 --> 1 + 1/4 --> "1.25"
 * 5 --> 1 + 1/4 + 1/7 + 1/10 + 1/13 --> "1.57"
 */

public class NthSeriess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        System.out.println(seriesSum(n));
        sc.close();
    }

    private static String seriesSum(int n) {
        int step = 3;
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += 1.0 / (1 + step * i);
        }
        return String.format("%.2f", sum);
    }
}
