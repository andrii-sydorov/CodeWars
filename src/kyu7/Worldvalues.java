package kyu7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given a string "abc" and assuming that each letter in the string has a value
 * equal to its position in the alphabet, our string will have a value of 1 + 2
 * + 3 = 6. This means that: a = 1, b = 2, c = 3 ....z = 26.
 * 
 * You will be given a list of strings and your task will be to return the
 * values of the strings as explained above multiplied by the position of that
 * string in the list. For our purpose, position begins with 1.
 * 
 * nameValue ["abc","abc abc"] should return [6,24] because of [ 6 * 1, 12 * 2
 * ]. Note how spaces are ignored.
 * 
 * "abc" has a value of 6, while "abc abc" has a value of 12. Now, the value at
 * position 1 is multiplied by 1 while the value at position 2 is multiplied by
 * 2.
 * 
 * Input will only contain lowercase characters and spaces.
 * 
 * Good luck!
 * 
 * If you like this Kata, please try:
 * 
 * String matchup
 * 
 * Consonant value
 */

public class Worldvalues {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split("\\s+");
        sc.close();
        System.out.println(Arrays.toString(nameValue(arr)));
    }

    public static int[] nameValue(String[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = calculateSum(arr[i], i + 1);
        }
        return ans;
    }

    public static int calculateSum(String s, int mul) {
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            sb.append(ch);
        }
        for (int i = 0; i < s.length(); i++) {
            sum += sb.indexOf(Character.toString(s.charAt(i))) + 1;
        }
        return sum * mul;
    }
}
