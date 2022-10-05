package kyu7;

import java.util.Scanner;

/**
 * In this Kata, you will be given a string that may have mixed uppercase and
 * lowercase letters and your task is to convert that string to either lowercase
 * only or uppercase only based on:
 * 
 * make as few changes as possible.
 * if the string contains equal number of uppercase and lowercase letters,
 * convert the string to lowercase.
 * For example:
 * 
 * solve("coDe") = "code". Lowercase characters > uppercase. Change only the "D"
 * to lowercase.
 * solve("CODe") = "CODE". Uppercase characters > lowecase. Change only the "e"
 * to uppercase.
 * solve("coDE") = "code". Upper == lowercase. Change all to lowercase.
 * More examples in test cases. Good luck!
 * 
 * Please also try:
 * 
 * Simple time difference
 * 
 * Simple remove duplicates
 * 
 * @author SMD_ASY
 *
 */

public class FixStringCase {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        System.out.println(solve(scanner.nextLine()));
        scanner.close();
    }

    public static String solve(String str) {
        int upperCase = 0;
        int lowerCase = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                upperCase++;
            } else {
                lowerCase++;
            }
        }
        return upperCase > lowerCase ? str.toUpperCase() : str.toLowerCase();
    }

}
