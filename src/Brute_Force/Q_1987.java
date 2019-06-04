package Brute_Force;

import java.util.Scanner;

public class Q_1987 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int row, col;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();

        sc.nextLine();
        String[][] board = new String[row][col];

        for (int i = 0; i < row; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < col; j++) {
                board[i][j] = String.valueOf(s.charAt(j));
            }
        }

        boolean[] check = new boolean[26]; // 알파벳 체크
        check[(board[0][0].charAt(0) - 'A')] = true;

        //System.out.println("char : " + check[(board[0][0].charAt(0)-'A')]);

        System.out.println(solve(board, check, 0, 0));
    }

    static int solve(String[][] board, boolean[] check, int x, int y) {
        int ans = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
                if (!check[(board[nx][ny].charAt(0) - 'A')]) {
                    check[(board[nx][ny].charAt(0) - 'A')] = true;
                    int next = solve(board, check, nx, ny);

                    if (ans < next) {
                        ans = next;
                    }
                    check[(board[nx][ny].charAt(0) - 'A')] = false;
                }
            }
        }
        return ans + 1;
    }
}
