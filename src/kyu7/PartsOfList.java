package kyu7;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Write a function partlist that gives all the ways to divide a list (an array)
 * of at least two elements into two non-empty parts.
 * 
 * Each two non empty parts will be in a pair (or an array for languages without
 * tuples or a structin C - C: see Examples test Cases - )
 * Each part will be in a string
 * Elements of a pair must be in the same order as in the original array.
 * Examples of returns in different languages:
 * a = ["az", "toto", "picaro", "zone", "kiwi"] -->
 * [["az", "toto picaro zone kiwi"], ["az toto", "picaro zone kiwi"], ["az toto
 * picaro", "zone kiwi"], ["az toto picaro zone", "kiwi"]]
 * or
 * a = {"az", "toto", "picaro", "zone", "kiwi"} -->
 * {{"az", "toto picaro zone kiwi"}, {"az toto", "picaro zone kiwi"}, {"az toto
 * picaro", "zone kiwi"}, {"az toto picaro zone", "kiwi"}}
 * or
 * a = ["az", "toto", "picaro", "zone", "kiwi"] -->
 * [("az", "toto picaro zone kiwi"), ("az toto", "picaro zone kiwi"), ("az toto
 * picaro", "zone kiwi"), ("az toto picaro zone", "kiwi")]
 * or
 * a = [|"az", "toto", "picaro", "zone", "kiwi"|] -->
 * [("az", "toto picaro zone kiwi"), ("az toto", "picaro zone kiwi"), ("az toto
 * picaro", "zone kiwi"), ("az toto picaro zone", "kiwi")]
 * or
 * a = ["az", "toto", "picaro", "zone", "kiwi"] -->
 * "(az, toto picaro zone kiwi)(az toto, picaro zone kiwi)(az toto picaro, zone
 * kiwi)(az toto picaro zone, kiwi)"
 */

public class PartsOfList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split("\\s+");
        sc.close();
        System.out.println(Arrays.deepToString(partList(arr)));
    }

    public static String[][] partList(String[] arr) {
        String[][] ans = new String[arr.length - 1][];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = new String[2];
            for (int j = 0; j < ans[i].length; j++) {
                if (j == 0) {
                    ans[i][j] = copyTo(i, arr);
                } else {
                    ans[i][j] = copyFrom(i, arr);
                }
            }
        }
        return ans;
    }

    public static String copyTo(int index, String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= index; i++) {
            sb.append(arr[i] + " ");
        }
        return sb.toString().trim();
    }

    public static String copyFrom(int index, String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = index + 1; i < arr.length; i++) {
            sb.append(arr[i] + " ");
        }
        return sb.toString().trim();
    }

    public static String[][] partlist(String[] arr) {
        String[][] returnArray = new String[arr.length-1][2];
        for(int i = 0; i < arr.length-1; ++i) {
          returnArray[i][0] = String.join(" ", Arrays.copyOfRange(arr, 0, i+1));
          returnArray[i][1] = String.join(" ", Arrays.copyOfRange(arr, i+1, arr.length));
        }
        
        return returnArray;
    }
}
