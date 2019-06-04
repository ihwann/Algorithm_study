package Graph_and_BFS_DFS;

//어렵다.. 다시 풀어보기

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair_2206 {
    int x;
    int y;
    int z;

    Pair_2206(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Q_2206 {
    public static final int[] dx = {0, 1, 0, -1};
    public static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] a = new int[n][m];
        int[][][] d = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        sc.close();
        Queue<Pair_2206> q = new LinkedList<Pair_2206>();

        d[0][0][0] = 1;

        q.offer(new Pair_2206(0, 0, 0));
        while (!q.isEmpty()) {
            Pair_2206 p = q.remove();
            int x = p.x;
            int y = p.y;
            int z = p.z;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if (a[nx][ny] == 0 && d[nx][ny][z] == 0) {
                    d[nx][ny][z] = d[x][y][z] + 1;
                    q.offer(new Pair_2206(nx, ny, z));
                }
                if (z == 0 && a[nx][ny] == 1 && d[nx][ny][z] == 0) {
                    d[nx][ny][z + 1] = d[x][y][z] + 1;
                    q.offer(new Pair_2206(nx, ny, z + 1));
                }
            }
        }
        if (d[n - 1][m - 1][0] != 0 && d[n - 1][m - 1][1] != 0) {
            System.out.println(Math.min(d[n - 1][m - 1][0], d[n - 1][m - 1][1]));
        } else if (d[n - 1][m - 1][0] != 0) {
            System.out.println(d[n - 1][m - 1][0]);
        } else if (d[n - 1][m - 1][1] != 0) {
            System.out.println(d[n - 1][m - 1][1]);
        } else {
            System.out.println(-1);
        }
    }

}
