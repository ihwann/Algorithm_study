package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최대부분 증가 수열 a.k.a LIS
public class Q_1937_withDP {
    static int n;
    static int[][] map;
    static int[][] mapDP;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        mapDP = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, solution(i, j));
            }
        }

        System.out.println(ans);
    }

    private static int solution(int i, int j) {

        if (mapDP[i][j] != 0) return mapDP[i][j];

        mapDP[i][j] = 1;

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (map[i][j] < map[nx][ny]) {
                mapDP[i][j] = Math.max(mapDP[i][j], solution(nx, ny) + 1);
            }

        }
        return mapDP[i][j];
    }
}
