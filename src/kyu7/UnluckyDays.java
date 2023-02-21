package kyu7;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Friday 13th or Black Friday is considered as unlucky day. Calculate how many
 * unlucky days are in the given year.
 * 
 * Find the number of Friday 13th in the given year.
 * 
 * Input: Year in Gregorian calendar as integer.
 * 
 * Output: Number of Black Fridays in the year as an integer.
 * 
 * Examples:
 * 
 * unluckyDays(2015) == 3
 * unluckyDays(1986) == 1
 */

public class UnluckyDays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = Integer.valueOf(sc.nextLine());
        System.out.println(unluckyDays(year));
        sc.close();
    }

    public static int unluckyDays(int year) {
        LocalDate ld = LocalDate.of(year, 1, 1);
        int days = ld.lengthOfYear();
        int toAdd = 0;
        int count = 0;
        while (toAdd <= days) {
            if (ld.plusDays(toAdd).getDayOfMonth() == 13 && ld.plusDays(toAdd).getDayOfWeek() == DayOfWeek.FRIDAY) {
                count++;
            }
            toAdd++;
        }
        return count;
    }
}
