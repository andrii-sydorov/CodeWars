package kyu4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class StringsMix {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        sc.close();
        System.out.println(mix(s1, s2));
    }

    public static String mix(String s1, String s2) {

        Map<String, Integer> mapS1 = constructMap(s1);
        Map<String, Integer> mapS2 = constructMap(s1);

        List<Entry<String, Integer>> listS1 = new ArrayList<>(mapS1.entrySet());
        listS1.sort((x, y) -> x.getValue().compareTo(y.getValue()));

        List<Entry<String, Integer>> listS2 = new ArrayList<>(mapS2.entrySet());
        listS2.sort((x, y) -> x.getValue().compareTo(y.getValue()));

        int indexS1 = 0;
        int indexS2 = 0;

        String ans = "";
        while (indexS1 != listS1.size() && indexS2 != listS2.size()) {
            if (indexS1 < listS1.size() && indexS2 < listS2.size()) {
                if (listS1.get(indexS1).getValue() > listS2.get(indexS2).getValue()) {
                    ans += "1:" + makeString(listS1.get(indexS1));
                    indexS1++;
                } else if (listS1.get(indexS1).getValue() < listS2.get(indexS2).getValue()) {
                    ans += "2:" + makeString(listS2.get(indexS2));
                    indexS2++;
                } else {
                    ans += "=:" + makeString(listS1.get(indexS1));
                    indexS1++;
                    indexS2++;
                }
            } else if (indexS1 >= listS1.size()) {
                ans += listS2.get(indexS2);
                indexS2++;
            } else if (indexS2 >= listS2.size()) {
                ans += listS1.get(indexS1);
                indexS1++;
            }
            ans += "/";
        }
        return ans;
    }

    public static String makeString(Entry<String, Integer> entr) {
        String ans = "";
        for (int i = 0; i < entr.getValue(); i++) {
            ans += entr.getKey();
        }
        return ans;
    }

    public static Map<String, Integer> constructMap(String s) {
        Map<String, Integer> map = new HashMap<>();
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isAlphabetic(ch)) {
                String temp = Character.toString(s.charAt(i));
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            } else {
                continue;
            }
        }
        return map;
    }

}
