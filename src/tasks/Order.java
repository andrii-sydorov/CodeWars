package tasks;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Order {
   public static void main(String[] args) {
      System.out.println("Enter your sentences:");
      Scanner sc = new Scanner(System.in);
      String line = sc.nextLine();
      System.out.println(order2(line));
      sc.close();
   }
   
   public static String order(String line) {
      List<Integer> index = new ArrayList<Integer>();
      char[] chArr = line.toCharArray();
      char j = '1';
      for(int i = 0; i < chArr.length; i++) {
         if(Character.isDigit(chArr[i])) {
            index.add(i);
            chArr[i] = j;
            j++;
         }
      }
      return new String(chArr);
   }
   
   public static String order2(String line) {
      String[] strArr = line.split(" ");
      String res = "";
      int k = 0;
      char index = '1';
      while(k != strArr.length) {
         if(k != 0) {
            res += " ";
         }
      for(int i = 0; i < strArr.length; i++) {
         boolean exit = false;
         for(int j = 0; j < strArr[i].length(); j++) {
            if(strArr[i].charAt(j) == index) {
               res += strArr[i];
               index++;
               exit = true;
            }
         }
         if(exit) {
            break;
         }
      }
      k++;
      }
      return res;
   }
}
