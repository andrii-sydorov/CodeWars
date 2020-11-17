package tasks;
import java.util.Scanner;

public class RegexValidatePINCode {
   public static void main(String[] args) {
      System.out.println("Enter your pin:");
      Scanner sc = new Scanner(System.in);
      System.out.println(validatePin(sc.nextLine()));
      sc.close();
   }

   /**
    * ATM machines allow 4 or 6 digit PIN codes and PIN codes cannot contain
    * anything but exactly 4 digits or exactly 6 digits.
    * 
    * If the function is passed a valid PIN string, return true, else return false.
    * 
    * eg:
    * 
    * Solution.validatePin("1234") === true Solution.validatePin("12345") === false
    * Solution.validatePin("a234") === false
    * 
    * 
    * @param pin
    * @return
    */
   static boolean validatePin(String pin) {
      // Your code here...
      if (pin.length() != 4 && pin.length() != 6) {
         return false;
      }
      try {
         Integer.valueOf(pin);
      } catch (NumberFormatException e) {
         return false;
      }
      if (pin.charAt(0) == '-' || pin.charAt(0) == '+') {
         return false;
      }
      return true;
   }
   /*
    * 
    * public static boolean validatePin(String pin) { return
    * pin.matches("[0-9]{4}|[0-9]{6}");
    * 
    */
}
