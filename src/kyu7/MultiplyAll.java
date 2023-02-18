package kyu7;

import java.util.Scanner;
import java.util.Arrays;

public class MultiplyAll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer :: valueOf).toArray();
        sc.close();
        System.out.println(Arrays.toString(multiplyAll(array)));
    }

    public static int[] multiplyAll(int[] array) {
        return Arrays.stream(array).map(x -> x * 2).toArray();
    }
}
