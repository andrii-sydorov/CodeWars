package kyu6;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Collections;

/**
 * Substitute two equal letters by the next letter of the alphabet (two letters
 * convert to one):
 * 
 * "aa" => "b", "bb" => "c", .. "zz" => "a".
 * The equal letters do not have to be adjacent.
 * Repeat this operation until there are no possible substitutions left.
 * Return a string.
 * 
 * Example:
 * 
 * let str = "zzzab"
 * str = "azab"
 * str = "bzb"
 * str = "cz"
 * return "cz"
 * Notes
 * The order of letters in the result is not important.
 * The letters "zz" transform into "a".
 * There will only be lowercase letters.
 * If you like this kata, check out another one: Last Survivor Ep.3
 */

public class LastSurvivors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        System.out.println(lastSurvivors(str));
    }

    public static String lastSurvivors(String str) {
        List<String> ls = makeList(str);
        boolean isDone = false;
        while (!isDone) {
            List<String> copyOf = new ArrayList<>(ls);
            for (int i = 0; i < ls.size() - 1; i++) {
                if (ls.get(i).equals(ls.get(i + 1))) {
                    ls.remove(ls.get(i + 1));
                    char[] ch = ls.get(i).toCharArray();
                    if (ch[0] == 'z') {
                        ch[0] = 'a';
                    } else {
                        ch[0] = ++ch[0];
                    }
                    ls.set(i, Character.toString(ch[0]));
                    break;
                }
            }
            Collections.sort(ls);
            if (Objects.equals(ls, copyOf)) {
                isDone = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : ls) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static List<String> makeList(String str) {
        List<String> ls = new ArrayList<>();
        for (String s : str.split("")) {
            ls.add(s);
        }
        return ls;
    }
}
