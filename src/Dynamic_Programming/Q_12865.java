package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q_12865 {

    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] Parser1 = br.readLine().split(" ");

        int n = Integer.parseInt(Parser1[0]); // 물건의 갯수
        int k = Integer.parseInt(Parser1[1]); // 버틸수 있는 무게

        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            String[] Parser2 = br.readLine().split(" ");
            w[i] = Integer.parseInt(Parser2[0]); // 각 물건의 무게
            v[i] = Integer.parseInt(Parser2[1]); // 각 물건의 가치
        }

        dp = new int[n + 1][k + 1];
        // dp[i][j] : i 번째 물건까지 고려했을 때, 배낭에 넣은 물건 무게 합이 j일때 가치의 최대 값
        // i 번쨰 물건을 가방에 넣을 경우 d[i][j] = d[i-1][j-w[i]] + v[i]
        // i 번째 물건을 가방에 넣지 않을 경우  d[i][j] = d[i-1][j]
        for (int i = 1; i <= n; i++) {
            for (int j = k; j >= 1; j--) {
                dp[i][j] = dp[i - 1][j];
                if (j - w[i] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }

        System.out.println(dp[n][k]);


    }

}
