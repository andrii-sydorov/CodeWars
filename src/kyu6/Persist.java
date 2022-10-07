package kyu6;

import java.util.Scanner;

/**
 * Write a function, persistence, that takes in a positive parameter num and
 * returns its multiplicative persistence, which is the number of times you must
 * multiply the digits in num until you reach a single digit.
 * 
 * For example (Input --> Output):
 * 
 * 39 --> 3 (because 3*9 = 27, 2*7 = 14, 1*4 = 4 and 4 has only one digit)
 * 999 --> 4 (because 9*9*9 = 729, 7*2*9 = 126, 1*2*6 = 12, and finally 1*2 = 2)
 * 4 --> 0 (because 4 is already a one-digit number)
 * 
 * @author SMD_ASY
 *
 */

public class Persist {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        Long nLong = Long.valueOf(scanner.nextLine());
        scanner.close();
        System.out.println(persistence(nLong));
    }

    public static int persistence(Long n) {
        int sum = 0;
        String string = String.valueOf(n);
        while (string.length() != 1) {
            long prod = 1;
            for (int i = 0; i < string.length(); i++) {
                prod *= Character.getNumericValue(string.charAt(i));
            }
            string = String.valueOf(prod);
            sum++;
        }
        return sum;
    }

}
