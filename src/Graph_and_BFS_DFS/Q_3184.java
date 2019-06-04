package Graph_and_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair_3184 {
    int first;
    int second;

    Pair_3184(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Q_3184 {
    static int r, c;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static String[] map = new String[250]; // 마당
    static boolean[][] check = new boolean[250][250]; // 방문검사
    static int[][] d = new int[250 * 250][2]; // 양과 늑대 수

    private static void bfs(int sx, int sy, int cnt) {
        Queue<Pair_3184> q = new LinkedList<Pair_3184>();
        q.add(new Pair_3184(sx, sy));
        check[sx][sy] = true;
        while (!q.isEmpty()) {
            Pair_3184 p = q.remove();
            int x = p.first;
            int y = p.second;
            if (map[x].charAt(y) == 'o') {
                d[cnt][0] += 1; // cnt 영역에서 양의 수
            } else if (map[x].charAt(y) == 'v') {
                d[cnt][1] += 1; // cnt 영역에서 늑대의 수
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c)
                    continue;
                if (check[nx][ny] == true)
                    continue;
                if (map[nx].charAt(ny) == '#')
                    continue;
                q.add(new Pair_3184(nx, ny));
                check[nx][ny] = true;
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt(); // 마당의 행
        c = sc.nextInt(); // 마당의 열

        for (int i = 0; i < r; i++) {
            map[i] = sc.next();
        }

        int cnt = 0; // 영역 갯수
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i].charAt(j) != '#' && check[i][j] == false) {
                    cnt += 1;
                    bfs(i, j, cnt);
                }
            }
        }

        int o = 0; // 양의 수
        int v = 0; // 늑대 의 수

        for (int i = 1; i <= cnt; i++) {
            if (d[i][0] > d[i][1]) {
                o += d[i][0];
            } else if (d[i][0] <= d[i][1]) {
                v += d[i][1];
            }
        }

        System.out.println(o + " " + v);

    }

}
