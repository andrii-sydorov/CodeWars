package kyu7;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Write a function that can return the smallest value of an array or the index
 * of that value. The function's 2nd parameter will tell whether it should
 * return the value or the index.
 * 
 * Assume the first parameter will always be an array filled with at least 1
 * number and no duplicates. Assume the second parameter will be a string
 * holding one of two values: 'value' and 'index'.
 * 
 * Arrays.findSmallest(new int[]{1,2,3,4,5}, 'value') // => 1
 * Arrays.findSmallest(new int[]{1,2,3,4,5}, 'index') // => 0
 */

public class SmallestValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        String toReturn = sc.nextLine();
        sc.close();
        System.out.println(findSmallest(numbers, toReturn));
    }

    public static int findSmallest(int[] numbers, String toReturn) {
        int minValue = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (minValue > numbers[i]) {
                minValue = numbers[i];
                index = i;
            }
        }
        return toReturn.equals("value") ? minValue : index;
    }
}
