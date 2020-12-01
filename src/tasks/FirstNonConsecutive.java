package tasks;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Your task is to find the first element of an array that is not consecutive.
 * 
 * By not consecutive we mean not exactly 1 larger than the previous element of
 * the array.
 * 
 * E.g. If we have an array [1,2,3,4,6,7,8] then 1 then 2 then 3 then 4 are all
 * consecutive but 6 is not, so that's the first non-consecutive number.
 * 
 * If the whole array is consecutive then return null2.
 * 
 * The array will always have at least 2 elements1 and all elements will be
 * numbers. The numbers will also all be unique and in ascending order. The
 * numbers could be positive or negative and the first non-consecutive could be
 * either too!
 * 
 * If you like this Kata, maybe try this one next:
 * https://www.codewars.com/kata/represent-array-of-numbers-as-ranges
 * 
 * @author Zver
 *
 */
public class FirstNonConsecutive {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your's value:");
		String[] in = sc.nextLine().split(" ");
		int[] array = new int[in.length];
		for (int i = 0; i < in.length; i++) {
			array[i] = Integer.valueOf(in[i]);
		}
		System.out.println(find(array));
		sc.close();
	}

	/**
	 * my solution
	 * 
	 * @param array
	 * @return
	 */
	static Integer find(final int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i + 1] - array[i] != 1) {
				return array[i + 1];
			}
		}
		return null;
	}

	/**
	 * solution from CodeWars
	 * 
	 * @param array
	 * @return
	 */
	static Integer find2(final int[] array) {
		return IntStream.range(1, array.length).filter(i -> array[i - 1] != array[i] - 1)
				.mapToObj(x -> new Integer(array[x])).findFirst().orElse(null);
	}
}
