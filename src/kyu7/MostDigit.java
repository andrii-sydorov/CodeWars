package kyu7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Find the number with the most digits.
 * 
 * If two numbers in the argument array have the same number of digits, return
 * the first one in the array.
 * 
 * @author SMD_ASY
 *
 */

public class MostDigit {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        scanner.close();
        System.out.println(findLongest(numbers));
    }

    public static int findLongest(int[] numbers) {
        int maxLength = numbers[0] < 0 ? String.valueOf(numbers[0]).length() - 1 : String.valueOf(numbers[0]).length();
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            int currentLength = numbers[i] < 0 ? String.valueOf(numbers[i]).length() - 1
                    : String.valueOf(numbers[i]).length();
            if (currentLength > maxLength) {
                max = numbers[i];
                maxLength = String.valueOf(numbers[i]).length();
            }
        }
        return max;
    }

}
