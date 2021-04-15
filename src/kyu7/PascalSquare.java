package kyu7;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * In the drawing below we have a part of the Pascal's triangle, horizontal lines are numbered from zero (top).

We want to calculate the sum of the squares of the binomial coefficients on a given horizontal line with a function called easyline (or easyLine or easy-line).

Can you write a program which calculate easyline(n) where n is the horizontal line number?

The function will take n (with: n>= 0) as parameter and will return the sum of the squares of the binomial coefficients on line n.
Examples:

easyline(0) => 1
easyline(1) => 2
easyline(4) => 70
easyline(50) => 100891344545564193334812497256

 */

public class PascalSquare {

    public static void main(String[] args) {
        System.out.println(easyLine(19));
    }

    public static BigInteger easyLine(int n) {
        // your code
        BigInteger[] arInt = new BigInteger[n + 1];
        for(int m = 0; m < arInt.length; m++) {
            arInt[m] = factorial(n).divide(factorial(m)).divide(factorial(n - m));
        }
        BigInteger bi = BigInteger.valueOf(0);
        for(int i = 0; i < arInt.length; i++) {
            bi = bi.add(arInt[i].pow(2));
        }
        System.out.println(Arrays.toString(arInt));
        return bi;
    }

    public static BigInteger factorial(int n) {
        if(n == 0 || n == 1) {
            return BigInteger.valueOf(1);
        }
        BigInteger ans = BigInteger.valueOf(1);
        for(int i = 2; i <= n; i++) {
            ans = ans.multiply(BigInteger.valueOf(i));
        }
        return ans;
    }
    
}
