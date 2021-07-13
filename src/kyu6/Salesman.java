package kyu6;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * A traveling salesman has to visit clients. He got each client's address e.g.
 * "432 Main Long Road St. Louisville OH 43071" as a list.
 * 
 * The basic zipcode format usually consists of two capital letters followed by
 * a white space and five digits. The list of clients to visit was given as a
 * string of all addresses, each separated from the others by a comma, e.g. :
 * 
 * "123 Main Street St. Louisville OH 43071,432 Main Long Road St. Louisville OH
 * 43071,786 High Street Pollocksville NY 56432".
 * 
 * To ease his travel he wants to group the list by zipcode.
 * 
 * Task The function travel will take two parameters r (addresses' list of all
 * clients' as a string) and zipcode and returns a string in the following
 * format:
 * 
 * zipcode:street and town,street and town,.../house number,house number,...
 * 
 * The street numbers must be in the same order as the streets where they
 * belong.
 * 
 * If a given zipcode doesn't exist in the list of clients' addresses return
 * "zipcode:/"
 * 
 * Examples
 * 
 * r = "123 Main Street St. Louisville OH 43071,432 Main Long Road St.
 * Louisville OH 43071,786 High Street Pollocksville NY 56432"
 * 
 * travel(r, "OH 43071") --> "OH 43071:Main Street St. Louisville,Main Long Road
 * St. Louisville/123,432"
 * 
 * travel(r, "NY 56432") --> "NY 56432:High Street Pollocksville/786"
 * 
 * travel(r, "NY 5643") --> "NY 5643:/"
 * 
 * 
 * Note for Elixir: In Elixir the empty addresses' input is an empty list, not
 * an empty string.
 * 
 * Note: You can see a few addresses and zipcodes in the test cases.
 * 
 * @author SMD_ASY
 *
 */

public class Salesman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the comlepete adrees:");
		String r = sc.nextLine();
		System.out.println("Enter the zipcode:");
		String zipcode = sc.nextLine();
		sc.close();
		System.out.println(travel(r, zipcode));
	}

	public static String travel(String r, String zipcode) {
		String ans = zipcode + ":";
		String[] arrAdress = r.split(",");
		String[] arrZipcode = zipcode.split(" ");
		int lengthZipcode = arrZipcode.length;
		List<String> lsStreet = new ArrayList<>();
		List<String> lsHouse = new ArrayList<>();
		for (int i = 0; i < arrAdress.length; i++) {
			int matches = 0;
			String[] arrAdressWithSpace = arrAdress[i].split(" ");
			for (int j = 0; j < arrZipcode.length; j++) {
				for (int k = 0; k < arrAdressWithSpace.length; k++) {
					if (arrZipcode[j].equals(arrAdressWithSpace[k])) {
						matches++;
						continue;
					}
				}
			}
			if (matches == lengthZipcode) {
				int index = arrAdress[i].indexOf(zipcode);
				String before = arrAdress[i].substring(0, index - 1);
				String after = arrAdress[i].substring((zipcode.length() + index), arrAdress[i].length());
				String temp = before + after;
				String street = temp.substring(temp.indexOf(" ") + 1);
				String house = temp.substring(0, temp.indexOf(" "));
				lsStreet.add(street);
				lsHouse.add(house);
			}
		}
		if (lsStreet.size() == 0) {
			return ans + "/";
		}

		return ans + String.join(",", lsStreet.toArray(new String[lsStreet.size()])) + "/"
				+ String.join(",", lsHouse.toArray(new String[lsHouse.size()]));
	}

	/*
	 * public static String travel(String r, String zipcode) {
	 * if(zipcode.trim().length() < 8){ 
	 * return zipcode + ":/"; 
	 * }
	 * java.util.List<String> list = java.util.Arrays.stream(r.split(",")) .filter(s
	 * -> s.contains(zipcode)) .map(s -> s.replace(zipcode, ""))
	 * .collect(Collectors.toList()); 
	 * String codes = list.stream() .map(s -> s.split(" ")[0]) .collect(Collectors.joining(",")); 
	 * String addresses = list.stream() .map(s -> s.replace(s.split(" ")[0], "").trim())
	 * .collect(Collectors.joining(",")); 
	 * return String.format("%s:%s/%s", zipcode,addresses, codes); }
	 */

}
