package kyu7;

import java.util.Scanner;

/**
 * Task
 * Using n as a parameter in the function pattern, where n>0, complete the codes
 * to get the pattern (take the help of examples):
 * 
 * Note: There is no newline in the end (after the pattern ends)
 * 
 * Examples
 * pattern(3) should return "1\n1*2\n1**3", e.g. the following:
 * 
 * 1
 * 1*2
 * 1**3
 * pattern(10): should return the following:
 * 
 * 1
 * 1*2
 * 1**3
 * 1***4
 * 1****5
 * 1*****6
 * 1******7
 * 1*******8
 * 1********9
 * 1*********10
 */

public class NumberStarrLadder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        sc.close();
        System.out.println(pattern(n));
    }

    public static String pattern(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (n == 1) {
                sb.append(i);
                continue;
            } else if (i < n) {
                sb.append(func(i) + "\n");
            } else {
                sb.append(func(i));
            }
        }
        return sb.toString();
    }

    public static String func(int n) {
        int start = 1;
        int stop = n;
        if (n == 1) {
            return String.valueOf(n);
        }
        int numberOfStar = n - 1;
        StringBuilder sb = new StringBuilder();
        sb.append(start);
        for (int i = 0; i < numberOfStar; i++) {
            sb.append("*");
        }
        sb.append(stop);
        return sb.toString();
    }
}
