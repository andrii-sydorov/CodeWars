package kyu8;

import java.util.Scanner;

/**
 * If you can't sleep, just count sheep!!
 * Task:
 * 
 * Given a non-negative integer, 3 for example, return a string with a murmur:
 * "1 sheep...2 sheep...3 sheep...". Input will always be valid, i.e. no
 * negative integers.
 * 
 */

public class CountSheep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.valueOf(sc.nextLine());
        sc.close();
        System.out.println(countingSheep(num));
    }

    private static String countingSheep(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= num; i++) {
            sb.append(i + " sheep...");
        }
        return sb.toString();
    }
}
