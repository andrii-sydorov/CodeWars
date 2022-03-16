package kyu7;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

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

        // int[] prod =
        // Arrays.stream(sc.nextLine().split("\\W+")).mapToInt(Integer::valueOf).toArray();
        // int sub_size = Integer.valueOf(sc.nextLine());
        // System.out.println(maxProduct(prod, sub_size));

        // int[] numbers =
        // Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        // System.out.println(arrayLeaders(numbers));

        // int[] array = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer ::
        // valueOf).toArray();
        // System.out.println(MaxProduct(array));

        int[] arr = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        int n = Integer.valueOf(sc.nextLine());
        System.out.println(nthSmallest(arr, n));
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

    /**
     * 
     * Definition
     * An element is leader if it is greater than The Sum all the elements to its
     * right side.
     * 
     * Task
     * Given an array/list [] of integers , Find all the LEADERS in the array.
     * 
     * Notes
     * Array/list size is at least 3 .
     * 
     * Array/list's numbers Will be mixture of positives , negatives and zeros
     * 
     * Repetition of numbers in the array/list could occur.
     * 
     * Returned Array/list should store the leading numbers in the same order in the
     * original array/list .
     * 
     * Input >> Output Examples
     * arrayLeaders ({1, 2, 3, 4, 0}) ==> return {4}
     * Explanation:
     * 4 is greater than the sum all the elements to its right side
     * 
     * Note : The last element 0 is equal to right sum of its elements (abstract
     * zero).
     * 
     * arrayLeaders ({16, 17, 4, 3, 5, 2}) ==> return {17, 5, 2}
     * Explanation:
     * 17 is greater than the sum all the elements to its right side
     * 
     * 5 is greater than the sum all the elements to its right side
     * 
     * Note : The last element 2 is greater than the sum of its right elements
     * (abstract zero).
     * 
     * arrayLeaders ({5, 2, -1}) ==> return {5, 2}
     * Explanation:
     * 5 is greater than the sum all the elements to its right side
     * 
     * 2 is greater than the sum all the elements to its right side
     * 
     * Note : The last element -1 is less than the sum of its right elements
     * (abstract zero).
     * 
     * arrayLeaders ({0, -1, -29, 3, 2}) ==> return {0, -1, 3, 2}
     * Explanation:
     * 0 is greater than the sum all the elements to its right side
     * 
     * -1 is greater than the sum all the elements to its right side
     * 
     * 3 is greater than the sum all the elements to its right side
     * 
     * Note : The last element 2 is greater than the sum of its right elements
     * (abstract zero).
     * 
     * @param numbers
     * @return all the LEADERS in the array
     */
    public static List<Integer> arrayLeaders(int[] numbers) {
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > sum(Arrays.copyOfRange(numbers, i + 1, numbers.length))) {
                ls.add(numbers[i]);
            }
        }
        return ls;
    }

    /**
     * 
     * @param array
     * @return sum elements of array
     */
    private static int sum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    /**
     * Task
     * Given an array of integers , Find the maximum product obtained from
     * multiplying 2 adjacent numbers in the array.
     * 
     * Notes
     * Array/list size is at least 2.
     * 
     * Array/list numbers could be a mixture of positives, negatives also zeroes .
     * 
     * Input >> Output Examples
     * adjacentElementsProduct([1, 2, 3]); ==> return 6
     * Explanation:
     * The maximum product obtained from multiplying 2 * 3 = 6, and they're adjacent
     * numbers in the array.
     * adjacentElementsProduct([9, 5, 10, 2, 24, -1, -48]); ==> return 50
     * Explanation:
     * Max product obtained from multiplying 5 * 10 = 50 .
     * 
     * adjacentElementsProduct([-23, 4, -5, 99, -27, 329, -2, 7, -921]) ==> return
     * -14
     * Explanation:
     * The maximum product obtained from multiplying -2 * 7 = -14, and they're
     * adjacent numbers in the array.
     * 
     * @param array
     * @return the maximum product obtained from
     *         multiplying 2 adjacent numbers in the array
     */
    public static int MaxProduct(int[] array) {
        int prod = Integer.MIN_VALUE;
        for (int i = 0; i < array.length - 1; i++) {
            if (prod <= array[i] * array[i + 1]) {
                prod = array[i] * array[i + 1];
            }
        }
        return prod;
    }

    /**
     * Task
     * Given an array/list [] of integers , Find the Nth smallest element in this
     * array of integers
     * 
     * Notes
     * Array/list size is at least 3 .
     * 
     * Array/list's numbers could be a mixture of positives , negatives and zeros .
     * 
     * Repetition in array/list's numbers could occur , so don't Remove Duplications
     * .
     * 
     * Input >> Output Examples
     * nthSmallest({3,1,2} ,2) ==> return (2)
     * Explanation:
     * Since the passed number is 2 , Then * the second smallest element in this
     * array/list is 2*
     * 
     * nthSmallest({15,20,7,10,4,3} ,3) ==> return (7)
     * Explanation:
     * Since the passed number is 3 , Then * the third smallest element in this
     * array/list is 7*
     * 
     * nthSmallest({2,169,13,-5,0,-1} ,4) ==> return (2)
     * Explanation:
     * Since the passed number is 4 , Then * the fourth smallest element in this
     * array/list is 2*
     * 
     * nthSmallest({177,225,243,-169,-12,-5,2,92} ,5) ==> return (92)
     * Explanation:
     * Since the passed number is 5 , Then * the fifth smallest element in this
     * array/list is 92*
     * 
     * @param arr
     * @param n
     * @return Find the Nth smallest element in this
     *         array of integers
     */
    public static int nthSmallest(final int[] arr, final int n) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr[n - 1];
    }

}
