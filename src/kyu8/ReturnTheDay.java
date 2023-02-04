package kyu8;

import java.util.Scanner;

/**
 * Complete the function which returns the weekday according to the input
 * number:
 * 
 * 1 returns "Sunday"
 * 2 returns "Monday"
 * 3 returns "Tuesday"
 * 4 returns "Wednesday"
 * 5 returns "Thursday"
 * 6 returns "Friday"
 * 7 returns "Saturday"
 * Otherwise returns "Wrong, please enter a number between 1 and 7"
 */

public class ReturnTheDay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        sc.close();
        System.out.println(getDay(n));
    }

    public static String getDay(int n) {
        for (Days d : Days.values()) {
            if (d.ordinal() + 1 == n) {
                return d.toString();
            }
        }
        return "Wrong, please enter a number between 1 and 7";
    }
}

enum Days {

    SUNDAY("Sunday"),
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday");

    private String s;

    Days(String s) {
        this.s = s;
    }

    public String toString() {
        return this.s;
    }
}
