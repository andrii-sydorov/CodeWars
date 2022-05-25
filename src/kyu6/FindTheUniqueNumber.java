package kyu6;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

/**
 * There is an array with some numbers. All numbers are equal except for one.
 * Try to find it!
 * 
 * Kata.findUniq(new double[]{ 1, 1, 1, 2, 1, 1 }); // => 2
 * Kata.findUniq(new double[]{ 0, 0, 0.55, 0, 0 }); // => 0.55
 * It’s guaranteed that array contains at least 3 numbers.
 * 
 * The tests contain some very huge arrays, so think about performance.
 * 
 * This is the first kata in series:
 * 
 * Find the unique number (this kata)
 * Find the unique string
 * Find The Unique
 */

public class FindTheUniqueNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] arr = Arrays.stream(sc.nextLine().split("\\s+")).mapToDouble(Double::valueOf).toArray();
        System.out.println(findUniq(arr));
    }

    private static double findUniq(double[] arr) {
        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            double key = arr[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (Map.Entry<Double, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0.0;
    }
}
