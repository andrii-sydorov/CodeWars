package tasks;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Assume "#" is like a backspace in string. This means that string "a#bc#d"
 * actually is "bd"
 * 
 * Your task is to process a string with "#" symbols.
 * 
 * Examples "abc#d##c" ==> "ac" 
 * "abc##d######" ==> "" 
 * "#######" ==> "" 
 * "" ==> ""
 * 
 * @author SMD_ASY
 *
 */
public class BackspacesInString {
	public static void main(String[] args) {
		System.out.println("Enter your's string");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(cleanString(s));
		sc.close();
	}

	public static String cleanString(String s) {
		ArrayList<String> list = new ArrayList<>();
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '#') {
				if (list.size() == 0) {
					continue;
				}
				list.remove(index - 1);
				index--;
			} else {
				list.add(Character.toString(s.charAt(i)));
				index++;
			}
		}
		if (list.size() != 0) {
			String res = "";
			for (int i = 0; i < list.size(); i++) {
				res += list.get(i);
			}
			return res;
		} else
			return "";
	}

	public String cleanString2(String s) {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if (c == '#')
				b.setLength(Math.max(b.length() - 1, 0));
			else
				b.append(c);
		}
		return b.toString();
	}

	static String cleanString3(String s) {
		while (s.matches(".*#.*"))
			s = s.replaceFirst(".?#", "");
		return s;
	}
}
