package kyu6.WhichAreIn;

/**
 * Given two arrays of strings a1 and a2 return a sorted array r in lexicographical order of the strings of a1 which are substrings of strings of a2.
Example 1:

a1 = ["arp", "live", "strong"]

a2 = ["lively", "alive", "harp", "sharp", "armstrong"]

returns ["arp", "live", "strong"]
Example 2:

a1 = ["tarp", "mice", "bull"]

a2 = ["lively", "alive", "harp", "sharp", "armstrong"]

returns []
Notes:

    Arrays are written in "general" notation. See "Your Test Cases" for examples in your language.

    In Shell bash a1 and a2 are strings. The return is a string where words are separated by commas.

    Beware: r must be without duplicates.


 */

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Arrays;
import java.io.FileInputStream;
import java.util.List;
import java.util.ArrayList;

public class WhichAreIn {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf1 = new BufferedReader(
				new FileReader("D:\\Java\\Work\\CodeWars\\src\\kyu6\\WhichAreIn\\a1.txt"));
		BufferedReader bf2 = new BufferedReader(
				new FileReader("D:\\Java\\Work\\CodeWars\\src\\kyu6\\WhichAreIn\\a2.txt"));
		String array1[] = bf1.readLine().split(" ");
		String array2[] = bf2.readLine().split(" ");
		bf1.close();
		bf2.close();
		System.out.println(Arrays.toString(inArray(array1, array2)));
	}

	public static String[] inArray(String[] array1, String[] array2) {
		List<String> ls = new ArrayList<>();
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array2.length; j++) {
				if (array2[j].contains(array1[i])) {
					ls.add(array1[i]);
					break;
				}
			}
		}
		String[] ans = new String[ls.size()];
		for (int k = 0; k < ans.length; k++) {
			ans[k] = ls.get(k);
		}
		Arrays.sort(ans);

		return ans;

		/*
		 * return ls.toArray(new String[ls.size()]);
		 * return Arrays.stream(array1).filter(str -> Arrays.stream(array2).anyMatch(s -> s.contains(str))).distinct()
				.sorted().toArray(String[]::new);
		return Arrays.stream(ans).toArray(String[]::new);
		 */
		
	}

}
