package kyu7;

import java.util.Scanner;

/**
 * The aim of this kata is to split a given string into different strings of
 * equal size (note size of strings is passed to the method)
 * 
 * Example:
 * 
 * Split the below string into other strings of size #3
 * 
 * 'supercalifragilisticexpialidocious'
 * 
 * Will return a new string
 * 'sup erc ali fra gil ist ice xpi ali doc iou s'
 * Assumptions:
 * 
 * String length is always greater than 0
 * String has no spaces
 * Size is always positive
 */

public class SplitInParts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int partLength = Integer.valueOf(sc.nextLine());
        sc.close();
        System.out.println(splitInParts(s, partLength));
    }

    public static String splitInParts(String s, int partLength) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index <= s.length()) {
            sb.append(s.substring(0 + index, index + partLength >= s.length() ? s.length() : index + partLength) + " ");
            index += partLength;
        }
        return sb.toString().trim();
    }
}
