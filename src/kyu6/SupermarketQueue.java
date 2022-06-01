package kyu6;

import java.util.Scanner;
import java.util.Arrays;

/**
 * The Supermarket Queue
 * 
 * There is a queue for the self-checkout tills at the supermarket. Your task is
 * write a function to calculate the total time required for all the customers
 * to check out!
 * input
 * 
 * customers: an array of positive integers representing the queue. Each integer
 * represents a customer, and its value is the amount of time they require to
 * check out.
 * n: a positive integer, the number of checkout tills.
 * 
 * output
 * 
 * The function should return an integer, the total time required.
 * Important
 * 
 * Please look at the examples and clarifications below, to ensure you
 * understand the task correctly :)
 * Examples
 * 
 * queueTime([5,3,4], 1)
 * // should return 12
 * // because when there is 1 till, the total time is just the sum of the times
 * 
 * queueTime([10,2,3,3], 2)
 * // should return 10
 * // because here n=2 and the 2nd, 3rd, and 4th people in the
 * // queue finish before the 1st person has finished.
 * 
 * queueTime([2,3,10], 2)
 * // should return 12
 * 
 * Clarifications
 * 
 * There is only ONE queue serving many tills, and
 * The order of the queue NEVER changes, and
 * The front person in the queue (i.e. the first element in the array/list)
 * proceeds to a till as soon as it becomes free.
 * 
 * N.B. You should assume that all the test input will be valid, as specified
 * above.
 * 
 * P.S. The situation in this kata can be likened to the
 * more-computer-science-related idea of a thread pool, with relation to running
 * multiple processes at the same time:
 * https://en.wikipedia.org/wiki/Thread_pool
 * 
 */

public class SupermarketQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] customers = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        int n = Integer.valueOf(sc.nextLine());
        sc.close();
        System.out.println(solveSuperMarketQueue(customers, n));
    }

    private static int solveSuperMarketQueue(int[] customers, int n) {
        if (customers == null || customers.length == 0) {
            return 0;
        }
        int limit = Math.min(customers.length, n);
        int[] sums = new int[limit];
        int[] tills = new int[limit];
        for (int i = 0; i < customers.length;) {
            for (int j = 0; j < tills.length && i < customers.length; j++) {
                if (tills[j] == 0) {
                    sums[j] += customers[i];
                    tills[j] += customers[i];
                    i++;
                }
            }
            boolean exit = false;
            while (!exit) {
                for (int j = 0; j < tills.length; j++) {
                    tills[j]--;
                }
                for (int j = 0; j < tills.length; j++) {
                    if (tills[j] == 0) {
                        exit = true;
                    }
                }
            }
        }
        Arrays.sort(sums);
        return sums[sums.length - 1];
    }
}
