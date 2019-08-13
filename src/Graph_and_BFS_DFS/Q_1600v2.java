package Graph_and_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair_1600v2 {
    int x;
    int y;
    int cnt;

    Pair_1600v2(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class Q_1600v2 {

    static int[] dx = {0, 0, 1, -1, -2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {-1, 1, 0, 0, 1, 2, 2, 1, -1, -2, -2, -1};
    static int[] cost = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1};
    static int[][] map;
    static int[][][] path;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int jump = Integer.parseInt(br.readLine()); // 점프할 수 있는 최대 수
        String[] wh = br.readLine().split(" ");

        int w = Integer.parseInt(wh[0]); // 가로 길이
        int h = Integer.parseInt(wh[1]); // 세로 길이

        map = new int[h][w];
        path = new int[h][w][jump + 1];

        for (int i = 0; i < h; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Pair_1600v2> q = new LinkedList<>();
        q.add(new Pair_1600v2(0, 0, 0));

        while (!q.isEmpty()) {
            Pair_1600v2 p = q.remove();
            int x = p.x;
            int y = p.y;
            int cnt = p.cnt;

            for (int i = 0; i < 12; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int ncnt = cnt + cost[i];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                if (map[nx][ny] == 1) continue;

                if (ncnt <= jump) {
                    if (path[nx][ny][ncnt] == 0) {
                        path[nx][ny][ncnt] = path[x][y][cnt] + 1;
                        q.add(new Pair_1600v2(nx, ny, ncnt));
                    }
                }
            }
        }

        int ans = -1;
        for (int i = 0; i <= jump; i++) {
            if (path[h - 1][w - 1][i] == 0) continue;
            if (ans == -1 || ans > path[h - 1][w - 1][i]) {
                ans = path[h - 1][w - 1][i];
            }
        }

        System.out.println(ans);
    }
}
