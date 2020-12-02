package kyu8;

import java.util.Scanner;

/**
 * Nathan loves cycling.
 * 
 * Because Nathan knows it is important to stay hydrated, he drinks 0.5 litres
 * of water per hour of cycling.
 * 
 * You get given the time in hours and you need to return the number of litres
 * Nathan will drink, rounded to the smallest value.
 * 
 * For example:
 * 
 * time = 3 ----> litres = 1
 * 
 * time = 6.7---> litres = 3
 * 
 * time = 11.8--> litres = 5
 * 
 * @author Zver
 *
 */
public class KeepHydrated {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the numbers of hours:");
		double time = sc.nextDouble();
		System.out.println(new KeepHydrated().Liters(time));
		sc.close();
	}

	public int Liters(double time) {
		final double literPerHour = 0.5;
		return (int) Math.floor(time * literPerHour);
	}
}
