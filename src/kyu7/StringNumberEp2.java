package kyu7;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Definition
 * Strong number is the number that the sum of the factorial of its digits is
 * equal to number itself.
 * 
 * For example, 145 is strong, since 1! + 4! + 5! = 1 + 24 + 120 = 145.
 * 
 * Task
 * Given a number, Find if it is Strong or not and return either "STRONG!!!!" or
 * "Not Strong !!".
 * 
 * Notes
 * Number passed is always Positive.
 * Return the result as String
 * Input >> Output Examples
 * strong_num(1) ==> return "STRONG!!!!"
 * Since, the sum of its digits' factorial (1) is equal to number itself, then
 * its a Strong.
 * 
 * strong_num(123) ==> return "Not Strong !!"git
 * Since the sum of its digits' factorial of 1! + 2! + 3! = 9 is not equal to
 * number itself, then it's Not Strong .
 * 
 * strong_num(2) ==> return "STRONG!!!!"
 * Since the sum of its digits' factorial of 2! = 2 is equal to number itself,
 * then its a Strong.
 * 
 * strong_num(150) ==> return "Not Strong !!"
 * Since the sum of its digits' factorial of 1! + 5! + 0! = 122 is not equal to
 * number itself, Then it's Not Strong .
 * 
 * 
 */

public class StringNumberEp2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.valueOf(sc.nextLine());
        sc.close();
        System.out.println(isStrongNumber(num));
    }

    public static String isStrongNumber(int num) {
        int[] ar = Arrays.stream(String.valueOf(num).split("")).mapToInt(Integer::valueOf).toArray();
        int sum = 0;
        for (int i = 0; i < ar.length; i++) {
            sum += getFactorial(ar[i]);
        }
        return sum == num ? "STRONG!!!!" : "Not Strong !!";
    }

    public static int getFactorial(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        return n * getFactorial(n - 1);
    }
}
