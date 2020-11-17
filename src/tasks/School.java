package tasks;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * It's the academic year's end, fateful moment of your school report. The
 * averages must be calculated. All the students come to you and entreat you to
 * calculate their average for them. Easy ! You just need to write a script.
 * 
 * Return the average of the given array rounded down to its nearest integer.
 * 
 * The array will never be empty.
 * 
 * @author SMD_ASY
 *
 */
public class School {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your array:");
		String[] arStr = sc.nextLine().split(" ");
		int[] arInt = new int[arStr.length];
		for (int i = 0; i < arInt.length; i++) {
			arInt[i] = Integer.valueOf(arStr[i]);
		}
		System.out.println(getAverage(arInt));
		sc.close();
	}

	public static int getAverage(int[] marks) {
		int sum = 0;
		for (int i = 0; i < marks.length; i++) {
			sum += marks[i];
		}
		return sum / marks.length;
	}

	public static int getAverage2(int[] marks) {
		return (int) Arrays.stream(marks).average().orElse(Double.NaN);
	}

	static int getAverage3(int[] marks) {
		return (int) IntStream.of(marks).average().getAsDouble();
	}
}
