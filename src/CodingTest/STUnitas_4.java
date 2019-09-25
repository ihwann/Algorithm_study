package CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class coex {
    int x;
    int y;

    public coex(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class STUnitas_4 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        int[][] count = new int[n][n];
        boolean[][] visitChk = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        Queue<coex> q = new LinkedList<>();

        q.offer(new coex(0, 0));
        visitChk[0][0] = true; // 방문함

        while (!q.isEmpty()) {
            coex c = q.remove();

            int x = c.x;
            int y = c.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visitChk[nx][ny] == false && map[nx][ny] == 1) {
                    visitChk[nx][ny] = true;
                    q.offer(new coex(nx, ny));
                    count[nx][ny] = count[x][y] + 1;
                }
            }
        }

        System.out.println(count[n - 1][n - 1]);

    }
}
