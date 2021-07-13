package kyu5;

import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/**
 * You have to code a function getAllPrimeFactors which take an integer as
 * parameter and return an array containing its prime decomposition by ascending
 * factors, if a factors appears multiple time in the decomposition it should
 * appear as many time in the array.
 * 
 * example: getAllPrimeFactors(100) returns [2,2,5,5] in this order.
 * 
 * This decomposition may not be the most practical.
 * 
 * You should also write getUniquePrimeFactorsWithCount, a function which will
 * return an array containing two arrays: one with prime numbers appearing in
 * the decomposition and the other containing their respective power.
 * 
 * example: 
 * getUniquePrimeFactorsWithCount(100) returns [[2,5],[2,2]]
 * 
 * You should also write getPrimeFactorPotencies an array containing the prime
 * factors to their respective powers.
 * 
 * example:
 *  getPrimeFactorPotencies(100) returns [4,25]
 * 
 * Errors, if:
 * 
 * n is not a number n not an integer n is negative or 0 The three functions
 * should respectively return [], [[],[]] and [].
 * 
 * Edge cases:
 * 
 * if n=0, the function should respectively return [], [[],[]] and []. 
 * if n=1, the function should respectively return [1], [[1],[1]], [1]. 
 * if n=2, the function should respectively return [2], [[2],[1]], [2]. 
 * 
 * The result for n=2 is normal. The result for n=1 is arbitrary and has been chosen to return a
 * usefull result. The result for n=0 is also arbitrary but can not be chosen to
 * be both usefull and intuitive. ([[0],[0]] would be meaningfull but wont work
 * for general use of decomposition, [[0],[1]] would work but is not intuitive.)
 * 
 * @author SMD_ASY
 *
 */

public class PrimeNumberDecomposer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter your number:");
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		sc.close();
		System.out.println(Arrays.toString(getAllPrimeFactors(n)));
		System.out.println(Arrays.deepToString(getUniquePrimeFactorsWithCount(n)));
		System.out.println(Arrays.toString(getPrimeFactorPotencies(n)));
	}

	/**
	 * Return value: List of all prime factors of a given number n
	 */
	public static Long[] getAllPrimeFactors(long n) {
		if(n == 0) {
			return new Long[0];
		}
		if(n == 1) {
			return new Long[] {1l};
		}
		if (n==2) {
			return new Long[] {2l};
		}
		List<Long> listOfPrimes = new ArrayList<>();
		List<Long> listOfPrimeNumbers = new ArrayList<>();
		listOfPrimes = buildListOfPrimes(n);
		for (int i = 0; i < listOfPrimes.size(); i++) {
			long temp = listOfPrimes.get(i);
			while (n % temp == 0) {
				n /= temp;
				listOfPrimeNumbers.add(temp);
			}
		}
		return listOfPrimeNumbers.toArray(new Long[listOfPrimeNumbers.size()]);
	}

	private static List<Long> buildListOfPrimes(long n) {
		List<Long> ls = new ArrayList<>();
		long limit = n / 2;
		for (long i = 2; i <= limit; i++) {
			if (isPrime(i)) {
				ls.add(i);
			}
		}
		return ls;
	}

	private static boolean isPrime(long i) {
		int limit = (int) Math.sqrt(i);
		for (int j = 2; j <= limit; j++) {
			if (i % j == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Return value: List containing two lists, first containg all prime factors
	 * without duplicates, second containing the count, how often each prime factor
	 * occured. Return code always contains two lists.
	 * 
	 * e.g.: getUniquePrimeFactorsWithCount(100) = {{2,5},{2,2}) // prime 2 occurs 2
	 * times, prime 2 occurs 5 times,
	 */
	public static Long[][] getUniquePrimeFactorsWithCount(long n) {
		if(n == 0) {
			return new Long[2][0];
		}
		if(n == 1) {
			return new Long[][] {{1l}, {1l}};
		}
		if (n==2) {
			return new Long[][] {{2l}, {1l}};
		}
		Long[] allPrimeFactor = getAllPrimeFactors(n);
		Set<Long> hashSet = new HashSet<>();
		hashSet = getSetOfUniquePrimeNumber(allPrimeFactor);
		Long[] primeFactor = hashSet.toArray(new Long[hashSet.size()]);
		Long[] powerOfPrimeFactor = buildArrayOfPowerFactor(allPrimeFactor, hashSet);
		return new Long[][] { primeFactor, powerOfPrimeFactor };
	}

	private static Set<Long> getSetOfUniquePrimeNumber(Long[] allPrimeFactor) {
		Set<Long> hashSet = new HashSet<>();
		for (int i = 0; i < allPrimeFactor.length; i++) {
			hashSet.add(allPrimeFactor[i]);
		}
		return hashSet;
	}

	private static Long[] buildArrayOfPowerFactor(Long[] allPrimeFactor, Set<Long> hashSet) {
		Long[] ans = fillWithNulls(hashSet);
		int index = 0;
		for (Long temp : hashSet) {
			for (int j = 0; j < allPrimeFactor.length; j++) {
				if (temp - allPrimeFactor[j] == 0) {
					ans[index]++;
				}
			}
			index++;
		}
		return ans;
	}

	private static Long[] fillWithNulls(Set<Long> hashSet) {
		Long[] arrayFilledWithNulls = new Long[hashSet.size()];
		for (int i = 0; i < arrayFilledWithNulls.length; i++) {
			arrayFilledWithNulls[i] = 0l;
		}
		return arrayFilledWithNulls;
	}
	
	/**
	 * Return value: List containing product of same prime factors, e.g.: 45 = 3*3*5
	 * ==> {3^2,5^1} == {9,5} e.g.: getUniquePrimeFactorsWithCount(100) =
	 * {{2,5},{2,2}) // prime 2 occurs 2 times, prime 2 occurs 5 times,
	 */
	public static Long[] getPrimeFactorPotencies(long n) {
		if(n == 0) {
			return new Long[0];
		}
		if(n == 1) {
			return new Long[] {1l};
		}
		if (n==2) {
			return new Long[] {2l};
		}
		Long[][] uniquePrimeFactorsWithCount = getUniquePrimeFactorsWithCount(n);
		List<Long> ls = new ArrayList<>();
		for(int i = 0; i < uniquePrimeFactorsWithCount.length; i++) {
			ls.add((long)Math.pow(uniquePrimeFactorsWithCount[0][i], uniquePrimeFactorsWithCount[1][i]));
		}
		return ls.toArray(new Long[ls.size()]);
	}

}
