package Brute_Force;

import java.util.Scanner;

public class Q_14500 {
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int ans = 0;
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                solve(i, j, 0, 0); // ㄴ, ㅁ, ㅡ 모양의 테트로미노 검사 (대칭 회전 포함)
                // ㅗ, ㅜ 모양의 테트로미노 검사
                if (j + 2 < m) {
                    int temp = map[i][j] + map[i][j + 1] + map[i][j + 2];
                    if (i - 1 >= 0) { // ㅗ
                        int temp2 = temp + map[i - 1][j + 1];
                        if (temp2 > ans) ans = temp2;
                    }
                    if (i + 1 < n) { // ㅜ
                        int temp2 = temp + map[i + 1][j + 1];
                        if (temp2 > ans) ans = temp2;
                    }
                }
                // ㅏ , ㅓ 모양의 테트로미노 검사
                if (i + 2 < n) {
                    int temp = map[i][j] + map[i + 1][j] + map[i + 2][j];
                    if (j - 1 >= 0) { // ㅓ
                        int temp2 = temp + map[i + 1][j - 1];
                        if (temp2 > ans) ans = temp2;
                    }
                    if (j + 1 < m) { // ㅏ
                        int temp2 = temp + map[i + 1][j + 1];
                        if (temp2 > ans) ans = temp2;
                    }
                }
            }
        }

        System.out.println(ans);
    }

    static void solve(int x, int y, int cnt, int sum) { // x,y 현재위치, cnt 방문 횟수, sum : 현재 테트로미노가 위치한 값의 최대값

        if (cnt == 4) {
            if (ans < sum) {
                ans = sum;
                return;
            }
        } else {
            if (x < 0 || x >= n || y < 0 || y >= m) return;
            if (visit[x][y]) return;
            visit[x][y] = true;
            for (int i = 0; i < 4; i++) {
                solve(x + dx[i], y + dy[i], cnt + 1, sum + map[x][y]);
            }
            visit[x][y] = false;
        }
    }
}
