package Graph_and_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair_7576_BFS {
    int x;
    int y;

    Pair_7576_BFS(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Q_7576_BFS {
    public static final int[] dx = {0, 1, 0, -1};
    public static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Queue<Pair_7576_BFS> q = new LinkedList<Pair_7576_BFS>();
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] a = new int[n][m];
        int[][] des = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
                des[i][j] = -1;
                if (a[i][j] == 1) {
                    des[i][j] = 0;
                    q.add(new Pair_7576_BFS(i, j));
                }
            }
        }
        while (!q.isEmpty()) {
            Pair_7576_BFS p = q.remove();
            int x = p.x;
            int y = p.y;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (0 <= nx && n > nx && 0 <= ny && m > ny) {
                    if (a[nx][ny] == 0 && des[nx][ny] == -1) {
                        q.add(new Pair_7576_BFS(nx, ny));
                        des[nx][ny] = des[x][y] + 1;
                    }
                }
            }
        }
        int day = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (day < des[i][j]) {
                    day = des[i][j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0 && des[i][j] == -1) {
                    day = -1;
                }
            }
        }
        System.out.println(day);

    }

}
