package kyu7;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Introduction and Warm-up (Highly recommended)
 * Playing With Lists/Arrays Series
 */
public class MonimizeSumOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int[] passed =
        // Arrays.stream(sc.nextLine().split("\\W+")).mapToInt(Integer::valueOf).toArray();
        // System.out.println(minSum(passed));
        int[] prod = Arrays.stream(sc.nextLine().split("\\W+")).mapToInt(Integer::valueOf).toArray();
        int sub_size = Integer.valueOf(sc.nextLine());
        System.out.println(maxProduct(prod, sub_size));
        sc.close();
    }

    /**
     * Task
     * Given an array of integers , Find the minimum sum which is obtained from
     * summing each Two integers product .
     * 
     * Notes
     * Array/list will contain positives only .
     * Array/list will always has even size
     * Input >> Output Examples
     * minSum({5,4,2,3}) ==> return (22)
     * Explanation:
     * The minimum sum obtained from summing each two integers product , 5*2 + 3*4 =
     * 22
     * minSum({12,6,10,26,3,24}) ==> return (342)
     * Explanation:
     * The minimum sum obtained from summing each two integers product , 26*3 + 24*6
     * + 12*10 = 342
     * minSum({9,2,8,7,5,4,0,6}) ==> return (74)
     * Explanation:
     * The minimum sum obtained from summing each two integers product , 9*0 + 8*2
     * +7*4 +6*5 = 74
     */
    public static int minSum(int[] passed) {
        Arrays.sort(passed);
        int sum = 0;
        for (int i = 0; i < passed.length / 2; i++) {
            sum += passed[i] * passed[passed.length - 1 - i];
        }
        return sum;
    }

    /**
     * Task
     * Given an array/list [] of integers , Find the product of the k maximal
     * numbers.
     * 
     * Notes
     * Array/list size is at least 3 .
     * 
     * Array/list's numbers Will be mixture of positives , negatives and zeros
     * 
     * Repetition of numbers in the array/list could occur.
     * 
     * Input >> Output Examples
     * maxProduct ({4, 3, 5}, 2) ==> return (20)
     * Explanation:
     * Since the size (k) equal 2 , then the subsequence of size 2 whose gives
     * product of maxima is 5 * 4 = 20 .
     * maxProduct ({8, 10 , 9, 7}, 3) ==> return (720)
     * Explanation:
     * Since the size (k) equal 3 , then the subsequence of size 3 whose gives
     * product of maxima is 8 * 9 * 10 = 720 .
     * maxProduct ({10, 8, 3, 2, 1, 4, 10}, 5) ==> return (9600)
     * Explanation:
     * Since the size (k) equal 5 , then the subsequence of size 5 whose gives
     * product of maxima is 10 * 10 * 8 * 4 * 3 = 9600 .
     * maxProduct ({-4, -27, -15, -6, -1}, 2) ==> return (4)
     * Explanation:
     * Since the size (k) equal 2 , then the subsequence of size 2 whose gives
     * product of maxima is -4 * -1 = 4 .
     * maxProduct ({10, 3, -1, -27} , 3) return (-30)
     * Explanation:
     * Since the size (k) equal 3 , then the subsequence of size 3 whose gives
     * product of maxima is 10 * 3 * -1 = -30 .
     * 
     * @param passed
     * @return the product of the k maximal numbers.
     */
    public static long maxProduct(int[] passed, int sub_size) {
        long product = 1;
        for (int i = 0; i < passed.length - 1; i++) {
            for (int j = i + 1; j < passed.length; j++) {
                if (passed[i] >= passed[j]) {
                    int temp = passed[i];
                    passed[i] = passed[j];
                    passed[j] = temp;
                }
            }
        }
        for (int i = passed.length - sub_size; i < passed.length; i++) {
            product *= passed[i];
        }
        return product;
    }
}
