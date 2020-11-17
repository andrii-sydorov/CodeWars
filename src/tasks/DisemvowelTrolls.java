package tasks;
import java.util.Scanner;
public class DisemvowelTrolls {
   public static void main(String[] args) {
      System.out.println("Enter your's line");
      Scanner sc = new Scanner(System.in);
      String in = sc.nextLine();
      System.out.println(disemvowel(in));
      sc.close();
   }
   
   static String disemvowel(String in) {
      String ans ="";
      String vowel = "aeiouAEIOU";
      for (int i = 0; i < in.length(); i++) {
         boolean found = false;
         for (int j = 0; j < vowel.length(); j++) {
            if (in.charAt(i) == vowel.charAt(j)) {
               found = true;
               break;
            } else {
               continue;
            }
         }
         if (!found) {
         ans += Character.toString(in.charAt(i));
         }
      }
      return ans;
   }
}
