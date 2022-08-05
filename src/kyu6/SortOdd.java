package kyu6;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Sort the odd
 * 
 * Task
 * You will be given an array of numbers. You have to sort the odd numbers in
 * ascending order while leaving the even numbers at their original positions.
 * 
 * Examples
 * [7, 1] => [1, 7]
 * [5, 8, 6, 3, 4] => [3, 8, 6, 5, 4]
 * [9, 8, 7, 6, 5, 4, 3, 2, 1, 0] => [1, 8, 3, 6, 5, 4, 7, 2, 9, 0]
 */

public class SortOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(sortArray(array)));
        sc.close();
    }

    private static int[] sortArray(int[] array) {
        int[] res = Arrays.copyOfRange(array, 0, array.length);
        List<Integer> numbers = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                numbers.add(array[i]);
                indexes.add(i);
            }
        }
        Collections.sort(numbers);
        for (int i = 0; i < numbers.size(); i++) {
            res[indexes.get(i)] = numbers.get(i);
        }
        return res;
    }
}
