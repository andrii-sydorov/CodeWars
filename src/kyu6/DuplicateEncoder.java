package kyu6;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

/**
 * The goal of this exercise is to convert a string to a new string where each
 * character in the new string is "(" if that character appears only once in the
 * original string, or ")" if that character appears more than once in the
 * original string. Ignore capitalization when determining if a character is a
 * duplicate.
 * 
 * Examples
 * "din" => "((("
 * "recede" => "()()()"
 * "Success" => ")())())"
 * "(( @" => "))(("
 * Notes
 * Assertion messages may be unclear about what they display in some languages.
 * If you read "...It Should encode XXX", the "XXX" is the expected result, not
 * the input!
 * 
 * 
 */

public class DuplicateEncoder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        System.out.println(encode(word));
        sc.close();
    }

    private static String encode(String word) {
        word = word.toLowerCase();
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        for (Character c : word.toCharArray()) {
            map.put(Character.toString(c), map.getOrDefault(Character.toString(c), 0) + 1);
        }
        // System.out.println(map);
        for (Character c : word.toCharArray()) {
            if (map.get(Character.toString(c)) > 1) {
                sb.append(")");
            } else {
                sb.append("(");
            }
        }
        return sb.toString();
    }
}
