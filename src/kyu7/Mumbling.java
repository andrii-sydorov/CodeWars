package kyu7;

import java.util.Scanner;

/**
 * This time no story, no theory. The examples below show you how to write
 * function accum:
 * 
 * Examples:
 * 
 * accum("abcd") -> "A-Bb-Ccc-Dddd" 
 * accum("RqaEzty") ->"R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy" 
 * accum("cwAt") -> "C-Ww-Aaa-Tttt"
 * 
 * The parameter of accum is a string which includes only letters from a..z and
 * A..Z.
 * 
 * @author SMD_ASY
 *
 */
public class Mumbling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your phrase:");
		String s = sc.nextLine();
		sc.close();
		System.out.println(accum(s));
	}

	public static String accum(String s) {
		char[] chArr = s.toCharArray();
		String[] strArr = new String[s.length()];
		for (int i = 0; i < strArr.length; i++) {
			strArr[i] = "";
		}
		for (int i = 0; i < chArr.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					strArr[i] += Character.toString(chArr[i]).toUpperCase();
				} else {
					strArr[i] += Character.toString(chArr[i]).toLowerCase();
				}
			}
		}
		String res = "";
		res += String.join("-", strArr);
		return res;
	}
}
