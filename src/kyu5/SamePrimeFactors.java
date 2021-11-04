package kyu5;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;

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
        List<Integer> is = new ArrayList<>();
        for (int i = 1; i <= nMax; i++) {
            StringBuilder direct = new StringBuilder(String.valueOf(i));
            StringBuilder reverse = new StringBuilder(String.valueOf(i)).reverse();
            if (direct.compareTo(reverse) == 0) {
                continue;
            }
            if (contained(is, direct, reverse) || contained(ls, direct, reverse)) {
                continue;
            }
            if (haveSamePrimeFactors(Integer.valueOf(direct.toString()), Integer.valueOf(reverse.toString()))) {
                ls.add(Integer.valueOf(direct.toString()));
                ls.add(Integer.valueOf(reverse.toString()));
            } else {
                toAdd(is, direct, reverse);
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
        System.out.println(direct + " " + reverse);
        int number = 2;
        while (direct + reverse != 2) {
            if (isPrime(number)) {
                if (direct % number == 0) {
                    if (reverse % number == 0) {
                        while (direct % number == 0) {
                            direct /= number;
                        }
                        while (reverse % number == 0) {
                            reverse /= number;
                        }
                    } else {
                        return false;
                    }
                } 
            }
            number++;
        }
        return true;
    }

    private static boolean contained(List<Integer> ls, StringBuilder direct, StringBuilder reverse) {
        if (ls.contains(Integer.valueOf(direct.toString())) || ls.contains(Integer.valueOf(reverse.toString()))) {
            return true;
        }
        return false;
    }

    private static void toAdd(List<Integer> ls, StringBuilder direct, StringBuilder reverse) {
        ls.add(Integer.valueOf(direct.toString()));
        ls.add(Integer.valueOf(reverse.toString()));
    }

    private static boolean isPrime(int n) {
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static Set<Integer> makeSet(int number) {
        Set<Integer> s = new HashSet<>();
        int n = 2;
        while (number != 1) {
            if (number % n == 0 && isPrime(n)) {
                number /= n;
                s.add(n);
                continue;
            }
            n++;
        }
        return s;
    }
}
