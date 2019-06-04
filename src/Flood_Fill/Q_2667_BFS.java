package Flood_Fill;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair_2667_BFS {
    int x;
    int y;

    Pair_2667_BFS(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Q_2667_BFS {
    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};

    public static void bfs(int[][] a, int[][] group, int x, int y, int cnt, int n) {
        Queue<Pair_2667_BFS> q = new LinkedList<Pair_2667_BFS>();
        q.add(new Pair_2667_BFS(x, y));
        group[x][y] = cnt;
        while (!q.isEmpty()) {
            Pair_2667_BFS p = q.remove();
            x = p.x;
            y = p.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && n > nx && 0 <= ny && n > ny) {
                    if (a[nx][ny] == 1 && group[nx][ny] == 0) {
                        q.add(new Pair_2667_BFS(nx, ny));
                        group[nx][ny] = cnt;
                    }
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
