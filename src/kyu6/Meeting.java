package kyu6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * John has invited some friends. His list is:
 * 
 * s =
 * "Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";
 * Could you make a program that
 * 
 * makes this string uppercase
 * gives it sorted in alphabetical order by last name.
 * When the last names are the same, sort them by first name. Last name and
 * first name of a guest come in the result between parentheses separated by a
 * comma.
 * 
 * So the result of function meeting(s) will be:
 * 
 * "(CORWILL, ALFRED)(CORWILL, FRED)(CORWILL, RAPHAEL)(CORWILL,
 * WILFRED)(TORNBULL, BARNEY)(TORNBULL, BETTY)(TORNBULL, BJON)"
 * It can happen that in two distinct families with the same family name two
 * people have the same first name too.
 * 
 * Notes
 * You can see another examples in the "Sample tests".
 * 
 * @author SMD_ASY
 *
 */

public class Meeting {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(meeting(s));
        sc.close();
    }

    public static String meeting(String s) {
        List<Person> personList = new ArrayList<>();
        String[] persons = s.split(";");
        for (int i = 0; i < persons.length; i++) {
            String[] names = persons[i].split(":");
            personList.add(new Person(names[0], names[1]));
        }

        Comparator<Person> cmpLastName = (x, y) -> x.lastName.toUpperCase().compareTo(y.lastName.toUpperCase());
        Comparator<Person> cmpFirstName = (x, y) -> x.firstName.toUpperCase().compareTo(y.firstName.toUpperCase());

        personList.sort(cmpLastName.thenComparing(cmpFirstName));

        String ans = "";
        for (Person p : personList) {
            ans += p.toString();
        }

        return ans;
    }

}

class Person {
    String firstName;
    String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "(" + this.lastName.toUpperCase() + ", " + this.firstName.toUpperCase() + ")";
    }
}
