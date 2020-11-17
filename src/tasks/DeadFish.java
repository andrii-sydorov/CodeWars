package tasks;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Write a simple parser that will parse and run Deadfish.
 * 
 * Deadfish has 4 commands, each 1 character long:
 * 
 * i increments the value (initially 0) 
 * d decrements the value 
 * s squares the value 
 * o outputs the value into the return array 
 * Invalid characters should be ignored.
 * 
 * Deadfish.parse("iiisdoso") =- new int[] {8, 64};
 * 
 * @author SMD_ASY
 *
 */
public class DeadFish {
	public static void main(String[] args) {
		System.out.println("Enter your parse:");
		Scanner sc = new Scanner(System.in);
		String data = sc.nextLine();
		System.out.println(Arrays.toString(parse(data)));
		sc.close();
	}

	public static int[] parse(String data) {
		final int init = 0;
		int value = init;
		char[] chArr = data.toCharArray();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < chArr.length; i++) {
			switch (chArr[i]) {
			case 'i':
				value++;
				break;
			case 'd':
				value--;
				break;
			case 's':
				value = (int) Math.pow(value, 2);
				break;
			case 'o':
				list.add(value);
			}
		}
		int[] intArr = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			intArr[i] = list.get(i);
		}
		return intArr;
	}

	public static int[] parse2(String data) {
		int value = 0;
		List<Integer> result = new ArrayList<>();
		for (char letter : data.toCharArray()) {
			switch (letter) {
			case 'i':
				value++;
				break;
			case 'd':
				value--;
				break;
			case 's':
				value *= value;
				break;
			case 'o':
				result.add(value);
				break;
			default:
				throw new IllegalArgumentException("Not valid code letter");
			}
		}
		return result.stream().mapToInt(Integer::intValue).toArray();
	}
}