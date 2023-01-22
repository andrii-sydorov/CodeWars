package kyu6;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Definition (Primorial Of a Number)
 * Is similar to factorial of a number, In primorial, not all the natural
 * numbers get multiplied, only prime numbers are multiplied to calculate the
 * primorial of a number. It's denoted with P# and it is the product of the
 * first n prime numbers.
 * 
 * Task
 * Given a number N , calculate its primorial.!alt!alt
 * Notes
 * Only positive numbers will be passed (N > 0) .
 * Input >> Output Examples:
 * 1- numPrimorial (3) ==> return (30)
 * Explanation:
 * Since the passed number is (3) ,Then the primorial should obtained by
 * multiplying 2 * 3 * 5 = 30 .
 * 
 * Mathematically written as , P3# = 30 .
 * 2- numPrimorial (5) ==> return (2310)
 * Explanation:
 * Since the passed number is (5) ,Then the primorial should obtained by
 * multiplying 2 * 3 * 5 * 7 * 11 = 2310 .
 * 
 * Mathematically written as , P5# = 2310 .
 * 3- numPrimorial (6) ==> return (30030)
 * Explanation:
 * Since the passed number is (6) ,Then the primorial should obtained by
 * multiplying 2 * 3 * 5 * 7 * 11 * 13 = 30030 .
 * 
 * Mathematically written as , P6# = 30030 .
 * Playing with Numbers Series
 * Playing With Lists/Arrays Series
 * For More Enjoyable Katas
 * ALL translations are welcomed
 * Enjoy Learning !!
 * Zizou
 * 
 */

public class PrimorialOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        sc.close();
        System.out.println(numPrimorial(n));
    }

    public static String numPrimorial(int n) {
        BigInteger prod = BigInteger.ONE;
        ;
        int count = 0;
        int number = 0;
        while (count < n) {
            if (isPrime(number)) {
                prod = prod.multiply(BigInteger.valueOf(number));
                count++;
            }
            number++;
        }
        return prod.toString();
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
