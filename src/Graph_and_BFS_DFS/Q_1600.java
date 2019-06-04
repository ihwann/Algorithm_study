package Graph_and_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair_1600 {
    int x;
    int y;
    int c;

    Pair_1600(int x, int y, int c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }
}

public class Q_1600 {
    static final int[] dx = {0, 0, 1, -1, -2, -1, 1, 2, 2, 1, -1, -2};
    static final int[] dy = {1, -1, 0, 0, 1, 2, 2, 1, -1, -2, -2, -1};
    static final int[] cost = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int h = sc.nextInt();
        int w = sc.nextInt();

        int[][] map = new int[w][h];
        int[][][] check = new int[w][h][k + 1];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        sc.close();
        check[0][0][0] = 0;

        Queue<Pair_1600> q = new LinkedList<Pair_1600>();
        q.offer(new Pair_1600(0, 0, 0));

        while (!q.isEmpty()) {
            Pair_1600 p = q.remove();
            int x = p.x;
            int y = p.y;
            int c = p.c;

            for (int i = 0; i < 12; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nc = c + cost[i];

                if (nx < 0 || nx >= w || ny < 0 || ny >= h)
                    continue;
                if (map[nx][ny] == 1) {
                    continue;
                }
                if (nc <= k) {
                    if (check[nx][ny][nc] == 0) {
                        check[nx][ny][nc] = check[x][y][c] + 1;
                        q.offer(new Pair_1600(nx, ny, nc));
                    }
                }
            }
        }

        int ans = -1;
        for (int i = 0; i <= k; i++) {
            if (check[w - 1][h - 1][i] == 0)
                continue;
            if (ans == -1 || ans > check[w - 1][h - 1][i]) {
                ans = check[w - 1][h - 1][i];
            }
        }
        System.out.println(ans);
    }
}
