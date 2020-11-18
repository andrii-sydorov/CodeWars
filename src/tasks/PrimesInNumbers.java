package tasks;

import java.util.Scanner;

public class PrimesInNumbers {
	public static void main(String[] args) {
		System.out.println("Enter your's number");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		long l = System.currentTimeMillis();
		System.out.println(factors(n));
		System.out.println(System.currentTimeMillis() - l);
	}

	public static String factors(int n) {
		String res = "";
		if(isSimple(n)) {
			res += "("+ n + ")";
			return res;
		}
		for (int i = 2; i <= n ; i++) {
			if (isSimple(i)) {
			int j = 0;
			while (n % i == 0) {
				n /= i;
				j++;
			}
			if (j > 1) {
				res += "(" + i + "**" + j + ")";
			} else if (j == 1) {
				res += "(" + i + ")";
			}
			if(i > 3) {
			i++;
			}
			}
		}
		return res;
	}
	
	static boolean isSimple(int number) {
		for (int i = 2; i < Math.sqrt(number); i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
