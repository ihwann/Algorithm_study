package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_2096 {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][3];
        int[][] maxDp = new int[n][3];
        int[][] minDp = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    maxDp[i][j] = map[i][j];
                    minDp[i][j] = map[i][j];
                }
            }
        }

        /*
        점화식
        dp[i][0] = dp[i-1][0] + map[i][0], dp[i-1][1] + map[i][0]
        dp[i][1] = dp[i-1][0] + map[i][1], dp[i-1][1] + map[i][1], dp[i-1][2] + map[i][1]
        dp[i][2] = dp[i-1][1] + map[i][2], dp[i-1][2] + map[i][2]
         */
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    maxDp[i][j] = Math.max(maxDp[i - 1][0] + map[i][0], maxDp[i - 1][1] + map[i][0]);
                    minDp[i][j] = Math.min(minDp[i - 1][0] + map[i][0], minDp[i - 1][1] + map[i][0]);
                }
                if (j == 1) {
                    maxDp[i][j] = Math.max(maxDp[i - 1][0] + map[i][1], Math.max(maxDp[i - 1][1] + map[i][1], maxDp[i - 1][2] + map[i][1]));
                    minDp[i][j] = Math.min(minDp[i - 1][0] + map[i][1], Math.min(minDp[i - 1][1] + map[i][1], minDp[i - 1][2] + map[i][1]));
                }
                if (j == 2) {
                    maxDp[i][j] = Math.max(maxDp[i - 1][1] + map[i][2], maxDp[i - 1][2] + map[i][2]);
                    minDp[i][j] = Math.min(minDp[i - 1][1] + map[i][2], minDp[i - 1][2] + map[i][2]);
                }
            }
        }

        max = Math.max(maxDp[n - 1][0], Math.max(maxDp[n - 1][1], maxDp[n - 1][2]));
        min = Math.min(minDp[n - 1][0], Math.min(minDp[n - 1][1], minDp[n - 1][2]));

        System.out.println(max + " " + min);
    }
}
