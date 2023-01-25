package kyu6;

import java.util.Scanner;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * To participate in a prize draw each one gives his/her firstname.
 * 
 * Each letter of a firstname has a value which is its rank in the English
 * alphabet. A and a have rank 1, B and b rank 2 and so on.
 * 
 * The length of the firstname is added to the sum of these ranks hence a number
 * som.
 * 
 * An array of random weights is linked to the firstnames and each som is
 * multiplied by its corresponding weight to get what they call a winning
 * number.
 * 
 * Example:
 * names: "COLIN,AMANDBA,AMANDAB,CAROL,PauL,JOSEPH"
 * weights: [1, 4, 4, 5, 2, 1]
 * 
 * PauL -> som = length of firstname + 16 + 1 + 21 + 12 = 4 + 50 -> 54
 * The *weight* associated with PauL is 2 so PauL's *winning number* is 54 * 2 =
 * 108.
 * Now one can sort the firstnames in decreasing order of the winning numbers.
 * When two people have the same winning number sort them alphabetically by
 * their firstnames.
 * 
 * Task:
 * parameters: st a string of firstnames, we an array of weights, n a rank
 * 
 * return: the firstname of the participant whose rank is n (ranks are numbered
 * from 1)
 * 
 * Example:
 * names: "COLIN,AMANDBA,AMANDAB,CAROL,PauL,JOSEPH"
 * weights: [1, 4, 4, 5, 2, 1]
 * n: 4
 * 
 * The function should return: "PauL"
 * Notes:
 * The weight array is at least as long as the number of names, it may be
 * longer.
 * 
 * If st is empty return "No participants".
 * 
 * If n is greater than the number of participants then return "Not enough
 * participants".
 * 
 * See Examples Test Cases for more examples.
 */

public class PrizeDraw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        Integer[] we = null;
        int n = Integer.valueOf(sc.nextLine());
        System.out.println(nthRank(st, we, n));
        sc.close();
    }

    public static String nthRank(String st, Integer[] we, int n) {
        if (st.length() == 0) {
            return "No participants";
        }
        Map<String, Integer> map = new HashMap<>();
        String[] data = st.split(",");
        if (data.length < n) {
            return "Not enough participants";
        }
        String letters = makeLettersString();
        for (int i = 0; i < data.length; i++) {
            map.put(data[i], calculateWeight(data[i], letters, we[i]));
        }
        List<Map.Entry<String, Integer>> ls = new ArrayList<>(map.entrySet());
        Comparator<Map.Entry<String, Integer>> cmp1 = (x, y) -> y.getValue() > x.getValue() ? 1 : y.getValue() < x.getValue() ? -1 : 0;
        Comparator<Map.Entry<String, Integer>> cmp2 = (x, y) -> x.getKey().compareTo(y.getKey());
        //ls.sort((x, y) -> x.getValue() > y.getValue() ? 1 : x.getValue() < y.getValue() ? -1 : 0);
        ls.sort(cmp1.thenComparing(cmp2));
        return ls.get(n - 1).getKey();
    }

    public static int calculateWeight(String s, String letters, Integer mul) {
        s = s.toLowerCase();
        int sum = s.length();
        for (int i = 0; i < s.length(); i++) {
            sum += letters.indexOf(Character.toString(s.charAt(i))) + 1;
        }
        sum *= mul;
        return sum;
    }

    public static String makeLettersString() {
        StringBuilder sb = new StringBuilder();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
