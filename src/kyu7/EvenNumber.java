package kyu7;

import java.util.Scanner;

public class EvenNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println(isVeryEvenNumber(number));
        sc.close();
    }

    private static boolean isVeryEvenNumber(int number) {
        if (number <= 9) {
            return number % 2 == 0;
        }
        int sum = 0;
        while(number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return isVeryEvenNumber(sum);
    }
}
