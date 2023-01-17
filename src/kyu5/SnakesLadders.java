package kyu5;

import java.util.HashMap;
import java.util.Map;

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
