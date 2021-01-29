package kyu7;

import java.util.Locale;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class TargetDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in).useLocale(Locale.UK);
		System.out.println("Enter your start value of money:");
		double a0 = sc.nextDouble();
		System.out.println("Enter your desired value of money:");
		double a = sc.nextDouble();
		System.out.println("Enter the procent value:");
		double p = sc.nextDouble();
		sc.close();
		System.out.println(dateNbDays(a0, a, p));
	}

	public static String dateNbDays(double a0, double a, double p) {
		LocalDate ld = LocalDate.of(2016, 1, 1);
		LocalDate n = LocalDate.now();
		double days = 0;
		while (a0 <= a) {
			a0 += a0 * p / 36000;
			days++;
		}
		System.out.println(days);
		ld = ld.plusDays((long)days);
		Calendar cd = Calendar.getInstance();
		cd.set(2016, 0, 1);
		cd.add(Calendar.DATE, (int)days);
		System.out.printf("%1$TY-%1$Tm-%1$Td" + "\n", cd.getTime());
		System.out.println( n.toString());
		return ld.toString();
	}

}
