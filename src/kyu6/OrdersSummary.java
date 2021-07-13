package kyu6;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Clients place orders to a stockbroker as strings. The order can be simple or
 * multiple or empty.
 * 
 * Type of a simple order:
 * Quote/white-space/Quantity/white-space/Price/white-space/Status
 * 
 * where Quote is formed of non-whitespace character, Quantity is an int, Price
 * a double (with mandatory decimal point "." ), Status is represented by the
 * letter B (buy) or the letter S (sell).
 * 
 * Example: "GOOG 300 542.0 B"
 * 
 * A multiple order is the concatenation of simple orders with a comma between
 * each.
 * 
 * Example: "ZNGA 1300 2.66 B, CLH15.NYM 50 56.32 B, OWW 1000 11.623 B, OGG 20
 * 580.1 B"
 * 
 * or
 * 
 * "ZNGA 1300 2.66 B,CLH15.NYM 50 56.32 B,OWW 1000 11.623 B,OGG 20 580.1 B"
 * 
 * To ease the stockbroker your task is to produce a string of type
 * 
 * "Buy: b Sell: s" where b and s are 'double' formatted with no decimal, b
 * representing the total price of bought stocks and s the total price of sold
 * stocks.
 * 
 * Example: "Buy: 294990 Sell: 0"
 * 
 * Unfortunately sometimes clients make mistakes. When you find mistakes in
 * orders, you must pinpoint these badly formed orders and produce a string of
 * type:
 * 
 * "Buy: b Sell: s; Badly formed nb: badly-formed 1st simple order ;badly-formed
 * nth simple order ;"
 * 
 * where nb is the number of badly formed simple orders, b representing the
 * total price of bought stocks with correct simple order and s the total price
 * of sold stocks with correct simple order.
 * 
 * Examples: "Buy: 263 Sell: 11802; Badly formed 2: CLH16.NYM 50 56 S ;OWW 1000
 * 11 S ;"
 * 
 * "Buy: 100 Sell: 56041; Badly formed 1: ZNGA 1300 2.66 ;"
 * 
 * Notes: 
 * If the order is empty, Buy is 0 and Sell is 0 hence the return is: "Buy: 0 Sell: 0".
 *  Due to Codewars whitespace differences will not always show up in test results. 
 * With Golang (and maybe others) you can use a format with "%.0f" for "Buy" and "Sell".
 * 
 * @author SMD_ASY
 *
 */

public class OrdersSummary {

	public static String test = "ZNGA 1300 2.66 B, CLH15.NYM 50 56.32 B, OWW 1000 11.623 B, OGG 20 580.1 B";
	public static String test1 = "GOOG 90 160.45 B, JPMC 67 12.8 S, MYSPACE 24.0 210 B, CITI 50 450 B, CSCO 100 55.5 S";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(balanceStatements(test));
		System.out.println(balanceStatements(test1));
	}

	public static String balanceStatements(String lst) {
		String[] orders = lst.split(",");
		List<String> incorrectOrders = new ArrayList<>();
		double sold = 0;
		double buied = 0;
		for (int i = 0; i < orders.length; i++) {

			String[] membersOrders = orders[i].trim().split(" ");
			if (membersOrders.length != 4) {
				incorrectOrders.add(orders[i]);
				continue;
			}
			if (membersOrders[1].contains(".") || !membersOrders[2].contains(".")) {
				incorrectOrders.add(orders[i]);
				continue;
			}

			int quantity = 0;
			double price = 0.0;
			String action = "";

			try {
				String.valueOf(membersOrders[0]);
				quantity += Integer.valueOf(membersOrders[1]);
				price += Double.valueOf(membersOrders[2]);
				action += String.valueOf(membersOrders[3]);
			} catch (NumberFormatException nfe) {
				incorrectOrders.add(orders[i]);
				continue;
			}

			if (action.equals("S")) {
				sold += price * quantity;
			} else if (action.equals("B")) {
				buied += price * quantity;
			} else {
				incorrectOrders.add(orders[i]);
			}

		}

		String buy = "Buy: " + Math.round(buied);
		String sell = "Sell: " + Math.round(sold);
		if (lst.isEmpty()) {
			return buy + " " + sell;
		}
		if (incorrectOrders.size() == 0) {
			return buy + " " + sell;
		} else {
			String badlyFormed = "";
			for (int i = 0; i < incorrectOrders.size(); i++) {
				badlyFormed += incorrectOrders.get(i).trim() + " ;";
			}
			String bad = "Badly formed " + incorrectOrders.size() + ": " + badlyFormed;
			return buy + " " + sell + "; " + bad;
		}
	}
	
	
	  public static String balanceStatementsCodeWars(String lst) {
		    String[] orders = lst.split(", ");
		    String error = "";
		    int cnt = 0;
		    double buy = 0;
		    double sell = 0;
		        
		    for(String order : orders) {
		      if(order.isEmpty()) continue;
		      
		      if(!order.matches("[\\w\\.]+ [0-9]+ [0-9]*\\.[0-9]+ [BS]")) {
		        error += order + " ;";
		        cnt++;
		        continue;
		      }
		      
		      Scanner sc = new Scanner(order);
		      sc.next();
		      int quantity = sc.nextInt();
		      double price = sc.nextDouble();
		      if(sc.next().equals("B")) {
		        buy += quantity * price;
		      } else {
		        sell += quantity * price;
		      }
		    }
		    
		    String res = String.format("Buy: %.0f Sell: %.0f", buy, sell);
		    if(!error.isEmpty()) res += String.format("; Badly formed %d: %s", cnt, error);
		    return res;
		  }

}
