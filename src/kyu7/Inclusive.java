package kyu7;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Input:
 * 
 * a string strng
 * an array of strings arr
 * Output of function contain_all_rots(strng, arr) (or containAllRots or
 * contain-all-rots):
 * 
 * a boolean true if all rotations of strng are included in arr
 * false otherwise
 * Examples:
 * contain_all_rots(
 * "bsjq", ["bsjq", "qbsj", "sjqb", "twZNsslC", "jqbs"]) -> true
 * 
 * contain_all_rots(
 * "Ajylvpy", ["Ajylvpy", "ylvpyAj", "jylvpyA", "lvpyAjy", "pyAjylv", "vpyAjyl",
 * "ipywee"]) -> false)
 * Note:
 * Though not correct in a mathematical sense
 * 
 * we will consider that there are no rotations of strng == ""
 * and for any array arr: contain_all_rots("", arr) --> true
 * Ref: https://en.wikipedia.org/wiki/String_(computer_science)#Rotations
 */

public class Inclusive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strng = sc.nextLine();
        List<String> arr = Arrays.stream(sc.nextLine().split("\\s+")).map(String::valueOf).collect(Collectors.toList());
        // System.out.println(ls);
        System.out.println(rotateString(strng));
        System.out.println(containAllRots(strng, arr));
        sc.close();
    }

    public static boolean containAllRots(String strng, List<String> arr) {
        if (strng == null || strng.isEmpty()) {
            return true;
        }
        List<String> ls = rotateString(strng);
        for (String s : ls) {
            if (arr.indexOf(s) < 0) {
                return false;
            }
        }
        return true;
    }

    public static List<String> rotateString(String s) {
        List<String> ls = new ArrayList<>();
        int numberOfTurns = s.length();
        char[] input = s.toCharArray();
        for (int i = 0; i < numberOfTurns; i++) {
            char[] ch = new char[numberOfTurns];
            for (int j = 0; j < numberOfTurns; j++) {
                ch[j] = input[(j + i) % numberOfTurns];
            }
            ls.add(new String(ch));
        }
        return ls;
    }

    public static Boolean containAllRots2(String strng, List<String> arr) {
        for(int i=0;i<strng.length();i++)
          if(!arr.contains(strng.substring(i,strng.length())+strng.substring(0,i)))
            return false;
        return true;
    }
}
