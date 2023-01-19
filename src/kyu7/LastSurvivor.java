package kyu7;

import java.util.Scanner;
import java.util.Arrays;

/**
 * You are given a string of letters and an array of numbers.
 * The numbers indicate positions of letters that must be removed, in order,
 * starting from the beginning of the array.
 * After each removal the size of the string decreases (there is no empty
 * space).
 * Return the only letter left.
 * 
 * Example:
 * 
 * str = "zbk", arr = {0, 1}
 * str = "bk", arr = {1}
 * str = "b", arr = {}
 * return "b"
 * Notes
 * The given string will never be empty.
 * The length of the array is always one less than the length of the string.
 * All numbers are valid.
 * There can be duplicate letters and numbers.
 * If you like this kata, check out the next one: Last Survivors Ep.2А
 */

public class LastSurvivor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String letters = sc.nextLine();
        int[] coords = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        sc.close();
        System.out.println(lastSurvivor(letters, coords));
    }

    public static String lastSurvivor(String letters, int[] coords) {
        StringBuilder sb = new StringBuilder(letters);
        for (int i = 0; i < coords.length; i++) {
            sb.deleteCharAt(coords[i]);
        }
        return sb.toString();
    }
}
