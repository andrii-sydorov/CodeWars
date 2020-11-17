package tasks;
import java.util.Scanner;

public class PlayingWithDigits {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter your's number:");
//      digits(sc.nextInt());
      System.out.println(digPow(sc.nextInt(), sc.nextInt()));
      sc.close();
   }

   static void digits(int i) {
      while (i != 0) {
         System.out.print(i % 10);
         i /= 10;
      }
   }

   /**
    * Some numbers have funny properties. For example:
    * 
    * 89 --> 8¹ + 9² = 89 * 1
    * 
    * 695 --> 6² + 9³ + 5⁴= 1390 = 695 * 2
    * 
    * 46288 --> 4³ + 6⁴+ 2⁵ + 8⁶ + 8⁷ = 2360688 = 46288 * 51
    * 
    * Given a positive integer n written as abcd... (a, b, c, d... being digits)
    * and a positive integer p
    * 
    * we want to find a positive integer k, if it exists, such as the sum of the
    * digits of n taken to the successive powers of p is equal to k * n.
    * 
    * In other words:
    * 
    * Is there an integer k such as : (a ^ p + b ^ (p+1) + c ^(p+2) + d ^ (p+3) +
    * ...) = n * k
    * 
    * If it is the case we will return k, if not return -1.
    * 
    * Note: n and p will always be given as strictly positive integers.
    * 
    * digPow(89, 1) should return 1 since 8¹ + 9² = 89 = 89 * 1 
    * digPow(92, 1) should return -1 since there is no k such as 9¹ + 2² equals 92 * k 
    * digPow(695, 2) should return 2 since 6² + 9³ + 5⁴= 1390 = 695 * 2
    * digPow(46288, 3) should return 51 since 4³ + 6⁴+ 2⁵ + 8⁶ + 8⁷ = 2360688 =
    * 46288 * 51
    * 
    * @param n
    * @param p
    * @return
    */
   static long digPow(int n, int p) {
      String[] strArr = new String[Integer.toString(n).length()];
      for (int i = 0; i < Integer.toString(n).length(); i++) {
         strArr[i] = Character.toString(Integer.toString(n).charAt(i));
      }
      long sum = 0;
      for (int i = 0; i < strArr.length; i++) {
         sum += Math.pow(Integer.valueOf(strArr[i]), p);
         p++;
      }
      return sum % n == 0 ? sum / n : -1;
   }
}
