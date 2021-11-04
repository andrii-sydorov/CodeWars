package kyu5;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class SamePrimeFactors {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nMax = Integer.valueOf(sc.nextLine());
        System.out.println(Arrays.toString(sameFactRev(nMax)));
        sc.close();
    }

    public static int[] sameFactRev(int nMax) {
        System.out.println(nMax);
        List<Integer> ls = new ArrayList<>();
        for (int i = 1; i <= nMax; i++) {
            StringBuilder direct = new StringBuilder(String.valueOf(i));
            StringBuilder reverse = new StringBuilder(String.valueOf(i)).reverse();
            if (direct.compareTo(reverse) == 0) {
                continue;
            }
            if (haveSamePrimeFactors(Integer.valueOf(direct.toString()), Integer.valueOf(reverse.toString()))) {
                ls.add(Integer.valueOf(direct.toString()));
            }
        }
        Collections.sort(ls);
        int[] ans = new int[ls.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = ls.get(i);
        }
        return ans;
    }

    private static boolean haveSamePrimeFactors(int direct, int reverse) {
        // System.out.println(direct + " " + reverse);
        List<Integer> lsDirect = makeListOfPrimes(direct);
        List<Integer> lsReverse = makeListOfPrimes(reverse);
        return lsDirect.equals(lsReverse) ? true : false;
    }

    private static List<Integer> makeListOfPrimes(int n) {
        List<Integer> factors = new ArrayList<Integer>();
        for (int i = 2; i * i <= n; i++) {
            int cnt = 0;
            while (n % i == 0) {
                if (cnt == 0) factors.add(i);
                cnt++;
                n /= i;
            }
        }
        if (n > 1) factors.add(n);
        return factors;
    }
}
