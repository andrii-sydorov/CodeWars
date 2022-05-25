package kyu7;

import java.util.*;
import java.util.stream.Collectors;

/**
 * In this kata you will create a function that takes a list of non-negative
 * integers and strings and returns a new list with the strings filtered out.
 * 
 * Example
 * Kata.filterList(List.of(1, 2, "a", "b")) => List.of(1,2)
 * Kata.filterList(List.of(1, 2, "a", "b", 0, 15)) => List.of(1,2,0,15)
 * Kata.filterList(List.of(1, 2, "a", "b", "aasf", "1", "123", 231)) =>
 * List.of(1, 2, 231)
 */

public class ListFiltering {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Object> list = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());
        sc.close();
        System.out.println(filterList(list));
    }

    private static List<Object> filterList(final List<Object> list) {
        List<Object> ans = new ArrayList<>();
        for (Object ob : list) {
            try {
                int i = Integer.valueOf((String) ob);
                ans.add(ob);
            } catch (Exception e) {
                continue;
            }
        }
        return ans;
    }
}
