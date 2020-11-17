package tasks;
import java.util.Scanner;
public class ArrayElementParity {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arrStr = sc.nextLine().split(" ");
		int[] arrInt = new int[arrStr.length];
		for (int i = 0; i < arrInt.length; i++) {
			arrInt[i] = Integer.valueOf(arrStr[i]);
		}
		System.out.println(solve(arrInt));
		sc.close();
	}
	
    public static int solve(int [] arr){
    	for (int i = 0; i < arr.length; i++) {
        	int count = 0;
    		for (int j = 0; j < arr.length; j++) {
    			if (arr[i] == - arr[j]) {
    				count++;
    			}
    		}
    		if (count != 1) {
    			return arr[i];
    		}
    	}
    	return 0;
}
}
