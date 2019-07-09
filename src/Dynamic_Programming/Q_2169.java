package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_2169 {

    static int[][] map;
    static int[][][] dp;
    static int n;
    static int m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] num = br.readLine().split(" ");

        n = Integer.parseInt(num[0]);
        m = Integer.parseInt(num[1]);

        map = new int[n + 2][m + 2];
        dp = new int[n + 2][m + 2][3];
        /*
        dp[i][j][0] = 위에서 오는 경우
        dp[i][j][1] = 왼쪽에서 오는 경우
        dp[i][j][2] = 오른쪽에서 오는 경우
         */

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i <= n + 1; i++) {
            for (int j = 0; j <= m + 1; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = -100000000;
                }
            }
        }

        dp[1][1][1] = map[1][1];

        /*
        dp첫 번째 행은 왼쪽에서 올 수 밖에 없음(한 번 방문한 칸은 재방문이 안되기 때문에
         */

        for (int j = 2; j <= m; j++) {
            dp[1][j][1] = dp[1][j - 1][1] + map[1][j];
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], Math.max(dp[i - 1][j][1], dp[i - 1][j][2])) + map[i][j];
                dp[i][j][1] = Math.max(dp[i][j - 1][0], dp[i][j - 1][1]) + map[i][j];
            }
            for (int j = m; j >= 1; j--) {
                dp[i][j][2] = Math.max(dp[i][j + 1][0], dp[i][j + 1][2]) + map[i][j];
            }
        }

        System.out.println(Math.max(dp[n][m][0], Math.max(dp[n][m][1], dp[n][m][2])));
    }
}
