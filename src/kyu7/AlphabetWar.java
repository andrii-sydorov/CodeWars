package kyu7;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * Introduction
 * There is a war and nobody knows - the alphabet war!
 * There are two groups of hostile letters. The tension between left side
 * letters and right side letters was too high and the war began.
 * 
 * Task
 * Write a function that accepts fight string consists of only small letters and
 * return who wins the fight. When the left side wins return Left side wins!,
 * when the right side wins return Right side wins!, in other case return Let's
 * fight again!.
 * 
 * The left side letters and their power:
 * 
 * w - 4
 * p - 3
 * b - 2
 * s - 1
 * The right side letters and their power:
 * 
 * m - 4
 * q - 3
 * d - 2
 * z - 1
 * The other letters don't have power and are only victims.
 * 
 * Example
 * AlphabetWar("z"); //=> Right side wins!
 * AlphabetWar("zdqmwpbs"); //=> Let's fight again!
 * AlphabetWar("zzzzs"); //=> Right side wins!
 * AlphabetWar("wwwwwwz"); //=> Left side wins!
 * 
 * @author SMD_ASY
 *
 */

public class AlphabetWar {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        String fightString = scanner.nextLine();
        scanner.close();
        System.out.println(alphabetWar(fightString));
    }

    public static String alphabetWar(String fight) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('w', 4);
        map.put('p', 3);
        map.put('b', 2);
        map.put('s', 1);
        map.put('m', -4);
        map.put('q', -3);
        map.put('d', -2);
        map.put('z', -1);
        int count = 0;
        char[] arr = fight.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            count += map.getOrDefault(arr[i], 0);
        }
        return count > 0 ? "Left side wins!" : count < 0 ? "Right side wins!" : "Let's fight again!";
    }

}
