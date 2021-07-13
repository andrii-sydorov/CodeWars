package kyu6;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The maximum sum subarray problem consists in finding the maximum sum of a
 * contiguous subsequence in an array or list of integers:
 * 
 * Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}); 
 * // should be 6: {4, -1, 2, 1}
 * 
 * Easy case is when the list is made up of only positive numbers and the
 * maximum sum is the sum of the whole array. If the list is made up of only
 * negative numbers, return 0 instead.
 * 
 * Empty list is considered to have zero greatest sum. Note that the empty list
 * or array is also a valid sublist/subarray.
 * 
 */

public class Max {

    public static void main(String[] args) {
        int[] array = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        long start = System.currentTimeMillis();
        System.out.println(sequence(array));
        System.out.println(System.currentTimeMillis() - start);
    }

    public static int sequence(int[] arr) {
        if (arr.length == 0 || isNegative(arr)) {
            return 0;
        }
        List<Integer> ls = new ArrayList<>();
        int i = arr.length - 1;
        int startLength = 2;
        while (i > 0) {
            for (int j = 0; j < i; j++) {
                int sum = 0;
                for (int k = j; k < j + startLength; k++) {
                    sum += arr[k];
                }
                ls.add(sum);
            }
            i--;
            startLength++;
        }
        return Collections.max(ls);
    }

    public static boolean isNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * public static int sequence(int[] arr) { 
     * int max_ending_here = 0, 
     * max_so_far = 0; 
     * for (int v : arr) { 
     * max_ending_here = Math.max(0, max_ending_here + v);
     * max_so_far = Math.max(max_so_far, max_ending_here); 
     * } 
     * return max_so_far; 
     * }
     */

}
