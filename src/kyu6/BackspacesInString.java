package kyu6;

import java.util.Scanner;

/**
 * Assume "#" is like a backspace in string. This means that string "a#bc#d"
 * actually is "bd"
 * 
 * Your task is to process a string with "#" symbols. Examples
 * 
 * "abc#d##c" ==> "ac" 
 * "abc##d######" ==> "" 
 * "#######" ==> "" 
 * "" ==> ""
 * 
 * 
 */
public class BackspacesInString {

    public static void main(String[] ans) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        System.out.println(backSpaceInString(s));
    }

    public static String backSpaceInString(String s) {
        char[] tempCharArray = s.toCharArray();
        String ans = "";
        for (int i = 0; i < tempCharArray.length; i++) {
            if (tempCharArray[i] != '#') {
                ans += Character.toString(tempCharArray[i]);
            } else {
                if (ans.isEmpty()) {
                    continue;
                } else {
                    ans = ans.substring(0, ans.length() - 1);
                }
            }
        }
        return ans;
    }

}
