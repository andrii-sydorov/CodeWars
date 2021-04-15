package kyu8;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * You will be given a vector of strings. You must sort it alphabetically
 * (case-sensitive, and based on the ASCII values of the chars) and then return
 * the first value.
 * 
 * The returned value must be a string, and have "***" between each of its
 * letters.
 * 
 * You should not remove or add elements from/to the array.
 * 
 */

public class sortString {

    public static void main(String[] args) {
        String[] s = {"bitcoin", "take", "over", "the", "world", "maybe", "who", "knows", "perhaps"};
        System.out.println(twoSort(s));
        System.out.println(twoSortWithOutCollections(s));
    }

    public static String twoSort(String[] s) {
        List<String> ls = new ArrayList<>(Arrays.asList(s));
        Collections.sort(ls);
        String temp = ls.get(0);
        char[] ch = temp.toCharArray();
        String ans = String.join("***", ls.get(0).split(""));
        return ans;
    }

    public static String twoSortWithOutCollections(String[] s) {
        String ans = s[0];
        for(int i = 1; i < s.length; i++) {
            String s1 = s[i];
            for(int j = 0; j < Math.min(s1.length(), ans.length()); j++) {
                if(s1.charAt(j) < ans.charAt(j)) {
                    ans = s1;
                    break;
            } else if(s1.charAt(j) > ans.charAt(j)){
                break;
            } else {
                continue;
            }
        }
        }
        return String.join("***", ans.split(""));
    }
}
