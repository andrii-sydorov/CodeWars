package kyu7;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Write a function that reverses the bits in an integer.
 * 
 * For example, the number 417 is 110100001 in binary. Reversing the binary is
 * 100001011 which is 267.
 * 
 * You can assume that the number is not negative.
 */

public class BitsOfInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        sc.close();
        System.out.println(reverse_bits(n));
    }

    public static int reverse_bits(int n) {
        ArrayDeque<Integer> ar = new ArrayDeque<>();
        while (true) {
            if (n < 2) {
                ar.push(n);
                break;
            }
            ar.push(n % 2);
            n /= 2;
        }
        System.out.println(ar.toString());
        int sum = 0;
        int i = 0;
        while (!ar.isEmpty()) {
            sum += ar.pollFirst() * Math.pow(2, i);
            i++;
        }
        return sum;
    }
}
