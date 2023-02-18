package kyu5;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Common denominators
 * 
 * You will have a list of rationals in the form
 * 
 * { {numer_1, denom_1} , ... {numer_n, denom_n} }
 * or
 * [ [numer_1, denom_1] , ... [numer_n, denom_n] ]
 * or
 * [ (numer_1, denom_1) , ... (numer_n, denom_n) ]
 * where all numbers are positive ints. You have to produce a result in the
 * form:
 * 
 * (N_1, D) ... (N_n, D)
 * or
 * [ [N_1, D] ... [N_n, D] ]
 * or
 * [ (N_1', D) , ... (N_n, D) ]
 * or
 * {{N_1, D} ... {N_n, D}}
 * or
 * "(N_1, D) ... (N_n, D)"
 * depending on the language (See Example tests) in which D is as small as
 * possible and
 * 
 * N_1/D == numer_1/denom_1 ... N_n/D == numer_n,/denom_n.
 * Example:
 * convertFracs [(1, 2), (1, 3), (1, 4)] `shouldBe` [(6, 12), (4, 12), (3, 12)]
 * Note:
 * Due to the fact that the first translations were written long ago - more than
 * 6 years - these first translations have only irreducible fractions.
 * 
 * Newer translations have some reducible fractions. To be on the safe side it
 * is better to do a bit more work by simplifying fractions even if they don't
 * have to be.
 * 
 * Note for Bash:
 * input is a string, e.g "2,4,2,6,2,8" output is then "6 12 4 12 3 12"
 */

public class CommonDenominators {
    public static void main(String[] args) {
        long[][] lst = new long[][] { { 1, 2 }, { 1, 3 }, { 1, 4 } };
        System.out.println(convertFrac(lst));
    }

    public static String convertFrac(long[][] lst) {
        if (lst.length == 0) {
            return "";
        }
        changeArray(lst);
        List<Long> ls = makeList(lst);
        long common = findCommon(ls);
        for (int i = 0; i < ls.size(); i += 2) {
            ls.set(i, ls.get(i) * common / ls.get(i + 1));
            ls.set(i + 1, common);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ls.size(); i += 2) {
            sb.append("(").append(ls.get(i)).append(",").append(ls.get(i + 1)).append(")");
        }
        return sb.toString();
    }

    public static void changeArray(long[][] lst) {
        for (int i = 0; i < lst.length; i++) {
            long[] ar = lst[i];
            long nominator = ar[0];
            long denominator = ar[1];
            int com = 2;
            while (com <= nominator) {
                if (nominator % com == 0 && denominator % com == 0) {
                    nominator /= com;
                    denominator /= com;
                    continue;
                }
                com++;
            }
            lst[i] = new long[] { nominator, denominator };
        }
    }

    public static long findCommon(List<Long> ls) {
        List<Long> list = new ArrayList<>();
        for (int i = 1; i < ls.size(); i += 2) {
            list.add(ls.get(i));
        }
        Collections.sort(list);
        long start = list.get(list.size() - 1);
        boolean ready = false;
        while (!ready) {
            ready = true;
            for (long l : list) {
                if (start % l != 0) {
                    start++;
                    ready = false;
                    break;
                }
            }
        }
        return start;
    }

    public static List<Long> makeList(long[][] lst) {
        List<Long> ls = new ArrayList<>();
        for (int i = 0; i < lst.length; i++) {
            for (int j = 0; j < lst[i].length; j++) {

                ls.add(lst[i][j]);

            }
        }
        return ls;
    }
}
