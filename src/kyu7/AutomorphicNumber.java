package kyu7;

import java.util.Scanner;

/**
 * Definition
 * A number is called Automorphic number if and only if its square ends in the
 * same digits as the number itself.
 * 
 * Task
 * Given a number determine if it Automorphic or not .
 * 
 * Warm-up (Highly recommended)
 * Playing With Numbers Series
 * Notes
 * The number passed to the function is positive
 * Input >> Output Examples
 * autoMorphic (25) -->> return "Automorphic"
 * Explanation:
 * 25 squared is 625 , Ends with the same number's digits which are 25 .
 * 
 * autoMorphic (13) -->> return "Not!!"
 * Explanation:
 * 13 squared is 169 , Not ending with the same number's digits which are 69 .
 * 
 * autoMorphic (76) -->> return "Automorphic"
 * Explanation:
 * 76 squared is 5776 , Ends with the same number's digits which are 76 .
 * 
 * autoMorphic (225) -->> return "Not!!"
 * Explanation:
 * 225 squared is 50625 , Not ending with the same number's digits which are 225
 * .
 * 
 * autoMorphic (625) -->> return "Automorphic"
 * Explanation:
 * 625 squared is 390625 , Ends with the same number's digits which are 625 .
 * 
 * autoMorphic (1) -->> return "Automorphic"
 * Explanation:
 * 1 squared is 1 , Ends with the same number's digits which are 1 .
 * 
 * autoMorphic (6) -->> return "Automorphic"
 * Explanation:
 * 6 squared is 36 , Ends with the same number's digits which are 6
 * 
 * Playing with Numbers Series
 * Playing With Lists/Arrays Series
 * For More Enjoyable Katas
 * ALL translations are welcomed
 * Enjoy Learning !!
 * Zizou
 * 
 */

public class AutomorphicNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = Integer.valueOf(sc.nextLine());
        sc.close();
        System.out.println(autoMorphic(number));
    }

    public static String autoMorphic(int number) {
        int square = (int) Math.pow(number, 2);
        while (number > 0) {
            int first = number % 10;
            number /= 10;
            int second = square % 10;
            square /= 10;
            if (first != second) {
                return "Not!!";
            }
        }
        return "Automorphic";
    }
}
