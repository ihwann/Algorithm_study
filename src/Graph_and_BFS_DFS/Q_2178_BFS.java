package Graph_and_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair_2178 {
    int x;
    int y;

    Pair_2178(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Q_2178_BFS {

    public static final int[] dx = {0, 1, 0, -1};
    public static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        int[][] ans = new int[n][m];
        boolean[][] check = new boolean[n][m];

        Queue<Pair_2178> q = new LinkedList<Pair_2178>();
        q.add(new Pair_2178(0, 0));
        check[0][0] = true;
        ans[0][0] = 1;
        while (!q.isEmpty()) {
            Pair_2178 p = q.remove();
            int x = p.x;
            int y = p.y;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (0 <= nx && n > nx && 0 <= ny && m > ny) {
                    if (a[nx][ny] == 1 && check[nx][ny] == false) {
                        check[nx][ny] = true;
                        ans[nx][ny] = ans[x][y] + 1;
                        q.add(new Pair_2178(nx, ny));
                    }
                }
            }
        }
        System.out.println(ans[n - 1][m - 1]);
    }

}
