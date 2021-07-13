package kyu5;

/**
 * The aim of the kata is to decompose n! (factorial n) into its prime factors.

Examples:

n = 12; decomp(12) -> "2^10 * 3^5 * 5^2 * 7 * 11"
since 12! is divisible by 2 ten times, by 3 five times, by 5 two times and by 7 and 11 only once.

n = 22; decomp(22) -> "2^19 * 3^9 * 5^4 * 7^3 * 11^2 * 13 * 17 * 19"

n = 25; decomp(25) -> 2^22 * 3^10 * 5^6 * 7^3 * 11^2 * 13 * 17 * 19 * 23
Prime numbers should be in increasing order. When the exponent of a prime is 1 don't put the exponent.

Notes

the function is decomp(n) and should return the decomposition of n! into its prime factors in increasing order of the primes, as a string.
factorial can be a very big number (4000! has 12674 digits, n can go from 300 to 4000).
In Fortran - as in any other language - the returned string is not permitted to contain any redundant trailing whitespace: you can use dynamically allocated character strings.
 */

import java.util.Scanner;
import java.math.BigInteger;
import java.util.List;
import java.util.ArrayList;

public class FactorialDecomposition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = Integer.valueOf(sc.nextLine());
		sc.close();
		System.out.println(decomp(n));
	}

	public static String decomp(int n) {

		BigInteger factorial = factorial(n);

		List<Integer> lsOfPrimitives = new ArrayList<>();
		lsOfPrimitives = listOfPrimitive(n);

		List<Integer> lsOfPower = new ArrayList<>(lsOfPrimitives.size());
		lsOfPower = listOfPowers(factorial, lsOfPrimitives);

		String[] beforeConcat = buildArray(lsOfPrimitives, lsOfPower);

		return String.join(" * ", beforeConcat);

	}

	private static String[] buildArray(List<Integer> lsOfPrimitives, List<Integer> lsOfPower) {
		String[] beforeConcat = new String[lsOfPower.size()];
		for (int i = 0; i < beforeConcat.length; i++) {
			int temp = lsOfPower.get(i);
			switch (temp) {
			case 0:
				break;
			case 1:
				beforeConcat[i] = String.valueOf(lsOfPrimitives.get(i));
				break;
			default:
				beforeConcat[i] = lsOfPrimitives.get(i) + "^" + lsOfPower.get(i);
				break;
			}
		}
		return beforeConcat;
	}

	private static List<Integer> listOfPowers(BigInteger factorial, List<Integer> lsOfPrimitives) {
		List<Integer> lsOfPower = new ArrayList<>();
		for (int i = 0; i < lsOfPrimitives.size(); i++) {
			int countPowers = 0;
			if (factorial.equals(BigInteger.valueOf(0))) {
				break;
			}
			while (factorial.remainder(BigInteger.valueOf(lsOfPrimitives.get(i))).equals(BigInteger.valueOf(0))) {
				countPowers++;
				factorial = factorial.divide(BigInteger.valueOf(lsOfPrimitives.get(i)));
			}
			lsOfPower.add(countPowers++);
		}
		return lsOfPower;
	}

	private static List<Integer> listOfPrimitive(int n) {
		List<Integer> ls = new ArrayList<>();
		for (int i = 2; i <= n; i++) {
			if (isPrimitive(i)) {
				ls.add(i);
			}
		}
		return ls;
	}

	private static boolean isPrimitive(int i) {
		int limit = (int) Math.sqrt(i);
		for (int j = 2; j <= limit; j++) {
			if (i % j == 0) {
				return false;
			}
		}
		return true;
	}

	public static BigInteger factorial(int n) {
		BigInteger prod = BigInteger.valueOf(1);
		for (int i = 1; i <= n; i++) {
			prod = prod.multiply(BigInteger.valueOf(i));
		}
		return prod;
	}

}
