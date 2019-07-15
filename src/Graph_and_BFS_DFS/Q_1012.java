package Graph_and_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pair_1012 {
    int x;
    int y;

    public Pair_1012(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Q_1012 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] num = br.readLine().split(" ");

            int n = Integer.parseInt(num[1]); // 배추밭 세로 길이
            int m = Integer.parseInt(num[0]); // 배추밭 가로 길이
            int k = Integer.parseInt(num[2]); // 배추가 심어진 위치의 갯수

            int[][] map = new int[n][m];
            boolean[][] visit = new boolean[n][m];

            for (int i = 0; i < k; i++) {
                String[] num2 = br.readLine().split(" ");
                map[Integer.parseInt(num2[1])][Integer.parseInt(num2[0])] = 1; // 배추가 심어진 좌표 입력
            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1 && !visit[i][j]) {
                        ans += 1;
                        visit[i][j] = true;

                        Queue<Pair_1012> q = new LinkedList<>();
                        q.add(new Pair_1012(i, j));

                        while (!q.isEmpty()) {
                            Pair_1012 p = q.remove();
                            int x = p.x;
                            int y = p.y;

                            for (int z = 0; z < 4; z++) {
                                int nx = x + dx[z];
                                int ny = y + dy[z];

                                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                                if (map[nx][ny] == 1 && !visit[nx][ny]) {
                                    visit[nx][ny] = true;
                                    q.add(new Pair_1012(nx, ny));
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
