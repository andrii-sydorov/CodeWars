package kyu6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Write Number in Expanded Form
 * You will be given a number and you will need to return it as a string in
 * Expanded Form. For example:
 * 
 * Kata.expandedForm(12); # Should return "10 + 2"
 * Kata.expandedForm(42); # Should return "40 + 2"
 * Kata.expandedForm(70304); # Should return "70000 + 300 + 4"
 * NOTE: All numbers will be whole numbers greater than 0.
 * 
 * If you liked this kata, check out part 2!!
 * 
 * @author SMD_ASY
 *
 */

public class ExtendedForm {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int num = Integer.valueOf(sc.nextLine());
        System.out.println(expandedForm(num));
        sc.close();
    }

    public static String expandedForm(int num) {
        List<String> ls = new ArrayList<>();
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            if (Character.getNumericValue(s.charAt(i)) == 0) {
                continue;
            }
            ls.add(String.valueOf(Character.getNumericValue(s.charAt(i)) * (int) Math.pow(10, s.length() - 1 - i)));
        }
        String ans = "";
        for (int i = 0; i < ls.size(); i++) {
            ans += ls.get(i);
            if (i == ls.size() - 1) {
                continue;
            }
            ans += " + ";
        }
        return ans;
    }

}
