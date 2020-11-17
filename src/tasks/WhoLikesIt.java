package tasks;

import java.util.Scanner;

/**
 * You probably know the "like" system from Facebook and other pages. People can
 * "like" blog posts, pictures or other items. We want to create the text that
 * should be displayed next to such an item.
 * 
 * Implement a function likes :: [String] -> String, which must take in input
 * array, containing the names of people who like an item. It must return the
 * display text as shown in the examples:
 * 
 * likes {} // must be "no one likes this" 
 * likes {"Peter"} // must be "Peter likes this" 
 * likes {"Jacob", "Alex"} // must be "Jacob and Alex like this"
 * likes {"Max", "John", "Mark"} // must be "Max, John and Mark like this" 
 * likes {"Alex", "Jacob", "Mark", "Max"} // must be "Alex, Jacob and 2 others like
 * this" 
 * For 4 or more names, the number in and 2 others simply increases.
 * 
 * @author SMD_ASY
 *
 */
public class WhoLikesIt {
	public static void main(String[] args) {
		System.out.println("Enter the names:");
		Scanner sc = new Scanner(System.in);
		String[] in = sc.nextLine().split(" ");
		System.out.println(whoLikesIt(in));
		sc.close();
	}

	public static String whoLikesIt(String[] in) {
		StringBuilder sb = new StringBuilder();
		switch (in.length) {
		case 0:
			sb.append("no one likes this");
			break;
		case 1:
			sb.append(in[0] + " likes this");
			break;
		case 2:
			sb.append(in[0] + " and " + in[1] + " like this");
			break;
		case 3:
			sb.append(in[0] + ", " + in[1] + " and " + in[2] + " like this");
			break;
		default:
			sb.append(in[0] + ", " + in[1] + " and " + (in.length - 2) + " others like this");
			break;
		}
		return sb.toString();
	}
}
