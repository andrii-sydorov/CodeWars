package kyu5;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class KPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		System.out.print("Enter the value of k-Primes, the start, and the stop point:");
//		int k = sc.nextInt();
//		long start = sc.nextLong();
//		long end = sc.nextLong();
//		System.out.println(Arrays.toString(countKprimes(k, start, end)));
		System.out.println(listOfPrimes(5860906 / 2));
//		sc.close();
	}

	public static long[] countKprimes(int k, long start, long end) {
		ArrayList<Long> ls = new ArrayList<>();
		ArrayList<Long> lsPrime = listOfPrimes(end / 3);
		for (long i = start; i <= end; i++) {
			if (i == 0) {
				continue;
			}
			int count = 0;
			long temp = i;
			int index = 0;
			while (temp != 1) {
				if (temp % lsPrime.get(index) == 0) {
					temp /= lsPrime.get(index);
					count++;
					continue;
				} else {
					index++;
				}
				if(count > k) {
					break;
				}
				if(index >= lsPrime.size()) {
					break;
				}
			}
			if (count == k) {
				ls.add(i);
			}
		}
		long[] res = new long[ls.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = ls.get(i);
		}
		return res;
	}
	
	public static ArrayList<Long> listOfPrimes(long end) {
		ArrayList<Long> ls = new ArrayList<>();
		for(long i = 2; i <= end; i++) {
			if (isSimple(i)) {
				ls.add(i);
			}
		}
		return ls;
	}
	
	public static boolean isSimple(long number) {
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
