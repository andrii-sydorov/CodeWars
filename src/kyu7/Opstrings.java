package kyu7;

import java.util.function.Function;

/**
 * This kata is the first of a sequence of four about "Squared Strings".
 * 
 * You are given a string of n lines, each substring being n characters long:
 * For example:
 * 
 * s = "abcd\nefgh\nijkl\nmnop"
 * 
 * We will study some transformations of this square of strings.
 * 
 * Vertical mirror: vert_mirror (or vertMirror or vert-mirror)
 * vert_mirror(s) => "dcba\nhgfe\nlkji\nponm"
 * Horizontal mirror: hor_mirror (or horMirror or hor-mirror)
 * hor_mirror(s) => "mnop\nijkl\nefgh\nabcd"
 * or printed:
 * 
 * vertical mirror     |horizontal mirror
 * abcd --> dcba       |abcd --> mnop
 * efgh hgfe           |efgh ijkl
 * ijkl lkji           |ijkl efgh
 * mnop ponm           |mnop abcd
 * Task:
 * Write these two functions
 * and
 * 
 * high-order function oper(fct, s) where
 * 
 * fct is the function of one variable f to apply to the string s (fct will be
 * one of vertMirror, horMirror)
 * 
 * Examples:
 * s = "abcd\nefgh\nijkl\nmnop"
 * oper(vert_mirror, s) => "dcba\nhgfe\nlkji\nponm"
 * oper(hor_mirror, s) => "mnop\nijkl\nefgh\nabcd"
 * Note:
 * The form of the parameter fct in oper changes according to the language. You
 * can see each form according to the language in "Sample Tests".
 * 
 * Bash Note:
 * The input strings are separated by , instead of \n. The output strings should
 * be separated by \r instead of \n. See "Sample Tests".
 */

public class Opstrings {
    public static void main(String[] args) {
        System.out.println(vertMirror("abcd\nefgh\nijkl\nmnop"));
        System.out.println();
        System.out.println(horMirror("abcd\nefgh\nijkl\nmnop"));
    }

    public static String vertMirror(String str) {
        String[] arr = str.split("\n");
        for (int i = 0; i < arr.length; i++) {
            char[] ch = arr[i].toCharArray();
            for (int j = 0; j < ch.length / 2; j++) {
                char t = ch[j];
                ch[j] = ch[ch.length - 1 - j];
                ch[ch.length - 1 - j] = t;
            }
            arr[i] = new String(ch);
        }
        return String.join("\n", arr);
    }

    public static String horMirror(String str) {
        String[] arr = str.split("\n");
        for (int i = 0; i < arr.length / 2; i++) {
            String s = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = s;
        }
        return String.join("\n", arr);
    }

    public static String oper(Function<String, String> operator, String s) {
        return operator.apply(s);
    }
}
