package kyu6;

import java.util.Scanner;

/**
 * Story
 * The Pied Piper has been enlisted to play his magical tune and coax all the
 * rats out of town.
 * 
 * But some of the rats are deaf and are going the wrong way!
 * 
 * Kata Task
 * How many deaf rats are there?
 * 
 * Legend
 * P = The Pied Piper
 * O~ = Rat going left
 * ~O = Rat going right
 * Example
 * ex1 ~O~O~O~O P has 0 deaf rats
 * 
 * ex2 P O~ O~ ~O O~ has 1 deaf rat
 * 
 * ex3 ~O~O~O~OP~O~OO~ has 2 deaf rats
 * 
 * 
 */

public class DeafRats {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String town = sc.nextLine();
        sc.close();
        System.out.println(countDeafRats(town));
    }

    public static int countDeafRats(String town) {
        town = town.replaceAll(" ", "");
        int res = 0;
        int left = 0;
        int right = 0;
        StringBuilder sb = new StringBuilder();
        boolean wasFound = false;
        for (int i = 0; i < town.length(); i++) {
            char ch = town.charAt(i);
            sb.append(ch);
            String s = sb.toString();
            switch (s) {
                case "~O":
                    right++;
                    sb.setLength(0);
                    break;
                case "O~":
                    left++;
                    sb.setLength(0);
                    break;
                case "P":
                    wasFound = true;
                    sb.setLength(0);
                    break;
            }
            if (wasFound) {
                res = left;
                right = 0;
                wasFound = false;
            }
        }
        res += right;
        return res;
    }
}
