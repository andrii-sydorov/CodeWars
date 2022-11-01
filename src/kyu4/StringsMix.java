package kyu4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * Given two strings s1 and s2, we want to visualize how different the two
 * strings are. We will only take into account the lowercase letters (a to z).
 * First let us count the frequency of each lowercase letters in s1 and s2.
 * 
 * s1 = "A aaaa bb c"
 * 
 * s2 = "& aaa bbb c d"
 * 
 * s1 has 4 'a', 2 'b', 1 'c'
 * 
 * s2 has 3 'a', 3 'b', 1 'c', 1 'd'
 * 
 * So the maximum for 'a' in s1 and s2 is 4 from s1; the maximum for 'b' is 3
 * from s2. In the following we will not consider letters when the maximum of
 * their occurrences is less than or equal to 1.
 * 
 * We can resume the differences between s1 and s2 in the following string:
 * "1:aaaa/2:bbb" where 1 in 1:aaaa stands for string s1 and aaaa because the
 * maximum for a is 4. In the same manner 2:bbb stands for string s2 and bbb
 * because the maximum for b is 3.
 * 
 * The task is to produce a string in which each lowercase letters of s1 or s2
 * appears as many times as its maximum if this maximum is strictly greater than
 * 1; these letters will be prefixed by the number of the string where they
 * appear with their maximum value and :. If the maximum is in s1 as well as in
 * s2 the prefix is =:.
 * 
 * In the result, substrings (a substring is for example 2:nnnnn or 1:hhh; it
 * contains the prefix) will be in decreasing order of their length and when
 * they have the same length sorted in ascending lexicographic order (letters
 * and digits - more precisely sorted by codepoint); the different groups will
 * be separated by '/'. See examples and "Example Tests".
 * 
 * Hopefully other examples can make this clearer.
 * 
 * s1 = "my&friend&Paul has heavy hats! &"
 * s2 = "my friend John has many many friends &"
 * mix(s1, s2) -->
 * "2:nnnnn/1:aaaa/1:hhh/2:mmm/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss"
 * 
 * s1 = "mmmmm m nnnnn y&friend&Paul has heavy hats! &"
 * s2 = "my frie n d Joh n has ma n y ma n y frie n ds n&"
 * mix(s1, s2) -->
 * "1:mmmmmm/=:nnnnnn/1:aaaa/1:hhh/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss"
 * 
 * s1="Are the kids at home? aaaaa fffff"
 * s2="Yes they are here! aaaaa fffff"
 * mix(s1, s2) --> "=:aaaaaa/2:eeeee/=:fffff/1:tt/2:rr/=:hh"
 * Note for Swift, R, PowerShell
 * The prefix =: is replaced by E:
 * 
 * s1 = "mmmmm m nnnnn y&friend&Paul has heavy hats! &"
 * s2 = "my frie n d Joh n has ma n y ma n y frie n ds n&"
 * mix(s1, s2) -->
 * "1:mmmmmm/E:nnnnnn/1:aaaa/1:hhh/2:yyy/2:dd/2:ff/2:ii/2:rr/E:ee/E:ss"
 * 
 * @author SMD_ASY
 *
 */

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
        Map<String, Integer> mapS2 = constructMap(s2);

        List<Entry<String, Integer>> listS1 = new ArrayList<>(mapS1.entrySet());
        List<Entry<String, Integer>> listS2 = new ArrayList<>(mapS2.entrySet());

        deleteTheOnes(listS1);
        deleteTheOnes(listS2);

        Map<Entry<String, Integer>, String> map = new HashMap<>();

        for (Entry<String, Integer> entr : listS1) {
            map.put(entr, "1");
        }

        for (Entry<String, Integer> entr : listS2) {

            Iterator<Entry<String, Integer>> it = map.keySet().iterator();
            boolean contain = false;
            while (it.hasNext()) {
                Entry<String, Integer> ent = it.next();
                if (entr.getKey().equals(ent.getKey())) {
                    contain = true;
                    if (entr.getValue() > ent.getValue()) {
                        it.remove();
                        map.put(entr, "2");
                    } else if (entr.getValue() == ent.getValue()) {
                        it.remove();
                        map.put(entr, "=");
                    }
                    break;
                }
            }

            if (!contain) {
                map.put(entr, "2");
            }

        }

        List<Entry<Entry<String, Integer>, String>> list = new ArrayList<>(map.entrySet());

        Comparator<Entry<Entry<String, Integer>, String>> cmpRepeated = (x, y) -> {
            if (x.getKey().getValue() > y.getKey().getValue()) {
                return -1;
            } else if (x.getKey().getValue() < y.getKey().getValue()) {
                return 1;
            }
            return 0;
        };

        Comparator<Entry<Entry<String, Integer>, String>> cmpListNumber = (x, y) -> {
            if ((x.getValue().equals("1") && y.getValue().equals("2"))
                    || (x.getValue().equals("1") && y.getValue().equals("=")
                            || (x.getValue().equals("2") && y.getValue().equals("=")))) {
                return -1;
            } else if ((x.getValue().equals("2") && y.getValue().equals("1"))
                    || (x.getValue().equals("=") && y.getValue().equals("1"))
                    || (x.getValue().equals("=") && y.getValue().equals("2"))) {
                return 1;
            }

            return 0;
        };

        Comparator<Entry<Entry<String, Integer>, String>> cmpAlphabetical = (x, y) -> {
            if (x.getKey().getKey().compareTo(y.getKey().getKey()) > 0) {
                return 1;
            }
            return -1;
        };

        list.sort(cmpRepeated.thenComparing(cmpListNumber).thenComparing(cmpAlphabetical));

        List<String> myList = new ArrayList<>();
        for (Entry<Entry<String, Integer>, String> entr : list) {
            myList.add(entr.getValue() + ":" + makeString(entr.getKey()));
        }

        return String.join("/", myList.toArray(new String[0]));
    }

    public static void deleteTheOnes(List<Entry<String, Integer>> list) {
        Iterator<Entry<String, Integer>> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getValue() == 1) {
                it.remove();
            }
        }
    }

    public static String makeString(Entry<String, Integer> entr) {
        String ans = "";
        for (int i = 0; i < entr.getValue(); i++) {
            ans += entr.getKey();
        }
        return ans;
    }

    public static Map<String, Integer> constructMap(String s) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isAlphabetic(ch) && Character.isLowerCase(ch)) {
                String temp = Character.toString(s.charAt(i));
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            } else {
                continue;
            }
        }
        return map;
    }

}
