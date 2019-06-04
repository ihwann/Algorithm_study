package Brute_Force;

import java.util.Scanner;

public class Q_2580 {
    static final int n = 9;
    static int[][] sudoku = new int[n][n];
    static boolean[][] check_row = new boolean[n][10]; // i 행에 숫자 j가 있으면 true;
    static boolean[][] check_col = new boolean[n][10]; // i 열에 숫자 j가 있으면 true;
    static boolean[][] check_box = new boolean[n][10]; // i 번째 박스에 숫자 j가 있으면 true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sudoku[i][j] = sc.nextInt();
                if (sudoku[i][j] != 0) {
                    check_row[i][sudoku[i][j]] = true;
                    check_col[j][sudoku[i][j]] = true;
                    check_box[(i / 3) * 3 + (j / 3)][sudoku[i][j]] = true;
                }
            }
        }
        sc.close();
        solve(sudoku, check_row, check_col, check_box, 0);
    }

    private static boolean solve(int[][] sudoku, boolean[][] check_row, boolean[][] check_col, boolean[][] check_box, int num) {
        if (num == 81) { // 0~80 까지 숫자를 입력, 81은 모든 숫자를 입력했으므로 출력
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(sudoku[i][j] + " ");
                }
                System.out.println();
            }
            return true;
        } else {
            int x = num / n;
            int y = num % n;
            if (sudoku[x][y] != 0) {
                return solve(sudoku, check_row, check_col, check_box, num + 1);
            } else {
                for (int i = 1; i <= 9; i++) {
                    if (!check_row[x][i] && !check_col[y][i] && !check_box[(x / 3) * 3 + (y / 3)][i]) {
                        check_row[x][i] = check_col[y][i] = check_box[(x / 3) * 3 + (y / 3)][i] = true;
                        sudoku[x][y] = i;
                        if (solve(sudoku, check_row, check_col, check_box, num + 1)) {
                            return true;
                        }
                        sudoku[x][y] = 0;
                        check_row[x][i] = check_col[y][i] = check_box[(x / 3) * 3 + (y / 3)][i] = false;
                    }
                }
            }
        }
        return false;
    }
}
