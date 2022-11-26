package kyu7;

import java.util.Scanner;

public class FilterNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();
        System.out.println(filterString(value));
        sc.close();
    }

    private static long filterString(String value) {
        return Long.valueOf(value.replaceAll("\\D",""));
    }
}
