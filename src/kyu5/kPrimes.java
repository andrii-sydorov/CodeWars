package kyu5;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class kPrimes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the dates: ");
        String s = sc.nextLine();
        int[] n = Arrays.stream(s.split(" ")).mapToInt(Integer :: valueOf).toArray();
        sc.close();
        System.out.println(Arrays.toString(countKPrimes(n[0], n[1], n[2])));
    }

    public static long[] countKPrimes(int k, int start, int end) {
        List<Long> ls = new ArrayList<>();
        for (long i = start; i <= end; i++) {
            if (makeList(i).size() == k) {
                ls.add(i);
            }
        }
        long[] ans = new long[ls.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = ls.get(i);
        }
        return ans;
    }

    public static List<Long> makeList(long n) {
        List<Long> ls = new ArrayList<>();
        if (n == 0) {
            return ls;
        }
        long number = 2;
        while (n != 1) {
            if (n % number == 0) {
                n /= number;
                ls.add(number);
                continue;
            }
            number++;
        }
        return ls;
    }
    
}
