package Graph_and_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair_14442 {
    int x;
    int y;
    int z;

    Pair_14442(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Q_14442 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();

        int[][] map = new int[n][m];
        int[][][] check = new int[n][m][k + 1];

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        sc.close();

        check[0][0][0] = 1;
        Queue<Pair_14442> q = new LinkedList<Pair_14442>();
        q.offer(new Pair_14442(0, 0, 0));

        while (!q.isEmpty()) {
            Pair_14442 p = q.remove();
            int x = p.x;
            int y = p.y;
            int z = p.z;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if (map[nx][ny] == 0 && check[nx][ny][z] == 0) {
                    check[nx][ny][z] = check[x][y][z] + 1;
                    q.offer(new Pair_14442(nx, ny, z));
                }
                if (z + 1 <= k && map[nx][ny] == 1 && check[nx][ny][z] == 0) {
                    check[nx][ny][z + 1] = check[x][y][z] + 1;
                    q.offer(new Pair_14442(nx, ny, z + 1));
                }
            }
        }

        int ans = -1;
        for (int i = 0; i <= k; i++) {
            if (check[n - 1][m - 1][i] == 0)
                continue;
            if (ans == -1) {
                ans = check[n - 1][m - 1][i];
            } else if (ans > check[n - 1][m - 1][i]) {
                ans = check[n - 1][m - 1][i];
            }
        }
        System.out.println(ans);
    }

}
