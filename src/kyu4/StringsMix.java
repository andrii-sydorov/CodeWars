package kyu4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class StringsMix {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        Scanner sc = new Scanner(System.in);
//        String s1 = sc.nextLine();
//        String s2 = sc.nextLine();
//        sc.close();
        System.out.println(mix("looping is fun but dangerous", "less dangerous than coding"));
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

        System.exit(0);

        Comparator<Entry<String, Integer>> cmp1 = (x, y) -> y.getValue().compareTo(x.getValue());
        Comparator<Entry<String, Integer>> cmp2 = (x, y) -> x.getKey().compareTo(y.getKey());

        listS1.sort(cmp1.thenComparing(cmp2));
        listS2.sort(cmp1.thenComparing(cmp2));

        List<String> ls = new ArrayList<>();

        int indexS1 = 0;
        int indexS2 = 0;

        while (indexS1 != listS1.size() || indexS2 != listS2.size()) {

            if (indexS1 < listS1.size() && indexS2 < listS2.size()) {
                Entry<String, Integer> entr1 = listS1.get(indexS1);
                Entry<String, Integer> entr2 = listS2.get(indexS2);
                if (entr1.getKey().equals(entr2.getKey())) {
                    if (entr1.getValue() > entr2.getValue()) {
                        ls.add("1:" + makeString(entr1));
                    } else if (entr2.getValue() > entr1.getValue()) {
                        ls.add("2:" + makeString(entr2));
                    } else {
                        ls.add("=:" + makeString(entr2));
                    }
                    indexS1++;
                    indexS2++;
                } else if (entr1.getValue() > entr2.getValue()) {
                    ls.add("1:" + makeString(entr1));
                    indexS1++;
                } else if (entr2.getValue() > entr1.getValue()) {
                    ls.add("2:" + makeString(entr2));
                    indexS2++;
                } else if (entr1.getKey().compareTo(entr2.getKey()) > 0) {
                    ls.add("2:" + makeString(entr2));
                    indexS2++;
                } else {
                    ls.add("1:" + makeString(entr1));
                    indexS1++;
                }
            } else if (indexS2 >= listS2.size()) {
                ls.add("1:" + makeString(listS1.get(indexS1)));
                indexS1++;
            } else {
                ls.add("2:" + makeString(listS2.get(indexS2)));
                indexS2++;
            }
        }

        Comparator<String> comparator = (x, y) -> {
            if (x.length() > y.length()) {
                return -1;
            } else if (x.length() < y.length()) {
                return 1;
            }
            if ((x.startsWith("1") || (x.startsWith("2"))) && y.startsWith("=")) {
                return -1;
            } else if (x.startsWith("=") && (y.startsWith("1") || y.startsWith("2"))) {
                return 1;
            } else if (x.startsWith("1") && y.startsWith("2")) {
                return -1;
            } else if (x.startsWith("2") && y.startsWith("1")) {
                return 1;
            }
            return 0;
        };

        ls.sort(comparator);

        return String.join("/", ls.toArray(new String[0]));
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
