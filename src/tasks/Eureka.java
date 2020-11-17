package tasks;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The number 89 is the first integer with more than one digit that fulfills the
 * property partially introduced in the title of this kata. What's the use of
 * saying "Eureka"? Because this sum gives the same number.
 * 
 * In effect: 89 = 8^1 + 9^2
 * 
 * The next number in having this property is 135.
 * 
 * See this property again: 135 = 1^1 + 3^2 + 5^3
 * 
 * We need a function to collect these numbers, that may receive two integers a,
 * b that defines the range [a, b] (inclusive) and outputs a list of the sorted
 * numbers in the range that fulfills the property described above.
 * 
 * Let's see some cases:
 * 
 * sum_dig_pow(1, 10) == [1, 2, 3, 4, 5, 6, 7, 8, 9]
 * 
 * sum_dig_pow(1, 100) == [1, 2, 3, 4, 5, 6, 7, 8, 9, 89]
 * 
 * If there are no numbers of this kind in the range [a, b] the function should
 * output an empty list.
 * 
 * sum_dig_pow(90, 100) == []
 * 
 * Enjoy it!!
 * 
 * @author ASY
 *
 */
public class Eureka {
   public static void main(String[] args) {
      System.out.println("Enter your values:");
      Scanner sc = new Scanner(System.in);
      long a = sc.nextLong();
      long b = sc.nextLong();
      System.out.println(Arrays.toString(sumDigPower(a, b).toArray()));
      sc.close();
   }

   public static List<Long> sumDigPower(long a, long b) {
      List<Long> res = new ArrayList<Long>();
      for (long i = a; i <= b; i++) {
         if (isVerified(i)) {
            res.add(i);
         }
      }
      return res;
   }

   public static boolean isVerified(long l) {
      String str = Long.toString(l);
      long sum = 0;
      for (int i = 0; i < str.length(); i++) {
         sum += Math.pow(Long.valueOf(Character.toString(str.charAt(i))), i + 1);
      }
      return sum == l ? true : false;
   }
}

/*
 * import java.util.List; import java.util.stream.*;
 * 
 * 
 * class SumDigPower {
 * 
 * public static List<Long> sumDigPow(long a, long b) { 
 * return LongStream.rangeClosed(a, b) .filter(i -> isValid(i)) .boxed()
 * .collect(Collectors.toList()); 
 * }
 * 
 * private static boolean isValid(long x) { 
 * String value = Long.toString(x);
 * return IntStream.range(0, value.length()) .mapToDouble(i ->
 * Math.pow(Character.getNumericValue(value.charAt(i)), i + 1)) .sum() == x; 
 * } 
 * }
 */

/*
 * import java.util.List; import java.util.ArrayList; import
 * java.util.stream.LongStream; import java.util.stream.Collectors; import
 * java.lang.Math;
 * 
 * class SumDigPower {
 * 
 * public static List<Long> sumDigPow(long a, long b) { 
 * return LongStream.rangeClosed(a, b) .filter(d -> { 
 * long sum = 0L, pow = 1L; 
 * for(char dig : String.valueOf(d).toCharArray()) { 
 * sum += Math.pow(Character.getNumericValue(dig), pow++); } 
 * return (long) d == sum; })
 * .collect(ArrayList::new, ArrayList::add, ArrayList::addAll); 
 * } 
 * }
 */