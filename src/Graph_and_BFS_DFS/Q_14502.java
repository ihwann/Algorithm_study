package Graph_and_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair_14502 {
    int x;
    int y;

    Pair_14502(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Q_14502 {
    private static int[][] map; // 원래상태 지도
    private static int[][] map2; // 바이러스 퍼질 때 지도
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        map = new int[n][m];
        map2 = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = map2[i][j] = sc.nextInt();
            }
        }

        int ans = 0; // 정답(안전영역의 최대값)
        // x1,y1 x2,y2 x3,y3 // 벽 1, 2, 3 위치
        for (int x1 = 0; x1 < n; x1++) {
            for (int y1 = 0; y1 < m; y1++) {
                if (map[x1][y1] != 0) continue;
                for (int x2 = 0; x2 < n; x2++) {
                    for (int y2 = 0; y2 < m; y2++) {
                        if (map[x2][y2] != 0) continue;
                        for (int x3 = 0; x3 < n; x3++) {
                            for (int y3 = 0; y3 < m; y3++) {
                                if (map[x3][y3] != 0) continue;
                                if (x1 == x2 && y1 == y2) continue;
                                if (x1 == x3 && y1 == y3) continue;
                                if (x2 == x3 && y2 == y3) continue;
                                map[x1][y1] = 1;
                                map[x2][y2] = 1;
                                map[x3][y3] = 1;

                                int cur = dfs(n, m);
                                if (cur > ans) ans = cur;

                                map[x1][y1] = 0;
                                map[x2][y2] = 0;
                                map[x3][y3] = 0;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }

    private static int dfs(int n, int m) {
        Queue<Pair_14502> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map2[i][j] = map[i][j];
                if (map2[i][j] == 2) {
                    q.add(new Pair_14502(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Pair_14502 p = q.remove();
            int x = p.x;
            int y = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map2[nx][ny] == 0) {
                        map2[nx][ny] = 2;
                        q.add(new Pair_14502(nx, ny));
                    }

                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map2[i][j] == 0) cnt += 1;
            }
        }
        return cnt;
    }
}
