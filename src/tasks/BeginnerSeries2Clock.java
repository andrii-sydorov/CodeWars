package tasks;
import java.time.Duration;
import java.util.Scanner;

/**
 * Clock shows 'h' hours, 'm' minutes and 's' seconds after midnight.
 * 
 * Your task is to make 'Past' function which returns time converted to
 * milliseconds.
 * 
 * Example: Past(0, 1, 1) == 61000 
 * Input constraints: 0 <= h <= 23, 0 <= m <= 59, 0 <= s <= 59
 * 
 * @author SMD_ASY
 *
 */
public class BeginnerSeries2Clock {
	public static void main(String[] args) {
		System.out.println("Enter your's time:");
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		int s = sc.nextInt();
		sc.close();
		System.out.println(Past(h, m, s));
	}

	public static int Past(int h, int m, int s) {
		final int ms = 1000;
		return h * 60 * 60 * ms + m * 60 * ms + s * ms;
	}

	public static int Past2(int h, int m, int s) {
		return (int) Duration.ofHours(h).plusMinutes(m).plusSeconds(s).toMillis();
	}

}
