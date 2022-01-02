package kyu7;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * There is a bus moving in the city, and it takes and drop some people in each
 * bus stop.
 * 
 * You are provided with a list (or array) of integer pairs. Elements of each
 * pair represent number of people get into bus (The first item) and number of
 * people get off the bus (The second item) in a bus stop.
 * 
 * Your task is to return number of people who are still in the bus after the
 * last bus station (after the last array). Even though it is the last bus stop,
 * the bus is not empty and some people are still in the bus, and they are
 * probably sleeping there :D
 * 
 * Take a look on the test cases.
 * 
 * Please keep in mind that the test cases ensure that the number of people in
 * the bus is always >= 0. So the return integer can't be negative.
 * 
 * The second value in the first integer array is 0, since the bus is empty in
 * the first bus stop.
 */

public class Metro {
    public static void main(String[] args) {
        System.out.println("Enter the number of people, which are incomming and outcomming at every stage: ");
        Scanner sc = new Scanner(System.in);
        List<int[]> ls = new ArrayList<>();
        String st = sc.nextLine();
        while (!(st.isEmpty() || st.length() == 0)) {
            ls.add(Arrays.stream(st.split("\\s+")).mapToInt(Integer::valueOf).toArray());
            st = sc.nextLine();
        }
        sc.close();
        System.out.println(countPassengers(ls));
    }

    public static int countPassengers(List<int[]> stops) {
        int ans = 0;
        for (int[] ar : stops) {
            ans += ar[0] - ar[1];
        }
        return ans;
    }
}
