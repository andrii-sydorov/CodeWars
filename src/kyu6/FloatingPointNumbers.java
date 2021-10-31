package kyu6;

import java.util.Scanner;
import java.util.Locale;

public class FloatingPointNumbers {

	private static final int base = 2;
	private static final int wholePartDouble = 11;
	private static final int fractPartDouble = 52;
	private static final int wholePartFloat = 8;
	private static final int fractPartFloat = 23;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test for 15.875:");
		System.out.println("Test for double: " + doubleToIEEE_754(15.875).equals("0 10000000010 1111110000000000000000000000000000000000000000000000"));
		System.out.println("Test for float: " + floatToIEEE_754(15.875f).equals("0 10000010 11111100000000000000000"));
		System.out.println("Test for Max_Value:");
		System.out.println("Test for double: " + doubleToIEEE_754(Double.MAX_VALUE).equals("0 11111111110 1111111111111111111111111111111111111111111111111111"));
		System.out.println("Test for float: " + floatToIEEE_754(Float.MAX_VALUE).equals("0 11111110 11111111111111111111111"));
		System.out.println("Test for Min_Value:");
		System.out.println("Test for double: " + doubleToIEEE_754(Double.MIN_VALUE).equals("0 00000000000 0000000000000000000000000000000000000000000000000001"));
		System.out.println("Test for float: " + floatToIEEE_754(Float.MIN_VALUE).equals("0 00000000 00000000000000000000001"));
		System.out.println(doubleToIEEE_754(Double.MIN_VALUE));
		System.out.println(floatToIEEE_754(Float.MIN_VALUE));
	}

	public static String doubleToIEEE_754(double number) {
		String sign = defineSign(number);
		int bias = (int) Math.pow(base, 10) - 1;
		String tempAns = makeString(Math.abs(number));
		int shift = defineShift(tempAns);
		String fract = expandString(tempAns.substring(1).replace(".", ""), "fractPart", fractPartDouble);
		String exp = expandString(convertWholePart(bias + shift), "wholePart", wholePartDouble);
		return sign + " " + exp + " " + fract;
	}

	public static String floatToIEEE_754(float number) {
		String sign = defineSign(number);
		int bias = (int) Math.pow(base, 7) - 1;
		String tempAns = makeString(Math.abs(number));
		int shift = defineShift(tempAns);
		String fract = expandString(tempAns.substring(1).replace(".", ""), "fractPart", fractPartFloat);
		String exp = expandString(convertWholePart(bias + shift), "wholePart", wholePartFloat);
		return sign + " " + exp + " " + fract;
	}

	private static int defineShift(String st) {
		if (st.contains(".")) {
			return st.indexOf(".") - 1;
		}
		return st.length() - 1;
	}

	private static String expandString(String st, String operation, int numberToExpand) {
		int diff = numberToExpand - st.length();
		if (diff < 0) {
			return st.substring(0, numberToExpand);
		}
		switch (operation) {
		case "fractPart":
			while (diff != 0) {
				st += "0";
				diff--;
			}
			break;
		case "wholePart":
			while (diff != 0) {
				st = st + "0";
				diff--;
			}
			break;
		default:
			break;
		}
		return st;
	}

	private static String makeString(double number) {
		String wholePart = convertWholePart(number);
		String fractPart = convertFractPart(number);
		if (fractPart.length() == 0) {
			return wholePart;
		}
		return convertWholePart(number) + "." + convertFractPart(number);
	}

	private static String defineSign(double d) {
		return d > 0 ? "0" : "1";
	}

	private static String convertWholePart(double d) {
		String wholePart = "";
		double whole = d - d % 1;
		while (true) {
			if (whole < base) {
				wholePart = (int) whole % base + wholePart;
				break;
			}
			wholePart = (int) whole % base + wholePart;
			whole /= base;
		}
		//System.out.println("The length is " + wholePart.length());
		return wholePart;
	}

	private static String convertFractPart(double d) {
		String fractPart = "";
		double rest = d % 1;
		while (rest != 1 && rest != 0) {
			rest *= base;
			fractPart += (int) rest;
			if (rest > 1) {
				rest -= 1;
			}
		}
		return fractPart;
	}

}
