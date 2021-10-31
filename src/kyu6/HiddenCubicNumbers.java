package kyu6;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * We search non-negative integer numbers, with at most 3 digits, such as the
 * sum of the cubes of their digits is the number itself; we will call them
 * "cubic" numbers.
 * 
 * 153 is such a "cubic" number : 1^3 + 5^3 + 3^3 = 153 These "cubic" numbers of
 * at most 3 digits are easy to find, even by hand, so they are "hidden" with
 * other numbers and characters in a string.
 * 
 * The task is to find, or not, the "cubic" numbers in the string and then to
 * make the sum of these "cubic" numbers found in the string, if any, and to
 * return a string such as:
 * 
 * "number1 number2 (and so on if necessary) sumOfCubicNumbers Lucky" if "cubic"
 * numbers number1, number2, ... were found.
 * 
 * The numbers in the output are to be in the order in which they are
 * encountered in the input string.
 * 
 * If no cubic numbers are found return the string: `"Unlucky"``.
 * 
 * Examples: 
 * - s = "aqdf&0#1xyz!22[153(777.777" 
 * the groups of at most 3 digits are 0 and 1 (one digit), 22 (two digits), 
 * 153, 777, 777 (3 digits) Only 0, 1, 153 are cubic and their sum is 154 
 * Return: "0 1 153 154 Lucky"
 * 
 * - s = "QK29a45[&erui9026315" 
 * the groups are 29, 45, 902, 631, 5. None is cubic. 
 * Return: "Unlucky" Notes In the string "001234" where 3 digits or more
 * follow each other the first group to examine is "001" and the following is
 * "234". If a packet of at most three digits has been taken, whether or not
 * "cubic", it's over for that packet.
 * 
 * When a continuous string of digits exceeds 3, the string is split into groups
 * of 3 from the left. The last grouping could have 3, 2 or 1 digits.
 * 
 * e.g "24172410" becomes 3 strings comprising "241", "724" and "10"
 * 
 * e.g "0785" becomes 2 strings comprising "078" and "5".
 * 
 * @author SMD_ASY
 *
 */

public class HiddenCubicNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your's string:");
		String s = sc.nextLine();
		sc.close();
		System.out.println(isSumOfCubes(s));
	}

	private static String isSumOfCubes(String s) {
		System.out.println(s);
		String[] st = s.replaceAll("\\D", " ").trim().split("\\s+");
		System.out.println("After parsing: " + Arrays.toString(st));
		int[] array = makeIntArray(st);
		System.out.println("Array of int: " + Arrays.toString(array));
		List<Integer> ls = new ArrayList<>();
		ls = makeListOfCubic(array);
		System.out.println("List of integer's: " + ls.toString());
		if (ls.size() != 0) {
			String members = makeStringArray(ls);
			return members + " " + calcSumOfList(ls) + " Lucky";
		}
		return "Unlucky";
	}

	private static String makeStringArray(List<Integer> ls) {
		String[] st = new String[ls.size()];
		int index = 0;
		for (int i : ls) {
			st[index] = String.valueOf(i);
			index++;
		}
		return String.join(" ", st);
	}

	private static String calcSumOfList(List<Integer> ls) {
		int sum = 0;
		for (int i : ls) {
			sum += i;
		}
		return String.valueOf(sum);
	}

	private static List<Integer> makeListOfCubic(int[] array) {
		List<Integer> ls = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			if (sumOfCubes(array[i]) == array[i]) {
				ls.add(array[i]);
			}
		}
		return ls;
	}

	private static int sumOfCubes(int i) {
		String s = String.valueOf(i);
		int sum = 0;
		for (int j = 0; j < s.length(); j++) {
			sum += Math.pow(Character.getNumericValue(s.charAt(j)), 3);
		}
		return sum;
	}

	private static int[] makeIntArray(String[] st) {
		String temp = "";
		for (int i = 0; i < st.length; i++) {
			if (st[i].length() > 3) {
				temp += recursiveString(st[i]);
			} else {
				temp += st[i];
			}
			temp += " ";
		}
		return Arrays.stream(temp.split(" ")).mapToInt(Integer::valueOf).toArray();
	}

	private static String recursiveString(String s) {
		if (s.length() <= 3) {
			return s;
		}
		return s.substring(0, 3) + " " + recursiveString(s.substring(3));
	}

}
