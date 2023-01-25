package kyu7;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

/**
 * Complete the function to find the count of the most frequent item of an
 * array. You can assume that input is an array of integers. For an empty array
 * return 0
 * 
 * Example
 * input array: [3, -1, -1, -1, 2, 3, -1, 3, -1, 2, 4, 9, 3]
 * ouptut: 5
 * The most frequent number in the array is -1 and it occurs 5 times.
 */

public class MostFrequentNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] collection = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        sc.close();
        System.out.println(mostFrequentItemCount(collection));
    }

    public static int mostFrequentItemCount(int[] collection) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : collection) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entr : map.entrySet()) {
            if (max < entr.getValue()) {
                max = entr.getValue();
            }
        }
        return max;
    }
}
