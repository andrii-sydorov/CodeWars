package kyu8;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.stream.*;

public class WrongEndHead {
	private static String[] arr = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter your order of bodies:");
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			arr = bf.readLine().split("\\s+");
		} catch(IOException ie) {
			try {
				bf.close();
			} catch(IOException ie1) {
			}
		}
		System.out.println(String.join(", ", fixTheMeerkat(arr)));
	}

	public static String[] fixTheMeerkat(String[] arr) {
		List<String> ls = new ArrayList<String>(Arrays.asList(arr));
		String[] ans = new String[ls.size()];
		Collections.reverse(ls);
		for(int i = 0; i < ls.size(); i++) {
			ans[i] = ls.get(i);
		}
		return ans;
	}
}
