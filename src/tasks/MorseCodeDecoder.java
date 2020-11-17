package tasks;
import java.util.Scanner;

public class MorseCodeDecoder {
	public static void main(String[] args) {
		System.out.println("Enter your MorseCode:");
		Scanner sc = new Scanner(System.in);
		String morseCode = sc.nextLine();
		System.out.println(decode(morseCode));
		sc.close();
	}

	public static String decode(String morseCode) {
		String ans = "";
		String[] words = morseCode.split("   ");
		for (int i = 0; i < words.length; i++) {
			String[] letters = words[i].split(" ");
			for (int j = 0; j < letters.length; j++) {
				String a = get(letters[j]);
				ans += get(letters[j]);
			}
			ans += " ";
		}
		return ans;
	}

	public static String get(String a) {
		switch (a) {
		case ".-":
			return "A";
		case "-...":
			return "B";
		case "-.-.":
			return "C";
		case "-..":
			return "D";
		case ".":
			return "E";
		case "..-.":
			return "F";
		case "--.":
			return "G";
		case "....":
			return "H";
		case "..":
			return "I";
		case ".---":
			return "J";
		case "-.-":
			return "K";
		case ".-..":
			return "L";
		case "--":
			return "M";
		case "-.":
			return "N";
		case "----":
			return "O";
		case ".--.":
			return "P";
		case "--.-":
			return "Q";
		case ".-.":
			return "R";
		case "...":
			return "S";
		case "-":
			return "T";
		case "..-":
			return "U";
		case "...-":
			return "V";
		case ".--":
			return "W";
		case "-..-":
			return "X";
		case "-.--":
			return "Y";
		case "--..":
			return "Z";
		case ".----":
			return "1";
		case "..---":
			return "2";
		case "...--":
			return "3";
		case "....-":
			return "4";
		case ".....":
			return "5";
		case "-....":
			return "6";
		case "--...":
			return "7";
		case "---..":
			return "8";
		case "----.":
			return "9";
		case "-----":
			return "10";
		}
		return a;
	}
}
