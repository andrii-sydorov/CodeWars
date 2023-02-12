package kyu7;

import java.util.Scanner;
import java.util.Arrays;

/**
 * A Nice array is defined to be an array where for every value n in the array,
 * there is also an element n - 1 or n + 1 in the array.
 * 
 * examples:
 * 
 * [2, 10, 9, 3] is a nice array because
 * 
 * 2 = 3 - 1
 * 10 = 9 + 1
 * 3 = 2 + 1
 * 9 = 10 - 1
 * 
 * [4, 2, 3] is a nice array because
 * 
 * 4 = 3 + 1
 * 2 = 3 - 1
 * 3 = 2 + 1 (or 3 = 4 - 1)
 * 
 * [4, 2, 1] is a not a nice array because
 * 
 * for n = 4, there is neither n - 1 = 3 nor n + 1 = 5
 * Write a function named isNice/IsNice that returns true if its array argument
 * is a Nice array, else false. An empty array is not considered nice.
 * 
 * 
 */

public class NiceArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        System.out.println(isNice(arr));
        sc.close();
    }

    /**
     * Soluyion that isn't match perfect to the task, it's checked if array has only
     * ascending or descending numbers, without repetition
     * 
     * @param arr
     * @return
     */
    public static boolean isNice1(int[] arr) {
        if (arr.length <= 1) {
            return false;
        }
        Arrays.sort(arr);
        boolean isNice = false;
        ;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] + 1 == arr[i + 1]) {
                isNice = true;
                continue;
            } else {
                if (!isNice) {
                    return isNice;
                }
                isNice = false;
            }
        }
        return isNice;
    }

    public static boolean isNice(int[] arr) {
        if (arr.length <= 1) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            boolean isNice = false;
            int t = arr[i];
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    continue;
                }
                if (Math.abs(t - arr[j]) == 1) {
                    isNice = true;
                    break;
                }
            }
            if (!isNice) {
                return isNice;
            }
        }
        return true;
}