package kyu7;

import java.util.Scanner;

public class Drinkin {
	/**
	 * Welcome to the Codewars Bar!
	 * 
	 * Codewars Bar recommends you drink 1 glass of water per standard drink so
	 * you're not hungover tomorrow morning.
	 * 
	 * Your fellow coders have bought you several drinks tonight in the form of a
	 * string. Return a string suggesting how many glasses of water you should drink
	 * to not be hungover. 
	 * Example parties: 
	 * Input 0:
	 * "1 beer" 
	 * Output 0:
	 * "1 glass of water" 
	 * Explaination 0:
	 * You drank one standard drink 
	 * 
	 * Input 1:
	 * "1 shot, 5 beers, 2 shots, 1 glass of wine, 1 beer" 
	 * Output 1:
	 * "10 glasses of water" Explaination 1:
	 * 
	 * You drank ten standard drinks
	 * 
	 * Note:
	 * 
	 * To keep the things simple, we'll considere that any "numbered thing" in the
	 * string is a drink. 
	 * Even "1 bear" => "1 glass of water" or "1 chainsaw and 2
	 * pools" => "3 glasses of water"...
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your's menu of drinks:");
		String drinkString = sc.nextLine();
		sc.close();
		System.out.println(hydrate(drinkString));
	}

	public static String hydrate(String drinkString) {
		char[] chArr = drinkString.replaceAll("[^0-9]", "").toCharArray();
		int number = 0;
		for (int i = 0; i < chArr.length; i++) {
			number += Character.getNumericValue(chArr[i]);
		}
		;
		return number == 1 ? number + " " + "glass of water" : number + " " + "glasses of water";
	}

}
