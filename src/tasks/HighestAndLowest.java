package tasks;

import java.util.Scanner;
import java.util.Arrays;

/**
 * In this little assignment you are given a string of space separated numbers,
 * and have to return the highest and lowest number.
 * 
 * Example:
 * 
 * highAndLow("1 2 3 4 5") // return "5 1" 
 * highAndLow("1 2 -3 4 5") // return "5 -3" 
 * highAndLow("1 9 3 4 -5") // return "9 -5" 
 * Notes:
 * 
 * All numbers are valid Int32, no need to validate them. There will always be
 * at least one number in the input string. Output string must be two numbers
 * separated by a single space, and highest number is first.
 * 
 * @author SMD_ASY
 *
 */
public class HighestAndLowest {
	public static void main(String[] args) {
		System.out.println("Enter your value's");
		Scanner sc = new Scanner(System.in);
		String numbers = sc.nextLine();
		System.out.println(highAndLow(numbers));
		sc.close();
	}

	public static String highAndLow(String numbers) {
		String[] strArr = numbers.split(" ");
		int min = Integer.parseInt(strArr[0]);
		int max = Integer.parseInt(strArr[0]);
		for (int i = 1; i < strArr.length; i++) {
			if (Integer.valueOf(strArr[i]) > max) {
				max = Integer.valueOf(strArr[i]);
			}
			if (Integer.valueOf(strArr[i]) < min) {
				min = Integer.valueOf(strArr[i]);
			}
		}
		return Integer.toString(max) + " " + Integer.toString(min);
	}

	public static String HighAndLow2(String numbers) {

		int min = Arrays.stream(numbers.split(" ")).mapToInt(i -> Integer.parseInt(i)).min().getAsInt();

		int max = Arrays.stream(numbers.split(" ")).mapToInt(i -> Integer.parseInt(i)).max().getAsInt();

		return String.format("%d %d", max, min);
	}
}
