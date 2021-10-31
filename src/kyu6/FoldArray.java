package kyu6;

import java.util.Scanner;
import java.util.Arrays;

/**
 * In this kata you have to write a method that folds a given array of integers by the middle x-times.

An example says more than thousand words:

Fold 1-times:
[1,2,3,4,5] -> [6,6,3]

A little visualization (NOT for the algorithm but for the idea of folding):

 Step 1         Step 2        Step 3       Step 4       Step5
                     5/           5|         5\          
                    4/            4|          4\      
1 2 3 4 5      1 2 3/         1 2 3|       1 2 3\       6 6 3
----*----      ----*          ----*        ----*        ----*


Fold 2-times:
[1,2,3,4,5] -> [9,6]
As you see, if the count of numbers is odd, the middle number will stay. Otherwise the fold-point is between the middle-numbers, so all numbers would be added in a way.

The array will always contain numbers and will never be null. The parameter runs will always be a positive integer greater than 0 and says how many runs of folding your method has to do.

If an array with one element is folded, it stays as the same array.

The input array should not be modified!

Have fun coding it and please don't forget to vote and rank this kata! :-)

I have created other katas. Have a look if you like coding and challenges.
 * @author SMD_ASY
 *
 */

public class FoldArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter arrays: ");
		Scanner sc = new Scanner(System.in);
		int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
		System.out.println("Enter the numbers of fold: ");
		int n = Integer.parseInt(sc.nextLine());
		System.out.println(Arrays.toString(fold(input, n)));
		sc.close();
	}

	private static int[] fold(int[] array, int n) {
		if (array.length == 1) {
			return array;
		}
		if (n == 1) {
		return foldRecursive(array);
		}
		return fold(foldRecursive(array), n - 1);

	}

	private static int[] foldRecursive(int[] input) {
		int l = input.length % 2 == 0 ? input.length / 2 : input.length / 2 + 1;
		int[] ans = new int[l];
		for (int i = 0; i < ans.length; i++) {
			if (input.length % 2 == 0) {
			ans[i] = input[i] + input[input.length - i - 1];
			} else {
				if ( i == ans.length - 1) {
					ans[i] = input[i];
				} else {
					ans[i] = input[i] + input[input.length - i - 1];
				}
			}
		}
		return ans;
	}
}
