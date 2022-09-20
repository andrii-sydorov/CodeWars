package kyu7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given the triangle of consecutive odd numbers:
 * 
 *       1
 *      3 5
 *     7 9 11
 *   13 15 17 19
 * 21 23 25 27 29
 * ...
 * Calculate the sum of the numbers in the nth row of this triangle (starting at
 * index 1) e.g.: (Input --> Output)
 * 
 * 1 --> 1
 * 2 --> 3 + 5 = 8
 */

public class SumOddNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        System.out.println(rowSumOddNumbers(n));
        sc.close();
    }

    private static int rowSumOddNumbers(int n) {
        int startValue = 1;
        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[i + 1];
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = startValue;
                startValue += 2;
            }
        }
        // System.out.println(Arrays.deepToString(arr));
        return findSum(arr[n - 1]);
    }

    private static int findSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    private static int findSum(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}
