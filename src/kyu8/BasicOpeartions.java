package kyu8;

import java.util.*;

/**
 * Your task is to create a function that does four basic mathematical operations.

The function should take three arguments - operation(string/char), value1(number), value2(number).
The function should return result of numbers after applying the chosen operation.

Examples(Operator, value1, value2) --> output
('+', 4, 7) --> 11
('-', 15, 18) --> -3
('*', 5, 5) --> 25
('/', 49, 7) --> 7
 */

public class BasicOpeartions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] command = sc.nextLine().split("\\s+");
        String op = command[0];
        int v1 = Integer.valueOf(command[1]);
        int v2 = Integer.valueOf(command[2]);
        sc.close();
        System.out.println(basicMath(op, v1, v2));
    }

    private static Integer basicMath(String op, int v1, int v2) {
        switch (op) {
            case "+":
                return Integer.valueOf(v1 + v2);
            case "-":
                return Integer.valueOf(v1 - v2);
            case "*":
                return Integer.valueOf(v1 * v2);
            case "/":
                return Integer.valueOf(v1 / v2);
            default:
                return null;
        }
    }
}
