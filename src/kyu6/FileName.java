package kyu6;

import java.util.Scanner;

/**
 * Inputs:
 * 1231231223123131_FILE_NAME.EXTENSION.OTHEREXTENSION
 * 
 * 1_This_is_an_otherExample.mpg.OTHEREXTENSIONadasdassdassds34
 * 
 * 1231231223123131_myFile.tar.gz2
 * Outputs
 * FILE_NAME.EXTENSION
 * 
 * This_is_an_otherExample.mpg
 * 
 * myFile.tar
 * Acceptable characters for random tests:
 * 
 * abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_-0123456789
 * 
 * The recommended way to solve it is using RegEx and specifically groups.
 */

public class FileName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dirtyFileName = sc.nextLine();
        sc.close();
        System.out.println(extractFileName(dirtyFileName));
    }

    public static String extractFileName(String dirtyFileName) {
        String[] arr = dirtyFileName.split("\\.");
        String fileName = extractName(arr[0]);
        return fileName + "." + arr[1];
    }

    public static String extractName(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split("_");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].replaceAll("[0-9]", "").length() == 0) {
                continue;
            }
            if (i == arr.length - 1) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i] + "_");
            }
        }
        return sb.toString();
    }
}
