package kyu8;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Your task is to sum the differences between consecutive pairs in the array in
 * descending order.
 * 
 * Example
 * [2, 1, 10] --> 9
 * In descending order: [10, 2, 1]
 * 
 * Sum: (10 - 2) + (2 - 1) = 8 + 1 = 9
 * 
 * If the array is empty or the array has only one element the result should be
 * 0 (Nothing in Haskell, None in Rust).
 */

public class ZywOo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        sc.close();
        System.out.println(sumOfDifferences(arr));
    }

    public static int sumOfDifferences(int[] arr) {
        System.out.println(Arrays.toString(arr));
        boolean isSorted = false;
        int turns = 0;
        while (!isSorted) {
            isSorted = true;
            for (int i = arr.length - 1; i > turns; i--) {
                if (arr[i] > arr[i - 1]) {
                    int t = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = t;
                    isSorted = false;
                }
            }
            turns++;
        }
        int sum = 0;
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length - 1; i++) {
            sum += arr[i] - arr[i + 1];
        }
        return sum;
    }
}
