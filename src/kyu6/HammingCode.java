package kyu6;

import java.util.Arrays;

/**
 * Background information The Hamming Code is used to correct errors, so-called
 * bit flips, in data transmissions. Later in the description follows a detailed
 * explanation of how it works. In this Kata we will implement the Hamming Code
 * with bit length 3; this has some advantages and disadvantages:
 * 
 * [ + ] It's simple to implement 
 * [ + ] Compared to other versions of hamming code, we can correct more mistakes 
 * [ - ] The size of the input triples 
 * 
 * Task1: Encode function 
 * Implement the encode function, using the following steps:
 * 
 * convert every letter of the text to its ASCII value; 
 * convert ASCII values to 8-bit binary; 
 * triple every bit; 
 * concatenate the result; 
 * 
 * For example:
 * 
 * input: "hey" 
 * --> 104, 101, 121 // ASCII values 
 * --> 01101000, 01100101, 01111001 // binary 
 * --> 000111111000111000000000 000111111000000111000111 000111111111111000000111 // tripled 
 * --> "000111111000111000000000000111111000000111000111000111111111111000000111" // concatenated 
 * 
 * Task 2: Decode function: 
 * Check if any errors happened and correct them. Errors will be only bit flips, and not a loss of bits:
 * 
 * 111 --> 101 : this can and will happen 
 * 111 --> 11 : this cannot happen 
 * Note: the length of the input string is also always divisible by 24 so that you can
 * convert it to an ASCII value.
 * 
 * Steps:
 * 
 * Split the input into groups of three characters; 
 * Check if an error occurred: replace each group with the character that occurs most often, e.g. 010 --> 0, 110 --> 1, etc; 
 * Take each group of 8 characters and convert that binary number; 
 * Convert the binary values to decimal (ASCII); 
 * Convert the ASCII values to characters and concatenate the result For example:
 * 
 * input:
 * "100111111000111001000010000111111000000111001111000111110110111000010111"
 * --> 100, 111, 111, 000, 111, 001, ... // triples 
 * --> 0, 1, 1, 0, 1, 0, ... // corrected bits 
 * --> 01101000, 01100101, 01111001 // bytes 
 * --> 104, 101, 121 // ASCII values 
 * --> "hey"
 */

public class HammingCode {

	public static void main(String[] args) {
		System.out.println(encode("The Sensei told me that i can do this kata"));
		System.out.println(decode("100111111000111001000010000111111000000111001111000111110110111000010111"));
	}

	public static String encode(String text) {

		int[] ASCII = new int[text.length()];
		for (int i = 0; i < text.length(); i++) {
			ASCII[i] = (int) text.charAt(i);
		}

		String[] binary = new String[text.length()];
		for (int i = 0; i < binary.length; i++) {
			binary[i] = Integer.toBinaryString(ASCII[i]);
			while (binary[i].length() != 8) {
				binary[i] = "0" + binary[i];
			}
		}

		String[] tripled = new String[text.length()];
		for (int i = 0; i < tripled.length; i++) {
			tripled[i] = "";
			for (int j = 0; j < binary[i].length(); j++) {
				for (int k = 0; k < 3; k++) {
					tripled[i] += Character.toString(binary[i].charAt(j));
				}
			}
		}

		String bits = "";
		for (int i = 0; i < tripled.length; i++) {
			bits += tripled[i];
		}

		// System.out.println(Arrays.toString(ASCII));
		// System.out.println(Arrays.toString(binary));
		// System.out.println(Arrays.toString(tripled));
		return bits;
	}

	public static String decode(String bits) {
		String text = null;
		// making triples Arrays
		String[] triples = new String[bits.length() / 3];
		for (int i = 0; i < triples.length; i++) {
			triples[i] = bits.substring(3 * i, 3 * i + 3);
		}
		System.out.println(Arrays.toString(triples));
		// checking for errors
		for (int i = 0; i < triples.length; i++) {
			if (triples[i].contains("0") && triples[i].contains("1")) {
				int numberOfTheros = 0;
				for (int j = 0; j < triples[i].length(); j++) {
					if (triples[i].charAt(j) == '0') {
						numberOfTheros++;
					}
				}
				if (numberOfTheros > triples[i].length() - numberOfTheros) {
					triples[i] = "000";
				} else {
					triples[i] = "111";
				}
			}
		}
		// System.out.println(Arrays.toString(triples));
		// making bytes Array
		String[] bytes = new String[bits.length() / 24];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = "";
			for (int j = 8 * i; j < 8 + 8 * i; j++) {
				bytes[i] += triples[j].charAt(1);
			}
		}
		// System.out.println(Arrays.toString(bytes));
		// encoding bytes array
		char[] ch = new char[bytes.length];
		for (int i = 0; i < ch.length; i++) {
			int value = 0;
			int power = 0;
			for (int j = bytes[i].length() - 1; j >= 0; j--) {
				value += Character.getNumericValue(bytes[i].charAt(j)) * Math.pow(2, power);
				power++;
			}
			ch[i] = (char) value;
		}
		text = new String(ch);
		return text;
	}
}
