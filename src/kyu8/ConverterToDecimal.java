package kyu8;

import java.util.Scanner;

/**
 * Complete the function which converts hex number (given as a string) to a
 * decimal number.
 * 
 * @author SMD_ASY
 *
 */

public class ConverterToDecimal {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        String hexString = scanner.nextLine();
        scanner.close();
        System.out.println(hexToDec(hexString));
        System.out.println(hextToDecWithInteger(hexString));
    }

    public static int hexToDec(String hexString) {
        int sum = 0;
        String toConvertString = hexString.toUpperCase();
        String baseString = "0123456789ABCDEF";
        int j = 0;
        for (int i = toConvertString.length() - 1; i >= 0; i--) {
            int index = baseString.indexOf(Character.toString(toConvertString.charAt(i)));
            if (index >= 0) {
                sum += index * (int) Math.pow(16, j);
            }
            j++;
        }
        return hexString.startsWith("-") ? -sum : sum;
    }

    public static int hextToDecWithInteger(String hexString) {
        String toConvertString = hexString.toUpperCase();
        return Integer.parseInt(toConvertString, 16);
    }

}
