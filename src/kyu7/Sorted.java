package kyu7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Complete the method which accepts an array of integers, and returns one of
 * the following:
 * 
 * "yes, ascending" - if the numbers in the array are sorted in an ascending
 * order
 * "yes, descending" - if the numbers in the array are sorted in a descending
 * order
 * "no" - otherwise
 * You can assume the array will always be valid, and there will always be one
 * correct answer.
 * 
 * @author SMD_ASY
 *
 */

public class Sorted {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        sc.close();
        System.out.println(isSortedAndHow(array));
    }

    public static String isSortedAndHow(int[] array) {
        boolean ascend = false;
        boolean desc = false;
        for (int i = 0; i < array.length - 1; i++) {
            if (ascend == false && desc == false) {
                if (array[i] < array[i + 1]) {
                    ascend = true;
                } else {
                    desc = true;
                }
            }
            if (ascend) {
                if (array[i] > array[i + 1]) {
                    return "no";
                }
            }
            if (desc) {
                if (array[i + 1] > array[i]) {
                    return "no";
                }
            }
        }
        return ascend ? "yes, ascending" : "yes, descending";
    }

}
