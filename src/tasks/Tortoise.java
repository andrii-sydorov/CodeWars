package tasks;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Two tortoises named A and B must run a race. A starts with an average speed
 * of 720 feet per hour. Young B knows she runs faster than A, and furthermore
 * has not finished her cabbage.
 * 
 * When she starts, at last, she can see that A has a 70 feet lead but B's speed
 * is 850 feet per hour. How long will it take B to catch A?
 * 
 * More generally: given two speeds v1 (A's speed, integer > 0) and v2 (B's
 * speed, integer > 0) and a lead g (integer > 0) how long will it take B to
 * catch A?
 * 
 * The result will be an array [hour, min, sec] which is the time needed in
 * hours, minutes and seconds (round down to the nearest second) or a string in
 * some languages.
 * 
 * If v1 >= v2 then return nil, nothing, null, None or {-1, -1, -1} for C++, C,
 * Go, Nim, [] for Kotlin or "-1 -1 -1". Examples:
 * 
 * (form of the result depends on the language)
 * 
 * race(720, 850, 70) => [0, 32, 18] or "0 32 18" race(80, 91, 37) => [3, 21,
 * 49] or "3 21 49"
 * 
 * @author Zver
 *
 */
public class Tortoise {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the speed of the first toroise:");
		int v1 = sc.nextInt();
		System.out.print("Enter the speed of the second toroise:");
		int v2 = sc.nextInt();
		System.out.print("Enter the gap beetwen two toroise:");
		int g = sc.nextInt();
		System.out.println("Enter your's arrays:");
		System.out.println(Arrays.toString(race(v1, v2, g)));
		sc.close();
	}

	/**
	 * my solution isn't the best, the best solution don't use the loop and divide
	 * the distance to different of speed
	 * 
	 * @param v1 the speed of the first tortoise
	 * @param v2 the speed of the second tortoise
	 * @param g  the gap beetwen them
	 * @return
	 */
	public static int[] race(int v1, int v2, int g) {
		if (v1 > v2) {
			return null;
		}
		double v1PerSec = (double) v1 / 3600;
		double v2PerSec = (double) v2 / 3600;
		int sec = 1;
		while (v1PerSec * sec + g >= v2PerSec * sec) {
			sec++;
		}
		sec--;// we must understand, that when we leave the cycle we have sec + 1 second,
				// that's why we should decrement the value of sec
		return new int[] { sec / 3600, (sec % 3600) / 60, (sec % 3600) % 60 };
	}
	/**
	 * the best solution without the loops
	 * @param v1
	 * @param v2
	 * @param g
	 * @return
	 */
    public static int[] raceCodeWars(int v1, int v2, int g) {
        if (v1 >= v2) return null;
        int t = 3600 * g / (v2 - v1);
        return new int[] { t / 3600, t % 3600 / 60, t % 60};
    }
}
