package kyu5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumOfK {

    public static List<String> indexeStrings = new ArrayList<>();

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        makeCombinations(new int[] { 50, 55, 57, 58, 60 }, 3);
        System.out.println(indexeStrings.size());
        System.out.println(repeated(3, 5));
        System.out.println(repeated2(3, 5));
        indexeStrings.forEach(x -> System.out.println(x));
        System.exit(0);
        Scanner sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());
        int k = Integer.valueOf(sc.nextLine());
        List<Integer> ls = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::valueOf)
                .collect(Collectors.toList());
        sc.close();
        System.out.println(chooseBestSum(t, k, ls));
    }

    public static Integer chooseBestSum(int t, int k, List<Integer> ls) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < ls.size(); ++i) {
            if (ls.get(i) <= t) {
                if (k == 1) {
                    result = Math.max(result, ls.get(i));
                } else {
                    Integer temp = chooseBestSum(t - ls.get(i), k - 1, ls.subList(i + 1, ls.size()));
                    if (temp != null) {
                        result = Math.max(result, ls.get(i) + temp);
                    }
                }
            }
        }

        if (result < 0)
            return null;
        return result;
    }

    public static void makeCombinations(int[] array, int k) {
        int[][] combinations = new int[k][];
        for (int i = 0; i < k; i++) {
            combinations[i] = new int[array.length];
            for (int j = 0; j < array.length; j++) {
                combinations[i][j] = j;
            }
            System.out.println(Arrays.toString(combinations[i]));
        }
        // System.out.println(Arrays.deepToString(combinations));
        for (int i = 0; i < combinations[0].length; i++) {
            buildCombinations(0, combinations[0], String.valueOf(combinations[0][i]), k);
        }
    }

    public static void buildCombinations(int index, int[] initialArray, String forbidden, int limit) {
        index++;
        if (limit == index) {
            indexeStrings.add(forbidden);
            return;
        }
        //index++;
        for (int i = 0; i < initialArray.length; i++) {
            if (forbidden.indexOf(String.valueOf(i)) >= 0) {
                continue;
            }
//            if (index == limit - 1) {
//                indexeStrings.add(forbidden + String.valueOf(i));
//            }
            buildCombinations(index, initialArray, forbidden + String.valueOf(i), limit);
        }
    }

    public static int repeated(int r, int n) {
        /*
         * (r + n − 1)!
         * ------------
         * r!(n − 1)!
         */
        return factorial(r + n - 1)/(factorial(r) * factorial(n - 1));
    }
    
    public static int repeated2(int r, int n) {
        /*
         * (n)!
         * ------------
         * r!(n − r)!
         */
        return factorial(n)/(factorial(r) * factorial(n - r));
    }

    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        int prod = 1;
        for (int i = 1; i <= n; i++) {
            prod *= i;
        }
        return prod;
    }

}
