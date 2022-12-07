package kyu6;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Short Intro
 * 
 * Some of you might remember spending afternoons playing Street Fighter 2 in
 * some Arcade back in the 90s or emulating it nowadays with the numerous
 * emulators for retro consoles.
 * 
 * Can you solve this kata? Suuure-You-Can!
 * 
 * UPDATE: a new kata's harder version is available here.
 * 
 * The Kata
 * 
 * You'll have to simulate the video game's character selection screen
 * behaviour, more specifically the selection grid. Such screen looks like this:
 * 
 * Screen:
 * 
 * screen
 * 
 * Selection Grid Layout in text:
 * 
 * | Ryu | E.Honda | Blanka | Guile | Balrog | Vega |
 * | Ken | Chun Li | Zangief | Dhalsim | Sagat | M.Bison |
 * Input
 * 
 * the list of game characters in a 2x6 grid;
 * the initial position of the selection cursor (top-left is (0,0));
 * a list of moves of the selection cursor (which are up, down, left, right);
 * Output
 * 
 * the list of characters who have been hovered by the selection cursor after
 * all the moves (ordered and with repetition, all the ones after a move,
 * whether successful or not, see tests);
 * Rules
 * 
 * Selection cursor is circular horizontally but not vertically!
 * 
 * As you might remember from the game, the selection cursor rotates
 * horizontally but not vertically; that means that if I'm in the leftmost and I
 * try to go left again I'll get to the rightmost (examples: from Ryu to Vega,
 * from Ken to M.Bison) and vice versa from rightmost to leftmost.
 * 
 * Instead, if I try to go further up from the upmost or further down from the
 * downmost, I'll just stay where I am located (examples: you can't go lower
 * than lowest row: Ken, Chun Li, Zangief, Dhalsim, Sagat and M.Bison in the
 * above image; you can't go upper than highest row: Ryu, E.Honda, Blanka,
 * Guile, Balrog and Vega in the above image).
 * 
 * Test
 * 
 * For this easy version the fighters grid layout and the initial position will
 * always be the same in all tests, only the list of moves change.
 * 
 * Notice: changing some of the input data might not help you.
 * 
 * Examples
 * 
 * fighters = [
 * ["Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega"],
 * ["Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison"]
 * ]
 * initial_position = (0,0)
 * moves = ['up', 'left', 'right', 'left', 'left']
 * then I should get:
 * 
 * ['Ryu', 'Vega', 'Ryu', 'Vega', 'Balrog']
 * as the characters I've been hovering with the selection cursor during my
 * moves. Notice: Ryu is the first just because it "fails" the first up See test
 * cases for more examples.
 * 
 * fighters = [
 * ["Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega"],
 * ["Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison"]
 * ]
 * initial_position = (0,0)
 * moves = ['right', 'down', 'left', 'left', 'left', 'left', 'right']
 * Result:
 * 
 * ['E.Honda', 'Chun Li', 'Ken', 'M.Bison', 'Sagat', 'Dhalsim', 'Sagat']
 */

public class CharacterSelection {
    public static void main(String[] args) {
        String[][] fighters = new String[][] {
                new String[] { "Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega" },
                new String[] { "Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison" },
        };
        int[] position = new int[] { 0, 0 };
        String[] moves = new String[] { "up", "left", "down", "right", "up",
                "left", "down", "right" };
        System.out.println(Arrays.toString(streetFighterSelection(fighters, position, moves)));
    }

    public static String[] streetFighterSelection(String[][] fighters, int[] position, String[] moves) {
        List<String> res = new ArrayList<>();
        int raw = position[0];
        int column = position[1];
        for (String s : moves) {
            switch (s) {
                case "right":
                    column = (column + 1) % fighters[raw].length;
                    res.add(fighters[raw][column]);
                    break;
                case "left":
                    column = column - 1 >= 0 ? column - 1 : fighters[raw].length - 1;
                    res.add(fighters[raw][column]);
                    break;
                case "up":
                    if (raw != 0) {
                        raw--;
                    }
                    res.add(fighters[raw][column]);
                    break;
                case "down":
                    if (raw != fighters.length - 1) {
                        raw++;
                    }
                    res.add(fighters[raw][column]);
                    break;
            }

        }
        return res.toArray(new String[res.size()]);
    }
}