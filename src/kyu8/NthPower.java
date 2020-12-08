package kyu8;

import java.util.Scanner;

/**
 * This kata is from check py.checkio.org
 * 
 * You are given an array with positive numbers and a non-negative number N. You
 * should find the N-th power of the element in the array with the index N. If N
 * is outside of the array, then return -1. Don't forget that the first element
 * has the index 0.
 * 
 * Let's look at a few examples:
 * 
 * array = [1, 2, 3, 4] and N = 2, then the result is 3^2 == 9; 
 * array = [1, 2, 3] and N = 3, but N is outside of the array, so the result is -1.
 * 
 * 
 * @author ASY
 *
 */
public class NthPower {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your's array of Integer:");
		String[] str = sc.nextLine().split(" ");
		StringToInt t = (String[] test) -> {
			int[] res = new int[test.length];
			for (int i = 0; i < test.length; i++) {
				res[i] = Integer.valueOf(test[i]);
			}
			return res;
		};
		int[] array = t.StrToInt(str);
		System.out.println("Enter the index of element's:");
		int n = sc.nextInt();
		sc.close();
		System.out.println(nthPower(array, n));
	}

	public static int nthPower(int[] array, int n) {
		try {
			return (int) Math.pow(array[n], n);
		} catch (ArrayIndexOutOfBoundsException e) {
			return -1;
		}
	}
}

interface StringToInt {
	public int[] StrToInt(String[] str);
}
