package kyu7;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Create the function consecutive(arr) that takes an array of integers and
 * return the minimum number of integers needed to make the contents of arr
 * consecutive from the lowest number to the highest number.
 * 
 * For example:
 * If arr contains [4, 8, 6] then the output should be 2 because two numbers
 * need to be added to the array (5 and 7) to make it a consecutive array of
 * numbers from 4 to 8. Numbers in arr will be unique.
 * 
 * 
 */

public class Consecutive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        sc.close();
        System.out.println(consecutive(arr));
        System.out.println(consecutive2(arr));
    }

    private static int consecutive(final int[] arr) {
        int ans = 0;
        boolean isSorted = false;
        int turns = 0;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1 - turns; i++) {
                if (arr[i] > arr[i + 1]) {
                    int t = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = t;
                    isSorted = false;
                }
            }
            turns++;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            ans += arr[i + 1] - arr[i] > 0 ? arr[i + 1] - arr[i] - 1 : 0;
        }
        return ans;
    }

    private static int consecutive2(final int[] arr) {
        if (arr.length == 0)
            return 0;
        int max = arr[0];
        int min = arr[0];

        for (int i : arr) {
            if (i > max)
                max = i;
            if (i < min)
                min = i;
        }
        return max - min + 1 - arr.length;
    }
}
