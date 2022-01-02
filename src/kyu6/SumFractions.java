package kyu6;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream;

public class SumFractions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your arrays:");
        List<int[]> ls = new ArrayList<>();
        String st = sc.nextLine();
        while (!(st.isEmpty() || st.length() == 0)) {
            ls.add(Arrays.stream(st.split("\\s+")).mapToInt(Integer::valueOf).toArray());
            st = sc.nextLine();
        }
        sc.close();
        int[][] l = new int[ls.size()][];
        for (int i = 0; i < l.length; i++) {
            l[i] = ls.get(i);
        }
        System.out.println(Arrays.deepToString(l));
        System.out.println(sumFracts(l));
    }

    public static String sumFracts(int[][] l) {
        Map<Denominator, Nominator> map = new HashMap<>();
        for (int i = 0; i < l.length; i++) {
            Denominator d = new Denominator(l[i][1]);
            if (map.containsKey(d)) {
                map.put(new Denominator(l[i][1]), new Nominator(map.get(d).getValue() + l[i][0]));
            } else {
                map.put(new Denominator(l[i][1]), new Nominator(l[i][0]));
            }
        }
        Set<Denominator> set = map.keySet();
        int[] den = new int[set.size()];
        int i = 0;
        for (Denominator d : set) {
            den[i] = d.getValue();
        }

        return null;
    }
}

class Denominator {
    private Integer value;

    public Denominator(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class Nominator {
    private Integer value;

    public Nominator(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
