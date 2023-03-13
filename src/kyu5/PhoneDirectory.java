package kyu5;

//import java.util.Scanner;

/**
 * John keeps a backup of his old personal phone book as a text file. On each
 * line of the file he can find the phone number (formated as +X-abc-def-ghij
 * where X stands for one or two digits), the corresponding name between < and >
 * and the address.
 * 
 * Unfortunately everything is mixed, things are not always in the same order;
 * parts of lines are cluttered with non-alpha-numeric characters (except inside
 * phone number and name).
 * 
 * Examples of John's phone book lines:
 * 
 * "/+1-541-754-3010 156 Alphand_St. <J Steeve>\n"
 * 
 * " 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010!\n"
 * 
 * "<Anastasia> +48-421-674-8974 Via Quirinal Roma\n"
 * 
 * Could you help John with a program that, given the lines of his phone book
 * and a phone number num returns a string for this number : "Phone => num, Name
 * => name, Address => adress"
 * 
 * Examples:
 * s = "/+1-541-754-3010 156 Alphand_St. <J Steeve>\n 133, Green, Rd. <E Kustur>
 * NY-56423 ;+1-541-914-3010!\n"
 * 
 * phone(s, "1-541-754-3010") should return "Phone => 1-541-754-3010, Name => J
 * Steeve, Address => 156 Alphand St."
 * It can happen that there are many people for a phone number num, then return
 * : "Error => Too many people: num"
 * 
 * or it can happen that the number num is not in the phone book, in that case
 * return: "Error => Not found: num"
 * 
 * Notes
 * Codewars stdout doesn't print part of a string when between < and >
 * 
 * You can see other examples in the test cases.
 * 
 * JavaScript random tests completed by @matt c.
 */

public class PhoneDirectory {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        String strng = null;
        String num = null;
        strng = "/+1-541-754-3010 156 Alphand_St. <J Steeve>\n" +
                "133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010\n" +
                "+1-541-984-3012 <P Reed> /PO Box 530; Pollocksville, NC-28573\n" +
                ":+1-321-512-2222 <Paul Dive> Sequoia Alley PQ-67209\n" +
                "+1-741-984-3090 <Peter Reedgrave> _Chicago\n" +
                ":+1-921-333-2222 <Anna Stevens> Haramburu_Street AA-67209\n" +
                "+1-111-544-8973 <Peter Pan> LA\n" +
                "+1-921-512-2222 <Wilfrid Stevens> Wild Street AA-67209\n" +
                "<Peter Gone> LA ?+1-121-544-8974\n" +
                "<R Steell> Quora Street AB-47209 +1-481-512-2222\n" +
                "<Arthur Clarke> San Antonio $+1-121-504-8974 TT-45120\n" +
                "<Ray Chandler> Teliman Pk. !+1-681-512-2222! AB-47209,\n" +
                "<Sophia Loren> +1-421-674-8974 Bern TP-46017\n" +
                "<Peter O'Brien> High Street +1-908-512-2222; CC-47209\n" +
                "<Anastasia> +48-421-674-8974 Via Quirinal Roma\n" +
                "<P Salinger> Main Street, +1-098-512-2222, Denver\n" +
                "<C Powel> *+19-421-674-8974 Chateau des Fosses Strasbourg F-68000\n" +
                "<Bernard Deltheil> +1-498-512-2222; Mount Av.  Eldorado\n" +
                "+1-099-500-8000 <Peter Crush> Labrador Bd.\n" +
                "+1-931-512-4855 <William Saurin> Bison Street CQ-23071\n" +
                "<P Salinge> Main Street, +1-098-512-2222, Denve\n" +
                "<P Salinge> Main Street, +1-098-512-2222, Denve\n" +
                "/+5-541-754-3010 156 Alphandria_Street. <Jr Part>\n" +
                "1333, Green, Road <F Fulgur> NW-46423 ;+6-541-914-3010!\n" +
                "+5-541-984-3012 <Peter Reeves> /PO Box 5300; Albertville, SC-28573\n" +
                ":+5-321-512-2222 <Paulo Divino> Boulder Alley ZQ-87209\n" +
                "+3-741-984-3090 <F Flanaghan> _Chicago Av.\n" +
                ":+3-921-333-2222 <Roland Scorsini> Bellevue_Street DA-67209\n" +
                "+8-111-544-8973 <Laurence Pantow> SA\n" +
                "+8-921-512-2222 <Raymond Stevenson> Joly Street EE-67209\n" +
                "<John Freeland> Mantow ?+2-121-544-8974\n" +
                "<Robert Mitch> Eleonore Street QB-87209 +2-481-512-2222?\n" +
                "<Arthur Paternos> San Antonio $+7-121-504-8974 TT-45121\n" +
                "<Ray Charles> Stevenson Pk. !+7-681-512-2222! CB-47209,\n" +
                "<JP Gorce> +9-421-674-8974 New-Bern TP-16017\n" +
                "<P McDon> Revolution Street +2-908-512-2222; PP-47209\n" +
                "<Elizabeth Corber> +8-421-674-8974 Via Papa Roma\n" +
                "<C Saborn> Main Street, +15-098-512-2222, Boulder\n" +
                "<Colin Marshall> *+9-421-674-8974 Edinburgh UK\n" +
                "<Bernard Povit> +3-498-512-2222; Hill Av.  Cameron\n" +
                "+12-099-500-8000 <Pete Highman> Ontario Bd.\n" +
                "+8-931-512-4855 <W Mount> Oxford Street CQ-23071\n" +
                "<Donald Drinkaw> Moon Street, +3-098-512-2222, Peterville\n";
        num = "1-481-512-2222";
        num = "1-541-984-3012";
        num = "8-421-674-8974";
        num = "6-541-914-3010";
        // sc.close();
        System.out.println(phone(strng, num));
    }

    public static String phone(String strng, String num) {
        int count = 0;
        String[] lines = strng.split("\n");
        String name = null;
        String phone = null;
        String address = null;
        for (String s : lines) {
            if (!s.contains("+" + num)) {
                continue;
            }
            if (count == 1) {
                return String.format("Error => Too many people: %s", num);
            }
            name = s.substring(s.indexOf("<") + 1, s.indexOf(">"));
            s = s.substring(0, s.indexOf("<")) + s.substring(s.indexOf(">") + 1);
            StringBuilder sb = new StringBuilder();
            int index = s.indexOf("+");
            int firstIndex = index + 1;
            int lastIndex = firstIndex;
            for (int i = index + 1; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i)) || s.charAt(i) == '-') {
                    sb.append(s.charAt(i));
                } else {
                    lastIndex = i;
                    break;
                }
            }

            if (lastIndex == firstIndex) {
                lastIndex = s.length() - 1;
            }

            phone = sb.toString();

            if (index == 0) {
                s = s.replace(Character.toString(s.charAt(index)) + phone + Character.toString(s.charAt(lastIndex)),
                        "");
            } else if (lastIndex == s.length() - 1) {
                s = s.replace(Character.toString(s.charAt(index - 1)) + Character.toString(s.charAt(index)) + phone,
                        "");
            } else if (lastIndex < s.length()) {
                s = s.replace(
                        Character.toString(s.charAt(index - 1)) + Character.toString(s.charAt(index)) + phone
                                + Character.toString(s.charAt(lastIndex)),
                        "");
            }

            s = s.replaceAll("[;/_,!]", " ");
            s = s.trim();

            sb.setLength(0);

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    if (s.charAt(i - 1) == ' ') {
                        continue;
                    }
                }
                sb.append(s.charAt(i));

            }

            address = sb.toString();
            count++;
        }
        if (count == 0) {
            return String.format("Error => Not found: %s", num);
        }
        return String.format("Phone => %s, Name => %s, Address => %s", phone, name, address);
    }
}
