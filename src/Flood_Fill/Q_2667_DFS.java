package Flood_Fill;

import java.util.Arrays;
import java.util.Scanner;

public class Q_2667_DFS {
    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};

    public static void bfs(int[][] a, int[][] group, int x, int y, int cnt, int n) {
        group[x][y] = cnt;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && n > nx && 0 <= ny && n > ny) {
                if (a[nx][ny] == 1 && group[nx][ny] == 0) {
                    group[nx][ny] = cnt;
                    bfs(a, group, nx, ny, cnt, n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < n; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        sc.close();
        int cnt = 0;
        int[][] group = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1 && group[i][j] == 0) {
                    bfs(a, group, i, j, ++cnt, n);
                }
            }
        }
        int[] ans = new int[cnt];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (group[i][j] != 0) {
                    ans[group[i][j] - 1] += 1;
                }
            }
        }

        Arrays.sort(ans);
        System.out.println(cnt);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
