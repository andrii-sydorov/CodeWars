package kyu6;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

/**
 * Pair of gloves
 * Winter is coming, you must prepare your ski holidays. The objective of this
 * kata is to determine the number of pair of gloves you can constitute from the
 * gloves you have in your drawer.
 * 
 * Given an array describing the color of each glove, return the number of pairs
 * you can constitute, assuming that only gloves of the same color can form
 * pairs.
 * 
 * Examples:
 * input = ["red", "green", "red", "blue", "blue"]
 * result = 2 (1 red pair + 1 blue pair)
 * 
 * input = ["red", "red", "red", "red", "red", "red"]
 * result = 3 (3 red pairs)
 */

public class PairOfGloves {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the colours of gloves: ");
        String[] gloves = sc.nextLine().split("\\s+");
        sc.close();
        System.out.println(numberOfPairs(gloves));
    }

    public static int numberOfPairs(String[] gloves) {
        int count = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < gloves.length; i++) {
            if (map.containsKey(gloves[i])) {
                map.put(gloves[i], map.get(gloves[i]) + 1);
            } else {
                map.put(gloves[i], 1);
            }
        }
        for (Map.Entry<String, Integer> en : map.entrySet()) {

            count += en.getValue() / 2;

        }
        return count;
    }
}
