package kyu7;

import java.util.Scanner;

/**
 * Task
 * Remove all exclamation marks from the end of words. Words are separated by a
 * single space. There are no exclamation marks within a word.
 * 
 * Examples
 * remove("Hi!") === "Hi"
 * remove("Hi!!!") === "Hi"
 * remove("!Hi") === "!Hi"
 * remove("!Hi!") === "!Hi"
 * remove("Hi! Hi!") === "Hi Hi"
 * remove("!!!Hi !!hi!!! !hi") === "!!!Hi !!hi !hi"
 */

public class ExclamationMark {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        System.out.println(removeBang(str));

    }

    public static String removeBang(String str) {
        String[] arr = str.split("\\s+");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].endsWith("!")) {
                arr[i] = deleteMarks(arr[i]);
            }
        }
        return String.join(" ", arr);
    }

    public static String deleteMarks(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '!') {
                sb.deleteCharAt(i);
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
