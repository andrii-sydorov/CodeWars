package kyu6;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Given a list of strings (of letters and spaces), and a list of numbers:
 * 
 * Considering the list of strings as a 2D character array, the idea is to
 * remove from each column, starting from bottom, as many letters as indicated
 * in the list of numbers. Then return the remaining letters in any order as a
 * string.
 * 
 * If there aren't enough letters, just remove those you can.
 * The strings in the list will all be of the same length.
 * The list of numbers will be of the same length as the strings in the list of
 * strings.
 * Strings will contain only lowercase letters and spaces.
 * There can be duplicated letters and numbers.
 * Example:
 * strings
 * 
 * ["abc",
 * " z ",
 * " a "]
 * numbers
 * 
 * [0,4,1]
 * the output would be "a".
 * 
 * If you like this kata, check out another one: Survivors Ep.4
 */

public class LastSurvivorsEp3 {
    public static void main(String[] args) {
        String[] strs = new String[] { "to   ", "  tal", "it   ", "  ari", "an   ", "  ism" };
        int[] nums = new int[] { 7, 6, 4, 2, 1 };
        System.out.println(lastSurvivors(strs, nums));
    }

    public static String lastSurvivors(String[] strs, int[] nums) {
        char[][] ch = makeCharFiled(strs);
        List<String> ls = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            int toDelete = nums[i];
            for (int r = ch.length - 1; r >= 0; r--) {
                for (int c = 0; c < ch[r].length; c++) {
                    if (c == i && toDelete != 0) {
                        if (ch[r][c] != ' ') {
                            ch[r][c] = ' ';
                            toDelete--;
                        }
                    } else {
                        if (c == i && ch[r][c] != ' ') {
                            ls.add(Character.toString(ch[r][c]));
                        }
                    }
                }
            }
        }
        Collections.sort(ls);
        for (String s : ls) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static char[][] makeCharFiled(String[] strs) {
        char[][] ans = new char[strs.length][];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = new char[strs[i].length()];
            for (int j = 0; j < ans[i].length; j++) {
                ans[i][j] = strs[i].charAt(j);
            }
        }
        return ans;
    }
}
