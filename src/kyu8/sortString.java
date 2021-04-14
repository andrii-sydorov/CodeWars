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
     //   System.out.println(twoSortWithOutCollections(s));
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
        StringBuilder sb = new StringBuilder();
        String ans = null;
        int[] stringLength = new int[s.length];
        int maxLength = 0;
        for(int i = 0; i < stringLength.length; i++) {
            stringLength[i] = s[i].length();
            if(maxLength >= s[i].length()) {
                maxLength = s[i].length();
                if(maxLength == s[i].length()) {
                    sb.append(s[i]).append(" ");
                } else {
                    sb.setLength(0);
                }
            }
        }
        String[] stringWithMaxLength = null;
        if(sb.toString().trim().contains(" ")) {
            stringWithMaxLength = sb.toString().split(" ");
        } else {
            stringWithMaxLength = new String[1];
            stringWithMaxLength[0] = sb.toString();
        }

        
        for(int j = 0; j < stringWithMaxLength[0].length(); j++) {
            char[] letter = new char[stringWithMaxLength.length];
            char max = stringWithMaxLength[0].charAt(j);
            for(int i = 0; i < stringWithMaxLength.length; i++) {
                letter[j] = stringWithMaxLength[i].charAt(j);
                if(max <= letter[j]) {
                    max = letter[j];
                }
            } 
        }
        
        return ans;
    }
}
