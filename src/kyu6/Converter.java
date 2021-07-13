package kyu6;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Intro: I was doing a coding challenge. It was one of those multi-step
 * challenges. I don't know if my approach was good or bad, but in one of these
 * steps I was writing a function to convert word to numbers. I did it..
 * eventually, but... I didn't like how it was written. So I thought why not
 * create kata and check how other people do it :) So:
 * 
 * Task: Your task is to write the word to number converter. Digits in the
 * number should match letters in the word. Plus generated number should be the
 * smallest possible number you can get.
 * 
 * Words will contain of maximum 10 distinct letters, but word can be any
 * length, even longer than 10 characters long. Number can NOT start with 0 Same
 * letters share the same digit regardless of case For empty string return 0
 * Examples:
 * 
 * "A" -> 1 - OK
 * 
 * "ABA" -> 353 - WRONG ( number is OK, but it's not the smallest number )
 * 
 * "ABA" -> 333 - WRONG ( different letters map to same digits )
 * 
 * "ABA" -> 357 - WRONG ( same letters map to different digits )
 * 
 * @author SMD_ASY
 *
 */

public class Converter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter your's text:");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		System.out.println(convert1(s));
	}

	public static long convert(String word) {
		if(word.isEmpty()) {
			return 0L;
		}
		List<Integer> ls = new ArrayList<>();
		word = word.toLowerCase();
		char[] words = word.toCharArray();
		int[] numbers = new int[words.length];
		int startValue = 1;
		int countDifference = 0;
		boolean toIncrease = false;
		for (int i = 0; i < words.length; i++) {
			if (ls.contains(Integer.valueOf(i))) {
				continue;
			} else {
				for (int j = 0; j < words.length; j++) {
					if (words[i] == words[j]) {
						if (countDifference != 1) {
							toIncrease = true;
							numbers[j] = startValue;
							ls.add(j);
						} else {
							toIncrease = false;
							numbers[j] = 0;
							ls.add(j);
						}
					}
				}
				if (toIncrease) {
					startValue++;
				}
				countDifference++;
			}
		}
		String s = "";
		for (int i = 0; i < numbers.length; i++) {
			s += String.valueOf(numbers[i]);
		}
		return Long.valueOf(s);
	}
	
    public static long convert1(String word) {
        
        if(word == null || word.isEmpty()) {
            return 0;
        }
        
        final int wordLen = word.length();
        final char[] charArray = new char[]{'1', '0', '2', '3', '4', '5', '6', '7', '8', '9'};
        int pointer = 0;
        
        word = word.toUpperCase();
        
        for(int i=0;i<wordLen;i++) {
            char chr = word.charAt(i);
            if(Character.isUpperCase(chr)) {
                word = word.replace(chr, charArray[pointer]);
                pointer++;
            }
        }
        
        return Long.parseLong(word);
    }

}
