import java.util.Scanner;

/**
 * The input is a string str of digits. Cut the string into chunks (a chunk here
 * is a substring of the initial string) of size sz (ignore the last chunk if
 * its size is less than sz).
 * 
 * If a chunk represents an integer such as the sum of the cubes of its digits
 * is divisible by 2, reverse that chunk; otherwise rotate it to the left by one
 * position. Put together these modified chunks and return the result as a
 * string.
 * 
 * If
 * 
 * sz is <= 0 or if str is empty return "" 
 * sz is greater (>) than the length of str it is impossible to take a chunk of size sz hence return "". 
 * Examples:
 * revrot("123456987654", 6) --> "234561876549" 
 * revrot("123456987653", 6) --> "234561356789" 
 * revrot("66443875", 4) --> "44668753" 
 * revrot("66443875", 8) --> "64438756" 
 * revrot("664438769", 8) --> "67834466" 
 * revrot("123456779", 8) --> "23456771" 
 * revrot("", 8) --> "" 
 * revrot("123456779", 0) --> ""
 * revrot("563000655734469485", 4) --> "0365065073456944" 
 * 
 * Example of a string rotated to the left by one position: 
 * s = "123456" gives "234561".
 */

public class RevRot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your string value:");
        String strng = sc.nextLine();
        System.out.println("Enter the size of chunks:");
        int sz = sc.nextInt();
        sc.close();
        System.out.println(revRot(strng, sz));
    }

    private static String revRot(String strng, int sz) {
        if (sz == 0 || sz > strng.length()) {
            return "";
        }
        String[] chunk = new String[strng.length() / sz];
        for (int i = 0; i < chunk.length; i++) {
            chunk[i] = strng.substring(i * sz, (i + 1) * sz);
        }
        manipulateArray(chunk);
        return String.join("", chunk);
    }

    private static boolean isTheCubeOdd(String partOfChunk) {
        int sum = 0;
        char[] temp = partOfChunk.toCharArray();
        for (int i = 0; i < temp.length; i++) {
            sum += Character.getNumericValue(temp[i]);
        }
        return sum % 2 == 0 ? true : false;
    }

    private static void manipulateArray(String[] chunk) {
        for (int i = 0; i < chunk.length; i++) {
            if (isTheCubeOdd(chunk[i])) {
                chunk[i] = reverse(chunk[i]);
            } else {
                chunk[i] = leftRotate(chunk[i]);
            }
        }
    }

    private static String leftRotate(String string) {
        String[] line = string.split("");
        String[] newLine = new String[line.length];
        for (int i = 0; i < line.length; i++) {
            newLine[i] = line[(i + 1) % line.length];
        }
        return String.join("", newLine);
    }

    private static String reverse(String string) {
        char[] tempCharArray = string.toCharArray();
        for (int i = 0; i < tempCharArray.length / 2; i++) {
            char temp = tempCharArray[i];
            tempCharArray[i] = tempCharArray[tempCharArray.length - 1 - i];
            tempCharArray[tempCharArray.length - 1 - i] = temp;
        }
        return new String(tempCharArray);
    }
}
