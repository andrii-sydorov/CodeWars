package kyu5;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.LinkedHashMap;

/**
 * 1, 246, 2, 123, 3, 82, 6, 41 are the divisors of number 246. Squaring these
 * divisors we get: 1, 60516, 4, 15129, 9, 6724, 36, 1681. The sum of these
 * squares is 84100 which is 290 * 290.
 * 
 * Task
 * Find all integers between m and n (m and n integers with 1 <= m <= n) such
 * that the sum of their squared divisors is itself a square.
 * 
 * We will return an array of subarrays or of tuples (in C an array of Pair) or
 * a string. The subarrays (or tuples or Pairs) will have two elements: first
 * the number the squared divisors of which is a square and then the sum of the
 * squared divisors.
 * 
 * Example:
 * list_squared(1, 250) --> [[1, 1], [42, 2500], [246, 84100]]
 * list_squared(42, 250) --> [[42, 2500], [246, 84100]]
 * The form of the examples may change according to the language, see "Sample
 * Tests".
 * 
 * Note
 * In Fortran - as in any other language - the returned string is not permitted
 * to contain any redundant trailing whitespace: you can use dynamically
 * allocated character strings.
 */

public class RecreationOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long m = Long.valueOf(sc.nextLine());
        long n = Long.valueOf(sc.nextLine());
        sc.close();
        System.out.println(listSquared(m, n));
    }

    private static String listSquared(long m, long n) {
        Map<Long, Long> map = new LinkedHashMap<>();
        for (long i = m; i <= n; i++) {
            List<Long> divider = new ArrayList<>();
            for (long j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    divider.add(j);
                }
            }
            divider.add(i);
            long sum = squareSum(divider);
            if (Math.sqrt(sum) % 1 == 0) {
                map.put(i, sum);
            }
        }
        long[][] arr = new long[map.size()][];
        int index = 0;
        for (Map.Entry<Long, Long> entr : map.entrySet()) {
            arr[index] = new long[] { entr.getKey(), entr.getValue() };
            index++;
        }
        return Arrays.deepToString(arr);
    }

    private static long squareSum(List<Long> ls) {
        long sum = 0;
        for (long l : ls) {
            sum += Math.pow(l, 2);
        }
        return sum;
    }
}
