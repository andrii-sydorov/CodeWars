package tasks;

import java.util.Scanner;

/**
 * Your goal is to return multiplication table for number that is always an
 * integer from 1 to 10.
 * 
 * For example, a multiplication table (string) for number == 5 looks like
 * below:
 * 
 * 1 * 5 = 5 
 * 2 * 5 = 10 
 * 3 * 5 = 15 
 * 4 * 5 = 20 
 * 5 * 5 = 25 
 * 6 * 5 = 30 
 * 7 * 5 = 35 
 * 8 * 5 = 40 
 * 9 * 5 = 45 
 * 10 * 5 = 50
 * 
 * P. S. You can use \n in string to jump to the next line.
 * 
 * @author Zver
 *
 */
public class MultiplicationTableForNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number, which multiplication table you want to have:");
		int num = sc.nextInt();
		System.out.println(multiTable(num));
		sc.close();
	}
	
// my solution
	public static String multiTable(int num) {
		String result = "";
		for (int i = 1; i <= 10; i++) {
			if (i != 10) {
				result += i + " * " + num + " = " + (i * num) + "\n";
			} else {
				result += i + " * " + num + " = " + (i * num);
			}
		}
		return result; // good luck
	}
	
// not my solution
	public static String multiTable2(int num) {
		String arr[] = new String[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = String.format("%d * %d = %d", i + 1, num, (i + 1) * num);
		}
		return String.join("\n", arr);
	}
}
