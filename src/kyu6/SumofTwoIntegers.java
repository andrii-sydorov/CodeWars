package kyu6;

import java.util.Scanner;

/**
 * Task
 * Given Two integers a , b , find The sum of them , BUT You are not allowed to
 * use the operators + and -
 * 
 * Notes
 * The numbers (a,b) may be positive , negative values or zeros .
 * 
 * Returning value will be an integer .
 * 
 * Java: the following methods are prohibited: addExact, average, collect,
 * decrement, increment, nextAfter, nextDown, nextUp, reduce, subtractExact,
 * sum, summing . The following classes are prohibited: BigDecimal and
 * BigInteger .
 * Input >> Output Examples
 * 1- Add (5,19) ==> return (24)
 * 
 * 2- Add (-27,18) ==> return (-9)
 * 
 * 3- Add (-14,-16) ==> return (-30)
 * Playing with Numbers Series
 * Playing With Lists/Arrays Series
 * For More Enjoyable Katas
 * ALL translations are welcomed
 * Enjoy Learning !!
 * Zizou
 * 
 */

public class SumofTwoIntegers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = Integer.valueOf(sc.nextLine());
        int y = Integer.valueOf(sc.nextLine());
        sc.close();
        System.out.println(add(x, y));
    }

    public static int add(int x, int y) {
        while (y != 0) {
            int temp = x & y;
            x = x ^ y;
            y = temp << 1;
        }
        return x;
    }
}
