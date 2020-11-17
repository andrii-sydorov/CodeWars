package tasks;
import java.util.Scanner;
public class Palindromes {
	public static void main(String[] args) {
		System.out.println("Enter your's String:");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(longestPalindrome(s));
		sc.close();
	}
	
	public static int longestPalindrome(String s) {
		int max = 0;
		if (s.contains(" ")) {
			String[] arrStr = s.split(" ");
			for (int i = 0; i < arrStr.length; i++) {
				if (longPal(arrStr[i]) > max) {
					max = longPal(arrStr[i]);
				}
			}
		} else {
			if (longPal(s) > max) {
				max = longPal(s);
			}
		}
		return max;
	}
	
	public static int longPal(String s) {
		int max = 0;
		String temp = "";
		for(int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
			temp = s.substring(i, j + 1);
			if(temp.equals(reverse(temp))) {
				if (max < temp.length()) {
					max = temp.length();
				}	
			}
			}
		}
		return max;
	}
	
	public static String reverse(String s) {
		String result = "";
		for(int i = s.length()  - 1; i >= 0; i--) {
			char temp = s.charAt(i);
			result += Character.toString(temp);
		}
		return result;
	}
}
