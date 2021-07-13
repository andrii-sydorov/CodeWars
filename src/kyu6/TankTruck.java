package kyu6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * To introduce the problem think to my neighbor who drives a tanker truck. The
 * level indicator is down and he is worried because he does not know if he will
 * be able to make deliveries. We put the truck on a horizontal ground and
 * measured the height of the liquid in the tank.
 * 
 * Fortunately the tank is a perfect cylinder and the vertical walls on each end
 * are flat. The height of the remaining liquid is h, the diameter of the
 * cylinder is d, the total volume is vt (h, d, vt are positive or null
 * integers). You can assume that h <= d.
 * 
 * Could you calculate the remaining volume of the liquid? Your function
 * tankvol(h, d, vt) returns an integer which is the truncated result (e.g
 * floor) of your float calculation.
 * 
 * Examples:
 * 
 * tankvol(40,120,3500) 
 * should return 1021 (calculation gives about: 1021.26992027)
 * 
 * tankvol(60,120,3500) 
 * should return 1750
 * 
 * tankvol(80,120,3500) 
 * should return 2478 (calculation gives about: 2478.73007973)
 * 
 * @author SMD_ASY
 *
 */

public class TankTruck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] in = sc.nextLine().split(" ");
		int[] data = Arrays.stream(in).mapToInt(Integer::valueOf).toArray();
		System.out.println(calculateVolume(data[0], data[1], data[2]));
	}

	public static int calculateVolume(int h, int d, int vol) {
		double r = (double) d / 2;
		double tempH = h > r ? h - r : r - h;
		double square = Math.PI * Math.pow(r, 2);
		double angle = 2 * Math.acos((double) tempH / r);
		double squareOfSector = square * angle / (2 * Math.PI);
		double squareOfTriangle = (double) 1 / 2 * r * r * Math.sin(angle);
		double squareOf = squareOfSector - squareOfTriangle;
		return (int) (h > d / 2 ? (square - squareOf) / square * vol : (squareOf / square) * vol);
	}

}
