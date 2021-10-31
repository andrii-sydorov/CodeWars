package kyu5;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class CaesarCipher {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter the phrase: ");
        String s = sc.nextLine();
        System.out.println("Enter the shift number: ");
        int shift = Integer.parseInt(sc.nextLine());
        sc.close();
        List<String> ls = encodeStr(s, shift);
        System.out.println(ls.toString());
    }

    public static List<String> encodeStr(String s, int shift) {
        List<String> lowerCase = new ArrayList<>();
        for (int i = 'a'; i <= 'z'; i++) {
            lowerCase.add(Character.toString(i));
        }
        List<String> camelCase = new ArrayList<>();
        for(int i = 'A'; i <= 'Z'; i++) {
            camelCase.add(Character.toString(i));
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))) {
                if (lowerCase.contains(Character.toString(s.charAt(i)))) {
                    int index = (lowerCase.indexOf(Character.toString(s.charAt(i))) + shift) % lowerCase.size();
                    ans.add(lowerCase.get(index));
                } else {
                    int index = (camelCase.indexOf(Character.toString(s.charAt(i))) + shift) % camelCase.size();
                    ans.add(camelCase.get(index));
                }
            } else {
                ans.add(Character.toString(s.charAt(i)));
            }
        }
        ans.add(0, Character.toString(Character.toLowerCase(s.charAt(0))));
        ans.add(1, lowerCase.get((lowerCase.indexOf(ans.get(0)) + shift) % lowerCase.size()));
        return ans;
    }

    public static String[] toDecodeData(String s) {
        String[] ans = new String[5];
        int l = s.length() % 5 == 0 ? s.length() / 5 : s.length() / 4;
        int index = 0;
        for (int i = 0; i < ans.length; i++) {
            if ( i == ans.length - 1) {
                ans[i] = s.substring(index);
            }
            ans[i] = s.substring(i * l, l * (i +1));
            index += ans[i].length();
        }
        return ans;
    }
    
}
