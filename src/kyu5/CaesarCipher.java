package kyu5;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class CaesarCipher {

    private static final List<String> lowerCase;
    private static final List<String> upperCase;

    static {
        lowerCase = new ArrayList<>();
        for (int i = 'a'; i <= 'z'; i++) {
            lowerCase.add(Character.toString(i));
        }
        upperCase = new ArrayList<>();
        for (int i = 'A'; i <= 'Z'; i++) {
            upperCase.add(Character.toString(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the phrase: ");
        String s = sc.nextLine();
        System.out.println("Enter the shift number: ");
        int shift = Integer.parseInt(sc.nextLine());
        sc.close();
        List<String> ls = encodeStr(s, shift);
        System.out.println(ls.toString());
        System.out.println(decode(ls));
    }

    public static List<String> encodeStr(String s, int shift) {
        StringBuilder sb = new StringBuilder();
        String temp = null;
        String firstPrefix = Character.toString(Character.toLowerCase(s.charAt(0)));
        sb.append(firstPrefix);
        String secondPrefix = lowerCase.get((lowerCase.indexOf(firstPrefix) + shift) % lowerCase.size());
        sb.append(secondPrefix);
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))) {
                if (lowerCase.contains(Character.toString(s.charAt(i)))) {
                    int index = (lowerCase.indexOf(Character.toString(s.charAt(i))) + shift) % lowerCase.size();
                    temp = lowerCase.get(index);
                } else {
                    int index = (upperCase.indexOf(Character.toString(s.charAt(i))) + shift) % upperCase.size();
                    temp = upperCase.get(index);
                }
            } else {
                temp = Character.toString(s.charAt(i));
            }
            sb.append(temp);
        }
        int sL = sb.length();
        int l = sL % 5 == 0 ? sL / 5 : (sL + 5 - sL % 5) / 5;
        List<String> ls = new ArrayList<>();
        for (int i = 0; sL != 0; i++) {
            ls.add(sb.substring(i * l, l + i * l > sb.length() ? sb.length() : l + i * l));
            sL -= ls.get(i).length();
        }
        return ls;
    }

    public static String decode(List<String> s) {
        String temp = "";
        for (String str : s) {
            temp += str;
        }
        String prefix = temp.substring(0, 2);
        String toEncode = temp.substring(2);
        int shift = prefix.charAt(1) > prefix.charAt(0) ? prefix.charAt(1) - prefix.charAt(0)
                : prefix.charAt(1) + lowerCase.size() - prefix.charAt(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < toEncode.length(); i++) {
            char tch = toEncode.charAt(i);
            if (Character.isAlphabetic(tch)) {
                int index = 0;
                if (Character.isLowerCase(tch)) {
                    index = lowerCase.indexOf(Character.toString(tch)) > shift
                            ? lowerCase.indexOf(Character.toString(tch)) - shift
                            : lowerCase.indexOf(Character.toString(tch)) - shift + 26;
                    sb.append(lowerCase.get((index) % lowerCase.size()));
                } else {
                    index = upperCase.indexOf(Character.toString(tch)) > shift
                            ? upperCase.indexOf(Character.toString(tch)) - shift
                            : upperCase.indexOf(Character.toString(tch)) - shift + 26;
                    sb.append(upperCase.get((index) % lowerCase.size()));
                }
            } else {
                sb.append(Character.toString(tch));
            }
        }
        return sb.toString();
    }

}
