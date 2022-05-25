package kyu8;

import java.util.Scanner;

/**
 * Complete the function which converts a binary number (given as a string) to a
 * decimal number.
 */

public class Converter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        System.out.println(binToDecimal(inp));
        sc.close();
    }

    private static int binToDecimal(String inp) {
        int ans = 0;
        for (int i = 0; i < inp.length(); i++) {
            ans += Character.getNumericValue(inp.charAt(i)) * Math.pow(2, inp.length() - 1 - i);
        }
        return ans;
    }
}
