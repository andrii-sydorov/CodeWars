package kyu6;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Enough is enough!
 * Alice and Bob were on a holiday. Both of them took many pictures of the
 * places they've been, and now they want to show Charlie their entire
 * collection. However, Charlie doesn't like these sessions, since the motive
 * usually repeats. He isn't fond of seeing the Eiffel tower 40 times. He tells
 * them that he will only sit during the session if they show the same motive at
 * most N times. Luckily, Alice and Bob are able to encode the motive as a
 * number. Can you help them to remove numbers such that their list contains
 * each number only up to N times, without changing the order?
 * 
 * Task
 * Given a list and a number, create a new list that contains each number of lst
 * at most N times without reordering. For example if the input number is 2, and
 * the input list is [1,2,3,1,2,1,2,3], you take [1,2,3,1,2], drop the next
 * [1,2] since this would lead to 1 and 2 being in the result 3 times, and then
 * take 3, which leads to [1,2,3,1,2,3]. With list [20,37,20,21] and number 1,
 * the result would be [20,37,20,21].
 */

public class EnoughIsEnough {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split("\\W+");
        int[] elements = new int[str.length];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = Integer.valueOf(str[i]);
        }
        int maxOccurrences = Integer.valueOf(sc.nextLine());
        sc.close();
        System.out.println(Arrays.toString(deleteNth(elements, maxOccurrences)));
    }

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        if (elements == null || elements.length == 0) {
            return new int[] {};
        }
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < elements.length; i++) {
            if (map.containsKey(elements[i])) {
                map.put(elements[i], map.get(elements[i]) + 1);
            }
            map.putIfAbsent(elements[i], 1);
            if (map.get(elements[i]) <= maxOccurrences) {
                result.add(elements[i]);
            }
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}