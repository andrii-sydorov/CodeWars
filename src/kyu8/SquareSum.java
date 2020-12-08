package kyu8;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Complete the square sum function so that it squares each number passed into
 * it and then sums the results together.
 * 
 * For example, for [1, 2, 2] it should return 9 because 1^2 + 2^2 + 2^2 = 9.
 * 
 * @author ASY
 *
 */
public class SquareSum {
	public static void main(String[] args) {
		System.out.println("Enter your arrays:");
		ArrayList<Integer> ls = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String[] strArr = sc.nextLine().split(" ");
		int[] n = new int[strArr.length];
		for (int i = 0; i < strArr.length; i++) {
			n[i] = Integer.valueOf(strArr[i]);
		}
		System.out.println(squareSum(n));
		sc.close();
	}

	public static int squareSum(int[] n) {
		int sum = 0;
		for (int i = 0; i < n.length; i++) {
			sum += (int) Math.pow(n[i], 2);
		}
		return sum;
	}
}
