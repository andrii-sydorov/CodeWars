package tasks;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Write a function that takes an array of numbers (integers for the tests) and
 * a target number. It should find two different items in the array that, when
 * added together, give the target value. The indices of these items should then
 * be returned in a tuple like so: (index1, index2).
 * 
 * For the purposes of this kata, some tests may have multiple answers; any
 * valid solutions will be accepted.
 * 
 * The input will always be valid (numbers will be an array of length 2 or
 * greater, and all of the items will be numbers; target will always be the sum
 * of two different items from that array).
 * twoSum [1, 2, 3] 4 === (0, 2)
 * @author SMD_ASY
 *
 */
public class TwoSums {
	public static void main(String[] args) {
		System.out.println("Enter your array:");
		Scanner sc = new Scanner(System.in);
		String[] in = sc.nextLine().replaceAll(",", "").split(" ");
		System.out.println("Enter the target's value:");
		int target = sc.nextInt();
		Test a = (test) -> {
			int[] arInt = new int[test.length];
			for (int i = 0; i < test.length; i++) {
				arInt[i] = Integer.parseInt(test[i]);
			}
			return arInt;
		};
		System.out.println(Arrays.toString(twoSum(a.arInt(in), target)));
		sc.close();
	}

	public static int[] twoSum(int[] numbers, int target) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] + numbers[j] == target) {
					list.add(i);
					list.add(j);
					return TwoSums.retArrInt(list);
				}
			}
		}
		return null;
	}

	public static int[] retArrInt(ArrayList<Integer> list) {
		int[] result = new int[list.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}
		return result;
	}
	
	  public static int[] twoSum2(int[] numbers, int target) {
		    Map<Integer, Integer> numToIndexMapping = new HashMap<>(numbers.length);
		    for(int i = 0; i < numbers.length; i++) {
		      if(numToIndexMapping.containsKey(target - numbers[i])) {
		        return new int[] { i, numToIndexMapping.get(target - numbers[i]) };
		      } else {
		        numToIndexMapping.put(numbers[i], i);
		      }
		    }
		    return new int[0];
		  }
}

interface Test {
	int[] arInt(String[] in);
}
