package kyu8;

import java.util.Scanner;

/**
 * Write function bmi that calculates body mass index (bmi = weight / height2).
 * 
 * if bmi <= 18.5 return "Underweight"
 * 
 * if bmi <= 25.0 return "Normal"
 * 
 * if bmi <= 30.0 return "Overweight"
 * 
 * if bmi > 30 return "Obese"
 */

public class CalaculateBMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double weight = sc.nextDouble();
        double height = sc.nextDouble();
        sc.close();
        System.out.println(bmi(weight, height));
    }

    private static String bmi(double weight, double height) {
        double expr = weight / (height * height);
        if (expr <= 18.5) {
            return "Underweight";
        } else if (expr <= 25.0) {
            return "Normal";
        } else if (expr <= 30.0) {
            return "Overweight";
        }
        return "Obese";
    }
}
