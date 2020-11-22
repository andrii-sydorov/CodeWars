package tasks;

import java.util.Arrays;
import java.util.Scanner;

/**
 * What is your favourite day of the week? Check if it's the most frequent day
 * of the week in the year.
 * 
 * You are given a year as integer (e. g. 2001). You should return the most
 * frequent day(s) of the week in that year. The result has to be a list of days
 * sorted by the order of days in week (e. g. ['Monday', 'Tuesday'],
 * ['Saturday', 'Sunday'], ['Monday', 'Sunday']). Week starts with Monday.
 * 
 * Input: Year as an int.
 * 
 * Output: The list of most frequent days sorted by the order of days in week
 * (from Monday to Sunday).
 * 
 * Preconditions:
 * 
 * Week starts on Monday. Year is between 1583 and 4000. Calendar is Gregorian.
 * 
 * Example:
 * 
 * Kata.mostFrequentDays(2427) => {"Friday"} 
 * Kata.mostFrequentDays(2185) => {"Saturday"} 
 * Kata.mostFrequentDays(2860) => {"Thursday", "Friday"}
 * 
 * @author Zver
 *
 */
public class MostFrequentWeekdays {
	public static void main(String[] args) {
		System.out.println("Enter your's year");
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		sc.close();
		System.out.println("Is the year leap " + "\"" + isLeapYear(year) + "\"");
//		System.exit(1);
		System.out.println(Arrays.toString(mostFrequentDays(year)));

	}

	public static String[] mostFrequentDays(int year) {
		/*
		 * 
		 * Week starts on Monday. Year is between 1583 and 4000. Calendar is Gregorian.
		 * 
		 */
		final int START = 6; // the year 1583 was started at Saturday, day number 6
		final int YEAR = 1583; // the start year
		int numberOfDay = START;
		for (int i = YEAR; i < year; i++) {
			if (isLeapYear(i)) {
				numberOfDay += 2;
			} else {
				numberOfDay++;
			}
		}

		if (isLeapYear(year)) {
			int firstDay = numberOfDay;
			int secondDay = ++numberOfDay;
			firstDay = firstDay % 7 == 0 ? 7 : firstDay % 7;
			secondDay = secondDay % 7 == 0 ? 7 : secondDay % 7;
			return new String[] { dayOfTheWeek(Math.min(firstDay, secondDay)).toString(),
					dayOfTheWeek(Math.max(firstDay, secondDay)).toString() };
		} else {
			numberOfDay = numberOfDay % 7 == 0 ? 7 : numberOfDay % 7;
			return new String[] { dayOfTheWeek(numberOfDay).toString() };
		}
	}

	public static boolean isLeapYear(int year) {
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? true : false;
	}

	public static Weekdays dayOfTheWeek(int n) {
		switch (n) {
		case 1:
			return Weekdays.Monday;
		case 2:
			return Weekdays.Tuesday;
		case 3:
			return Weekdays.Wednesday;
		case 4:
			return Weekdays.Thursday;
		case 5:
			return Weekdays.Friday;
		case 6:
			return Weekdays.Saturday;
		case 7:
			return Weekdays.Sunday;
		}
		return null;
	}
}

enum Weekdays {
	Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;
}
