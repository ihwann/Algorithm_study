package brute_force;

import java.util.Scanner;

public class Q_16197 {
    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};
    private static char[][] board;
    private static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int x1, y1, x2, y2; // 동전의 위치
        x1 = y1 = x2 = y2 = -1;
        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            board[i] = sc.next().toCharArray();
            for (int j = 0; j < m; j++) {

                // 동전의 위치 구하기
                if (board[i][j] == 'o') {
                    if (x1 == -1) {
                        x1 = i;
                        y1 = j;
                    } else {
                        x2 = i;
                        y2 = j;
                    }
                    // 동전의 위치를 구했다면 빈칸으로
                    board[i][j] = '.';
                }
            }
        }

        System.out.println(solve(0, x1, y1, x2, y2));
    }

    private static int solve(int step, int x1, int y1, int x2, int y2) {
        if (step > 10) {
            return -1;
        }
        boolean coin1 = false; // 동전1 떨어지지 않음
        boolean coin2 = false; // 동전2 떨어지지 않음
        if (x1 < 0 || y1 < 0 || x1 >= n || y1 >= m) coin1 = true; // 동전1 떨어짐
        if (x2 < 0 || y2 < 0 || x2 >= n || y2 >= m) coin2 = true; // 동전2 떨어짐

        // 아래 if 조건문 순서 중요!!(하나만 먼저 떨어트리는 횟수를 구하기 때문에)
        if (coin1 && coin2) return -1;
        if (coin1 || coin2) return step;

        int answer = -1;
        for (int i = 0; i < 4; i++) {
            int nx1 = x1 + dx[i];
            int ny1 = y1 + dy[i];
            int nx2 = x2 + dx[i];
            int ny2 = y2 + dy[i];

            if (nx1 >= 0 && nx1 < n && ny1 >= 0 && ny1 < m && board[nx1][ny1] == '#') {
                nx1 = x1;
                ny1 = y1;
            }
            if (nx2 >= 0 && nx2 < n && ny2 >= 0 && ny2 < m && board[nx2][ny2] == '#') {
                nx2 = x2;
                ny2 = y2;
            }

            int temp = solve(step + 1, nx1, ny1, nx2, ny2);
            if (temp == -1) continue;
            if (answer == -1 || answer > temp) {
                answer = temp;
            }
        }
        return answer;
    }
}
