package kyu6;

import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;

/**
 * Your job is to create a calculator which evaluates expressions in Reverse
 * Polish notation.
 * 
 * For example expression 5 1 2 + 4 * + 3 - (which is equivalent to 5 + ((1 + 2)
 * * 4) - 3 in normal notation) should evaluate to 14.
 * 
 * For your convenience, the input is formatted such that a space is provided
 * between every token.
 * 
 * Empty expression should evaluate to 0.
 * 
 * Valid operations are +, -, *, /.
 * 
 * You may assume that there won't be exceptional situations (like stack
 * underflow or division by zero).
 */

public class Calc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expr = sc.nextLine();
        sc.close();
        System.out.println(evaluate(expr));
        double d = 3;
        System.out.println(d);
    }

    public static double evaluate(String expr) {
        if (expr.isEmpty()) {
            return 0;
        }
        List<Double> ls = new LinkedList<>();
        String[] str = expr.split("\\s+");
        for (int i = 0; i < str.length; i++) {
            switch (str[i]) {
                case "+":
                    double add = ls.get(ls.size() - 2) + ls.get(ls.size() - 1);
                    ls.remove(ls.size() - 1);
                    ls.remove(ls.size() - 1);
                    ls.add(add);
                    break;
                case "-":
                    double sub = ls.get(ls.size() - 2) - ls.get(ls.size() - 1);
                    ls.remove(ls.size() - 1);
                    ls.remove(ls.size() - 1);
                    ls.add(sub);
                    break;
                case "*":
                    double mul = ls.get(ls.size() - 2) * ls.get(ls.size() - 1);
                    ls.remove(ls.size() - 1);
                    ls.remove(ls.size() - 1);
                    ls.add(mul);
                    break;
                case "/":
                    double div = ls.get(ls.size() - 2) / ls.get(ls.size() - 1);
                    ls.remove(ls.size() - 1);
                    ls.remove(ls.size() - 1);
                    ls.add(div);
                    break;
                default:
                    ls.add(Double.valueOf(str[i]));
                    break;
            }
        }
        return ls.get(0);
    }
}
