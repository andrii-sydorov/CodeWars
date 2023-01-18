package kyu6;

import java.util.Scanner;

/**
 * You are the "computer expert" of a local Athletic Association (C.A.A.). Many
 * teams of runners come to compete. Each time you get a string of all race
 * results of every team who has run. For example here is a string showing the
 * individual results of a team of 5 runners:
 * 
 * "01|15|59, 1|47|6, 01|17|20, 1|32|34, 2|3|17"
 * 
 * Each part of the string is of the form: h|m|s where h, m, s (h for hour, m
 * for minutes, s for seconds) are positive or null integer (represented as
 * strings) with one or two digits. Substrings in the input string are separated
 * by , or ,.
 * 
 * To compare the results of the teams you are asked for giving three
 * statistics; range, average and median.
 * 
 * Range : difference between the lowest and highest values. In {4, 6, 9, 3, 7}
 * the lowest value is 3, and the highest is 9, so the range is 9 − 3 = 6.
 * 
 * Mean or Average : To calculate mean, add together all of the numbers and then
 * divide the sum by the total count of numbers.
 * 
 * Median : In statistics, the median is the number separating the higher half
 * of a data sample from the lower half. The median of a finite list of numbers
 * can be found by arranging all the observations from lowest value to highest
 * value and picking the middle one (e.g., the median of {3, 3, 5, 9, 11} is 5)
 * when there is an odd number of observations. If there is an even number of
 * observations, then there is no single middle value; the median is then
 * defined to be the mean of the two middle values (the median of {3, 5, 6, 9}
 * is (5 + 6) / 2 = 5.5).
 * 
 * Your task is to return a string giving these 3 values. For the example given
 * above, the string result will be
 * 
 * "Range: 00|47|18 Average: 01|35|15 Median: 01|32|34"
 * 
 * of the form: "Range: hh|mm|ss Average: hh|mm|ss Median: hh|mm|ss"`
 * 
 * where hh, mm, ss are integers (represented by strings) with each 2 digits.
 * 
 * Remarks:
 * if a result in seconds is ab.xy... it will be given truncated as ab.
 * if the given string is "" you will return ""
 */

public class Stat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strg = sc.nextLine();
        sc.close();
        System.out.println(stat(strg));
    }

    public static String stat(String strg) {
        String[] res = strg.split(",");
        int[] seconds = makeSeconds(res);
        sortArray(seconds);
        String range = buildData(seconds[seconds.length - 1] - seconds[0]);
        String mean = buildData(average(seconds));
        String median = buildData(medianValue(seconds));
        return String.format("Range: %s Average: %s Median: %s", range, mean, median);
    }

    public static int medianValue(int[] seconds) {
        if (seconds.length % 2 != 0) {
            return seconds[seconds.length / 2];
        }
        return (seconds[seconds.length / 2] + seconds[seconds.length / 2 - 1]) / 2;
    }

    public static int average(int[] seconds) {
        int sum = 0;
        for (int i = 0; i < seconds.length; i++) {
            sum += seconds[i];
        }
        return sum / seconds.length;
    }

    public static String buildData(int data) {
        int hours = data / 3600;
        int minutes = (data - hours * 3600) / 60;
        int seconds = data % 60;
        String sHours = hours == 0 ? "00" : hours < 10 ? "0" + String.valueOf(hours) : String.valueOf(hours);
        String sMinutes = minutes == 0 ? "00" : minutes < 10 ? "0" + String.valueOf(minutes) : String.valueOf(minutes);
        String sSeconds = seconds == 0 ? "00" : seconds < 10 ? "0" + String.valueOf(seconds) : String.valueOf(seconds);
        return sHours + "|" + sMinutes + "|" + sSeconds;
    }

    public static int[] makeSeconds(String[] res) {
        int[] ans = new int[res.length];
        for (int i = 0; i < res.length; i++) {
            String[] data = res[i].trim().split("\\|");
            int sum = 0;
            for (int j = data.length - 1; j >= 0; j--) {
                sum += Integer.valueOf(data[j]) * (int) Math.pow(60, data.length - 1 - j);
            }
            ans[i] = sum;
        }
        return ans;
    }

    public static void sortArray(int[] seconds) {
        boolean isSorted = false;
        int turns = 0;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < seconds.length - 1 - turns; i++) {
                if (seconds[i] > seconds[i + 1]) {
                    isSorted = false;
                    int temp = seconds[i];
                    seconds[i] = seconds[i + 1];
                    seconds[i + 1] = temp;
                }
            }
            turns++;
        }
    }
}
