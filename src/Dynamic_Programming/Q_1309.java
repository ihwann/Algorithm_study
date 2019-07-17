package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1309 {
    private static final int MOD = 9901;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][3];
        /*
        dp[i][0] : i 번째 우리에 사자가 왼쪽에만 있는 경우
        dp[i][1] : i 번째 우리에 사자가 오른쪽에만 있는 경우
        dp[i][2] : i 번째 우리에 사자가 없는 경우
         */

        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
        }

        int ans = (dp[n][0] + dp[n][1] + dp[n][2]) % MOD;
        System.out.println(ans);
    }
}
