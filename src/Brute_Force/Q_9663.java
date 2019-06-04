package Brute_Force;

import java.util.Scanner;

public class Q_9663 {
    static boolean[][] visit;
    static int n;
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        visit = new boolean[n][n];

        solve(0); // row 행에 퀸을 어디에 놓을지 결정
        System.out.println(ans);
    }

    static void solve(int row) {
        if (row == n) {
            ans += 1;
        } else {
            for (int col = 0; col < n; col++) {
                visit[row][col] = true;
                if (check(row, col)) {  // 퀸을 놓을 수 잇는지 없는지 검사
                    solve(row + 1);
                }
                visit[row][col] = false;
            }
        }
    }

    static boolean check(int row, int col) {
        for (int i = 0; i < n; i++) {
            if (i == row) continue;
            if (visit[i][col]) {
                return false;
            }
        }
        // 왼쪽 대각선 위
        int x = row - 1;
        int y = col - 1;

        while (x >= 0 && y >= 0) {
            if (visit[x][y]) {
                return false;
            }
            x -= 1;
            y -= 1;
        }

        // 오른쪽 대각선 위
        x = row - 1;
        y = col + 1;
        while (x >= 0 && y < n) {
            if (visit[x][y]) {
                return false;
            }
            x -= 1;
            y += 1;
        }
        return true;
    }
}
