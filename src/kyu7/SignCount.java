package kyu7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Count how often sign changes in array.

result
number from 0 to ... . Empty array returns 0

example
const arr = [1, -3, -4, 0, 5];


| elem | count |
|------|-------|
|  1   |  0    |
| -3   |  1    |
| -4   |  1    |
|  0   |  2    |
|  5   |  2    |


\\catchSignChange(arr)==2;
*/

public class SignCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        sc.close();
        System.out.println(signChange(arr));
    }

    private static int signChange(int[] arr) {
        if (arr.length <= 1) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] >= 0 && arr[i - 1] < 0) || (arr[i] < 0 && arr[i - 1] >= 0)) {
                count++;
            }
        }
        return count;
    }
}
