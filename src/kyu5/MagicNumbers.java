package kyu5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MagicNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your's numbers: ");
		int n = sc.nextInt();
		sc.close();
		long start = System.currentTimeMillis();
		System.out.println(powerSumDigTerm(n));
		System.out.println("Time is :" + (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		System.out.println(powerSumDigTerm1(n));
		System.out.println("Time is :" + (System.currentTimeMillis() - start));
	}

	private static long powerSumDigTerm(int n) {
		for (long i = 81;; i++) {
			String s = String.valueOf(i);
			long sum = makeSum(s);
			if (sum == 1) {
				continue;
			}
			long square = 0;
			int j = 2;
			for (;; j++) {
				square = (long) Math.pow(sum, j);
				if (square >= i) {
					break;
				}
			}
			if (square == i) {
				n--;
			}
			if (n == 0) {
				return i;
			}
		}
	}

	private static long makeSum(String s) {
		long sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum += Character.getNumericValue(s.charAt(i));
		}
		return sum;
	}

	public static long powerSumDigTerm1(int n) {
		ArrayList<Long> a = new ArrayList<Long>();
		for (int i = 2; i < 100; i++) {
			for (int j = 2; j < 200; j++) {
				long r = (long) Math.pow(i, j);
				if (sumDigits(r) == i)
					a.add(r);
			}
		}
		Collections.sort(a);
		return a.get(n - 1);
	}

	public static int sumDigits(long n) {
		int sum = 0;
		while (n > 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}

}
