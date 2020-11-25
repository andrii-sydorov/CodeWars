package tasks;

import java.util.Scanner;

/**
 * We want to approximate the length of a curve representing a function y = f(x)
 * with a <= x <= b. First, we split the interval [a, b] into n sub-intervals
 * with widths h1, h2, ... , hn by defining points x1, x2 , ... , xn-1 between a
 * and b. This defines points P0, P1, P2, ... , Pn on the curve whose
 * x-coordinates are a, x1, x2 , ... , xn-1, b and y-coordinates f(a), f(x1),
 * ..., f(xn-1), f(b) . By connecting these points, we obtain a polygonal path
 * approximating the curve.
 * 
 * Our task is to approximate the length of a parabolic arc representing the
 * curve y = x * x with x in the interval [0, 1]. We will take a common step h
 * between the points xi: h1, h2, ... , hn = h = 1/n and we will consider the
 * points P0, P1, P2, ... , Pn on the curve. The coordinates of each Pi are (xi,
 * yi = xi * xi).
 * 
 * The function len_curve (or similar in other languages) takes n as parameter
 * (number of sub-intervals) and returns the length of the curve. You can
 * truncate it to 9 decimal places.
 * 
 * @author Zver
 *
 */
public class ArcParabLen {
	public static void main(String[] args) {
		System.out.print("Enter the number of your's interval: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(lenCurve(n));
		sc.close();
	}

	public static double lenCurve(int n) {
		final double xSTART = 0;
		final double xSTOP = 1;
		double[] xCoordinates = new double[n + 1];
		double[] yCoordinates = new double[n + 1];
		xCoordinates[0] = 0.0;
		yCoordinates[0] = 0.0;
		double length = 0;
		double step = (xSTOP - xSTART) / n;
		for (int i = 0; i <= n; i++) {
			xCoordinates[i] += step * i;
			yCoordinates[i] = Math.pow(xCoordinates[i], 2);
		}
		for (int i = 0; i < n; i++) {
			length += Math.sqrt(Math.pow(xCoordinates[i + 1] - xCoordinates[i], 2)
					+ Math.pow(yCoordinates[i + 1] - yCoordinates[i], 2));
		}
		String result = String.format("%.9f", length).replace(',', '.');
		return Double.valueOf(result);
	}
}
