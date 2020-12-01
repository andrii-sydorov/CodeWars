package tasks;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.Arrays;

/**
 * Build a function that returns an array of integers from n to 1 where n>0.
 * 
 * Example : n=5 >> [5,4,3,2,1]
 * 
 * @author Zver
 *
 */
public class ReversedSequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your's number:");
		int n = sc.nextInt();
		System.out.println(Arrays.toString(reverse(n)));
		sc.close();
	}

	/**
	 * my solution
	 * 
	 * @param n
	 * @return
	 */
	public static int[] reverse(int n) {
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = n - i;
		}
		return res;
	}

	/**
	 * solution from codewars
	 * 
	 * @param n
	 * @return
	 */
	public static int[] reverse2(int n) {
		return IntStream.iterate(n, i -> i - 1).limit(n).toArray();
	}
}
