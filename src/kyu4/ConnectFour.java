package kyu4;

import java.util.*;
import java.util.stream.Collectors;

public class ConnectFour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // List<String> ls =
        // Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());
        List<String>[] myList = new List[3];

        myList[0] = new ArrayList<String>(Arrays.asList(
                "A_Red",
                "B_Yellow",
                "A_Red",
                "B_Yellow",
                "A_Red",
                "B_Yellow",
                "G_Red",
                "B_Yellow"));
        myList[1] = new ArrayList<String>(Arrays.asList(
                "C_Yellow",
                "E_Red",
                "G_Yellow",
                "B_Red",
                "D_Yellow",
                "B_Red",
                "B_Yellow",
                "G_Red",
                "C_Yellow",
                "C_Red",
                "D_Yellow",
                "F_Red",
                "E_Yellow",
                "A_Red",
                "A_Yellow",
                "G_Red",
                "A_Yellow",
                "F_Red",
                "F_Yellow",
                "D_Red",
                "B_Yellow",
                "E_Red",
                "D_Yellow",
                "A_Red",
                "G_Yellow",
                "D_Red",
                "D_Yellow",
                "C_Red"));
        myList[2] = new ArrayList<String>(Arrays.asList(
                "A_Yellow",
                "B_Red",
                "B_Yellow",
                "C_Red",
                "G_Yellow",
                "C_Red",
                "C_Yellow",
                "D_Red",
                "G_Yellow",
                "D_Red",
                "G_Yellow",
                "D_Red",
                "F_Yellow",
                "E_Red",
                "D_Yellow"));
                System.out.println(whoIsWinner(myList[0]));
                System.out.println(whoIsWinner2(myList[0]));
         sc.close();
    }

    public static String whoIsWinner(List<String> piecesPositionList) {
        int column = 7;
        int raw = 6;
        String[][] field = new String[raw][column];
        Map<String, Integer> map = getMap();
        String result = null;
        int count = 0;
        for (String s : piecesPositionList) {
            String[] t = s.split("_");
            String key = t[0]; // letter
            String value = t[1]; // color
            int c = map.get(key);
            fillField(c, value, field);
            count++;
            if (count > 6) {
                result = getWinner(field);
                if (!result.equals("Draw")) {
                    return result;
                }
            }
        }
        // print(field);
        return count < 6 ? "Draw" : result;
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
            for (int i = r - 1; i >= highLimitRaw; i--) {
                verticalWin = true;
                if (field[i][c] == null || !field[i][c].equals(color)) {
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
                if (field[r][i] == null || !field[r][i].equals(color)) {
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
                if (field[r - i][c + i] == null || !field[r - i][c + i].equals(color)) {
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
                if (field[r - i][c - i] == null || !field[r - i][c - i].equals(color)) {
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

    public static String whoIsWinner2(List<String> piecesPositionList) {
        var board = new String[7][6];
        for (String piece : piecesPositionList)
        {
            int row, column = piece.charAt(0) - 'A';
            for (row = 0; board[column][row] != null; row++);

            board[column][row] = piece.substring(2);
            for (var move : new int[][] { { 0, 1 }, { 1, 0 }, { 1, 1 }, { 1, -1 } })
            {
                for (int n = 0, f = 1; f >= -1; f -= 2)
                {
                    for (int c = column, r = row; c >= 0 && c < 7 && r >= 0 && r < 6 && piece.substring(2).equals(board[c][r]); c += move[0] * f, r += move[1] * f)
                    {
                        if (++n > 4)
                        {
                            return piece.substring(2);
                        }
                    }
                }
            }
        }
        return "Draw";
    }
}
