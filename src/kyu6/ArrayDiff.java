package kyu6;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Your goal in this kata is to implement a difference function, which subtracts
 * one list from another and returns the result.
 * 
 * It should remove all values from list a, which are present in list b keeping
 * their order.
 * 
 * Kata.arrayDiff(new int[] {1, 2}, new int[] {1}) => new int[] {2} If a value
 * is present in b, all of its occurrences must be removed from the other:
 * 
 * Kata.arrayDiff(new int[] {1, 2, 2, 2, 3}, new int[] {2}) => new int[] {1, 3}
 */

public class ArrayDiff {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first array:");
        int[] a = null;
        int[] b = null;
        // try {
        //     a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // } catch (Exception e) {
        //     System.out.println(Arrays.toString(new int[] {}));
        //     System.exit(0);
        // }

        // System.out.println("Enter the second array:");

        // try {
        //     b = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // } catch (Exception e) {
        //     System.out.println(Arrays.toString(a));
        //     System.exit(0);
        // }

        a = new int[] { 2, 1, 14, 10, 10, 11, 14, 16, 20, 12, 3, 21, 22, 21, 16, 18, 19, 10, 12, 14, 23, 22, 24, 1, 20,
                5, 16, 10, 9, 3, 23, 4, 9, 9, 11, 5, 11, 0, 10, 7, 16, 2, 10, 3, 19, 20, 5, 17, 16, 11, 0, 14, 1, 11, 3,
                1 };
        b = new int[] { 8, 2, 14, 21, 14, 4, 5, 18, 2, 11, 13, 6, 1, 0, 0, 18, 9, 17, 3, 20, 11, 19, 17, 5, 2, 14, 13,
                6, 12, 11, 8, 10, 15, 0, 5, 15, 7, 11, 7, 4, 14, 6, 13, 19, 8, 12, 19, 21, 11, 7, 19, 8, 23, 18, 14, 19,
                17, 12, 16, 11, 20, 22, 11, 14, 20, 5, 12, 22, 3, 14, 4, 9, 17, 11, 22, 2, 6, 9, 8, 19, 0, 12 };
        System.out.println(Arrays.toString(arrayDiff(a, b)));
        System.out.println(Arrays.toString(arrayDiff2(a, b)));
        sc.close();
    }

    private static int[] arrayDiff(int[] a, int[] b) {
        if (b == null || b.length == 0) {
            return a;
        }
        if (a == null || a.length == 0) {
            return new int[] {};
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            boolean isIncluded = false;
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    isIncluded = true;
                    break;
                }
            }
            if (!isIncluded) {
                ans.add(a[i]);
            }
        }
        return fromListToArray(ans);
    }

    private static int[] fromListToArray(List<Integer> ls) {
        int[] ans = new int[ls.size()];
        for (int i = 0; i < ls.size(); i++) {
            ans[i] = ls.get(i);
        }
        return ans;
    }

    private static int[] arrayDiff2(int[] a, int[] b) {
        if (b == null || b.length == 0) {
            return a;
        }
        if (a == null || a.length == 0) {
            return new int[] {};
        }
        StringBuilder sb = new StringBuilder();
        String first = buildString(a);
        String second = buildString(b);
        for (int i = 0; i < first.length(); i++) {
            if (second.contains(Character.toString(first.charAt(i)))) {
                continue;
            }
            sb.append(first.charAt(i));
        }
        int[] ans = new int[sb.length()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = Integer.valueOf(Character.getNumericValue(sb.charAt(i)));
        }
        return ans;
    }

    private static String buildString(int[] a) {
        String ans = "";
        for (int i = 0; i < a.length; i++) {
            ans += String.valueOf(a[i]);
        }
        return ans;
    }

}
