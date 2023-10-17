package kyu7;

import java.util.*;

/**
 * Count the number of occurrences of each character and return it as a (list of
 * tuples) in order of appearance. For empty output return (an empty list).
 * 
 * Consult the solution set-up for the exact data structure implementation
 * depending on your language.
 * 
 * Example:
 * 
 * ordered_count("abracadabra") == [('a', 5), ('b', 2), ('r', 2), ('c', 1),
 * ('d', 1)]
 */

public class OrderedCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        sc.close();
        System.out.println(orderedCount(text));
    }

    private static List<Map.Entry<Character, Integer>> orderedCount(String text) {
        char[] ar = text.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < ar.length; i++) {
            map.put(ar[i], map.getOrDefault(ar[i], 0) + 1);
        }
        List<Map.Entry<Character, Integer>> ls = new ArrayList<>();
        for (Map.Entry<Character, Integer> entr : map.entrySet()) {
            ls.add(entr);
        }
        return ls;
    }
}
