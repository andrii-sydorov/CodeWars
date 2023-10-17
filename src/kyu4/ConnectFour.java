package kyu4;

import java.util.*;
import java.util.stream.Collectors;

public class ConnectFour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // List<String> ls =
        // Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());
        List<String> myList = new ArrayList<String>(Arrays.asList(
                "A_Red",
                "B_Yellow",
                "A_Red",
                "B_Yellow",
                "A_Red",
                "B_Yellow",
                "G_Red",
                "B_Yellow"));
        System.out.println(whoIsWinner(myList));
        sc.close();
    }

    public static String whoIsWinner(List<String> piecesPositionList) {
        // return "Red" or "Yellow" or "Draw"
        int column = 7;
        int raw = 6;
        String[][] field = new String[raw][column];
        Map<String, Integer> map = getMap();
        for (String s : piecesPositionList) {
            String[] t = s.split("_");
            String key = t[0]; // letter
            String value = t[1]; // color
            int c = map.get(key);
            fillField(c, value, field);
        }
        // print(field);
        return getWinner(field);
    }

    private static String getWinner(String[][] field) {
        int raw = field.length;
        int column = field[0].length;
        for (int c = 0; c < column; c++) {
            for (int r = raw - 1; r >= 0; r--) {
                if (field[r][c] == null) {
                    break;
                } else {
                    if (isWinner(r, c, field)) {
                        return field[r][c];
                    }
                }
            }
        }
        return "Draw";
    }

    private static boolean isWinner(int r, int c, String[][] field) {
        String color = field[r][c];
        // vertical
        boolean verticalWin = false;
        int highLimitRaw = r - 3;
        if (highLimitRaw >= 0) {
            for (int i = r - 1; i <= highLimitRaw; i--) {
                verticalWin = true;
                if (!field[r][c].equals(color)) {
                    verticalWin = false;
                    break;
                }
            }
        }
        if (verticalWin) {
            return true;
        }
        // horizontal
        boolean horizontalWin = false;
        int highLimitColumn = c + 3;
        if (highLimitColumn < field[0].length) {
            for (int i = c + 1; i <= highLimitColumn; i++) {
                horizontalWin = true;
                if (!field[r][c].equals(color)) {
                    horizontalWin = false;
                    break;
                }
            }
        }
        if (horizontalWin) {
            return true;
        }
        // axillary diagonal
        boolean auxiliaryDiagonalWin = false;
        if (highLimitRaw >= 0 && highLimitColumn < field[0].length) {
            for (int i = 1; i <= 3; i++) {
                auxiliaryDiagonalWin = true;
                if (!field[r - i][c + i].equals(color)) {
                    auxiliaryDiagonalWin = false;
                    break;
                }
            }
        }
        if (auxiliaryDiagonalWin) {
            return true;
        }
        // main diagonal
        highLimitRaw = r - 3;
        highLimitColumn = c - 3;
        boolean mainDiagonalWin = false;
        if (highLimitColumn >= 0 && highLimitRaw >= 0) {
            for (int i = 1; i <= 3; i++) {
                mainDiagonalWin = true;
                if (!field[r - i][c - i].equals(color)) {
                    mainDiagonalWin = false;
                    break;
                }
            }
        }
        if (mainDiagonalWin) {
            return true;
        }
        return false;
    }

    private static Map<String, Integer> getMap() {
        Map<String, Integer> map = new HashMap<>();
        char key = 'A';
        int value = 0;
        while (key <= 'G') {
            map.put(String.valueOf(key), value);
            key++;
            value++;
        }
        return map;
    }

    private static void fillField(int column, String color, String[][] field) {
        for (int i = field.length - 1; i >= 0; i--) {
            if (field[i][column] == null) {
                field[i][column] = color;
                break;
            }
        }
    }

    private static void print(String[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }
}
