package kyu5;

import java.util.Scanner;
import java.util.Arrays;

/**
 * A natural number is called k-prime if it has exactly k prime factors, counted
 * with multiplicity. A natural number is thus prime if and only if it is
 * 1-prime.
 * 
 * Examples: 
 * k = 2 -> 4, 6, 9, 10, 14, 15, 21, 22, … 
 * k = 3 -> 8, 12, 18, 20, 27, 28, 30, … 
 * k = 5 -> 32, 48, 72, 80, 108, 112, …
 * 
 * Task:
 * 
 * Given an integer k and a list arr of positive integers the function
 * consec_kprimes (or its variants in other languages) returns how many times in
 * the sequence arr numbers come up twice in a row with exactly k prime factors?
 * Examples:
 * 
 * arr = [10005, 10030, 10026, 10008, 10016, 10028, 10004] 
 * consec_kprimes(4, arr) => 3 because 10005 and 10030 are consecutive 4-primes, 10030 and 10026
 * too as well as 10028 and 10004 but 10008 and 10016 are 6-primes.
 * 
 * consec_kprimes(4, [10175, 10185, 10180, 10197]) => 3 because 10175-10185 and
 * 10185- 10180 and 10180-10197 are all consecutive 4-primes.
 * 
 */

public class ConsKPrimes {

    public static void main(String[] args) {
        System.out.println("Enter your numbers of k-prime:");
        Scanner sc = new Scanner(System.in);
        int k = Integer.valueOf(sc.nextLine());
        System.out.println("Enter the arrays of number:");
        String[] temp = sc.nextLine().replaceAll("[^0-9\\s+]", "").split("\\s+");
        long[] arr = Arrays.stream(temp).mapToLong(Long::parseLong).toArray();
        sc.close();
        System.out.println(consecPrimes(k, arr));
    }

    protected static int consecPrimes(int k, long[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (isConsecPrimes(k, arr[i]) && isConsecPrimes(k, arr[i + 1])) {
                ans++;
            }
        }
        return ans;
    }

    private static boolean isConsecPrimes(int k, long l) {
        int index = 0;
        int number = 2;
        while (l != 1) {
            if (l % number == 0) {
                l /= number;
                index++;
                continue;
            }
            number++;
        }
        return index == k ? true : false;
    }

}
