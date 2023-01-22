package kyu7;

import java.util.Scanner;

/**
 * Definition
 * Jumping number is the number that All adjacent digits in it differ by 1.
 * 
 * Task
 * Given a number, Find if it is Jumping or not .
 * 
 * Warm-up (Highly recommended)
 * Playing With Numbers Series
 * Notes
 * Number passed is always Positive .
 * 
 * Return the result as String .
 * 
 * The difference between ‘9’ and ‘0’ is not considered as 1 .
 * 
 * All single digit numbers are considered as Jumping numbers.
 * 
 * Input >> Output Examples
 * jumpingNumber(9) ==> return "Jumping!!"
 * Explanation:
 * It's single-digit number
 * jumpingNumber(79) ==> return "Not!!"
 * Explanation:
 * Adjacent digits don't differ by 1
 * jumpingNumber(23) ==> return "Jumping!!"
 * Explanation:
 * Adjacent digits differ by 1
 * jumpingNumber(556847) ==> return "Not!!"
 * Explanation:
 * Adjacent digits don't differ by 1
 * jumpingNumber(4343456) ==> return "Jumping!!"
 * Explanation:
 * Adjacent digits differ by 1
 * jumpingNumber(89098) ==> return "Not!!"
 * Explanation:
 * Adjacent digits don't differ by 1
 * jumpingNumber(32) ==> return "Jumping!!"
 * Explanation:
 * 
 * Adjacent digits differ by 1
 */

public class StrongNumberEp3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = Integer.valueOf(sc.nextLine());
        System.out.println(jumpingNumber(number));
    }

    public static String jumpingNumber(int number) {
        if (number < 10) {
            return "Jumping!!";
        }
        int cur = 0;
        int prev = 0;
        boolean firstTurn = true;
        while (number > 0) {
            cur = number % 10;
            number /= 10;
            if (firstTurn) {
                prev = cur;
                firstTurn = false;
                continue;
            }
            if (Math.abs(cur - prev) != 1) {
                return "Not!!";
            }
            prev = cur;
        }
        return "Jumping!!";
    }
}
