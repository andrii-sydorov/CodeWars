package kyu6;

import java.util.Scanner;
import java.util.Arrays;

/**
 * A stream of data is received and needs to be reversed.
 * 
 * Each segment is 8 bits long, meaning the order of these segments needs to be
 * reversed, for example:
 * 
 * 11111111 00000000 00001111 10101010
 * (byte1) (byte2) (byte3) (byte4)
 * should become:
 * 
 * 10101010 00001111 00000000 11111111
 * (byte4) (byte3) (byte2) (byte1)
 * The total number of bits will always be a multiple of 8.
 * 
 * The data is given in an array as such:
 * 
 * [1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,1,0,1,0,1,0]
 * Note: In the C and NASM languages you are given the third parameter which is
 * the number of segment blocks.
 */

public class DataReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] data = Arrays.stream(sc.nextLine().split("\\s")).mapToInt(Integer::valueOf).toArray();
        System.out.println(Arrays.toString(dataReverse(data)));
        sc.close();
    }

    public static int[] dataReverse(int[] data) {
        // complete length is 32
        int[][] temp = new int[data.length / 8][];
        int index = 0;
        for (int i = 0; i < temp.length; i++) {
            temp[i] = new int[8];
            for (int j = 0; j < temp[i].length; j++) {
                temp[i][j] = data[index];
                index++;
            }
        }
        System.out.println(Arrays.deepToString(temp));
        for (int i = 0; i < temp.length / 2; i++) {
            int[] t = Arrays.copyOf(temp[i], 8);
            temp[i] = temp[temp.length - i - 1];
            temp[temp.length - i - 1] = t;
        }
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                data[index] = temp[i][j];
                index++;
            }
        }
        return data;
    }
}
