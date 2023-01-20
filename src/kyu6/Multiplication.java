package kyu6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Your task, is to create N×N multiplication table, of size provided in
 * parameter.
 * 
 * For example, when given size is 3:
 * 
 * 1 2 3
 * 2 4 6
 * 3 6 9
 * For the given example, the return value should be:
 * 
 * [[1,2,3],[2,4,6],[3,6,9]]
 */

public class Multiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        sc.close();
        System.out.println(Arrays.deepToString(multiplicationTable(n)));
    }

    public static int[][] multiplicationTable(int n) {
        int[][] ans = new int[n][n];
        int row = 1;
        int column = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    ans[i][j] = row;
                    row++;
                } else if (j == 0) {
                    ans[i][j] = column;
                    column++;
                } else {
                    ans[i][j] = ans[0][j] * ans[i][0];
                }
            }
        }
        return ans;
    }

    // public static int[][] multiplicationTable(int n) {
    //     int[][] array = new int[n][n];
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < n; j++) {
    //             array[i][j] = (i + 1) * (j + 1);
    //         }
    //     }
        
    //     return array;
    // }
}
