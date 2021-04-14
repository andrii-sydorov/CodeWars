package kyu8;

import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class sortString {

    public static void main(String[] args) {
        System.out.println("Enter your's String array:");
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        sc.close();
        System.out.println(twoSort(s));
    }

    public static String twoSort(String[] s) {
        List<String> ls = new ArrayList<>(Arrays.asList(s));
        Collections.sort(ls);
        String temp = ls.get(0);
        char[] ch = temp.toCharArray();
        int numberStart = 3;
        String ans = "";
        for(int i = 0; i < ch.length; i++) {
            ans += Character.toString(ch[i]);
            for(int j = 0; j < numberStart; j++) {
                ans += "*";
            }
        }
        return ans;
    }
}
