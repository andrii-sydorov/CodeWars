package kyu8;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Each number should be formatted that it is rounded to two decimal places. You
 * don't need to check whether the input is a valid number because only valid
 * numbers are used in the tests.
 * 
 * Example:
 * 5.5589 is rounded 5.56
 * 3.3424 is rounded 3.34
 */

public class FormattingDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double number = Double.valueOf(sc.nextLine());
        sc.close();
        System.out.println(TwoDecimalPlaces(number));
    }

    public static double TwoDecimalPlaces(double number) {
        //Locale.setDefault(Locale.UK);
        //return Double.parseDouble(String.format("%.2f", number));

        BigDecimal bd = new BigDecimal(Double.toString(number));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
