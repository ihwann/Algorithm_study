package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {
        System.out.println(3%0);

        //System.out.println(isValidSudoku(new char[][]{}));
    }


    public static boolean isValidSudoku(char[][] board) {
        Set<Integer> columnSet = new HashSet<>();
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> bokSet = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                if (!columnSet.add(Character.getNumericValue(board[i][j]))
                    || !rowSet.add(Character.getNumericValue(board[j][i]))
                    || !bokSet.add(Character.getNumericValue(board[i][j]))) {
                    return false;
                }
            }
            rowSet.clear();
        }

        return true;
    }
}
