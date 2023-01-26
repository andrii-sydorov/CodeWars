package kyu7;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Implement a function that adds two numbers together and returns their sum in
 * binary. The conversion can be done before, or after the addition.
 * 
 * The binary number returned should be a string.
 * 
 * Examples:(Input1, Input2 --> Output (explanation)))
 * 
 * 1, 1 --> "10" (1 + 1 = 2 in decimal or 10 in binary)
 * 5, 9 --> "1110" (5 + 9 = 14 in decimal or 1110 in binary)
 */

public class BinaryAddition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = Integer.valueOf(sc.nextLine());
        int b = Integer.valueOf(sc.nextLine());
        sc.close();
        System.out.println(binaryAddition(a, b));
    }

    public static String binaryAddition(int a, int b) {
        int sum = a + b;
        return Integer.toBinaryString(sum);
    }
}
