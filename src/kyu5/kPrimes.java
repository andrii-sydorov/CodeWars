package kyu5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * A natural number is called k-prime if it has exactly k prime factors, counted
 * with multiplicity. For example:
 * 
 * k = 2 --> 4, 6, 9, 10, 14, 15, 21, 22, ...
 * k = 3 --> 8, 12, 18, 20, 27, 28, 30, ...
 * k = 5 --> 32, 48, 72, 80, 108, 112, ...
 * A natural number is thus prime if and only if it is 1-prime.
 * 
 * Task:
 * Complete the function count_Kprimes (or countKprimes, count-K-primes,
 * kPrimes) which is given parameters k, start, end (or nd) and returns an array
 * (or a list or a string depending on the language - see "Solution" and "Sample
 * Tests") of the k-primes between start (inclusive) and end (inclusive).
 * 
 * Example:
 * countKprimes(5, 500, 600) --> [500, 520, 552, 567, 588, 592, 594]
 * Notes:
 * 
 * The first function would have been better named: findKprimes or kPrimes :-)
 * In C some helper functions are given (see declarations in 'Solution').
 * For Go: nil slice is expected when there are no k-primes between start and
 * end.
 * Second Task: puzzle (not for Shell)
 * Given a positive integer s, find the total number of solutions of the
 * equation a + b + c = s, where a is 1-prime, b is 3-prime, and c is 7-prime.
 * 
 * Call this function puzzle(s).
 * 
 * Examples:
 * puzzle(138) --> 1 because [2 + 8 + 128] is the only solution
 * puzzle(143) --> 2 because [3 + 12 + 128] and [7 + 8 + 128] are the solutions
 * 
 * @author SMD_ASY
 *
 */

public class kPrimes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the dates: ");
        String s = sc.nextLine();
        int[] n = Arrays.stream(s.split(" ")).mapToInt(Integer::valueOf).toArray();
        sc.close();
        long t = System.currentTimeMillis();
        System.out.println(Arrays.toString(countKPrimes(n[0], n[1], n[2])));
        long t1 = System.currentTimeMillis();
        System.out.println(t1 - t);
        t = System.currentTimeMillis();
        System.out.println(Arrays.toString(countKPrimes2(n[0], n[1], n[2])));
        t1 = System.currentTimeMillis();
        System.out.println(t1 - t);

        t = System.currentTimeMillis();
        System.out.println(Arrays.toString(countKprimes(n[0], n[1], n[2])));
        t1 = System.currentTimeMillis();
        System.out.println(t1 - t);

        System.out.println(Arrays.equals(countKPrimes(n[0], n[1], n[2]), countKPrimes2(n[0], n[1], n[2])));
        System.out.println(Arrays.equals(countKPrimes2(n[0], n[1], n[2]), countKprimes(n[0], n[1], n[2])));
    }

    public static long[] countKprimes(int k, long start, long end) {
        List<Long> result = new ArrayList<>();

        for (long i = start == 0 ? 2 : start; i <= end; i++) {
            int numOfFactors = 0;
            long cur = i;

            for (int j = 2; j <= cur / j; j++) {
                while (cur % j == 0) {
                    numOfFactors++;
                    cur /= j;
                }
            }

            if (cur > 1) {
                numOfFactors++;
            }

            if (numOfFactors == k)
                result.add(i);
        }

        return result.stream().mapToLong(l -> l).toArray();
    }

    public static long[] countKPrimes(int k, int start, int end) {
        List<Long> ls = new ArrayList<>();
        for (long i = start; i <= end; i++) {
            if (numberOfProd(i, k) == k) {
                ls.add(i);
            }
        }
        long[] ans = new long[ls.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = ls.get(i);
        }
        return ans;
    }

    public static long[] countKPrimes2(int k, int start, int end) {
        List<Long> ls = new ArrayList<>();
        for (long i = start; i <= end; i++) {
            if (numberOfProd2(i, k) == k) {
                ls.add(i);
            }
        }
        return ls.stream().mapToLong(l -> l).toArray();
    }

    public static int numberOfProd2(long n, int k) {
        int count = 0;
        int div = 2;
        int sqr = (int) Math.sqrt(n);
        if (n < div) {
            return 0;
        }
        while (n != 1) {
            if (count > k) {
                return -1;
            }
            if (div > sqr && count == 0) {
                return -1;
            }
            if (n % div == 0) {
                n /= div;
                count++;
                continue;
            }
            div++;
        }
        return count;
    }

    public static int numberOfProd(long n, int k) {
        int count = 0;
        int div = 2;
        if (n < div) {
            return 0;
        }
        while (div <= n / div) {

            while (n % div == 0) {
                n /= div;
                count++;
            }

            div++;
        }

        if (n > 1) {
            count++;
        }
        return count;
    }

    public static int puzzle(int s) {
        int combinations = 0;

        long[] onePrimes = countKprimes(1, 2, s);
        long[] threePrimes = countKprimes(3, 2, s);
        long[] sevenPrimes = countKprimes(7, 2, s);

        for (long i : onePrimes) {
            for (long j : threePrimes) {
                for (long k : sevenPrimes) {
                    if (i + j + k == s)
                        combinations++;
                }
            }
        }

        return combinations;
    }

}
