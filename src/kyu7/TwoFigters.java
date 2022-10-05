package kyu7;

import java.util.Scanner;

/**
 * Create a function that returns the name of the winner in a fight between two
 * fighters.
 * 
 * Each fighter takes turns attacking the other and whoever kills the other
 * first is victorious. Death is defined as having health <= 0.
 * 
 * Each fighter will be a Fighter object/instance. See the Fighter class below
 * in your chosen language.
 * 
 * Both health and damagePerAttack (damage_per_attack for python) will be
 * integers larger than 0. You can mutate the Fighter objects.
 * 
 * Example:
 * declare_winner(Fighter("Lew", 10, 2), Fighter("Harry", 5, 4), "Lew") => "Lew"
 * 
 * Lew attacks Harry; Harry now has 3 health.
 * Harry attacks Lew; Lew now has 6 health.
 * Lew attacks Harry; Harry now has 1 health.
 * Harry attacks Lew; Lew now has 2 health.
 * Lew attacks Harry: Harry now has -1 health and is dead. Lew wins.
 * 
 * public class Fighter {
 *  public String name;
 *  public int health, damagePerAttack;
 *  public Fighter(String name, int health, int damagePerAttack) {
 *      this.name = name;
 *      this.health = health;
 *      this.damagePerAttack = damagePerAttack;
 *  }
 * }
 * 
 * @author SMD_ASY
 *
 */

public class TwoFigters {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        Fighter fighter1 = new Fighter(scanner.nextLine(), Integer.valueOf(scanner.nextLine()),
                Integer.valueOf(scanner.nextLine()));
        Fighter fighter2 = new Fighter(scanner.nextLine(), Integer.valueOf(scanner.nextLine()),
                Integer.valueOf(scanner.nextLine()));
        String firstAttackerString = scanner.nextLine();
        scanner.close();
        System.out.println(declareWinner(fighter1, fighter2, firstAttackerString));
    }

    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        Fighter[] fighters = null;
        if (firstAttacker.equals(fighter1.name)) {
            fighters = new Fighter[] { fighter1, fighter2 };
        } else {
            fighters = new Fighter[] { fighter2, fighter1 };
        }
        int turns = 0;
        while (fighter1.health > 0 && fighter2.health > 0) {
            fighters[(turns + 1) % fighters.length].health -= fighters[turns % fighters.length].damagePerAttack;
            turns++;
        }
        return fighter1.health > 0 ? fighter1.name : fighter2.name;
    }

}

class Fighter {

    public String name;
    public int health;
    public int damagePerAttack;

    public Fighter(String name, int health, int damagePerAttack) {
        this.name = name;
        this.health = health;
        this.damagePerAttack = damagePerAttack;
    }
}
