package kyu7;

import java.util.Scanner;

/**
 * Definition
 * A Tidy number is a number whose digits are in non-decreasing order.
 * 
 * Task
 * Given a number, Find if it is Tidy or not .
 * 
 * Warm-up (Highly recommended)
 * Playing With Numbers Series
 * Notes
 * Number passed is always Positive .
 * 
 * Return the result as a Boolean
 * 
 * Input >> Output Examples
 * tidyNumber (12) ==> return (true)
 * Explanation:
 * The number's digits { 1 , 2 } are in non-Decreasing Order (i.e) 1 <= 2 .
 * 
 * tidyNumber (32) ==> return (false)
 * Explanation:
 * The Number's Digits { 3, 2} are not in non-Decreasing Order (i.e) 3 > 2 .
 * 
 * tidyNumber (1024) ==> return (false)
 * Explanation:
 * The Number's Digits {1 , 0, 2, 4} are not in non-Decreasing Order as 0 <= 1 .
 * 
 * tidyNumber (13579) ==> return (true)
 * Explanation:
 * The number's digits {1 , 3, 5, 7, 9} are in non-Decreasing Order .
 * 
 * tidyNumber (2335) ==> return (true)
 * Explanation:
 * The number's digits {2 , 3, 3, 5} are in non-Decreasing Order , Note 3 <= 3
 * 
 * Playing with Numbers Series
 * Playing With Lists/Arrays Series
 * For More Enjoyable Katas
 * ALL translations are welcomed
 * Enjoy Learning !!
 * Zizou
 * 
 */

public class TidyNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = Integer.valueOf(sc.nextLine());
        sc.close();
        System.out.println(tidyNumber(number));
    }

    public static boolean tidyNumber(int number) {
        int prev = 0;
        int curr = 0;
        boolean firstTurn = true;
        while (number > 0) {
            curr = number % 10;
            number /= 10;
            if (firstTurn) {
                firstTurn = false;
                prev = curr;
                continue;
            }
            if (prev < curr) {
                return false;
            }
            prev = curr;
        }
        return true;
    }
}
