package tasks;

import java.util.Scanner;

/**
 * Write a function that takes an integer as input, and returns the number of
 * bits that are equal to one in the binary representation of that number. You
 * can guarantee that input is non-negative.
 * 
 * Example: The binary representation of 1234 is 10011010010, so the function
 * should return 5 in this case
 * 
 * @author SMD_ASY
 *
 */
public class BitCounting {
	public static void main(String[] args) {
		System.out.println("Enter your's number");
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		int result = countBits(input);
		System.out.println(result);
		scanner.close();
	}

	public static int countBits(int n) {
		// Show me the code!
		int count = 0;
		while (n != 0) {
			if (n % 2 != 0) {
				n /= 2;
				count++;
			} else {
				n /= 2;
			}
		}
		return count;
	}
}
