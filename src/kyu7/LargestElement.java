package kyu7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Write a program that outputs the top n elements from a list.
 * 
 * Example:
 * 
 * largest(2, new int[]{7, 6, 5, 4, 3, 2, 1})
 * // => new int[]{6, 7}
 */

public class LargestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(Arrays.toString(largest(n, arr)));
        sc.close();
    }

    public static int[] largest(int n, int[] arr) {
        int[] ans = new int[n];
        boolean isSorted = false;
        int turns = 0;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - turns - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int t = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = t;
                    isSorted = false;
                }
            }
            turns++;
        }
        int index = arr.length - 1;
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = arr[index];
            index--;
        }
        return ans;
    }
}
