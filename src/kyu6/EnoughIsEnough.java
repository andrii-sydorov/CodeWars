package kyu6;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

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