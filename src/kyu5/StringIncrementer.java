package kyu5;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Your job is to write a function which increments a string, to create a new
 * string.
 * 
 * If the string already ends with a number, the number should be incremented by
 * 1.
 * If the string does not end with a number. the number 1 should be appended to
 * the new string.
 * Examples:
 * 
 * foo -> foo1
 * 
 * foobar23 -> foobar24
 * 
 * foo0042 -> foo0043
 * 
 * foo9 -> foo10
 * 
 * foo099 -> foo100
 * 
 * Attention: If the number has leading zeros the amount of digits should be
 * considered.
 * 
 * @author SMD_ASY
 *
 */

public class StringIncrementer {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        System.out.println(incrementString(str));
    }

    public static String incrementString(String str) {
        StringBuilder strings = new StringBuilder();
        StringBuilder numbers = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            String string = Character.toString(str.charAt(i));
            try {
                Integer.valueOf(string);
                numbers.append(string);
            } catch (NumberFormatException nfe) {
                strings.append(numbers);
                strings.append(string);
                numbers.setLength(0);
            }
        }
        int size = numbers.length();
        if (size == 0) {
            return strings.toString() + 1;
        }
        BigInteger temp = new BigInteger(numbers.toString()).add(BigInteger.ONE);
        StringBuilder toAddBuilder = new StringBuilder();
        if (String.valueOf(temp).length() < size) {
            for (int i = 0; i < size - String.valueOf(temp).length(); i++) {
                toAddBuilder.append("0");
            }
        }
        toAddBuilder.append(String.valueOf(temp));
        return strings.toString() + toAddBuilder.toString();
    }

}
