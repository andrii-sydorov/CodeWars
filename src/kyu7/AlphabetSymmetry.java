package kyu7;

import java.util.Arrays;
import java.io.IOException;
import java.nio.file.*;
import java.io.PrintWriter;

/**
 * Consider the word "abode". We can see that the letter a is in position 1 and
 * b is in position 2. In the alphabet, a and b are also in positions 1 and 2.
 * Notice also that d and e in abode occupy the positions they would occupy in
 * the alphabet, which are positions 4 and 5.
 * 
 * Given an array of words, return an array of the number of letters that occupy
 * their positions in the alphabet for each word. For example,
 * 
 * solve(["abode","ABc","xyzD"]) = [4, 3, 1]
 * See test cases for more examples.
 * 
 * Input will consist of alphabet characters, both uppercase and lowercase. No
 * spaces.
 * 
 * Good luck!
 * 
 * If you like this Kata, please try:
 * 
 * Last digit symmetry
 * 
 * Alternate capitalization
 */

public class AlphabetSymmetry {
    public static void main(String[] args) throws IOException {

        String[] arr = readAllLines("./src/kyu7/test.txt").split(",");
        PrintWriter pwr = new PrintWriter("./src/kyu7/parse.txt");
        for (String s : arr) {
            pwr.println(s);
        }
        pwr.close();
        System.out.println(Arrays.toString(solve(arr)));
        PrintWriter pww = new PrintWriter("./src/kyu7/results.txt");
        for (Integer s : solve(arr)) {
            pww.println(s);
        }
        pww.close();
        System.out.println(Arrays.toString(solve(new String[] { "cdsfsf", "", "adfsf" })));
    }

    private static String readAllLines(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    private static int[] solve(String[] arr) {
        int[] ans = new int[arr.length];
        StringBuilder sb = new StringBuilder();
        for (char c = 'a'; c <= 'z'; c++) {
            sb.append(c);
        }
        for (int i = 0; i < arr.length; i++) {
            String[] str = arr[i].split("");
            for (int j = 0; j < str.length; j++) {
                if (str[j].equals("")) {
                    ans[i] = 0;
                    continue;
                }
                if (sb.indexOf(str[j].toLowerCase()) == j) {
                    ans[i]++;
                }
            }
        }
        return ans;
    }
}
