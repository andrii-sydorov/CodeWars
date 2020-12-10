package tasks;

import java.util.Scanner;

/**
 * Given a positive number n > 1 find the prime factor decomposition of n. The
 * result will be a string with the following form :
 * 
 * "(p1**n1)(p2**n2)...(pk**nk)"
 * 
 * where a ** b means a to the power of b
 * 
 * with the p(i) in increasing order and n(i) empty if n(i) is 1.
 * 
 * Example: n = 86240 should return "(2**5)(5)(7**2)(11)"
 * 
 * @author Zver
 *
 */
public class PrimesInNumbers {
	public static void main(String[] args) {
//		System.out.println("Enter your's number");
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		sc.close();
		long l = System.currentTimeMillis();
//		System.out.println(factors(n));
		for(int i = 5860906; i<= 5865661; i++) {
			System.out.println(i + " " + "\t" + factors(i));
			System.out.println();
		}
		System.out.println(System.currentTimeMillis() - l);
		System.out.println(isSimple(4));
	}
/**
 * to slow was optimised below
 * @param n
 * @return
 */
	public static String factors1(int n) {
		StringBuilder sb = new StringBuilder();
		String res = "";
		if (isSimple(n)) {
			sb.append("(" + n + ")");
			res += "(" + n + ")";
			return res;
		}
		for (int i = 2; i <= n; i++) {
			if (i > 2 && i % 2 == 0) {
				continue;
			} else {
				if (isSimple(i)) {
					int j = 0;
					while (n % i == 0) {
						n /= i;
						j++;
					}
					if (j > 1) {
						res += "(" + i + "**" + j + ")";
						sb.append("(" + i + "**" + j + ")");
					} else if (j == 1) {
						res += "(" + i + ")";
						sb.append("(" + i + ")");
					}
				}
			}
		}
//		return res;
		return sb.toString();
	}
/**
 * checking if number primes is, the area is limited Math.sqrt(number)
 * @param number
 * @return
 */
	static boolean isSimple(int number) {
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
/**
 * the best solution, is optimised and ready for using
 * @param n
 * @return
 */
	public static String factors(int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= n; i++) {
			int count = 0;
			while (n % i == 0) {
				n /= i;
				count++;
			}
			if (count == 1) {
				sb.append("(" + i + ")");
			} else if (count > 1) {
				sb.append("(" + i + "**" + count + ")");
			}
		}
		return sb.toString();
	}
}
