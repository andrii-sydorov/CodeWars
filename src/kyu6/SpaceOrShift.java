package kyu6;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Some new cashiers started to work at your restaurant.
 * 
 * They are good at taking orders, but they don't know how to capitalize words,
 * or use a space bar!
 * 
 * All the orders they create look something like this:
 * 
 * "milkshakepizzachickenfriescokeburgerpizzasandwichmilkshakepizza"
 * 
 * The kitchen staff are threatening to quit, because of how difficult it is to
 * read the orders.
 * 
 * Their preference is to get the orders as a nice clean string with spaces and
 * capitals like so:
 * 
 * "Burger Fries Chicken Pizza Pizza Pizza Sandwich Milkshake Milkshake Coke"
 * 
 * The kitchen staff expect the items to be in the same order as they appear in
 * the menu.
 * 
 * The menu items are fairly simple, there is no overlap in the names of the
 * items:
 * 
 * 1. Burger
 * 2. Fries
 * 3. Chicken
 * 4. Pizza
 * 5. Sandwich
 * 6. Onionrings
 * 7. Milkshake
 * 8. Coke
 */

public class SpaceOrShift {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "milkshakepizzachickenfriescokeburgerpizzasandwichmilkshakepizza";
        sc.close();
        System.out.println(getOrder(input));
    }

    public static String getOrder(String input) {
        String[] menu = { "Burger", "Fries", "Chicken", "Pizza", "Sandwich", "Onionrings", "Milkshake", "Coke" };
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < menu.length;) {
            String s = menu[i].toLowerCase();
            if (input.indexOf(s) >= 0) {
                input = input.substring(0, input.indexOf(s)) + input.substring(input.indexOf(s) + s.length());
                ls.add(menu[i]);
                continue;
            }
            i++;
        }
        return String.join(" ", ls.toArray(new String[0]));
    }
}
