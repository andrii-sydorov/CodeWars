package kyu7;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.util.List;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Simple enough this one - you will be given an array. The values in the array
 * will either be numbers or strings, or a mix of both. You will not get an
 * empty array, nor a sparse one.
 * 
 * Your job is to return a single array that has first the numbers sorted in
 * ascending order, followed by the strings sorted in alphabetic order. The
 * values must maintain their original type.
 * 
 * Note that numbers written as strings are strings and must be sorted with the
 * other strings.
 * 
 * @author SMD_ASY
 *
 */
public class DoubleSort {

	public static void main(String[] args) throws IOException {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		String[] line = bf.readLine().split("\\s+");
		Object[] task = new Object[] { "Banana", "Orange", "Apple", "Mango", 0, 2, 2 };
		Object[] res = dbSortCollections(task);
		for (Object ob : res) {
			System.out.println(ob);
		}
	}
/**
 * don't pass all tests, I don't know why
 * @param a
 * @return
 */
	public static Object[] dbSort(Object[] a) {
		Object[] ans = new Object[a.length];
		int numberOfDigit = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (isNumber(a[i]) && isNumber(a[j])) {
					Integer first = (int) a[i];
					Integer second = (int) a[j];
					if (first >= second) {
						Object temp = a[j];
						a[j] = a[i];
						a[i] = temp;
					}
					numberOfDigit++;
				} else if (!isNumber(a[i]) && !isNumber(a[j])) {
					String first = (String) a[i];
					String second = (String) a[j];
					if (first.compareTo(second) > 0) {
						Object temp = a[j];
						a[j] = a[i];
						a[i] = temp;
					}
				} else {
					continue;
				}
			}
		}
		// starting from digit
		int i = 0;
		for (int j = 0; j < a.length; j++) {
			if (isNumber(a[j])) {
				ans[i] = a[j];
				i++;
			}
		}
		// ending with string
		int k = numberOfDigit;
		for (int j = 0; j < a.length; j++) {
			if (!isNumber(a[j])) {
				ans[k] = a[j];
				k++;
			}
		}
		return ans;
	}
/**
 * passes all tests, but I used Collections
 * @param a
 * @return
 */
	public static Object[] dbSortCollections(Object[] a) {
		List<Integer> lsInt = new ArrayList<>();
		List<String> lsString = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			if (a[i] instanceof Integer) {
				lsInt.add((int) a[i]);
			} else if (a[i] instanceof String) {
				lsString.add((String) a[i]);
			}
		}
		Collections.sort(lsInt);
		Collections.sort(lsString);
		List<Object> lsObj = new ArrayList<>();
		lsObj.addAll(lsInt);
		lsObj.addAll(lsString);
		Object[] arObj = new Object[lsObj.size()];
		for (int i = 0; i < arObj.length; i++) {
			arObj[i] = lsObj.get(i);
		}
		return arObj;
	}

	public static boolean isNumber(Object a) {
		if (a instanceof Integer || a instanceof Double) {
			return true;
		}
		return false;
//		String s = (String) a;
//		for (int i = 0; i < s.length(); i++) {
//			if (Character.isDigit(s.charAt(i))) {
//				continue;
//			} else {
//				return false;
//			}
//		}
//		return true;
	}

}
