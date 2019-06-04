package Graph_and_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair_1261 {
    int x;
    int y;

    Pair_1261(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Q_1261 {
    public static final int[] dx = {0, 1, 0, -1};
    public static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        int[][] a = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        sc.close();
        Queue<Pair_1261> now_queue = new LinkedList<Pair_1261>();
        Queue<Pair_1261> next_queue = new LinkedList<Pair_1261>();

        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = -1;
            }
        }
        ans[0][0] = 0;
        now_queue.add(new Pair_1261(0, 0));
        while (!now_queue.isEmpty()) {
            Pair_1261 p = now_queue.remove();
            int x = p.x;
            int y = p.y;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (ans[nx][ny] == -1) {
                        if (a[nx][ny] == 0) {
                            ans[nx][ny] = ans[x][y];
                            now_queue.add(new Pair_1261(nx, ny));
                        } else {
                            ans[nx][ny] = ans[x][y] + 1;
                            next_queue.add(new Pair_1261(nx, ny));
                        }
                    }
                }
            }
            if (now_queue.isEmpty()) {
                now_queue = next_queue;
                next_queue = new LinkedList<Pair_1261>();
            }
        }
        System.out.println(ans[n - 1][m - 1]);

    }

}
