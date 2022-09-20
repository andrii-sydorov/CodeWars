package kyu7;

import java.util.Random;

/**
 * Given an integer as input, can you round it to the next (meaning, "greater
 * than or equal") multiple of 5?
 * 
 * Examples:
 * 
 * input: output:
 * 0 -> 0
 * 2 -> 5
 * 3 -> 5
 * 12 -> 15
 * 21 -> 25
 * 30 -> 30
 * -2 -> 0
 * -5 -> -5
 * etc.
 * Input may be any positive or negative integer (including 0).
 * 
 * You can assume that all inputs are valid integers.
 */

public class RoundToFive {
    public static void main(String[] args) {
        final int n = 7;
        int[] data = makeSomeArray(n);
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i] + " -> " + roundToNext5(data[i]));
        }
    }

    private static int[] makeSomeArray(int n) {
        Random r = new Random();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = r.nextInt() + i;
        }
        return ans;
    }

    private static int roundToNext5(int number) {
        while (true) {
            if (number % 5 != 0) {
                number++;
                continue;
            }
            break;
        }
        return number;
    }
}
