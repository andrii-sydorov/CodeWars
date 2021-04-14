package kyu8;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class sortString {

    public static void main(String[] args) {
        System.out.println("Enter your's String array:");
        String[] s = {"bitcoin", "take", "over", "the", "world", "maybe", "who", "knows", "perhaps"};
        System.out.println(twoSort(s));
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
        String ans;
        int[] stringLength = new int[s.length];
        int maxLength = 0;
        for(int i = 0; i < stringLength.length; i++) {
            stringLength[i] = s[i].length();
            if(maxLength >= s[i].length()) {
                maxLength = s[i].length();
            }
        }
        
        for(int i = 0; i < stringLength.length; i++) {

        }
        return ans;
    }
}
