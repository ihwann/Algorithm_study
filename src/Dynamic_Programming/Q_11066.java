package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q_11066 {

    static int[] chap;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.valueOf(br.readLine()); // 챕터 갯수
            chap = new int[n + 1];
            dp = new int[n + 1][n + 1]; // i 부터 j 까지 더하는 비용의 최소합

            String[] Parser = br.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                chap[i] = Integer.valueOf(Parser[i - 1]);
                Arrays.fill(dp[i], -1);
            }

            System.out.println(go(1, n));
        }

    }

    private static int go(int i, int j) {
        if (i == j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = -1;
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += chap[k];
        }

        for (int k = i; k <= j - 1; k++) {
            int temp = go(i, k) + go(k + 1, j) + sum;
            if (ans == -1 || ans > temp) {
                ans = temp;
            }
        }

        dp[i][j] = ans;
        return ans;

    }

}
