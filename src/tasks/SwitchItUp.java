package tasks;

import java.util.HashMap;
import java.util.Scanner;

/**
 * When provided with a number between 0-9, return it in words.
 * 
 * Input :: 1
 * 
 * Output :: "One".
 * 
 * If your language supports it, try using a switch statement.
 * 
 * @author Zver
 *
 */
public class SwitchItUp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your's value:");
		int number = sc.nextInt();
		System.out.println(switchItUp(number));
		sc.close();
	}

	/**
	 * My solution, first attempt with HashMap
	 * 
	 * @param number
	 * @return
	 */
	public static String switchItUp(int number) {
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(0, "Zero");
		hm.put(1, "One");
		hm.put(2, "Two");
		hm.put(3, "Three");
		hm.put(4, "Four");
		hm.put(5, "Five");
		hm.put(6, "Six");
		hm.put(7, "Seven");
		hm.put(8, "Eight");
		hm.put(9, "Nine");
		return hm.get(number);
	}

	/**
	 * solution from CodeWars
	 * 
	 * @param number
	 * @return
	 */
	public static String switchItUp2(int number) {
		return new String[] { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" }[number];
	}
}
