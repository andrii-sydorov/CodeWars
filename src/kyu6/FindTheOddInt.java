package kyu6;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

/**
 * Find the odd int
 * 
 * Given an array of integers, find the one that appears an odd number of times.
 * 
 * There will always be only one integer that appears an odd number of times.
 * Examples
 * 
 * [7] should return 7, because it occurs 1 time (which is odd).
 * [0] should return 0, because it occurs 1 time (which is odd).
 * [1,1,2] should return 2, because it occurs 1 time (which is odd).
 * [0,1,0,1,0] should return 0, because it occurs 3 times (which is odd).
 * [1,2,2,3,3,3,4,3,3,3,2,2,1] should return 4, because it appears 1 time (which
 * is odd).
 * 
 */

public class FindTheOddInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        sc.close();
        System.out.println(findInt(a));
    }

    private static int findInt(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entr : map.entrySet()) {
            if (entr.getValue() % 2 != 0) {
                return entr.getKey();
            }
        }
        return 0;
    }
}
