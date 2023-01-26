package kyu7;

import java.util.Scanner;
import java.util.Arrays;

/**
 * The Stanton measure of an array is computed as follows: count the number of
 * occurences for value 1 in the array. Let this count be n. The Stanton measure
 * is the number of times that n appears in the array.
 * 
 * Write a function which takes an integer array and returns its Stanton
 * measure.
 * 
 * Examples
 * The Stanton measure of [1, 4, 3, 2, 1, 2, 3, 2] is 3, because 1 occurs 2
 * times in the array and 2 occurs 3 times.
 * 
 * The Stanton measure of [1, 4, 1, 2, 11, 2, 3, 1] is 1, because 1 occurs 3
 * times in the array and 3 occurs 1 time.
 */

public class StantonMeasure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        sc.close();
        System.out.println(stantonMeasure(arr));
    }

    public static int stantonMeasure(int[] arr) {
        int n = 1;
        int count = frequent(arr, n);
        return frequent(arr, count);
    }

    public static int frequent(int[] arr, int n) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                count++;
            }
        }
        return count;
    }
}
