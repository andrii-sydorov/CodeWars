package kyu7;

import java.util.Scanner;

/**
 * Scenario
 * You're saying good-bye your best friend , See you next happy year .
 * 
 * Happy Year is the year with only distinct digits , (e.g) 2018
 * 
 * Task
 * Given a year, Find The next happy year or The closest year You'll see your
 * best friend!alt!alt
 * 
 * Notes
 * Year Of Course always Positive .
 * Have no fear , It is guaranteed that the answer exists .
 * It's not necessary that the year passed to the function is Happy one .
 * Input Year with in range (1000 ≤ y ≤ 9000)
 * Input >> Output Examples:
 * nextHappyYear (7712) ==> return (7801)
 * Explanation:
 * As the Next closest year with only distinct digits is 7801 .
 * 
 * nextHappyYear (8989) ==> return (9012)
 * Explanation:
 * As the Next closest year with only distinct digits is 9012 .
 * 
 * nextHappyYear (1001) ==> return (1023)
 * Explanation:
 * As the Next closest year with only distinct digits is 1023 .
 */

public class HappyNextYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = Integer.valueOf(sc.nextLine());
        sc.close();
        System.out.println(nextHappyYear(year));
    }

    public static int nextHappyYear(int year) {
        while (true) {
            year++;
            if (isHappy(year)) {
                return year;
            }
        }
    }

    public static boolean isHappy(int year) {
        boolean[] ar = new boolean[10];
        // Arrays.fill(ar, false);
        while (year > 0) {
            int div = year % 10;
            if (ar[div]) {
                return false;
            }
            ar[div] = true;
            year /= 10;
        }
        return true;
    }
}
