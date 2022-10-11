package kyu7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * You are given an odd-length array of integers, in which all of them are the
 * same, except for one single number.
 * 
 * Complete the method which accepts such an array, and returns that single
 * different number.
 * 
 * The input array will always be valid! (odd-length >= 3)
 * 
 * Examples
 * [1, 1, 2] ==> 2
 * [17, 17, 3, 17, 17, 17, 17] ==> 3
 * 
 * @author SMD_ASY
 *
 */

public class StrayNumber {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        scanner.close();
        System.out.println(stray(numbers));
    }

    public static int stray(int[] numbers) {
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (ls.contains(numbers[i])) {
                ls.remove(Integer.valueOf(numbers[i]));
            } else {
                ls.add(numbers[i]);
            }
        }
        return ls.get(0);
    }
    
    public static int stray2(int[] numbers) {
        int res = 0;
        for (int i = 0; i < numbers.length; i++) {
            res ^= numbers[i];
        }
        return res;
    }

}
