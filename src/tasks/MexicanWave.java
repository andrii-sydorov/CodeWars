package tasks;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Introduction The wave (known as the Mexican wave in the English-speaking
 * world outside North America) is an example of metachronal rhythm achieved in
 * a packed stadium when successive groups of spectators briefly stand, yell,
 * and raise their arms. Immediately upon stretching to full height, the
 * spectator returns to the usual seated position.
 * 
 * The result is a wave of standing spectators that travels through the crowd,
 * even though individual spectators never move away from their seats. In many
 * large arenas the crowd is seated in a contiguous circuit all the way around
 * the sport field, and so the wave is able to travel continuously around the
 * arena; in discontiguous seating arrangements, the wave can instead reflect
 * back and forth through the crowd. When the gap in seating is narrow, the wave
 * can sometimes pass through it. Usually only one wave crest will be present at
 * any given time in an arena, although simultaneous, counter-rotating waves
 * have been produced. (Source Wikipedia) 
 * Task 
 * In this simple Kata your task is to create a function that turns a string into a Mexican Wave. You will be
 * passed a string and you must return that string in an array where an
 * uppercase letter is a person standing up. 
 * Rules 1. 
 * The input string will always be lower case but maybe empty.
 * 
 * 2. If the character in the string is whitespace then pass over it as if it
 * was an empty seat 
 * Example 
 * wave("hello") => []string{"Hello", "hEllo","heLlo", "helLo", "hellO"}
 * 
 * @author SMD_ASY
 *
 */
public class MexicanWave {
	public static void main(String[] args) {
		System.out.println("Enter your's word:");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		System.out.println(Arrays.toString(wave(line)));
		sc.close();
	}

	public static String[] wave(String str) {
		String[] ans = new String[str.replaceAll(" ", "").replaceAll(",", "").length()];
		int whitespace = 0;
		for (int i = 0; i < ans.length; i++) {
			for (int j = i + whitespace; j < str.length(); j++) {
				char[] temp = str.toCharArray();
				if (temp[j] == ' ' || temp[j] == '.' || temp[j] == ',' || temp[j] == '!' || temp[j] == '?') {
					whitespace++;
					continue;
				}
				temp[j] = Character.toUpperCase(temp[j]);
				ans[i] = new String(temp);
				break;
			}
		}
		return ans;
	}
}

/*
 * import java.util.*;
 * 
 * public class MexicanWave {
 * 
 * public static String[] wave(String str) { 
 * List<String> list = new ArrayList<>(); 
 * for (int i = 0; i < str.length(); i++) { 
 * char ch = str.charAt(i); 
 * if (ch == ' ') 
 * 	continue; 
 * list.add(str.substring(0,i) + Character.toUpperCase(ch) + str.substring(i+1)); 
 * } 
 * return list.toArray(new String[0]); 
 * }
 * }
 */

/*
 * import java.util.stream.IntStream;
 * 
 * public class MexicanWave {
 * 
 * public static String[] wave(String str) { 
 * return IntStream .range(0,str.length()) .mapToObj(x -> new StringBuilder(str).replace(x, x+1,
 * String.valueOf(str.charAt(x)).toUpperCase()).toString()) .filter(x ->!x.equals(str)) .toArray(String[]::new); 
 * }
 * }
 */