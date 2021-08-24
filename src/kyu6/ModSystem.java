package kyu6;

import java.util.Scanner;
import java.util.Arrays;

/**
 * A number system with moduli is deﬁned by a vector of k moduli, [m1,m2,
 * ···,mk].
 * 
 * The moduli must be pairwise co-prime, which means that, for any pair of
 * moduli, the only common factor is 1.
 * 
 * In such a system each number n is represented by a string "-x1--x2-- ...
 * --xk-" of its residues, one for each modulus. The product m1 * ... * mk must
 * be greater than the given number n which is to be converted in the moduli
 * number system.
 * 
 * For example, if we use the system [2, 3, 5] the number n = 11 is represented
 * by "-1--2--1-", the number n = 23 by "-1--2--3-".
 * 
 * If we use the system [8, 7, 5, 3] the number n = 187 becomes "-3--5--2--1-".
 * 
 * You will be given a number n (n >= 0) and a system S = [m1,m2, ···,mk] and
 * you will return a string "-x1--x2-- ...--xk-" representing the number n in
 * the system S.
 * 
 * If the moduli are not pairwise co-prime or if the product m1 * ... * mk is
 * not greater than n, return "Not applicable".
 * 
 * Examples: (you can add them in the "Sample tests")
 * 
 * fromNb2Str(11, [2,3,5]) -> "-1--2--1-" 
 * fromNb2Str(6, [2, 3, 4]) -> "Not applicable", since 2 and 4 are not coprime 
 * fromNb2Str(7, [2, 3]) -> "Not applicable" since 2 * 3 < 7
 * 
 */

public class ModSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your's number: ");
        int n = Integer.parseInt(sc.nextLine());
        System.out.println("Enter a vector: ");
        String[] st = sc.nextLine().split(" ");
        int[] sys = Arrays.stream(st).mapToInt(Integer :: parseInt).toArray();
        System.out.println(fromNb2Str(n, sys));
        sc.close();
    }

    public static String fromNb2Str(int n, int[] sys) {
        String ans = null;
        if (checkIfIsNotCoPrime(sys) || isLessThen(n, sys)) {
            return "Not applicable";
        }
        String[] factors = new String[sys.length];
        for(int i = 0; i < sys.length; i++) {
            factors[i] = String.valueOf(n % sys[i]);
        }
        ans = "-" + String.join("--", factors) + "-";
        return ans;
    }

    public static boolean checkIfIsNotCoPrime(int[] sys) {
        int max = findMaxFromArray(sys);
        for (int j = 2; j < max; j++) {
            int count = 0;
            for (int i = 0; i < sys.length; i++) {
                if (sys[i] % j == 0) {
                    count++;
                }
            }
            if (count > 1) {
                return true;
            }
        }
        return false;
    }

    private static int findMaxFromArray(int[] sys) {
        int max = sys[0];
        for (int i = 1; i < sys.length; i++) {
            if (max < sys[i]) {
                max = sys[i];
            }
        }
        return max;
    }

    private static boolean isLessThen(int n, int[] sys) {
        int prod = 1;
        for (int i = 0; i < sys.length; i++) {
            prod *= sys[i];
        }
        return n > prod ? true : false;
    }
    
}
