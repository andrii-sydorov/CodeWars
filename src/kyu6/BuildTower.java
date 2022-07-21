package kyu6;

import java.util.Scanner;

/**
 * Build Tower
 * Build a pyramid-shaped tower given a positive integer number of floors. A
 * tower block is represented with "*" character.
 * 
 * For example, a tower with 3 floors looks like this:
 * 
 * [
 * "  *  ",
 * " *** ",
 * "*****"
 * ]
 * And a tower with 6 floors looks like this:
 * 
 * [
 * "     *     ",
 * "    ***    ",
 * "   *****   ",
 * "  *******  ",
 * " ********* ",
 * "***********"
 * ]
 */

public class BuildTower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int floors = Integer.parseInt(sc.nextLine());
        sc.close();
        print(towerBuilder(floors));
    }

    private static String[] towerBuilder(int floors) {
        if (floors == 0) {
            return new String[] {};
        }
        int[] stars = new int[floors];
        String[] ans = new String[floors];
        int a0 = 1;
        int d = 2;
        for (int n = 1; n <= floors; n++) {
            int starsNumber = a0 + (n - 1) * d;
            stars[n - 1] = starsNumber;
        }
        char[][] fields = makeStarsField(floors, stars);
        for (int i = 0; i < fields.length; i++) {
            ans[i] = new String(fields[i]);
        }
        return ans;
    }

    private static char[][] makeStarsField(int floors, int[] stars) {
        char[][] starsField = new char[floors][stars[stars.length - 1]];
        for (int i = 0; i < starsField.length; i++) {
            int offset = (starsField[i].length - stars[i]) / 2;
            for (int j = 0; j < starsField[i].length; j++) {
                if (j < offset || j >= starsField[i].length - offset) {
                    starsField[i][j] = ' ';
                } else {
                    starsField[i][j] = '*';
                }
            }
        }
        return starsField;
    }

    private static void print(String[] data) {
        for (String s : data) {
            System.out.println(s);
        }
    }
}
