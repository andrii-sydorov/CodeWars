package kyu8;

import java.util.Scanner;
import java.util.Arrays;
import java.util.function.IntPredicate;

/**
 * Task
 * Create a method all which takes two params:
 * 
 * a sequence
 * a function (function pointer in C)
 * and returns true if the function in the params returns true for every element
 * in the sequence. Otherwise, it should return false. If the sequence is empty,
 * it should return true, since technically nothing failed the test.
 * 
 * Example
 * all((1, 2, 3, 4, 5), greater_than_9) -> false
 * all((1, 2, 3, 4, 5), less_than_9) -> True
 * Help
 * Here's a (Ruby) resource if you get stuck:
 */

public class Enumerable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] list = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        sc.close();
        IntPredicate predicate = n -> n % 2 == 0;
        System.out.println(all(list, predicate));
    }

    public static boolean all(int[] list, IntPredicate predicate) {
        return Arrays.stream(list).allMatch(predicate);
    }
}
