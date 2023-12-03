package kyu7;

import java.util.Arrays;
import java.util.Scanner;

public class GCDsum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int g = sc.nextInt();
        sc.close();
        System.out.println(Arrays.toString(solve(s,g)));
    }

    private static int[] solve(int s, int g) {
        int[] ans = new int[2];
        for (int i = 1 ; i <= s / 2 + 1; i++) {
            if (i % g == 0 & (s - i) % g == 0) {
                ans[0] = i;
                ans[1] = s - i;
                return ans;
            }
        }
        return new int[]{-1, -1};
    }
}
