package kyu8;

import java.util.List;
import java.util.Arrays;

/**
 * Given an array of integers as strings and numbers, return the sum of the
 * array values as if all were numbers.
 * 
 * Return your answer as a number.
 * 
 */

public class SumMixedArray {
    public static void main(String[] args) {
        List<?> list = Arrays.asList(5, "5");
        System.out.println(sum(list));
    }

    private static int sum(List<?> list) {
        int sum = 0;
        for (Object el : list) {
            if (el instanceof Integer) {
                sum += (Integer) el;
            }
            if (el instanceof String) {
                sum += Integer.valueOf(el.toString());
            }
        }
        return sum;
    }
}
