package kyu6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Complete the solution so that the function will break up camel casing, using
 * a space between words.
 * 
 * Example
 * "camelCasing" => "camel Casing"
 * "identifier" => "identifier"
 * "" => ""
 * 
 * @author SMD_ASY
 *
 */

public class BreakCamelCase {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        System.out.println(camelCase(input));
    }

    public static String camelCase(String input) {
        StringBuilder sBuilder = new StringBuilder();
        List<String> lStrings = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (Character.isLowerCase(input.charAt(i))) {
                sBuilder.append(input.charAt(i));
            } else {
                if (sBuilder.length() != 0) {
                    lStrings.add(sBuilder.toString());
                    sBuilder.setLength(0);
                }
                sBuilder.append(input.charAt(i));
            }
        }
        if (sBuilder.length() != 0) {
            lStrings.add(sBuilder.toString());
        }
        return String.join(" ", lStrings.toArray(new String[0]));
    }

}
