package Dynamic_Programming;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_1520 {
    static int[][] map;
    static int[][] dp;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i], -1);
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        System.out.println(solution(0, 0));
    }

    private static int solution(int i, int j) {
        if (i == n - 1 && j == m - 1) {
            return 1;
        }

        if (dp[i][j] != -1) return dp[i][j];

        dp[i][j] = 0;

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (map[i][j] > map[nx][ny]) {
                dp[i][j] += solution(nx, ny);
            }
        }

        return dp[i][j];
    }
}
