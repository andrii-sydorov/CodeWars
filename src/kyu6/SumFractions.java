package kyu6;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

/**
 * You will have a list of rationals in the form
 * 
 * lst = [ [numer_1, denom_1] , ... , [numer_n, denom_n] ]
 * or
 * 
 * lst = [ (numer_1, denom_1) , ... , (numer_n, denom_n) ]
 * where all numbers are positive integers. You have to produce their sum N / D
 * in an irreducible form: this means that N and D have only 1 as a common
 * divisor.
 * 
 * Return the result in the form:
 * 
 * [N, D] in Ruby, Crystal, Python, Clojure, JS, CS, PHP, Julia, Pascal
 * Just "N D" in Haskell, PureScript
 * "[N, D]" in Java, CSharp, TS, Scala, PowerShell, Kotlin
 * "N/D" in Go, Nim
 * {N, D} in C, C++, Elixir, Lua
 * Some((N, D)) in Rust
 * Some "N D" in F#, Ocaml
 * c(N, D) in R
 * (N, D) in Swift
 * '(N D) in Racket
 * If the result is an integer (D evenly divides N) return:
 * 
 * an integer in Ruby, Crystal, Elixir, Clojure, Python, JS, CS, PHP, R, Julia
 * Just "n" (Haskell, PureScript)
 * "n" Java, CSharp, TS, Scala, PowerShell, Go, Nim, Kotlin
 * {n, 1} in C, C++, Lua
 * Some((n, 1)) in Rust
 * Some "n" in F#, Ocaml,
 * (n, 1) in Swift
 * n in Racket
 * (n, 1) in Swift, Pascal, Perl
 * If the input list is empty, return
 * 
 * nil/None/null/Nothing
 * {0, 1} in C, C++, Lua
 * "0" in Scala, PowerShell, Go, Nim
 * O in Racket
 * "" in Kotlin
 * [0, 1] in C++, "[0, 1]" in Pascal
 * [0, 1] in Perl
 * Example:
 * [ [1, 2], [1, 3], [1, 4] ] --> [13, 12]
 * 1/2 + 1/3 + 1/4 = 13/12
 * Note
 * See sample tests for more examples and form of results.
 */

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
        if (l.length == 0) {
            return null;
        }
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
            i++;
        }
        int denominator = findCommonDivisor(den);
        int numenator = 0;
        for (Map.Entry<Denominator, Nominator> ent : map.entrySet()) {
            numenator += ent.getValue().getValue() * (denominator / ent.getKey().getValue());
        }
        int index = 2;
        if (numenator % denominator == 0) {
            return String.valueOf(numenator / denominator);
        }
        while (true) {
            if (numenator % index == 0 && denominator % index == 0) {
                numenator /= index;
                denominator /= index;
                continue;
            } else {
                index++;
            }
            if (index == denominator) {
                break;
            }
        }
        return "[" + String.valueOf(numenator) + ", " + String.valueOf(denominator) + "]";
    }

    public static int findCommonDivisor(int[] den) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < den.length; i++) {
            if (den[i] >= max) {
                max = den[i];
            }
        }
        boolean isExit = true;
        int divisor = max;
        while (isExit) {
            for (int i = 0; i < den.length; i++) {
                if (divisor % den[i] != 0) {
                    divisor += max;
                    isExit = true;
                    break;
                }
                isExit = false;
            }
        }
        return divisor;
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
