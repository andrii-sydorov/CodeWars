package kyu5;

import java.util.HashMap;
import java.util.Map;

/**
 * Introduction
 * Snakes and Ladders is an ancient Indian board game regarded today as a
 * worldwide classic. It is played between two or more players on a gameboard
 * having numbered, gridded squares. A number of "ladders" and "snakes" are
 * pictured on the board, each connecting two specific board squares. (Source
 * Wikipedia)
 * 
 * Task
 * Your task is to make a simple class called SnakesLadders. The test cases will
 * call the method play(die1, die2) independantly of the state of the game or
 * the player turn. The variables die1 and die2 are the die thrown in a turn and
 * are both integers between 1 and 6. The player will move the sum of die1 and
 * die2.
 * 
 * Rules
 * 1. There are two players and both start off the board on square 0.
 * 
 * 2. Player 1 starts and alternates with player 2.
 * 
 * 3. You follow the numbers up the board in order 1=>100
 * 
 * 4. If the value of both die are the same then that player will have another
 * go.
 * 
 * 5. Climb up ladders. The ladders on the game board allow you to move upwards
 * and get ahead faster. If you land exactly on a square that shows an image of
 * the bottom of a ladder, then you may move the player all the way up to the
 * square at the top of the ladder. (even if you roll a double).
 * 
 * 6. Slide down snakes. Snakes move you back on the board because you have to
 * slide down them. If you land exactly at the top of a snake, slide move the
 * player all the way to the square at the bottom of the snake or chute. (even
 * if you roll a double).
 * 
 * 7. Land exactly on the last square to win. The first person to reach the
 * highest square on the board wins. But there's a twist! If you roll too high,
 * your player "bounces" off the last square and moves back. You can only win by
 * rolling the exact number needed to land on the last square. For example, if
 * you are on square 98 and roll a five, move your game piece to 100 (two
 * moves), then "bounce" back to 99, 98, 97 (three, four then five moves.)
 * 
 * 8. If the Player rolled a double and lands on the finish square “100” without
 * any remaining moves then the Player wins the game and does not have to roll
 * again.
 * 
 * Returns
 * Return Player n Wins!. Where n is winning player that has landed on square
 * 100 without any remainding moves left.
 * 
 * Return Game over! if a player has won and another player tries to play.
 * 
 * Otherwise return Player n is on square x. Where n is the current player and x
 * is the sqaure they are currently on.
 * Good luck and enjoy!
 */

public class SnakesLadders {
    Map<Integer, Integer> map;
    int firstPlayerPoints = 0;
    int secondPlayerPoints = 0;
    int count = 1;

    public SnakesLadders() {
        map = makeMap();
    };

    public Map<Integer, Integer> makeMap() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(2, 38);
        map.put(7, 14);
        map.put(8, 31);
        map.put(15, 26);
        map.put(16, 6);
        map.put(21, 42);
        map.put(28, 84);
        map.put(36, 44);
        map.put(46, 25);
        map.put(49, 11);
        map.put(51, 67);
        map.put(62, 19);
        map.put(64, 60);
        map.put(71, 91);
        map.put(74, 53);
        map.put(78, 98);
        map.put(87, 94);
        map.put(89, 68);
        map.put(92, 88);
        map.put(95, 75);
        map.put(99, 80);
        return map;
    }

    public String play(int die1, int die2) {
        if (firstPlayerPoints == 100 || secondPlayerPoints == 100) {
            return "Game over!";
        }
        switch (count % 2) {
            case 1:
                firstPlayerPoints += die1 + die2;
                if (firstPlayerPoints > 100) {
                    firstPlayerPoints = 100 - (firstPlayerPoints - 100);
                }
                if (firstPlayerPoints == 100) {
                    return "Player 1 Wins!";
                }
                firstPlayerPoints = map.getOrDefault(firstPlayerPoints, firstPlayerPoints);
                if (die1 != die2) {
                    count++;
                }
                return String.format("Player 1 is on square %d", firstPlayerPoints);
            case 0:
                secondPlayerPoints += die1 + die2;
                if (secondPlayerPoints > 100) {
                    secondPlayerPoints = 100 - (secondPlayerPoints - 100);
                }
                if (secondPlayerPoints == 100) {
                    return "Player 2 Wins!";
                }
                secondPlayerPoints = map.getOrDefault(secondPlayerPoints, secondPlayerPoints);
                if (die1 != die2) {
                    count++;
                }
                return String.format("Player 2 is on square %d", secondPlayerPoints);
        }
        return "";
    }

}
