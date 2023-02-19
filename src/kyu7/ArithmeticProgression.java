package kyu7;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * In your class, you have started lessons about arithmetic progression. Since
 * you are also a programmer, you have decided to write a function that will
 * return the first n elements of the sequence with the given common difference
 * d and first element a. Note that the difference may be zero!
 * 
 * The result should be a string of numbers, separated by comma and space.
 * 
 * Example
 * # first element: 1, difference: 2, how many: 5
 * arithmetic_sequence_elements(1, 2, 5) == "1, 3, 5, 7, 9"
 */

public class ArithmeticProgression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = Integer.valueOf(sc.nextLine());
        int d = Integer.valueOf(sc.nextLine());
        long n = Long.valueOf(sc.nextLine());
        sc.close();
        System.out.println(arithmeticSequenceElements(a, d, n));
    }

    public static String arithmeticSequenceElements(int a, int d, long n) {
        List<Long> ls = new ArrayList<>();
        for (long i = 1; i <= n; i++) {
            ls.add(a + (i - 1) * d);
        }
        return ls.toString().replace("[", "").replace("]", "");
    }

}
